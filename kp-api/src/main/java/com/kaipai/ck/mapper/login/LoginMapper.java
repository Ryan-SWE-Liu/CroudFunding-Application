package com.kaipai.ck.mapper.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.login.AppUserModel;
import com.kaipai.ck.model.login.KpUserInfo;
import com.kaipai.ck.model.login.LoginModel;
import com.kaipai.ck.model.login.UserBoundModel;
import com.kaipai.ck.model.login.UserDevModel;
import com.kaipai.ck.model.user.UserLoginVo;

public interface LoginMapper{
	
	public int updateBoundIdByUnionId(@Param("unionId")String unionId,@Param("bindId")String bindId);
	
	public String findUserIdByParam(@Param("userId")String userId,@Param("bindId")String bindId
			,@Param("bindType")String bindType);

	public UserBoundModel findBendIdInBoundByWX(@Param("unionId")String unionId);
	
	public List<String> findUserIdInBoundByWX(@Param("unionId")String unionId);
	
	public String findUserIdInBoundByQQ(@Param("bindId")String bindId);
	
	
	public int updateUserState(@Param("userId")String userId,@Param("userState")char userState);
	
	public int updateUserBoundByBindId(@Param("userId")String userId,@Param("bindId")String bindId);
	
	/**
	 * app登录
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	AppUserModel appLoginUserInfo(@Param("userName") String userName,
			@Param("userPwd")String userPwd);
	
	/**
	 * 查询手机号是否存在
	 * @param mobile
	 * @return
	 */
	public int findMobilIsHave(String mobile);
	
	/**
	 * 由手机号查用户ID
	 * @param mobile
	 * @return
	 */
	public String findUserIdByMobile(String mobile);
	/**
	 * 查询用户手机号
	 * @param userId
	 * @return
	 */
	public LoginModel findUserMobileByUserId (Long userId);
	
	LoginModel find2Login(@Param("userName") String userName,@Param("userPwd") String userPwd);
	
	
	int create2Register(LoginModel loginModel);
	int update2register(HashMap<String,Object> hashMap);
	List<LoginModel> findMobile(LoginModel loginModel);
	int findBoundInfo(LoginModel loginModel);
	int insertUserDev(HashMap<String, Object> hashMap);
	public int updateUserDevs(HashMap<String, Object> hashMap);
	LoginModel findUserName(HashMap<String, Object> hashMap);
	int findUserDev(HashMap<String, Object> hashMap);
	UserDevModel  findUserDevByUserId(HashMap<String, Object> hashMap);
	UserBoundModel findUserBoundByBindId(@Param("bindId")String bindId,@Param("bindType")String bindType);
	List<UserBoundModel> findUserBoundByUserId(long userId);
	public int createUserBound(UserBoundModel bindModel);
	//通过用户ID查询会员号
	public String queryKpNoByuserId(String userId);
	
	//查看userinfo表中有没有用户数据
	public int isUserExists(String userId);
	
	
	public long findUserIdByBoundId(String bindId);
	/**
	 * 用户信息
	 * @param userId
	 * @return
	 */
	public LoginModel findUserByUserId(String userId);

	/**
	 * APP修改用户信息
	 * @param kpUserInfo
	 * @return
	 */
	public int updateAppUser(KpUserInfo kpUserInfo);
	
	/**
	 * app修改个人密码
	 * @param map passwd,userId
	 * @return
	 */
	public int updateAppUserPasswd(Map<String, String> map);

	/**
	 * 添加用户基本信息
	 * @param kpUserInfo
	 * @return
	 */
	public int createKpUserInfo(KpUserInfo kpUserInfo);

	/**
	 * 添加用户基本信息
	 * @param kpUserInfo
	 * @return
	 */
	public int updateKpUserInfo(KpUserInfo kpUserInfo);
	
	/**
	 * 删除用户信息
	 * @param userId
	 * @return
	 */
	public int delAppUserInfo(long userId);
	
	/**
	 * 修改认证状态
	 * @param map
	 * @return
	 */
	public int updateAuthStatus(Map<String, Object> map);
	
	/**
	 * 修改手机号
	 * @param map
	 * @return
	 */
	public int updateUserMobile(Map<String,Object> map);
	
	//########################################用户中心新添加方法#####################################################
	
	/**
	 *添加用户
	 * @param userLoginVo
	 * @return
	 */
	public int createUser(UserLoginVo userLoginVo);
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public UserLoginVo userLogin(@Param("username")String username,@Param("password")String password);
	
	/**
	 * 用户基本信息 user_info表中的数据
	 * @param userId
	 * @return
	 */
	public UserLoginVo findUserInfo(long userId);
	
	/**
	 * 用户信息，kp_users表和kp_user_info表
	 * @param userId
	 * @return
	 */
	public UserLoginVo findUser(long userId);
	/**
	 * 修改用户名
	 * @param userId
	 * @param username
	 * @return
	 */
	public int userUpdateUsername(@Param("userId") long userId,@Param("username")String username);
	
	/**
	 * 修改kp_users表中信息
	 * @param userVo
	 * @return
	 */
	public int updateUser(UserLoginVo userVo);
	
	/**
	 * 修改kp_user_info表中信息
	 * @param userVo
	 * @return
	 */
	public int updateUserInfo(UserLoginVo userVo);
	
	/**
	 * 新增
	 * @param userVo
	 * @return
	 */
	public int insertUserInfo(UserLoginVo userVo);
	
	/**
	 * 是否存在
	 * @param userVo
	 * @return
	 */
	public int isExists(UserLoginVo userVo);
	
	/**
	 * 修改密码
	 * @param userId
	 * @param newPassword
	 * @param oldPassword
	 * @return
	 */
	public int updateUserPassword(@Param("userId") long userId,@Param("newPassword")String newPassword,@Param("oldPassword")String oldPassword);
	
	
	/**
	 * 重置密码
	 * @param userId
	 * @param password
	 * @return
	 */
	public int resetPassword(@Param("username")String username,@Param("password")String password);
	
	/**
	 * 用户审核
	 * @param userId
	 * @param state
	 * @return
	 */
	public int authUserStatus(@Param("userId") long userId,@Param("state")String state);
	
	/**
	 * 更新微信的unionId
	 * @param userId
	 * @param unionId
	 * @return
	 */
	public int updateBoundUnionId(@Param("userId")long userId,@Param("unionId")String unionId);
}
