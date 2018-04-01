package com.kaipai.ck.mapper.bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.bill.UserAmtHis;
import com.kaipai.ck.model.bill.UserBankInfoModel;
import com.kaipai.ck.model.bill.UserPrivateInfo;
import com.kaipai.ck.model.bill.Withdraw;
import com.kaipai.ck.model.bill.WithdrawFreezeModel;


public interface WithdrawMapper{
	
	
	/**
	 * 添加提现记录
	 * @param withdraw
	 * @return
	 */
	public int addBiWithdrawHis(Withdraw withdraw);
	
	/**
	 * 查看个人的提现记录
	 * @param map
	 * @return
	 */
	public List<Withdraw> findWithdrawByUserId(Map<String,Object> map);
	

			/**========================用户银行信息==========================**/
	
	/**
	 * 用户银行信息表
	 * @param withdraw
	 * @return
	 */
	public int addUserBankInfo(Withdraw withdraw);
	
	
	
	/**
	 * 根据userId查询银行信息
	 * @param userId
	 * @return
	 */
	public List<UserBankInfoModel> findUserBankInfoByUserId(String userId);
	
	/**
	 * 检查用户银行信息是否存在？
	 * @param withdraw
	 * @return
	 */
	public int checkBankNoIsExist(Withdraw withdraw);
	
	/**
	 * 将设置银行卡的时间，用于排序
	 * @param map
	 */
	public void updateBankInfoCreateTm(Map<String, Object> map);
	
	/**
	 * 根据ID查一条银行信息
	 * @param bankId
	 * @return
	 */
	public UserBankInfoModel findUserBankInfoByBankId(String bankId);
	
	/**
	 * 删除用户银行信息
	 * @param withdraw
	 * @return
	 */
	public int deleteUserBankInfoByUserId(Withdraw withdraw);
	

	/**========================用户私有信息==========================**/

	/**
	 * 获取用户私有信息
	 * @param userPrivateInfo
	 * @return
	 */
	public UserPrivateInfo findUserPrivateInfoByUserId(UserPrivateInfo userPrivateInfo);
	
	/**
	* 用户私有信息
	* @param userPrivateInfo
	* @return
	*/
	public int updateUserPrivateInfo(UserPrivateInfo userPrivateInfo);
	
	/**
	* 用户私有信息
	* @param userPrivateInfo
	* @return
	*/
	public int addUserPrivateInfo(UserPrivateInfo userPrivateInfo);
	
	/**
	* 删除私有信息
	* @param userPrivateInfo
	* @return
	*/
	public int deleteUserPrivateInfoByUserId(UserPrivateInfo userPrivateInfo);
	
	/**
	 * 收益或充值更新用户的余额
	 * userId 用户ID
	 * amt 金额为正
	 * @param map
	 * @return
	 */
	public int updateUserPriAmt(Map<String,Object>map);
	
	/**
	 * 更新提现申请审核状态
	 * @param withdraw
	 * @return
	 */
	public int updateBeanAuditState(Withdraw withdraw);
	
	/**
	 * 余额确认
	 * @param map
	 * @return
	 */
	public int checkBalance(Map<String, Object> map);
	/**
	 * 余额支付
	 * @param map
	 * @return
	 */
	public int updateUserPayWithBalance(Map<String, Object> map);

	/**
	 * 更新提现申请审核状态
	 * @param withdraw
	 * @return
	 */
	public int deleteBean(Withdraw withdraw);
	
	/**
	 * 获取提现申请详情
	 * @param id
	 * @return
	 */
	public Withdraw getWithdrawById(String id);
	
	/**
	 * 获取分页列表
	 * @param page
	 * @return
	 */
	public List<Withdraw> findList(HashMap<String,Object> page);
	
	public List<Withdraw> findWithdrawByTmAndState(Map<String, Object> map);
	public long findWithdrawByTmAndStateCount(Map<String, Object> map);

	public long getTotalCount(HashMap<String,Object> page);
	
	
		/**====================用户金额明细==================**/
	
	/**
	 * 获取用户金额明细分页列表
	 * @param page
	 * @return
	 */
	public List<UserAmtHis> findPayHisPage(HashMap<String,Object> page);

	public long findPayHisCount(HashMap<String,Object> page);
	
	/**
	 * 查询用户金额详情
	 * @param amtNo
	 * @return
	 */
  public UserAmtHis findSumPay();
   	/**
   	 * 查询用户总金额详情
   	 * @param amtNo
   	 * @return
   	 */
	
	
	
	
	public UserAmtHis findPayHisByAmtNo(String amtNo);

	/**
	 * 添加用户金额明细列表
	 * @param userAmtHis
	 * @return
	 */
	public int addUserAmtHis(UserAmtHis userAmtHis);
	
	/**
	 * 增加或是更新冻结艺人提现
	 * @param model
	 * @return
	 */
	public int insertOrUpdateFreezeWithdraw(@Param("userId")long userId,@Param("num")Integer num,@Param("reason")String reason);
	
	/**
	 * 查询冻结详情
	 * @param userId
	 * @return
	 */
	public WithdrawFreezeModel findWithdrawFreeze(long userId);
	
	
	/**
	 * 更新冻结时间
	 * @param model
	 * @return
	 */
	public int updateFreezeDate(WithdrawFreezeModel model);
	

	
}
