package com.kaipai.ck.mapper.movie;

import java.util.HashMap;
import java.util.List;

import com.kaipai.ck.model.movie.MovieModel;
import com.kaipai.ck.model.movie.PcHomeCountModel;
import com.kaipai.ck.model.movie.UserMovieInvestowModel;

public interface MovieMapper {
	
	/**
	 * pc首页统计 
	 * @return
	 */
	public PcHomeCountModel findPcHomeStatistics();
	
	/**
	 * 查询所有电影分页
	 * @param page
	 * @return
	 */
	public List<MovieModel> findMoviesPage(HashMap<String, Object> page);
	
	/**
	 * pc端列表数量
	 * @param page
	 * @return
	 */
	public long findMoviesCounts(HashMap<String, Object> page);
	
	/**
	 * 查询所有电影
	 * @return
	 */
	public List<MovieModel> findMovies(HashMap<String, Object> page);
	/**
	 * 电影详情
	 * @param model
	 * @return
	 */
	public MovieModel findMovie(MovieModel model);
	
	/**
	 * 项目详情
	 * @param map- movNo userId
	 * @return
	 */
	public MovieModel getMovieInfoByMovNo(HashMap<String, Object> map);

	/**
	 * 获取所有记录数，用于分页显示
	 * @return
	 */
	public long getTotalCount(HashMap<String, Object> page);
	
	public List<MovieModel> findMyMovie(HashMap<String, Object> page);
	

	/**
	 * 添加电影项目
	 * @param model
	 * @return
	 */
	public int insertMovie(MovieModel model);
	
	/**
	 * 修改电影项目
	 * @param model
	 * @return
	 */
	public int updateMovie(MovieModel model);
	public int updateMovieIsNotNull(MovieModel model);
	
	
	/**==========================电影分类标签===========================**/

	/**
	 * 查询分类标签列表
	 * @param movNo
	 * @return
	 */
	public List<String> selectMovieSort(String movNo);
	
	/**
	 * 添加电影分类标签
	 * @param model
	 * @return
	 */
	public int insertMovieSort(MovieModel model);
	
	/**
	 * 删除电影分类标签
	 * @param movNo
	 * @return
	 */
	public int delMovieSort(String movNo);
	

	/**==========================电影平台播放===========================**/

	/**
	 * 查询电影平台播放列表
	 * @param movNo
	 * @return
	 */
	public List<String> selectMoviePlatfrom(String movNo);
	
	/**
	 * 添加电影平台播放
	 * @param model
	 * @return
	 */
	public int insertMoviePlatfrom(MovieModel model);
	
	/**
	 * 删除电影平台播放
	 * @param movNo
	 * @return
	 */
	public int delMoviePlatfrom(String movNo);
	


	/**==========================用户关注电影项目信息列表===========================**/
	/**
	 * 添加电影关注
	 * @param model
	 * @return
	 */
	public int insertMovieFocus(MovieModel model);
	
	/**
	 * 删除电影关注
	 * @param movNo
	 * @return
	 */
	public int delMoviePlatFocus(MovieModel model);
	
	

	/**===============================投资人列表================================**/
	
	/**
	 * 投资人列表
	 * @param map
	 * @return
	 */
	
	public List<UserMovieInvestowModel> selectTzUserList(HashMap<String, Object> map);
	
	
	/**===============================我的投资，我的关注，我的意向================================**/
	
	/**
	 * 我的投资
	 * @param map
	 * @return
	 */
	public List<UserMovieInvestowModel> selectMyTzList(HashMap<String, Object> map);
	public long selectMyTzCounts(HashMap<String, Object> map);
	

	/**
	 * 我的关注
	 * @param map
	 * @return
	 */
	public List<UserMovieInvestowModel> selectMyGzList(HashMap<String, Object> map);
	public long selectMyGzCounts(HashMap<String, Object> map);
	

	/**
	 * 我的意向
	 * @param map
	 * @return
	 */
	public List<UserMovieInvestowModel> selectMyYxList(HashMap<String, Object> map);
	public long selectMyYxCounts(HashMap<String, Object> map);
	

	/**====================================投递意向====================================**/
	/**
	 * 查询项目信息
	 * @param investNo
	 * @return
	 */
	public UserMovieInvestowModel selectMovieIntention(String investNo);
	
	
	
	
	/**====================================历史案例====================================**/
	
	public List<UserMovieInvestowModel> selectHisMovieList(HashMap<String, Object> map);
	
	

	/**====================================我的项目====================================**/
	
	public List<MovieModel> findMyMoviesPage(HashMap<String, Object> map);
	
	
	
	
}
