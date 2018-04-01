package com.kaipai.ck.mapper.bill;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.base.AiwMyBaitsMapper;
import com.kaipai.ck.model.bill.PayCallbackHis;
import com.kaipai.ck.model.bill.PayHis;
import com.kaipai.ck.model.bill.UserAmtHis;
import com.kaipai.ck.model.video.VideoBalanceModel;


public interface PayHisMapper extends AiwMyBaitsMapper {
	
	/**
	 * 查询视频结算信息
	 * @param page
	 * @return
	 */
	public VideoBalanceModel findVideoBalance(HashMap<String, Object> page);
	
	/**
	 * 查询所有用户付款明细
	 * @return
	 */
	public List<PayHis> findPayHisPage(HashMap<String, Object> page);

	/**
	 * 获取所有记录数，用于分页显示
	 * @return
	 */
	public long findPayHisCount(HashMap<String, Object> page);
	
	/**
	 * 查询具体一条记录
	 * @param amtNo
	 * @return
	 */
	public PayHis findPayHisByAmtNo(String amtNo);
	

	/**
	 * 查询用户收益kp_user_priv_info
	 * @return
	 */
	public String findUserIncomeMoney(HashMap<String, Object> map);

	/**
	 * 查询用户收益bi_user_amt_his
	 * @return
	 */
	public String findUserIncomeMoney2(HashMap<String, Object> map);

	
	/**
	 * 查询用户增加的金额
	 * @return
	 */
	public long findUserIncomeADDMoney(HashMap<String, Object> map);
	/**
	 * 查询用户支出金额
	 * @return
	 */
	public long findUserIncomeDECMoney(HashMap<String, Object> map);
	
	/**
	 * 根据类型统计用户账单
	 * @param userId
	 * @param busiCode
	 * @return
	 */
	public double getTotalByType(@Param("userId")String userId,@Param("busiCode")String busiCode);
	
	
	/**
	 * 添加用户付款明细
	 * @param PayHis
	 * @return
	 */
	public int createPayHis(PayHis PayHis);

	/**
	 * 修改用户付款明细
	 * @param PayHis
	 * @return
	 */
	public int updatePayHis(PayHis PayHis);
	
	/**
	 * 删除用户付款明细
	 * @param PayHis
	 * @return
	 */
	public int delPayHis(PayHis PayHis);
	
	
	public PayHis findPayhisByOrderNo(String orderNo);
	
	public PayHis findBiPayHisByOrderNo(String orderNo);
	
	
			/**==============用户付款明细回调==============**/
	
	
	
	/**
	 * 查询所有用户付款明细回调
	 * @return
	 */
	public List<PayCallbackHis> findPayCallbackHisPage(HashMap<String, Object> page);

	/**
	 * 获取所有记录数，用于分页显示
	 * @return
	 */
	public long findPayCallbackHisCount(HashMap<String, Object> page);
	
	/**
	 * 添加用户付款明细回调
	 * @param PayCallbackHis
	 * @return
	 */
	public int createPayCallbackHis(PayCallbackHis PayCallbackHis);
	public void successedCallBackState(String orderNo);
	
	
	/**
	 * 删除用户付款明细回调
	 * @param PayCallbackHis
	 * @return
	 */
	public int delPayCallbackHis(PayCallbackHis PayCallbackHis);
	
	
	public void updatePayHisBycallBack(Map<String,String> map);
	
	
	public long isHaveCallByNo(String orderNo);
	
	
	public int addUserAmtHis(UserAmtHis userAmtHis);	
	
	/**
	 * 统计时间段内充值金额
	 * @param startTm
	 * @param endTm
	 * @return
	 */
	public double findRechargeInPeriod(@Param("startTm")Date startTm,@Param("endTm")Date endTm);
	
	/**
	 * 统计时间段内充值用户数
	 * @param startTm
	 * @param endTm
	 * @return
	 */
	public int findRechargeCount(@Param("startTm")Date startTm,@Param("endTm")Date endTm);
	
	/**
	 * 统计时段内交易手续费
	 * @param startTm
	 * @param endTm
	 * @return
	 */
	public double findFeeInPerios(@Param("startTm")Date startTm,@Param("endTm")Date endTm);
	
}
