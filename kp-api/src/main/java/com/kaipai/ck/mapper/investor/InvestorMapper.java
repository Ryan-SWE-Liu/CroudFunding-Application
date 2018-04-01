package com.kaipai.ck.mapper.investor;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.investor.UserInvestorAuth;

/**
 * 投资人
 *
 */
public interface InvestorMapper {

	/**
	 * 获取投资人列表
	 * @param userInvestorAuth UserInvestorAuth
	 * @return List<UserInvestorAuth>
	 */
	List<UserInvestorAuth> getInvestorList(Map<String,Object> map);
	
	/**
	 * 根据ID获取一个投资人
	 * @param id Long
	 * @return UserInvestorAuth
	 */
	UserInvestorAuth getInvestor(Long id);
	
	/**
	 * 获取投资人列表总数
	 * @param userInvestorAuth UserInvestorAuth
	 * @return Integer
	 */
	Integer getInvestorListCount(Map<String,Object> map);
	
	/**
	 * 投资人ID 获取详情
	 * @param id Long
	 * @return UserInvestorAuth
	 */
	UserInvestorAuth getInvestorDetail(Long id);
	
	/**
	 * 更新投资人
	 * @param userInvestorAuth UserInvestorAuth
	 */
	void updateInvestor(UserInvestorAuth userInvestorAuth);
	
	/**
	 * 更新用户投资人状态
	 * @param userId String
	 * @param investAuthFlg String
	 */
	void updateUser(@Param("userId") String userId,@Param("investAuthFlg") String investAuthFlg);
}
