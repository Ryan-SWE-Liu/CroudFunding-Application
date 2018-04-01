package com.kaipai.ck.mapper.bill;

import java.util.List;
import java.util.Map;


public interface UserPrivBillMapper {
	
	
	public int updateRecharge(Map<String,Object> paraMap);
	public int updatePostWithdrawal(Map<String,Object> paraMap);
	public int updatePassWithdrawal(Map<String,Object> paraMap);
	public int updateRefuseWithdrawal(Map<String,Object> paraMap);
	public Long getUserPrivVer(long userId);
	public int updateWasteAmt(Map<String,Object> paraMap);
	public long lockUserForUpdateByUserId(long userId);
	public int updateKPWithdrawal(Map<String,Object> paraMap);
	/**
	 * 总可用金额
	 * @return
	 */
	public double findAmountTotal();
	
	/**
	 * 总可用金额
	 * @return
	 */
	public double findAmountTotalExcludeFade(List<Long> idList);
	
	/**
	 * 交易锁定金额
	 * @return
	 */
	public double findLockAmountTotal();

}
