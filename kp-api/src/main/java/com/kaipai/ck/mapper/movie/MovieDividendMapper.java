package com.kaipai.ck.mapper.movie;

import java.util.List;
import java.util.Map;

import com.kaipai.ck.model.movie.MovieDividendModel;
import com.kaipai.ck.model.movie.UserStkBonusHisModel;


/**
 * 电影分红管理
 *
 */
public interface MovieDividendMapper {
	
	/**
	 * 获取未分红电影
	 * @param map Map<String,Object>
	 * @return List<MovieDividendModel>
	 */
	public List<MovieDividendModel> getUnMovieDevidend(Map<String,Object> map);
	
	/**
	 * 获取未分红电影总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	public Integer getUnMovieDevidendCount(Map<String,Object> map);
	
	/**
	 * 根据项目编号获取未分红明细
	 * @param collNo String
	 * @return List<UserStkBonusHisModel>
	 */
	public List<UserStkBonusHisModel> getUnMovieDevidendDetail(String movNo);
	
	/**
	 * 保存分红明细
	 * @param userStkBonusHisModel UserStkBonusHisModel
	 */
	public Integer insertUserStkBounsHis(UserStkBonusHisModel userStkBonusHisModel);
	
	/**
	 * 获取分红明细 列表
	 * @param map Map<String,Object>
	 * @return List<UserStkBonusHisModel>
	 */
	public List<UserStkBonusHisModel> getUserStkBounsHisList(Map<String,Object> map);
	
	/**
	 * 获取分红明细 总数
	 * @param map Map<String,Object>
	 * @return List<UserStkBonusHisModel>
	 */
	public Integer getUserStkBounsHisCount(Map<String,Object> map);
	
	/**
	 * 修改分红明细
	 * @param map Map<String,Object>
	 */
	public void updateUserStkBounsHis(Map<String,Object> map);
	
	/**
	 * 根据项目编号 获取分红明细 
	 * @param movNo String
	 * @return List<UserStkBonusHisModel>
	 */
	public List<UserStkBonusHisModel> getUserStkBounsHisByMovNo(String movNo);
	
	/**
	 * 更新
	 * @param map Map<String,Object>
	 */
	public Integer updateVideoBenfitHis(Map<String,Object> map);
	
}
