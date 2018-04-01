package com.kaipai.ck.mapper.movie;

import java.util.HashMap;
import java.util.List;

import com.kaipai.ck.model.movie.MovieNewModel;

public interface MovieNewMapper {

	/**
	 * 电影项目动态公告列表
	 * @param movNo
	 * @return
	 */
	public List<MovieNewModel> findMovieNews(HashMap<String, Object> map);
	
	/**
	 * 电影项目动态公告详情
	 * @param movNewsId
	 * @return
	 */
	public MovieNewModel findMovieNew(long movNewsId);

	/**
	 * 最新的一条电影项目公告动态详情
	 * @param newsType 类型 DT动态，公告GG
	 * @return
	 */
	public MovieNewModel findMovieNewThisNew(HashMap<String, Object> map);
	
	/**
	 * 更新电影项目动态公告
	 * @param movieNewModel
	 * @return
	 */
	public int updateMovieNew(MovieNewModel movieNewModel);

	/**
	 * 添加电影项目动态公告
	 * @param movieNewModel
	 * @return
	 */
	public int insertMovieNew(MovieNewModel movieNewModel);
	

	public int deleteMovieNew(long movNewsId);
}
