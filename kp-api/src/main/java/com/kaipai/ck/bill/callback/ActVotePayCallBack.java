package com.kaipai.ck.bill.callback;


import org.springframework.util.StringUtils;

import com.kaipai.ck.configs.AiwConfig;
import com.kaipai.ck.constant.KpContants;
import com.kaipai.ck.constant.KpContants.ORDER;
import com.kaipai.ck.model.order.OrderModel;
import com.kaipai.ck.model.security.User;
import com.kaipai.ck.service.recruitService.RecruitService;
import com.kaipai.utils.GenSeqUtils;
import com.kaipai.utils.SpringUtils;

public class ActVotePayCallBack extends AbstractPayCallBack {

	/**
	 * 活动报名支付回调逻辑
	 */
	@Override
	protected void execute(OrderModel orderModel) {
		log.info("A3 **********Start caulate the orderNo!********"	+ orderModel.getOrderNo() + " actRecSignId:"
				+ orderModel.getActRecSignId());

		RecruitService recruitService = SpringUtils.getBean(RecruitService.class);
		
		int re = recruitService.updateActRecruitSignsFeeFlg(orderModel.getActRecSignId());
		log.info("===========updateActRecruitSignsFeeFlg=========result:"+re);
		
		StringBuffer userNickName = new StringBuffer("匿名");
		if(!StringUtils.isEmpty(orderModel.getUserId())){
            User user = userService.getUsers(orderModel.getUserId());
            userNickName.append(user.getNickName()).append(AiwConfig.ACT_AMT_INFO) ;
        }
		String kpAmtNo = GenSeqUtils.genAmtNo(orderModel.getUserId());
	    hisService.addUserAmtHis(orderModel.getOdrAmt(), KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID ,orderModel.getOrderNo(), userNickName.toString(),kpAmtNo,ORDER.PAY_TYPE_ACT_FEE);
		callbackService.addUserAmtHis(orderModel.getOdrAmt(), KpContants.PAY.AMT_OP_CODE_ADD,KpContants.PAY.DEF_KP_ID ,orderModel.getOrderNo(), userNickName.toString(),kpAmtNo,ORDER.PAY_TYPE_ACT_FEE);
	    log.info("*****学员报名支付学费*****OK****** kpAmtNo:"+kpAmtNo);
	}

}
