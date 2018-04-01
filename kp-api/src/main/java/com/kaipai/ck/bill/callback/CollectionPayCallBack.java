package com.kaipai.ck.bill.callback;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.kaipai.ck.configs.AiwConfig;
import com.kaipai.ck.constant.KpContants;
import com.kaipai.ck.constant.KpContants.ORDER;
import com.kaipai.ck.model.contributiveList.CollectionBenfitModel;
import com.kaipai.ck.model.contributiveList.CollectionCompanyModel;
import com.kaipai.ck.model.contributiveList.UserContributiveModel;
import com.kaipai.ck.model.crowdfunding.CrowdfundingModel;
import com.kaipai.ck.model.fd.ChUgcModel;
import com.kaipai.ck.model.movie.MovieVideoModel;
import com.kaipai.ck.model.order.OrderCollectionModel;
import com.kaipai.ck.model.order.OrderModel;
import com.kaipai.ck.model.security.User;
import com.kaipai.ck.model.security.UserVideoRole;
import com.kaipai.ck.model.userManage.UserPointHis;
import com.kaipai.ck.push.KpwebPush;
import com.kaipai.ck.service.crowdfunding.CrowdfundingService;
import com.kaipai.ck.service.crowdfunding.FdCollService;
import com.kaipai.constants.KpConstants.FdUGC;
import com.kaipai.interfaces.fd.IFdService;
import com.kaipai.redis.ICache;
import com.kaipai.redis.jredis.RedisClusterCacheImp;
import com.kaipai.utils.BigDecimalUtils;
import com.kaipai.utils.GenSeqUtils;
import com.kaipai.utils.SpringUtils;
import com.kp.sys.tools.enums.AppMsgTypeEnum;
import com.kp.sys.tools.enums.PushTypeEnum;
import com.kp.sys.tools.msg.vo.BaiduMsgVo;

