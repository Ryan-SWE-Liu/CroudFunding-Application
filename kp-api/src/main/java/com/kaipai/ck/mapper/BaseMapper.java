package com.kaipai.ck.mapper;

import java.util.HashMap;
import java.util.List;

public interface BaseMapper<T> {
	public long getTotalCount(HashMap<String, Object> page);
	public long getTotalCountRankList(HashMap<String, Object> page);
	
	/**
	 * 投票活动列表
	 * @param page
	 * @return
	 */
	List<T> findList(HashMap<String,Object> page);
	/**
	 * 投票项目详情
	 * @param voteModel
	 * @return
	 */
	T findBean(T t);
	/**
	 * 投票
	 * @param voteModel
	 * @return
	 */
	int createBean(T t);
	
	
	
	int updateBean(T t);
	int deleteBean(T t);
}
