package com.kaipai.ck.mapper.comment;

import java.util.HashMap;
import java.util.List;





import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.comment.AppCommentModel;
import com.kaipai.ck.model.comment.AppCommentRelpyModel;
import com.kaipai.ck.model.comment.CommentModel;

public interface CommentMapper{

	public List<CommentModel> findVoteSignComments(HashMap<String,Object> page);
	/**
	 * 查询评论列表
	 */
	public List<CommentModel> findComments(HashMap<String,Object> page);
	/**
	 *众筹活动讨论列表
	 * @param page
	 * @return
	 */
	public List<CommentModel> findCommentsCo(HashMap<String,Object> page);
	public List<CommentModel> findCommentsMo(HashMap<String,Object> page);
	/**
	 * 添加演员投票评论
	 * @param commentModel
	 * @return
	 */
	int createVoteSignComments(CommentModel commentModel);
	/**
	 * 添加电影活动评论
	 */
	int createComments(CommentModel commentModel);
	/**
	 * 添加众筹活动评论
	 */
	int createCommentsCo(CommentModel commentModel);
	/**
	 * 添加电影评论
	 */
	int createCommentsMo(CommentModel commentModel);
	public long getVoteSignTotalCount(HashMap<String, Object> page);
	public long getTotalCountAct(HashMap<String, Object> page);
	public long getTotalCountCo(HashMap<String, Object> page);
	public long getTotalCountMo(HashMap<String, Object> page);

	
	/**
	 * app查看活动评论
	 * @param map
	 * @return
	 */
	public List<AppCommentModel> queryAppCommentAct(HashMap<String, Object> map);
	/**
	 * app查看视频评论
	 * @param map
	 * @return
	 */
	public List<AppCommentModel> queryAppCommentVideo(HashMap<String, Object> map);
	/**
	 * app查看众筹评论
	 * @param map
	 * @return
	 */
	public List<AppCommentModel> queryAppCommentColl(HashMap<String, Object> map);
	/**
	 * app查看活动评论回复
	 * @param map
	 * @return
	 */
	public List<AppCommentRelpyModel> queryCommentActRelpyByCommentId(HashMap<String, Object> map);
	/**
	 * app查看众筹评论回复
	 * @param map
	 * @return
	 */
	public List<AppCommentRelpyModel> queryCommentCollRelpyByCommentId(HashMap<String, Object> map);
	/**
	 * app查看视频评论回复
	 * @param map
	 * @return
	 */
	public List<AppCommentRelpyModel> queryCommentVideoRelpyByCommentId(HashMap<String, Object> map);
	/**
	 * app添加活动评论回复
	 * @param model
	 * @return
	 */
	public int createCommentActRelpy(AppCommentRelpyModel model);
	/**
	 * app添加众筹评论回复
	 * @param model
	 * @return
	 */
	public int createCommentCollRelpy(AppCommentRelpyModel model);
	/**
	 * app添加视频评论回复
	 * @param model
	 * @return
	 */
	public int createCommentVideoRelpy(AppCommentRelpyModel model);
	
	/**
	 * app删除视频评论
	 * @param distId
	 * @return
	 */
	public int deleteCommentVideo(@Param("discId")long discId);
	
	/**
	 * app删除项目评论
	 * @param distId
	 * @return
	 */
	public int deleteCommentMovie(@Param("discId")long discId);
	
	/**
	 * 查询是否本人发布得视频评论
	 * @param discId
	 * @param userId
	 * @return
	 */
	public int getCommentVideoByUserIdAndDiscId(@Param("discId")long discId,@Param("userId")long userId);

	/**
	 * 查询是否本人发布得项目评论
	 * @param discId
	 * @param userId
	 * @return
	 */
	public int getCommentMovieByUserIdAndDiscId(@Param("discId")long discId,@Param("userId")long userId);
	
	
	
}
