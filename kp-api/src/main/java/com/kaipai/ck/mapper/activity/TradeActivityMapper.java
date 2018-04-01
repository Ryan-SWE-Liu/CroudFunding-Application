package com.kaipai.ck.mapper.activity;

import java.util.List;
import java.util.Map;

import com.kaipai.ck.model.activity.ActivityModel;

public interface TradeActivityMapper {
	public List<ActivityModel> findTradeActList(Map<String, Object> map);
	
	
	/**
	 * 获取活动列表
	 * @param map Map<String, Object>
	 * @return List<ActivityModel>
	 */
	public List<ActivityModel> getActivityList(Map<String, Object> map);
	
	/**
	 * 获取活动总数
	 * @param map
	 * @return Integer
	 */
	public Integer getActivityCount(Map<String, Object> map);
	
	
	/**
	 * 根据ID获取一个活动
	 * @param id Long
	 * @return ActivityModel
	 */
	public ActivityModel getActivity(String actNo);
	
	/**
	 * 根据活动状态获取
	 * @param actState String
	 * @return List<ActivityModel>
	 */
	public List<ActivityModel> getActivityByState(String actState);
	
	/**
	 * 修改活动
	 * @param activityModel ActivityModel
	 */
	public void updateActivity(ActivityModel activityModel);
	
	/**
	 * 新增活动
	 * @param activityModel ActivityModel
	 */
	public void insertActivity(ActivityModel activityModel);
	
	/**
	 * 删除活动
	 */
	public void deleteActivity(String actNo);
}
