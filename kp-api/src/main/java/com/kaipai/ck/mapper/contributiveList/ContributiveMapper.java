package com.kaipai.ck.mapper.contributiveList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.contributiveList.CollectionBenfitModel;
import com.kaipai.ck.model.contributiveList.CollectionCompanyModel;
import com.kaipai.ck.model.contributiveList.ContributiveModel;
import com.kaipai.ck.model.contributiveList.UserContributiveModel;
import com.kaipai.ck.model.order.OrderCollectionModel;

public interface ContributiveMapper {

	/**
	 * 出资列表
	 * @param page
	 * @return
	 */
	public List<ContributiveModel> findContributiveList(HashMap<String,Object> page);
	public List<String> findContributyUserList(String collNo);
	Long getTotalCount(HashMap<String,Object> page);
	
	/**
	 * 获取众筹编号
	 * @param page
	 * @return
	 */
	List<OrderCollectionModel> getCollByOrderNo(HashMap<String,Object> page);
	
	public int saveUserColl(UserContributiveModel userContributiveModel);
	
	public List<CollectionCompanyModel> getCollectionCompanyByCollNoAndCompanyCode(Map<String, String> collSearchMap);
	
	
	public CollectionBenfitModel getCollBenfitByBenfitId(String collBenId);
	
	/**
	 * 修改用户参与众筹的状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateContributeStatus(@Param("id")long id,@Param("status")String status);
	
	/**
	 * 时间段内认购金额
	 * @param startTm
	 * @param endTm
	 * @return
	 */
	public double findSumContributeInPeriod(@Param("startTm")Date startTm,@Param("endTm")Date endTm);
}
