package com.kaipai.ck.mapper.crowdfunding;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.mapper.BaseMapper;
import com.kaipai.ck.model.crowdfunding.CrowdfundingModel;
import com.kaipai.ck.model.crowdfunding.FdCollBenfitModel;
import com.kaipai.ck.model.crowdfunding.FdCollModel;
import com.kaipai.ck.model.fd.ChUgcModel;

public interface FdCollMapper extends BaseMapper<CrowdfundingModel>{
	
	public int getXQCollIsHaveByUserId(@Param("userId")long userId);

	public String getCollNoByMovieNo(@Param("movNo")String movNo);
	
	/**
	 * 获取众筹价格
	 * @param collNo
	 * @return
	 */
	public FdCollBenfitModel getFdCollBenfitAmt(@Param("collNo")String collNo);
	
	/**
	 * 获取众筹统计数据
	 * @param collNo
	 * @param userId
	 * @return
	 */
	public FdCollModel getCollCountsData(@Param("collNo")String collNo,@Param("userId")String userId);
	
	/**
	 * Fd查询众筹详情
	 * @param collNO
	 * @param userId
	 * @return
	 */
	public FdCollModel getFdCollInfo(@Param("collNo")String collNo,@Param("userId")String userId);
	
	/**
	 * 查询众筹ugc信息
	 * @param collNo
	 * @param chId
	 * @param ugcId
	 * @return
	 */
	public ChUgcModel getCollUgcInfo(@Param("collNo")String collNo,@Param("chId")String chId
			,@Param("ugcId")String ugcId);
	
	/**
	 * Fd查询用户是否购买该众筹
	 * @param collNO
	 * @param userId
	 * @return
	 */
	public int getFdCollUserIsBy(@Param("collNo")String collNo,@Param("userId")long userId);
	
	/**
	 * 删除粉豆圈频道众筹关联
	 * @param ugcId
	 * @return
	 */
	public int deleteCollChs(long ugcId);
	public int deleteCollByUgcId(long ugcId);

	/**
	 * Fd查询众筹列表model
	 * @param collNo
	 * @param userId
	 * @param relUgc 只查询众筹中和众筹结束的时传值
	 * @return
	 */
	public FdCollModel getFdCollListModelInfo(@Param("collNo")String collNo,
			@Param("userId")String userId,@Param("relUgc")String relUgc);
	
	/**
	 * Fd查询众筹列表
	 * @param map
	 * @return
	 */
	public List<FdCollModel> getFdCollListPage(HashMap<String, Object> map);
	
	
	/**
	 * 粉豆圈频道众筹关联
	 * @param collNo
	 * @param chId
	 * @return
	 */
	public int insertCollChs(@Param("collNo")String collNo,@Param("chId")long chId,@Param("ugcId")long ugcId);
	/**
	 * 更新粉豆圈频道众筹关联
	 * @param collNo
	 * @param chId
	 * @return
	 */
	public int updateCollChs(@Param("collNo")String collNo,@Param("chId")long chId);
	/**
	 * 添加点赞
	 * @param collNo
	 * @param userId
	 * @return
	 */
	public int createCollPraises(@Param("collNo")String collNo,@Param("userId")long userId
			,@Param("source")String source);
	
	/**
	 * 取消点赞
	 * @param collNo
	 * @param userId
	 * @return
	 */
	public int updateCollPraises(@Param("collNo")String collNo,@Param("userId")long userId);
	
	
}
