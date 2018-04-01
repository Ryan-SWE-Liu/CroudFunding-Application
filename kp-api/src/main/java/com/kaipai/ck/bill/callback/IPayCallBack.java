package com.kaipai.ck.bill.callback;

import com.kaipai.ck.model.CallBackModel;
import com.kaipai.ck.model.order.OrderModel;

public interface IPayCallBack {

	public abstract void callBack(CallBackModel callModel,OrderModel orderModel) ;	
}
