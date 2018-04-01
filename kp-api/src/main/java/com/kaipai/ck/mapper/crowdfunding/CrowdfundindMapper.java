package com.kaipai.ck.mapper.crowdfunding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.mapper.BaseMapper;
import com.kaipai.ck.model.contributiveList.CollDrawModel;
import com.kaipai.ck.model.crowdfunding.CollBenfitModel;
import com.kaipai.ck.model.crowdfunding.CollContributionModel;
import com.kaipai.ck.model.crowdfunding.CollEmployeeModel;
import com.kaipai.ck.model.crowdfunding.CollPayHisModel;
import com.kaipai.ck.model.crowdfunding.CrowdfundingModel;
import com.kaipai.ck.model.crowdfunding.SimpleCollModel;
import com.kaipai.ck.model.crowdfunding.XfAppCollModel;
import com.kaipai.ck.model.crowdfunding.XfAppCrowdfundingModel;
import com.kaipai.ck.model.crowdfunding.XzyPurchaseDetail;
import com.kaipai.ck.model.movie.UserCollMovieModel;
import com.kaipai.ck.model.trade.UserStockModel;

public interface CrowdfundindMapper extends BaseMapper<CrowdfundingModel>{
	
	public long getUserCollListSumMoneyByCollNo(@Param("collNo")String collNo);
	
	/**
	 * 星主页App我的认购列表
	 * @param map
	 * @return
	 */
	public List<UserCollMovieModel> getMyCollMovieBeatList(HashMap<String,Object> map);
	
	/**
	 * 星主页App我的认购项目 详情
	 * @param map
	 * @return
	 */
	public UserCollMovieModel getMyCollMovieByUserIdAndCollNo(HashMap<String,Object> map);
	
	/**
	 * 星主页App我的认购项目
	 * @param map
	 * @return
	 */
	public List<UserCollMovieModel> getMyCollMovieByUserId(HashMap<String,Object> map);
	
	/**
	 * 星主页App查询众筹详情
	 * @param map
	 * @return
	 */
	public XfAppCrowdfundingModel selectXfAppCollInfo(HashMap<String,Object> map);

	/**
	 * 分页查询出资人列表
	 * @param page
	 * @return
	 */
	public List<CollContributionModel> findContributionsPage(HashMap<String,Object> page);
	
	/**
	 * 查询众筹列表
	 */
	public List<CrowdfundingModel> findCrowdfunds(HashMap<String,Object> page);
	public List<CrowdfundingModel> appFindCrowdfunds(HashMap<String,Object> page);
	
	/**
	 * 用户有没有认购项目
	 * @param collNo
	 * @param userId
	 * @return
	 */
	public int findUserHavePayForColl(@Param("collNo")String collNo,@Param("userId")String userId);
	/**
	 * 获取所有记录数，用于分页显示
	 * @param index 第几页
	 * @param size 每页显示个数
	 * @return
	 */
	/**
	 * 获取所有记录数，用于分页显示
	 * @return
	 */
	public long getTotalCount(HashMap<String, Object> page);
	/*用于后台管理*/
	public long getTotalCountBs(HashMap<String, Object> page);
	/**
	 * 查询众筹详情
	 */
	public CrowdfundingModel findCrowdfundsDetail(HashMap<String,Object> page);
	public CrowdfundingModel appFindCrowdfundsDetail(HashMap<String,Object> page);
	public List<CrowdfundingModel> findMyCollectionByUserId(Map<String,Object> map);
	int createLikes(CrowdfundingModel model);
	int updateLikes(CrowdfundingModel model);
	
	public List<CollBenfitModel> getCollBenfit(HashMap<String, Object> hashMap);
	public List<CrowdfundingModel> findHotColl(HashMap<String, Object> hashMap);
	public int buyPenfit(HashMap<String, Object> hashMap);
	/**
	 * 获取众筹收益可购买数量
	 * @param hashMap
	 * @return
	 */
	Long getCollBenfitSize(HashMap<String, Object> hashMap);
	
	/**
	 * 获取众筹收益已购买数量
	 * @param hashMap
	 * @return
	 */
	Long getOrderCollBenfit(HashMap<String, Object> hashMap);
	
	/**
	 * 查询出资人列表
	 * @param collNo
	 * @return
	 */
	List<CollContributionModel> findContributions(String collNo);
	
	/**
	 * 查询出资人列表不分组
	 * @param map
	 * @return
	 */
	public List<CollContributionModel> findCollRankAll(HashMap<String, Object> map);
	
