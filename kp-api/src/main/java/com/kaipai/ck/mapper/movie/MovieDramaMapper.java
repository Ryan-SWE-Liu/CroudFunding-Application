package com.kaipai.ck.mapper.movie;


import com.kaipai.ck.model.movie.MovieDramaModel;

public interface MovieDramaMapper {
	
	/**========================项目剧情相关==========================**/
	
	/**
	 * 查询项目剧情相关列表通过movNo
	 * @param movNo
	 * @return
	 */
	public MovieDramaModel findMovieDramaByMovNo(String movNo);

	/**
	 * 添加项目剧情相关
	 * @param movieDramaModel
	 * @return
	 */
	public int insertMovieDrama(MovieDramaModel movieDramaModel);

	/**
	 * 删除项目剧情相关
	 * @param movNo
	 * @return
	 */
	public int delMovieDrama(String movNo);
	

}
