package com.kaipai.ck.mapper.bill;

import java.util.List;

import com.kaipai.ck.model.bill.UserWithdrawBindModel;

public interface UserWithdrawBindMapper {
	
	/**
	 * 用户绑定信息
	 * @param userId
	 * @return
	 */
	List<UserWithdrawBindModel> findWithdrawBindByUserId(long userId);
	
	/**
	 * 绑定网络提现信息
	 * @param userWithdrawBind
	 * @return
	 */
	int createUserWithdrawBind(UserWithdrawBindModel userWithdrawBind);
	
	/**
	 * 更新网络提现信息
	 * @param userWithdrawBind
	 * @return
	 */
	int updateUserWithdrawBind(UserWithdrawBindModel userWithdrawBind);
	
	/**
	 * 查询是否已有绑定
	 * @param userId
	 * @param bindType
	 * @return
	 */
	int findBindIsHave(UserWithdrawBindModel userWithdrawBind);
	
	

}