	/*******************************************************/
	/*******************************************************/
	//业务员查看众筹项目
	CollEmployeeModel findCollByUserId(String userId);
	CollEmployeeModel findCollByuserIdAndCollNo(Map<String,Object> map);
	List<CrowdfundingModel> findCollListByUserId(String userId);
	//业务员查看众筹项目下用户众筹情况
	List<CollPayHisModel> findCollUserListByuserId(Map<String,Object> map);
	//业务员查看具体众筹项目下用户众筹情况
	List<CollPayHisModel> findCollUserListByCollNoAndUserId(Map<String,Object>map);
	//查找所有产品的ID
	List<String> findBenIds();
	
	
	
	
	public List<CrowdfundingModel> findContribute(HashMap<String,Object> m);
	public long findContributeCount(String collNo);
	
	public List<CrowdfundingModel> findCrowdFundingInfo(CrowdfundingModel t);
	int editUpdateBean(CrowdfundingModel t);
	int createActMov(CrowdfundingModel t);
	int updateCrowdFundingInfo(@Param("collNo")String collNo,@Param("collBenId")List<String> collBenId);
	int updateCrowdFundingInfoByCollNo(CrowdfundingModel t);
	int createCrowdFundingInfo(List<CrowdfundingModel> item);

	
	public List<CrowdfundingModel> findCrowdFundingsByParams(CrowdfundingModel t);
	
	public int updateCrowdFundingVideo(CrowdfundingModel model);
	public int showCrowdFunding(CrowdfundingModel t);
	public CrowdfundingModel findCrowdFundingSTandED(CrowdfundingModel t);
	
	public List<CrowdfundingModel> findColl2UpdateState(CrowdfundingModel t);
	public List<CrowdfundingModel> findColl2UpdateState2(CrowdfundingModel t);
	public List<CrowdfundingModel> findColl3UpdateState(CrowdfundingModel t);
	
	public int updateCollState(@Param("collState")String collState,
			@Param("collNos")String collNos);
	
	
	public int updateCollBenfit(CrowdfundingModel t);
	
	/**
	 * xfapp 项目列表
	 * @param map
	 * @return
	 */
	public List<XfAppCollModel> xfappFindCollList(Map<String, Object> map);
	
	/**
	 * 项目下单详情
	 * @param benfitId
	 * @return
	 */
	public CollBenfitModel getBefitDetail(String benfitId);
	
	/**
	 * 查看用户购买份数
	 * @param collBenId Long
	 * @return List<CrowdfundingModel>
	 */
	public List<CrowdfundingModel> getUserCollListByBenId(Long collBenId);
	
	/**
	 * 查看溢价项目的总金额和总购买金额
	 * @param collNo String
	 * @return CrowdfundingModel
	 */
	public CrowdfundingModel getRiseCollTotalAmt(String collNo);
	
	/**
	 * 众筹项目列表
	 * @param collNo
	 * @return
	 */
	public List<String> findBenfitIdList(String collNo); 
	
	/**
	 * 申购详情
	 * @param collNo
	 * @return
	 */
	public XzyPurchaseDetail findXzyPurchaseDetail(String collNo);
	
	/**
	 * 查找抽签源
	 * @param benfitId
	 * @return
	 */
	public List<CollDrawModel> findDrawModel(String benfitId);
	
	/**
	 * 更新抽签结果
	 * @param draw
	 * @return
	 */
	public int updateDrawResult(CollDrawModel draw);
	
	
	/**
	 * 更新最终开盘金额
	 * @param benfit
	 * @return
	 */
	public int updateBenfitFloat(@Param("benfitId")String benfit,@Param("floatAmt")double floatAmt);
	
	/**
	 * 根据众筹状态查询众筹号
	 * @param status
	 * @return
	 */
	public List<String> findCollNoByStatus(String status); 
	
	/**
	 * 一个用户的认购量
	 * @param benfit
	 * @param userId
	 * @return
	 */
	public long findContributeSumByUserId(@Param("benfitId")String benfitId,@Param("userId")String userId);
	
	/**
	 * 申请抽签结果，转化成股份
	 * @param collNo
	 * @return
	 */
	public List<UserStockModel> findDrawRes(@Param("collNo")String collNo);
	
	/**
	 * 根据类型查询
	 * @param collType
	 * @return
	 */
	public List<SimpleCollModel> findCollListToEnd();
	
	/**
	 * 认购中的星券
	 * @param userId
	 * @return
	 */
	public int findSalingXqByUserId(@Param("userId")String userId);
	
	/**
	 * 根据benId查找众筹状态
	 * @param benId
	 * @return
	 */
	public String findCollStateByBenId(@Param("benId")String benId);
}
