package com.kaipai.ck.bill.callback;

import org.springframework.util.StringUtils;

import com.kaipai.ck.constant.KpContants;
import com.kaipai.ck.constant.KpContants.ORDER;
import com.kaipai.ck.model.order.OrderModel;
import com.kaipai.ck.model.security.User;
import com.kaipai.ck.model.security.UserVideoRole;
import com.kaipai.ck.model.video.VideoModel;
import com.kaipai.ck.model.video.VideoUserOpHisModel;
import com.kaipai.ck.model.video.VideoUserTranAmtHis;
import com.kaipai.ck.service.video.VideoService;
import com.kaipai.ck.service.video.VideoUserOpService;
import com.kaipai.ck.service.video.VideoUserTranAmtService;
import com.kaipai.utils.BigDecimalUtils;
import com.kaipai.utils.GenSeqUtils;
import com.kaipai.utils.SpringUtils;

public class VideoPayCallBack extends AbstractPayCallBack {

	/*
	 * 视频支付回调逻辑
	 */
	@Override
	protected void execute(OrderModel orderModel) {
		log.info("V3 **********Start caulate the orderNo!********"	+ orderModel.getOrderNo() + " videoId:"
				+ orderModel.getVideoId());

		VideoService vService = SpringUtils.getBean(VideoService.class);
		VideoUserOpService vUserOpService = SpringUtils.getBean(VideoUserOpService.class);
		//UserService uService = SpringUtils.getBean(UserService.class);
		VideoUserTranAmtService videoUserTranAmtService=SpringUtils.getBean(VideoUserTranAmtService.class);
		long videoId = orderModel.getVideoId();
		VideoModel videoMode = new VideoModel();
		videoMode.setVideoId(String.valueOf(videoId));
		videoMode = vService.findVideoByViedoId(videoMode);
		log.info("V4 ******videoid:" + videoId + " feeState:"
				+ videoMode.getFeeFlg() + "  benfitType:"
				+ videoMode.getBenfitType() + " kprate:"
				+ videoMode.getKpFeeRate() + " benfituserid:"
				+ videoMode.getBenfitUsrId() + " tranferUserId:"
				+ orderModel.getTranferUsrId()+" orderNo:"+ orderModel.getOrderNo() );
		
		if (KpContants.VIDEO.VIDEO_FEE_TYPE_FREE.equals(videoMode.getFeeFlg()))	return;

		double amt = orderModel.getOdrAmt();
		String amtNo = GenSeqUtils.genAmtNo(Long.valueOf(orderModel.getUserId()));
		
		//收益类型 众筹转发用户收益权限COLLTRAN' 
		//if (KpContants.VIDEO.VIDEO_BENFIT_TYPE_COLLTRAN.equals(videoMode.getBenfitType())) {

			/*UserVideoRole userVideoRole = null;
			long syTranTimes = 0;
			if (!StringUtils.isEmpty(orderModel.getTranferUsrId())) {
				userVideoRole = new UserVideoRole();
				userVideoRole.setRoleCode(KpContants.VIDEO.VIDEO_ROLE_CODE_TRAN);
				userVideoRole.setUserId(orderModel.getTranferUsrId());
				userVideoRole.setVideoId(videoId);
				userVideoRole = uService.selectUserVideoRoleTimes(userVideoRole);
				if (!StringUtils.isEmpty(userVideoRole)) {
					syTranTimes = userVideoRole.getTimes()-userVideoRole.getTimed();
				}
			}*/
			

			double kprate = videoMode.getKpFeeRate();//开拍网分成比例
			double tranferRate = videoMode.getTransferFeeRate();//转发人分成比例
			double dividendRate = videoMode.getDividendFeeRate();//分红分成比例
			double invdRate = videoMode.getInvestorsFeeRate();//投资人分成比例
			//log.info("========分成比例=========kprate:"+kprate+" dividendRate:"
			//+dividendRate+" tranferRate:"+tranferRate+" invdRate:"+invdRate+" syTranTimes:"+syTranTimes);
			log.info("========分成比例=========kprate:"+kprate+" dividendRate:"
					+dividendRate+" tranferRate:"+tranferRate+" invdRate:"+invdRate);
			//转发人
			double amtTranfered = BigDecimalUtils.mul(amt, tranferRate);
			long amtTranfer = (long)amtTranfered;
			//投资人
			double amtInvd = BigDecimalUtils.mul(amt, invdRate);
			long amtInv = (long)amtInvd;
			//分红金额
			double dividendRated = BigDecimalUtils.mul(amt, dividendRate);
			
			// 开拍网   : 分红的收益默认打入开拍网账户  ：开拍网+分红
			double kpAmtFeed = BigDecimalUtils.sub(amt, BigDecimalUtils.sum(amtInvd,amtTranfered));
			long kpAmtFee = (long) kpAmtFeed;
			log.info("========分成金额=========amtTranfer:"+amtTranfer+" amtInv:"+amtInv+" kpAmtFee:"+kpAmtFee);

			log.info("V5 **********videoid:" + videoId + "  kprate:" + kprate+" dividendRate:"+dividendRate+"  tranferRate:" + tranferRate + "  tranferuserId:"+ orderModel.getTranferUsrId() + " amtInv:" + amtInv
					+ " amt:" + amt + "  amtNo:" + amtNo+" orderNo:"+ orderModel.getOrderNo()+" amtInvd:"+amtInvd
					+" kpAmtFeed:"+kpAmtFeed+" amtTranfered:"+amtTranfered);
			
			String amtInfo = "";
			String nickName = "匿名";
			if (!StringUtils.isEmpty(orderModel.getUserId())) {
				User user = userService.getUsers(orderModel.getUserId());
				nickName = user.getNickName();
				amtInfo = user.getNickName() + "观看了"+videoMode.getTitle()+",获得众筹转发收益";
			}

			//投资人id
			Long invuserId = null;
			if (StringUtils.isEmpty(videoMode.getBenfitUsrId())) {
				//投资人默认开拍网
				invuserId= KpContants.PAY.DEF_KP_TRAF_ID;
			}else{
				//投资人id
				invuserId = Long.valueOf(videoMode.getBenfitUsrId());
			}
			Long tranferuserId = orderModel.getTranferUsrId();
			//是否是众筹转发收益
			//if(!StringUtils.isEmpty(userVideoRole)&&syTranTimes>0){

				if (!StringUtils.isEmpty(tranferuserId)&&tranferuserId>0) {
					//转发人收益
					String transNo = GenSeqUtils.genAmtNo(Long.valueOf(orderModel.getUserId()));
					if (0 < amtTranfer){
						//更新billing系统数据
						callbackService.addUserAmtHis(amtTranfer,KpContants.PAY.AMT_OP_CODE_ADD, tranferuserId,orderModel.getOrderNo(), amtInfo, transNo,ORDER.PAY_TYPE_TARN_PROFIT);
						hisService.addUserAmtHis(amtTranfer,KpContants.PAY.AMT_OP_CODE_ADD, tranferuserId,orderModel.getOrderNo(), amtInfo, transNo,ORDER.PAY_TYPE_TARN_PROFIT);
					}
				}else{
					//如果转发人为空，则分成自动转入分红收益 ， 转发人收益为0
					dividendRated = dividendRated + amtTranfered;
					amtTranfered = 0;
					tranferuserId = KpContants.PAY.DEF_KP_TRAF_ID;
					// 开拍网   : 分红的收益默认打入开拍网账户  ：开拍网+分红+转发人的
					kpAmtFeed = kpAmtFeed + dividendRated;
					kpAmtFee = (long)kpAmtFeed;
					log.info("========转发人为空 ==========dividendRated:"+dividendRated
							+" kpAmtFeed:"+kpAmtFeed);
					
				}
				//投资人收益
				String invdNo = GenSeqUtils.genAmtNo(Long.valueOf(orderModel.getUserId()));
				if (0 < amtInvd){
					//更新billing系统数据
					callbackService.addUserAmtHis(amtInvd,KpContants.PAY.AMT_OP_CODE_ADD, invuserId,orderModel.getOrderNo(), amtInfo, invdNo,ORDER.PAY_TYPE_TARN_PROFIT);
					hisService.addUserAmtHis(amtInvd,KpContants.PAY.AMT_OP_CODE_ADD, invuserId,orderModel.getOrderNo(), amtInfo, invdNo,ORDER.PAY_TYPE_TARN_PROFIT);
				}
				//开拍网收益
				String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
				hisService.addUserAmtHis(kpAmtFee,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,KpContants.ORDER.PAY_TYPE_TARN_PROFIT);
				//更新billing系统数据
				callbackService.addUserAmtHis(kpAmtFee,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,ORDER.PAY_TYPE_TARN_PROFIT);
				log.info("V6 **********add amt his success!!*  kprate:"+ kprate+" dividendRate:"+dividendRate + " tranferRate:" + tranferRate + "  amtInv:"
						+ amtInv + " tranfUserId:" + tranferuserId + "  kpFeeAmt:" + kpAmtFee+" orderNo:"+ orderModel.getOrderNo());
					
				/*}else{
					
					String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
					hisService.addUserAmtHis(amt,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,ORDER.PAY_TYPE_BUY_VI);
					//更新billing系统数据
					callbackService.addUserAmtHis(amt,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,ORDER.PAY_TYPE_BUY_VI);
					log.info("V6 ********no tranferuserId**add amt his success!!*  kprate:"+ kprate + " tranferRate:" + tranferRate + "  amtInv:"
							+ amtInv + " tranfUserId:0" + "  kpFeeAmt:" + kpAmtFee+" orderNo:"+ orderModel.getOrderNo()+" amt:"+amt);
				}*/
				

				//添加用户转发收益记录
				if (!StringUtils.isEmpty(tranferuserId)) {
					VideoUserOpHisModel vuoh = new VideoUserOpHisModel();
					vuoh.setOwenUsrId(orderModel.getTranferUsrId());
					vuoh.setVideoId(videoId);
					vuoh.setOpUsrId(orderModel.getUserId());
					vuoh.setOpUsrNickName(nickName);
					vuoh.setOpType(KpContants.VIDEO.VIDEO_ORDER_TYPE_PAY_VI);
					vUserOpService.addVideoUserOpHis(vuoh);
				}
				
				//添加電影收益明細    --分红金额
				if (dividendRated>0) {
					vService.addVideoBenfitHis(videoId, dividendRated);
				}
				
				//添加電影轉發收益明細數據
				VideoUserTranAmtHis modeol = new VideoUserTranAmtHis();
				modeol.setVideoId(videoId);
				modeol.setOrderNo(orderModel.getOrderNo());
				modeol.setZzTeamAmt(amtInvd);//製作團隊收益值單位分
				modeol.setKpAmt(kpAmtFeed);
				modeol.setDividendAmt(dividendRated);
				modeol.setTranferUserAmt(amtTranfered);
				modeol.setTotalAmt(amt);
				modeol.setPayUserId(orderModel.getUserId());
				modeol.setTranferUserId(tranferuserId);
				modeol.setKpUserId(KpContants.PAY.DEF_KP_TRAF_ID);
				modeol.setZzTeamUserId(invuserId);
				modeol.setState(KpContants.PAY.USER_PRIVE_STATE_YES);
				modeol.setIsDividend(KpContants.PAY.VIDEO_TRAN_AMT_IS_BENFIED);
				videoUserTranAmtService.createVideoUserTranAmt(modeol);

			/*}else{
				//转发众筹转发次数收益权限用完后    转发人的收益 自动给到 分红收益   ; 转发人收益为0
				dividendRated = dividendRated + amtTranfered;
				// 开拍网   : 分红的收益默认打入开拍网账户  ：开拍网+分红+转发人的
				kpAmtFeed = kpAmtFeed + amtTranfered;
				kpAmtFee = (long)kpAmtFeed;
				log.info("========收益权限用完后 ==========dividendRated:"+dividendRated
						+" kpAmtFeed:"+kpAmtFeed);
				
				//投资人收益
				String invdNo = GenSeqUtils.genAmtNo(Long.valueOf(orderModel.getUserId()));
				if (0 != amtInvd){
					//更新billing系统数据
					callbackService.addUserAmtHis(amtInvd,KpContants.PAY.AMT_OP_CODE_ADD, invuserId,orderModel.getOrderNo(), amtInfo, invdNo,ORDER.PAY_TYPE_TARN_PROFIT);
					hisService.addUserAmtHis(amtInvd,KpContants.PAY.AMT_OP_CODE_ADD, invuserId,orderModel.getOrderNo(), amtInfo, invdNo,ORDER.PAY_TYPE_TARN_PROFIT);
				}else{
					hisService.addUserAmtHis(amtInvd,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID, orderModel.getOrderNo(),amtInfo, invdNo,ORDER.PAY_TYPE_TARN_PROFIT);
					//更新billing系统数据
					callbackService.addUserAmtHis(amtInvd,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID, orderModel.getOrderNo(),amtInfo, invdNo,ORDER.PAY_TYPE_TARN_PROFIT);
				}
				
				//开拍网收益
				String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
				hisService.addUserAmtHis(kpAmtFee,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,KpContants.ORDER.PAY_TYPE_TARN_PROFIT);
				//更新billing系统数据
				callbackService.addUserAmtHis(kpAmtFee,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,ORDER.PAY_TYPE_TARN_PROFIT);
				
				
				
				//=========添加電影收益明細  --分红金额
				vService.addVideoBenfitHis(videoId, dividendRated);
				
				//=========添加電影轉發收益明細數據
				VideoUserTranAmtHis modeol = new VideoUserTranAmtHis();
				modeol.setVideoId(videoId);
				modeol.setOrderNo(orderModel.getOrderNo());
				modeol.setZzTeamAmt(amtInvd);//製作團隊收益值單位分
				modeol.setKpAmt(BigDecimalUtils.mul(amt, kprate));
				modeol.setDividendAmt(dividendRated);
				modeol.setTranferUserAmt(0);//转发人收益为0
				modeol.setTotalAmt(amt);
				modeol.setPayUserId(orderModel.getUserId());
				modeol.setTranferUserId(orderModel.getTranferUsrId());
				modeol.setKpUserId(KpContants.PAY.DEF_KP_ID);
				modeol.setZzTeamUserId(invuserId);
				modeol.setState(KpContants.PAY.USER_PRIVE_STATE_YES);
				modeol.setIsDividend(KpContants.PAY.VIDEO_TRAN_AMT_IS_BENFIED);
				videoUserTranAmtService.createVideoUserTranAmt(modeol);
			}
			*/
			
			
		/*}else if (KpContants.VIDEO.VIDEO_BENFIT_TYPE_TRANSFER.equals(videoMode.getBenfitType())) {
		//收益类型 普通转发TRANSFER 
	
				//普通转发
				double kprate = videoMode.getKpFeeRate();
				double tranferRate = BigDecimalUtils.sub(1.0, kprate);
				double amtInvd = BigDecimalUtils.mul(amt, tranferRate);
				long amtInv = (long)amtInvd;
				double kpAmtFeed = BigDecimalUtils.sub(amt, amtInvd);
				long kpAmtFee = (long) kpAmtFeed;

				log.info("V5 **********videoid:" + videoId + "  kprate:" + kprate+ "  tranferRate:" + tranferRate + "  tranferuserId:"+ orderModel.getTranferUsrId() + " amtInv:" + amtInv
						+ " amt:" + amt + "  amtNo:" + amtNo+" orderNo:"+ orderModel.getOrderNo()+" amtInvd:"+amtInvd
						+" kpAmtFeed:"+kpAmtFeed);
				
				String amtInfo = "";
				if (!StringUtils.isEmpty(orderModel.getUserId())) {
					User user = userService.getUsers(orderModel.getUserId());
					amtInfo = user.getNickName() + AiwConfig.AMT_INFO;
				}
				if (!StringUtils.isEmpty(orderModel.getTranferUsrId())) {
					long tranferuserId = Long.valueOf(orderModel.getTranferUsrId());
					if (0 != orderModel.getTranferUsrId()){
						//更新billing系统数据
						callbackService.addUserAmtHis(amtInv,KpContants.PAY.AMT_OP_CODE_ADD, tranferuserId,orderModel.getOrderNo(), amtInfo, amtNo,ORDER.PAY_TYPE_BUY_VI);
						hisService.addUserAmtHis(amtInv,KpContants.PAY.AMT_OP_CODE_ADD, tranferuserId,orderModel.getOrderNo(), amtInfo, amtNo,ORDER.PAY_TYPE_BUY_VI);
					}else{
						hisService.addUserAmtHis(amtInv,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, amtNo,ORDER.PAY_TYPE_BUY_VI);
						//更新billing系统数据
						callbackService.addUserAmtHis(amtInv,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, amtNo,ORDER.PAY_TYPE_BUY_VI);
					}
					String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
					hisService.addUserAmtHis(kpAmtFee,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,KpContants.ORDER.PAY_TYPE_BUY_VI);
					//更新billing系统数据
					callbackService.addUserAmtHis(kpAmtFee,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,ORDER.PAY_TYPE_BUY_VI);
					log.info("V6 **********add amt his success!!*  kprate:"+ kprate + " tranferRate:" + tranferRate + "  amtInv:"
							+ amtInv + " tranfUserId:" + tranferuserId + "  kpFeeAmt:" + kpAmtFee+" orderNo:"+ orderModel.getOrderNo());
					
				}else{
					
					String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
					hisService.addUserAmtHis(amt,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,ORDER.PAY_TYPE_BUY_VI);
					//更新billing系统数据
					callbackService.addUserAmtHis(amt,KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(),amtInfo, kpAmtNo,ORDER.PAY_TYPE_BUY_VI);
					log.info("V6 ********no tranferuserId**add amt his success!!*  kprate:"+ kprate + " tranferRate:" + tranferRate + "  amtInv:"
							+ amtInv + " tranfUserId:0" + "  kpFeeAmt:" + kpAmtFee+" orderNo:"+ orderModel.getOrderNo()+" amt:"+amt);
					
				}
			
		} else if (KpContants.VIDEO.VIDEO_BENFIT_TYPE_INVESTORS.equals(videoMode.getBenfitType())) {
		//收益类型 投资人归属收益 INVESTORS 
	
			double kprate = videoMode.getKpFeeRate();
			double invetorRate = BigDecimalUtils.sub(1.0, kprate);
			double amtInvd = BigDecimalUtils.mul(amt, invetorRate);
			long amtInv = (long)amtInvd;
			double kpAmtFeed = BigDecimalUtils.sub(amt, amtInvd);
			long kpAmtFee = (long) kpAmtFeed;
			long invuserId = Long.valueOf(videoMode.getBenfitUsrId());

			String amtInfo = "";
			if (!StringUtils.isEmpty(orderModel.getUserId())) {
				User user = userService.getUsers(orderModel.getUserId());
				amtInfo = user.getNickName() + AiwConfig.AMT_INFO;
			}
			hisService.addUserAmtHis(amtInv, KpContants.PAY.AMT_OP_CODE_ADD,invuserId, orderModel.getOrderNo(), amtInfo, amtNo,ORDER.PAY_TYPE_BUY_VI);
			//更新billing系统数据
			callbackService.addUserAmtHis(amtInv, KpContants.PAY.AMT_OP_CODE_ADD,invuserId, orderModel.getOrderNo(), amtInfo, amtNo,ORDER.PAY_TYPE_BUY_VI);
			String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
			hisService.addUserAmtHis(kpAmtFee, KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(), amtInfo, kpAmtNo, ORDER.PAY_TYPE_BUY_VI);
			//更新billing系统数据
			callbackService.addUserAmtHis(kpAmtFee, KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_TRAF_ID, orderModel.getOrderNo(), amtInfo, kpAmtNo, ORDER.PAY_TYPE_BUY_VI);
			log.info("V4 ******add amt his success!!*  kprate:" + kprate+ " benfitRate:" + invetorRate + "  amtInv:" + amtInv
					+ " invuserId:" + invuserId + "  kpFeeAmt:" + kpAmtFee+" orderNo:"+ orderModel.getOrderNo()+" amtInvd:"+amtInvd
					+" kpAmtFeed:"+kpAmtFeed);
		}*/

		UserVideoRole videoRole = new UserVideoRole();
		videoRole.setRoleCode(KpContants.VIDEO.VIDEO_ROLE_CODE);
		videoRole.setUserId(orderModel.getUserId());
		videoRole.setVideoId(videoId);
		userService.addUserViedoRole(videoRole);
		log.info("V6 ******add video Role  his success!!*  userId:"+ orderModel.getUserId() + "  videoId:" + videoId+" orderNo:"+ orderModel.getOrderNo());
	}

}
