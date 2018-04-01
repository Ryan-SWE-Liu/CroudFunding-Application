package com.kaipai.ck.bill.callback;

import org.apache.log4j.Logger;

import com.kaipai.ck.configs.LogAppenderConfig;
import com.kaipai.ck.model.CallBackModel;
import com.kaipai.ck.model.order.OrderModel;
import com.kaipai.ck.service.bill.PayHisService;
import com.kaipai.ck.service.contributiveList.ContributiveService;
import com.kaipai.ck.service.movie.MovieVideoService;
import com.kaipai.ck.service.order.OrdersService;
import com.kaipai.ck.service.security.UserService;
import com.kaipai.ck.service.userManage.UserPointsService;
import com.kaipai.interfaces.bill.ICallbackService;
import com.kaipai.utils.SpringUtils;

public abstract class AbstractPayCallBack implements IPayCallBack {
	 protected final transient Logger log = Logger.getLogger(LogAppenderConfig.LOG_APPEND_PAY);
	 protected PayHisService hisService = null;
	 protected UserService userService = null;
	 protected OrdersService orderService = null;
	 protected ContributiveService contributiveService = null;
	 protected ICallbackService callbackService = null;
	 protected UserPointsService userPointService = null;
	 protected MovieVideoService movieVideoService = null;
	 
	 @Override
	 public void callBack(CallBackModel callModel, OrderModel orderModel) {
			 hisService = SpringUtils.getBean(PayHisService.class);
			 orderService = SpringUtils.getBean(OrdersService.class);	
			 userService = SpringUtils.getBean(UserService.class);
			 contributiveService = SpringUtils.getBean(ContributiveService.class);
			 callbackService = SpringUtils.getBean("callbackService",ICallbackService.class);
			 userPointService = SpringUtils.getBean(UserPointsService.class);
			 movieVideoService = SpringUtils.getBean(MovieVideoService.class);
			 execute(orderModel); 
//			// addCallBackHis(callModel);
//			 if(callModel instanceof InWxCallBackMsg){
//				 execute(orderModel); 
//				// updatePayHisCallBackState(callModel);
//				// successOrderState(orderModel.getOrderNo());
//			 }else if(callModel instanceof AlipayParam) {
//				 
		//	 }
	}
	    
	
	
	abstract protected void execute(OrderModel orderModel);

}
