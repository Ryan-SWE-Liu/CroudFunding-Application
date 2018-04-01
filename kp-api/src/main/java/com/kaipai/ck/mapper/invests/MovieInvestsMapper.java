package com.kaipai.ck.mapper.invests;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.kaipai.ck.model.invests.MovieIntentionList;
import com.kaipai.ck.model.invests.MovieInvestList;
import com.kaipai.ck.model.invests.MovieInvests;




/**
 * 电影投资管理
 *
 */
public interface MovieInvestsMapper {
	
	/**
	 * 添加投资意向信息
	 * @param movieIntentionList
	 * @return
	 */
	public int insertMovieIntentionList(MovieIntentionList movieIntentionList);

	/**
	 * 查询电影投资列表
	 * @param map Map<String,Object>
	 * @return List<MovieInvests>
	 */
	List<MovieInvests> getMovieInvestsList(Map<String,Object> map);
	
	/**
	 * 修改电影投资项目
	 * @param movieInvests MovieInvests
	 */
	void updateMovieInvests(MovieInvests movieInvests);
	
	/**
	 * 添加电影投资项目
	 * @param movieInvests
	 * @return
	 */
	public int insertMovieInvests(MovieInvests movieInvests);
	
	/**
	 * 查询电影投资列表总数
	 * @param map
	 * @return Integer
	 */
	Integer getMovieInvestsCount(Map<String,Object> map);
	
	/**
	 * 获取投资列表
	 * @param movNo String
	 * @return List<MovieInvestList>
	 */
	List<MovieInvestList> getMovieInvestLists(Map<String,Object> map);
	
	/**
	 * 获取投资列表总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	Integer getMovieInvestListsCount(Map<String,Object> map);
	
	/**
	 * 根据电影项目编号获取总投资金额 
	 * @param movNo String
	 * @return BigDecimal
	 */
	BigDecimal getMovieInvestListInvestAmt(String movNo);
	
	/**
	 * 查询投资意向列表
	 * @param map Map<String,Object>
	 * @return List<MovieIntentionList>
	 */
	List<MovieIntentionList> getMovieIntentionList(Map<String,Object> map);
	
	/**
	 * 根据ID查询投资意向 
	 * @param intentionId 根据ID查询投资意向
	 * @return MovieIntentionList
	 */
	MovieIntentionList getMovieIntention(Long intentionId );
	
	/**
	 * 查询投资意向列表总数
	 * @param map Map<String,Object>
	 * @return List<MovieIntentionList>
	 */
	Integer getMovieIntentionListCount(Map<String,Object> map);
	
	/**
	 * 更新投资意向
	 * @param movieIntentionList MovieIntentionList
	 */
	void updateMovieIntentionList(MovieIntentionList movieIntentionList);
	
	/**selectUsersByUserId
	 * 新增电影投资人
	 * @param movieInvestList MovieInvestList
	 */
	void insertMovieInvestList(MovieInvestList movieInvestList);
	
	/**
	 * 修改电影投资人
	 * @param movieInvestList MovieInvestList
	 */
	void updateMovieInvestList(MovieInvestList movieInvestList);
	
	/**
	 * 根据用户ID获取认证的状态
	 * @param userId Integer
	 * @return Integer
	 */
	Integer selectUsersByUserId( Long userId);
	
}
