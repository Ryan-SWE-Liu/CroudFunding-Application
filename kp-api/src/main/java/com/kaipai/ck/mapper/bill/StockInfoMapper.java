package com.kaipai.ck.mapper.bill;

import java.util.List;

import com.kaipai.base.AiwMyBaitsMapper;
import com.kaipai.ck.model.bill.StockInfoModel;

public interface StockInfoMapper extends AiwMyBaitsMapper{

		
	/**
	 * 添加股票信息
	 * @param stockInfoModel
	 */
	public int insertStockInfo(StockInfoModel stockInfoModel);
	
	/**
	 * 更新股票状态
	 * @param stockInfoModel
	 * @return
	 */
	public int updateStockState(StockInfoModel stockInfoModel);
	
	
	/**
	 * 流通比排名， 低的靠前
	 * @return
	 */
	public List<String> findCricOrder(); 
	
	
	/**
	 * 发行股票用户
	 * @return
	 */
	public List<Long> findStockUserIds();
	
	/**
	 * 股票持有人数， 包括曾经持有人
	 * @param stockCode
	 * @return
	 */
	public int findStockOwersCount(String stockCode);
	
}
