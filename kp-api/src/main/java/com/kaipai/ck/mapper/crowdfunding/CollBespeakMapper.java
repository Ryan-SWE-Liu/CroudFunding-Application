package com.kaipai.ck.mapper.crowdfunding;

import java.util.List;
import java.util.Map;

import com.kaipai.ck.model.crowdfunding.CollBespeakModel;


public interface CollBespeakMapper {
	
	/**
	 * 添加众筹预约
	 * @param collBespeakModel
	 * @return
	 */
	public int createCollBespeak(CollBespeakModel collBespeakModel);
	
	/**
	 * 获取重酬预约list
	 * @param map Map<String,Object>
	 * @return List<CollBespeakModel>
	 */
	public List<CollBespeakModel> getCollBespeaks(Map<String,Object> map);
	
	/**
	 * 获取重酬预约总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	public Integer getCollBespeakCount(Map<String,Object> map);

}
