package com.kaipai.ck.mapper.coin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.coins.CoinModel;
import com.kaipai.ck.model.coins.UserCoinAddressModel;
import com.kaipai.ck.model.coins.UserCoinPayHisModel;
import com.kaipai.ck.model.coins.UserCoinWithdrawRecodeModel;
import com.kaipai.ck.model.coins.UserCoinsModel;

public interface UserCoinMapper {
	
	/**
	 * 创建用户币值记录
	 * @param userCoin
	 * @return
	 */
	public int createUserCoin(UserCoinsModel userCoin);
	/**
	 * 查找币值记录
	 * @param userCoin
	 * @return
	 */
	public UserCoinsModel findCoinModelByUserIdAndCoinCode(UserCoinsModel userCoin);
	/**
	 * 查找用户的所有记录
	 * @param userId
	 * @return
	 */
	public List<UserCoinsModel> findUserCoinsByUserId(long userId);
	/**
	 * 增加值
	 * @param userId
	 * @param coinCode
	 * @param val
	 * @return
	 */
	public int addUserCoinVal(@Param(value="userId")long userId,@Param(value="coinCode")String coinCode,@Param(value="val")double val);
	/**
	 * 用户币值消费
	 * @param userId
	 * @param coinCode
	 * @param val
	 * @return
	 */
	public int subUserCoinVal(@Param(value="userId")long userId,@Param(value="coinCode")String coinCode,@Param(value="val")double val);
	/**
	 * 检查用户币值够不够
	 * @param userId
	 * @param coinCode
	 * @param val
	 * @return
	 */
	public long checkUserCoinVal(@Param(value="userId")long userId,@Param(value="coinCode")String coinCode,@Param(value="val")double val);
	
	/**
	 * 添加消费记录
	 * @param userCoinPayHis
	 * @return
	 */
	public int createUserCoinPayHis(UserCoinPayHisModel userCoinPayHis);
	/**
	 * 查看消费记录
	 * @param userId
	 * @return
	 */
	public List<UserCoinPayHisModel> findUserCoinPayHisByUserId(Map<String, Object> map);
	
	/**
	 * 检查充值历史
	 * @param address
	 * @param txid
	 * @return
	 */
	public long findRechargeRecordByTxid(@Param(value="address")String address,@Param(value="txid")String txid);
	
	/**
	 * 创建或更新一个充值地址
	 * @param address
	 * @return
	 */
	public int createOrUpdateUserCoinAddress(UserCoinAddressModel address);
	
	/**
	 * 查找充值地址
	 * @param userId
	 * @param coinCode
	 * @return
	 */
	public UserCoinAddressModel getUserCoinAddress(@Param(value="userId") long userId,@Param("coinCode") String coinCode);
	
	
	/**
	 * 查找用户提现地址
	 * @param userId
	 * @param coinCode
	 * @return
	 */
	public UserCoinAddressModel getUserCoinWithdrawAddress(@Param(value="userId") long userId,@Param("coinCode") String coinCode);
	
	/**
	 * 添加或更新用户提现地址
	 * @param address
	 * @return
	 */
	public int updateOrCreateUserCoinWithdrawAddress(UserCoinAddressModel address);
	
	/**
	 * 提现记录
	 * @return
	 */
	public int createUserCoinWithdrawHis(UserCoinWithdrawRecodeModel record);
	
	/**
	 * 查看提现记录
	 * @param map
	 * @return
	 */
	public List<UserCoinWithdrawRecodeModel> findUserCoinWithdrawRecode(Map<String, Object> map);
	
	/**
	 * 定时任务查找所有需要验证的充值
	 * @return
	 */
	public List<UserCoinAddressModel> getNeedCheckAddress();
	
	public int updateTest(String userId);
	
	/**
	 * 取到小蚁股没有分配给用户的地址
	 */
	public String findAnsAddrsss();
	
	public int updateAnsAddressPool(String address);
	
	/**
	 * 记录已经处理的区块
	 * @param coinCode
	 * @param blockCount
	 * @return
	 */
	public int updateCoinParseRecode(@Param("coinCode")String coinCode,@Param("blockCount")int blockCount);
	
	/**
	 * 查询被处理的区块
	 * @param coinCode
	 * @return
	 */
	public int findCoinParseRecode(String coinCode);
	
	/**
	 * 查找所有用户的地址
	 * @param coinCode
	 * @return
	 */
	public List<UserCoinAddressModel> findAllUserAddress(String coinCode); 
	
	/**
	 * 用户虚拟货币信息
	 * @param userId
	 * @param coinCode
	 * @return
	 */
	public CoinModel findUserCoinByUserIdAndCode(@Param("userId")long userId,@Param("coinCode")String coinCode);
}