public class CollectionPayCallBack extends AbstractPayCallBack{
    /**
     * 
     * 众筹转发收益逻辑
     * 
     * */
	@SuppressWarnings("static-access")
	@Override
	protected void execute(OrderModel orderModel) {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		List<OrderCollectionModel> collModelList = contributiveService.getCollByOrderNo(orderModel.getOrderNo());
		if(collModelList==null || collModelList.isEmpty()) {log.info("******the order is not exists!****"+orderModel.getOrderNo()); return;}
		
		OrderCollectionModel collModel = collModelList.get(0);
		String collNo=collModel.getCollNo();
    	String collBenId = collModel.getCollBenId();
    	String gitNum = collModel.getGitNum();
    	String companyCode = collModel.getCompanyCode();
    	long tranferUsrId = collModel.getTranferUsrId();
    	log.info(" C3 **********************orderType:"+orderModel.getOrderType()
    			  + " orderNo:"+orderModel.getOrderNo()
    			  + " *gitNum:"+gitNum+" collBenId:"+collBenId+" collNo:"+collNo +" companyCode:"+companyCode
    			  + " tranferUserId:"+tranferUsrId);
    	
    	UserContributiveModel userCModel = new UserContributiveModel();
    	userCModel.setCollBenId(Long.valueOf(collBenId));
    	userCModel.setCollNo(collNo);
    	userCModel.setUserId(Long.valueOf(orderModel.getUserId()));
    	userCModel.setState(KpContants.Collection.STATE_VAL_IS_VALIAD);
    	if(StringUtils.isEmpty(gitNum) || "0".equals(gitNum)) gitNum= KpContants.Collection.COLL_GIT_NUM_DEFAULT_VAL;
    	userCModel.setGitNum(Long.valueOf(gitNum));

    	StringBuffer userNickName = new StringBuffer("");
    	if(!StringUtils.isEmpty(orderModel.getUserId())){
             User user = userService.getUsers(orderModel.getUserId());
             userNickName.append(user.getNickName()).append(AiwConfig.COLL_AMT_INFO) ;
         	 userCModel.setNickName(user.getNickName());
        	 userCModel.setIconUrl(user.getUserIcon());
        }
    	
    	
    	
    	double gitNumD = Double.parseDouble(gitNum);
    	if(gitNumD == 0.0){
    		gitNumD = 1.0;
    	}
    	double evAmt =	BigDecimalUtils.div(orderModel.getOdrAmt(), gitNumD, 2);
		//double evAmt = orderModel.getOdrAmt()/Double.parseDouble(gitNum);
		
		
    	userCModel.setEvAmt(evAmt);
		contributiveService.saveUserColl(userCModel);
    	log.info(" C4 **********save user coll Data is success!!---***gitNum:"+gitNum+"  odrAmt:"+orderModel.getOdrAmt()+"  evAmt:"+evAmt+"   collNo:"+collNo);
    	
    	
    	
    	
    	CollectionBenfitModel collBenfitModel =  contributiveService.getCollBenfitByBenfitId(collBenId);
    	if(!StringUtils.isEmpty(companyCode)){
    		long companyUserId = userService.getCompanyUserIdByCompanyCode(companyCode);
    		log.info(" C5 ********************companyUserId:"+companyUserId);
    		Map<String,String> collSearchMap = new HashMap<String,String>();
	    	collSearchMap.put("collNo", collNo);
	    	collSearchMap.put("companyCode", companyCode);
	    	List<CollectionCompanyModel> collCompanys = contributiveService.getCollectionCompanyByCollNoAndCompanyCode(collSearchMap);
	    	
	    	if(collCompanys!=null && collCompanys.size()>0){
	    		CollectionCompanyModel collCompany = collCompanys.get(0);
	    		double companyRate = collCompany.getCompanyRate();
	    		double employeeRate = collCompany.getEmployeeRate();
	    		double userRate  = collCompany.getUserRate();
		    	log.info(" C6*************companyRate:"+companyRate+" employeeRate:"+employeeRate+" userRate:"+userRate +" orderNo:"+orderModel.getOrderNo()+" collectionNo:"+collNo);
		    	
	    		long evAmtfromDb = collBenfitModel.getEvAmt();
	    		
	    		double companyAmtd = BigDecimalUtils.mul(evAmtfromDb, companyRate);
	    		long companyAmt = (long) companyAmtd;
	    		
	    		double employeeAmtd = BigDecimalUtils.mul(evAmtfromDb, employeeRate);
	    		long employeeAmt = (long) employeeAmtd;

	    		double userAmtd = BigDecimalUtils.mul(evAmtfromDb, userRate);
	    		long userAmt = (long) userAmtd;;
	    		
	    		double kaipaiAmtd = BigDecimalUtils.sub(evAmtfromDb, companyAmt);
	    		kaipaiAmtd =  BigDecimalUtils.sub(kaipaiAmtd, employeeAmt);
	    		kaipaiAmtd =  BigDecimalUtils.sub(kaipaiAmtd, userAmt);
	    		long kaipaiAmt= (long) kaipaiAmtd;
	    		log.info("=====================kaipaiAmtd="+kaipaiAmtd+" kaipaiAmt:"+kaipaiAmt);


	    		if(companyAmt>0){
	    			String companyAmtNo = GenSeqUtils.genAmtNo(companyUserId);
				    hisService.addUserAmtHis(companyAmt, KpContants.PAY.AMT_OP_CODE_ADD,companyUserId ,orderModel.getOrderNo(), userNickName.toString()+companyRate,companyAmtNo,ORDER.PAY_TYPE_COLL_MV);
		    		callbackService.addUserAmtHis(companyAmt, KpContants.PAY.AMT_OP_CODE_ADD,companyUserId ,orderModel.getOrderNo(), userNickName.toString()+companyRate,companyAmtNo,ORDER.PAY_TYPE_COLL_MV);
				    log.info(" C7  ************company amt success !!!************************companyUserId："+companyUserId+" companyRate:"+companyRate+" amt:"+companyAmt+" orderNo:"+orderModel.getOrderNo());
	    		}
	    		
	    		if(employeeAmt>0){
	    			  String employeeAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
					  hisService.addUserAmtHis(employeeAmt, KpContants.PAY.AMT_OP_CODE_ADD,tranferUsrId ,orderModel.getOrderNo(),userNickName.toString()+employeeRate,employeeAmtNo,ORDER.PAY_TYPE_COLL_MV);
				      callbackService.addUserAmtHis(employeeAmt, KpContants.PAY.AMT_OP_CODE_ADD,tranferUsrId ,orderModel.getOrderNo(),userNickName.toString()+employeeRate,employeeAmtNo,ORDER.PAY_TYPE_COLL_MV);
					  log.info(" C8 ************employee amt success !!!************************tranferUsrId:"+tranferUsrId+" employeeRate:"+employeeRate+" amt:"+employeeAmt+" orderNo:"+orderModel.getOrderNo());
	    		}
	    		
	    		if(kaipaiAmt>0){
	    			String kpAmtNo = GenSeqUtils.genAmtNo(KpContants.PAY.DEF_KP_ID);
				    hisService.addUserAmtHis(kaipaiAmt, KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID ,orderModel.getOrderNo(),userNickName.toString(),kpAmtNo,ORDER.PAY_TYPE_COLL_MV);
			    	callbackService.addUserAmtHis(kaipaiAmt, KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID ,orderModel.getOrderNo(),userNickName.toString(),kpAmtNo,ORDER.PAY_TYPE_COLL_MV);
				    log.info(" C9 ************kaipai company amt success !!!************************KAIPAI:"+KpContants.PAY.DEF_KP_ID+"  kaipaiAmt:"+kaipaiAmt+" orderNo:"+orderModel.getOrderNo());
	    		}
	    		log.info(" C10 ************OK !!!************************"+" orderNo:"+orderModel.getOrderNo());
	    	}
    	}else{
    		//普通转发
    		String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
		    hisService.addUserAmtHis(orderModel.getOdrAmt(), KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID ,orderModel.getOrderNo(), userNickName.toString(),kpAmtNo,ORDER.PAY_TYPE_COLL_MV);
			callbackService.addUserAmtHis(orderModel.getOdrAmt(), KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID ,orderModel.getOrderNo(), userNickName.toString(),kpAmtNo,ORDER.PAY_TYPE_COLL_MV);
		    log.info(" C5 the collections is common! hava not companyCode**********OK****** zc is ok!collNo:"+collNo);
    	}
    	//添加积分
    	String pointCode = collBenfitModel.getGiftCode();
    	double pointValue = 0.0;
    	try{
    		int num = Integer.parseInt(gitNum);
    		if(num < 1){
    			num = 1;
    		}
    		pointValue = collBenfitModel.getGiftValue()*num;
    	}catch(Exception e){
    		pointValue = collBenfitModel.getGiftValue();
    	}
    	if(userPointService.updateAddPoint(orderModel.getUserId()+"", pointCode, pointValue,"众筹支付")){
    		//添加积分记录
    		UserPointHis userPointHis = new UserPointHis();
    		userPointHis.setOpVal(pointValue);
    		userPointHis.setUserId(orderModel.getUserId());
    		userPointHis.setOpCode("+");
    		userPointHis.setPointCode(pointCode);
    		userPointHis.setOpComment("用户:"+orderModel.getUserId()+"购买了众筹"+collBenId+" "+gitNum+"份，获得积分："+pointValue);
    		userPointService.inserUserPointHis(userPointHis);
    	}
    	
    	//众筹项目与视频对应关系
    	List<MovieVideoModel> cvL = movieVideoService.selectMovieVideos(collNo);
    	if (!StringUtils.isEmpty(cvL)&&cvL.size()>0) {
    		UserVideoRole uVideoRole = new UserVideoRole();
    		uVideoRole.setRoleCode(KpContants.VIDEO.VIDEO_ROLE_CODE_TRAN);
    		uVideoRole.setUserId(orderModel.getUserId());
			for (MovieVideoModel collVideoModel : cvL) {
				uVideoRole.setVideoId(collVideoModel.getVideoId());
				//查询用户视频权限收益次数
				UserVideoRole uvr = userService.selectUserVideoRoleTimes(uVideoRole);
				// 转发次数  = 购买份数  * 股數和轉發次數比率  
				double collTimes = Long.parseLong(gitNum)*collVideoModel.getScale();
				long collT = (long) collTimes;
				log.info("======转发次数=================collTimes:"+collTimes+"  collT:"+collT);
				if (collT>0) {
					if (!StringUtils.isEmpty(uvr)) {
						long times = uvr.getTimes() + collT;
						log.info("==========用户视频权限收益次数:前"+uvr.getTimes()+"  后times:"+times);
						uVideoRole.setTimes(times);
						userService.updateUserVideoRoleTimes(uVideoRole);
					}else {
						uVideoRole.setTimes(collT);
						userService.addUserViedoRole(uVideoRole);
					}
				}
				
			}
		}
    	
    	//添加用户众筹权限缓存
    	ICache cache = RedisClusterCacheImp.getInstance();
    	log.info("=========添加用户众筹权限缓存=========key:"+FdUGC.USER_COLL_ROLE_TRUE+orderModel.getUserId()
    			+"====collNo:"+collNo);
    	cache.hset(FdUGC.USER_COLL_ROLE_TRUE+orderModel.getUserId(), collNo, "1");

    	
    	FdCollService fdCollService = SpringUtils.getBean(FdCollService.class);
		try {
			ChUgcModel ugc = fdCollService.getCollUgcInfo(collNo,null, null);
	    	if (ugc!=null) {
	    		log.info("========用户申购送积分=========");
	        	//增加用户贡献值
	        	IFdService fdService = SpringUtils.getBean("fdService", IFdService.class);
	        	fdService.collGivePoint(ugc.getChId(), orderModel.getUserId(), "用户申购送积分");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try{
    		//众筹完全网成推送通知
       	 CrowdfundingService crowdfundingService = SpringUtils.getBean(CrowdfundingService.class); 
       	 if(!crowdfundingService.getCollBenfitCount(collBenId)){
   			KpwebPush push = new KpwebPush();
   			Map<String,String> map = new HashMap<String,String>();
   			map.put("type", "COLL");
   			map.put("value", collNo);
   			map.put("code", "13");
   			CrowdfundingModel model = new CrowdfundingModel();
   			model.setCollNo(collNo);
   			model = crowdfundingService.findBean(model);
   			String content = model.getCollName()+"众筹完成了！";
			BaiduMsgVo vo = push.buildMsgVo(PushTypeEnum.SYS_MSG, map, content);
   			push.sendAll(vo, AppMsgTypeEnum.SYS);
       	 }
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
	}
	
	
}
