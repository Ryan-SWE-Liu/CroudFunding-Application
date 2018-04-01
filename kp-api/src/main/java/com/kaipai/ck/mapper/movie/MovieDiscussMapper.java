package com.kaipai.ck.mapper.movie;

import java.util.HashMap;
import java.util.List;

import com.kaipai.ck.model.movie.MovieDiscussModel;
import com.kaipai.ck.model.movie.MovieDiscussPraiseModel;

public interface MovieDiscussMapper {

	/**
	 * 电影项目讨论列表
	 * @param movNo
	 * @return
	 */
	public List<MovieDiscussModel> findMovieDiscussList(HashMap<String, Object> map);
	
	/**
	 * 电影项目讨论详情
	 * @param discId
	 * @return
	 */
	public MovieDiscussModel findMovieDiscuss(long discId);

	/**
	 * 更新电影项目讨论
	 * @param movieDiscussModel
	 * @return
	 */
	public int updateMovieDiscuss(MovieDiscussModel movieDiscussModel);

	/**
	 * 添加电影项目讨论
	 * @param movieDiscussModel
	 * @return
	 */
	public int insertMovieDiscuss(MovieDiscussModel movieDiscussModel);
	

	public int deleteMovieDiscuss(long discId);
	
	
	/**=======================项目讨论点赞=======================**/
	
	/**
	 * 添加项目讨论点赞
	 * @param movieDiscussPraiseModel
	 * @return
	 */
	public int insertMovieDiscussPpraise(MovieDiscussPraiseModel movieDiscussPraiseModel);
	
	
}
