package com.kaipai.ck.mapper.homeconfig;

import java.util.HashMap;
import java.util.List;

import com.kaipai.base.AiwMyBaitsMapper;
import com.kaipai.ck.model.homeconfig.HomeConfig;
import com.kaipai.ck.model.homeconfig.HomeConfigDetail;



public interface HomeConfigMapper extends AiwMyBaitsMapper {
	
	/**
	 * 首页参数配置
	 * @param homeConfig
	 * @return
	 */
	public HomeConfig getHomeConfigInfo(Long homeId);
	
	
		/**================首页参数配置明细===============**/

	/**
	 * 查询首页参数配置明细列表
	 * @param homeId
	 * @return
	 */
	public List<HomeConfigDetail> findHomeConfigDetailByHomeId(long homeId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 分页查询首页参数配置
	 * @return
	 */
	public List<HomeConfig> getHomeConfigQueryPage(HashMap<String, Object> page);

	/**
	 * 获取所有记录数，用于分页显示
	 * @return
	 */
	public long getTotalCount(HashMap<String, Object> page);
	
	/**
	 * 增加首页参数配置
	 * @param homeConfig
	 * @return
	 */
	public int addHomeConfig(HomeConfig homeConfig);
	
	/**
	 * 修改首页参数配置
	 * @param homeConfig
	 * @return
	 */
	public int updateHomeConfig(HomeConfig homeConfig);
	
	/**
	 * 修改首页参数配置状态
	 * @param homeConfig
	 * @return
	 */
	public int updateStateHomeConfig(HomeConfig homeConfig);
	
	/**
	 * 增加首页参数配置明细
	 * @param list
	 * @return
	 */
	public int addHomeConfigDetail(HomeConfigDetail homeConfig);
	//public int addHomeConfigDetail(List<HomeConfigDetail> list);
	
	/**
	 * 删除首页参数配置明细
	 * @param roleid
	 * @return
	 */
	public int delHomeConfigDetailByHomeId(long homeId);
	

}
