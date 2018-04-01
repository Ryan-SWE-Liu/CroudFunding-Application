package com.kaipai.ck.mapper.bill;

import java.util.List;
import java.util.Map;

import com.kaipai.base.AiwMyBaitsMapper;
import com.kaipai.ck.model.bill.QueOpUsrAmtModel;
import com.kaipai.ck.model.bill.UserStockHisModel;
import com.kaipai.ck.model.trade.BuyStockHisModel;
import com.kaipai.ck.model.trade.UserStockModel;

public interface TradeStockMapper extends AiwMyBaitsMapper{

	public BuyStockHisModel getBuyStockByUserIdAndPno(Map<String,Object> paraMap);
		
	public void insertBuyUserStock(BuyStockHisModel buyHisModel);
	/**
	 * 查询用户股份数目根据用户ID和股票代码
	 * @param map
	 * @return
	 */
	public List<UserStockModel> getUserStockByUserIdAndStockCode(Map<String,Object> paraMap);
	
	public int updateLockSaleUserStock(Map<String,Object> paraMap);

	public int addBuyUserStock(Map<String,Object> paraMap);

	public int updateReleaseSaleUserStock(Map<String,Object> paraMap);
	
	public int updateLockUserBuyStockAmt(Map<String,Object> paraMap);

	public int updateReleaseUserBuyStockAmt(Map<String,Object> paraMap);
	
	public int updateIncreaseUserSaleStockAmt(Map<String,Object> paraMap);
	
	public int insertUserStock(UserStockModel userStockModel) ;

	public int tradeSuccessSalUserStock(Map<String,Object> paraMap);
	
	public int tradeSuccessSalUserStockEmptyCostAmtTtl(Map<String,Object> paraMap);
	
	public int tradeSuccessUserBuyStockAmt(Map<String,Object> paraMap);
	
	public List<UserStockModel> getUserStockIsEmpty(Map<String,Object> paraMap);
	
	public int updateSubUserLockAmt(Map<String,Object> paraMap);
	
	
	public int insertUserStocckHis(UserStockHisModel userStockHisModel);
	
	
	//public int opUserAmtPro(Map<String,Object> paraMap);
	
	public Long getUserPrivVersion(Long userId);
	
	
	public Long lockBuyAnSalUserId(Map<String,Object> paraMap);
	
	public Long insertUsrOpAmtQueue(QueOpUsrAmtModel queOpUsrAmtModel);
	
	public int updateUsrOpAmtQueueStatus(long qAmtId);
	
	public double getAllUsrAmtTtl();
	
	public long getStockNumTtlByStock(String stockCode);
	
	public int findUserStockCount(long userId);

	 
	

}
