package com.kaipai.ck.mapper.auth;

import java.util.List;
import java.util.Map;

import com.kaipai.ck.model.auth.UserAuthInfo;

/**
 * 身份认证
 *
 */
public interface UserAuthInfoMapper {

	/**
	 * 获取身份认证列表
	 * @param map  Map<String,Object>
	 * @return List<UserAuthInfo>
	 */
	List<UserAuthInfo> getUserAuthInfoList(Map<String,Object> map);
	
	/**
	 * 获取身份认证总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	Integer getUserAuthInfoCount(Map<String,Object> map);
	
	/**
	 * 根据用户ID获取明细
	 * @param userId String
	 * @return UserAuthInfo
	 */
	UserAuthInfo getUserAuthInfoDetail(String userId);
	
	/**
	 * 根据用户ID 更新
	 * @param userAuthInfo UserAuthInfo
	 */
	void updateUserAuthInfo(UserAuthInfo userAuthInfo);
	
}
