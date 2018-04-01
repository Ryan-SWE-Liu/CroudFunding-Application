package com.kaipai.ck.mapper.initiator;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.initiator.UserAuth;

/**
 * 发起人
 *
 */
public interface InitiatorMapper {

	/**
	 * 获取发起人列表
	 * @param map Map<String,Object>
	 * @return List<UserAuth>
	 */
	List<UserAuth> getInitiatorList(Map<String,Object> map);
	
	/**
	 * 根据ID获取一个发起人
	 * @param id Long
	 * @return UserAuth
	 */
	UserAuth getInitiator(Long id);
	
	/**
	 * 获取发起人列表总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	Integer getInitiatorListCount(Map<String,Object> map);
	
	/**
	 * 发起人ID 获取详情
	 * @param id Long
	 * @return UserAuth
	 */
	UserAuth getInitiatorDetail(Long id);
	
	/**
	 * 更新发起人
	 * @param UserAuth UserAuth
	 */
	void updateInitiator(UserAuth userAuth);
	
	/**
	 * 更新用户发起人状态
	 * @param userId String
	 * @param initiatorAuthFlg String
	 */
	void updateUser(@Param("userId") String userId,@Param("pdAuthFlg") String pdAuthFlg);
	
	
	/**
	 * 获取发布项目总数 ，如条件不为空并且状态为通过 则获取通过总数
	 * @param movState String
	 * @return Integer
	 */
	Integer getMoviesCount(@Param("movState") String movState,@Param("userId") Long userId);
}
