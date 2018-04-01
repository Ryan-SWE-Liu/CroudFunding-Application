package com.kaipai.ck.mapper.advert;

import java.util.List;
import java.util.Map;

import com.kaipai.ck.model.advert.AdvertConfigModel;


public interface AdvertConfigMapper {
	
	/**
	 * 获取广告配置list
	 * @param map Map<String,Object>
	 * @return List<AdvertConfigModel>
	 */
	public List<AdvertConfigModel> getAdvertConfigList(Map<String,Object> map);
	
	/**
	 * 获取广告配置总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	public Integer getAdvertConfigCount(Map<String,Object> map);
	/**
	 * 根据ID 获取广告配置
	 * @param id Long
	 * @return AdvertConfigModel
	 */
	public AdvertConfigModel getAdvertConfig(Long id);
	/**
	 * 修改广告配置
	 * @param advertConfigModel AdvertConfigModel
	 */
	public void updateAdvertConfig(AdvertConfigModel advertConfigModel);
	/**
	 * 新增广告配置
	 * @param advertConfigModel AdvertConfigModel
	 */
	public void insertAdvertConfig(AdvertConfigModel advertConfigModel);
	/**
	 * 删除广告配置
	 * @param id Long
	 */
	public void deleteAdvertConfig(Long id);
}
