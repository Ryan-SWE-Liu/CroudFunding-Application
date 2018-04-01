package com.kaipai.ck.mapper.movie;

import java.util.List;
import java.util.Map;

import com.kaipai.ck.model.movie.MovieBenfitModel;
import com.kaipai.ck.model.movie.MovieDividendModel;
import com.kaipai.ck.model.movie.MovieTranProfitModel;

/**
 * 电影收益管理
 *
 */
public interface MovieBenfitMapper {
	
	/**
	 * 电影收益列表
	 * @param map Map<String,Object>
	 * @return  List<MovieBenfitModel>
	 */
	public List<MovieBenfitModel> getMovieBenfits(Map<String,Object> map);
	
	/**
	 * 电影收益总数
	 * @param map Map<String,Object> map
	 * @return Integer
	 */
	public Integer getMovieBenfitCount(Map<String,Object> map);
	
	/**
	 * 电影收益总金额
	 * @param map Map<String,Object>
	 * @return Double
	 */
	public Double getMovieBenfitTotalAmt(Map<String,Object> map);
	
	/**
	 * 转发收收益排名
	 * @param movNo
	 * @return
	 */
	public List<MovieTranProfitModel> getTranProfitRank(String movNo);
	
	/**
	 * 项目分红历史
	 * @param movNo
	 * @return
	 */
	public List<MovieDividendModel> getDividendHis(String movNo);
	
}
