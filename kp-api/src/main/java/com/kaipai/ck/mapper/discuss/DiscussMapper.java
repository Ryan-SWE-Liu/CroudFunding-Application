package com.kaipai.ck.mapper.discuss;

import java.util.HashMap;
import java.util.List;

import com.kaipai.ck.model.discuss.Discuss;



public interface DiscussMapper {

	/**
	 * 分页查询讨论信息列表
	 * @param hashMap
	 * @return
	 */
	public List<Discuss> getDiscussQueryPage(HashMap<String, Object> hashMap);

	/**
	 * 获取总数
	 * @param hashMap
	 * @return 
	 */
	public long getTotalCount(HashMap<String, Object> hashMap);

	/**
	 * 获取讨论信息
	 * @param orderNo
	 * @return 
	 */
	public Discuss findDiscussByNumb(Discuss discuss);
	
	/**
	 * 删除讨论信息
	 * @param discuss
	 * @return
	 */
	public int delDiscussByDiscId(Discuss discuss);
}
