package com.kaipai.ck.mapper.game;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.games.GameActivitiesModel;
import com.kaipai.ck.model.games.GameDeatilModel;
import com.kaipai.ck.model.games.GameJoinHisModel;
import com.kaipai.ck.model.games.GameListModel;
import com.kaipai.ck.model.games.GameOrderModel;
import com.kaipai.ck.model.games.GamePrizeInstruction;
import com.kaipai.ck.model.games.GamePrizeModel;
import com.kaipai.ck.model.games.GamePrizesModel;
import com.kaipai.ck.model.games.GameWinnerHisModel;
import com.kaipai.ck.model.games.JoinUserListModel;
import com.kaipai.ck.model.games.LotteryInfo;

public interface GameMapper {
	
	/**
	 * 游戏详情
	 * @param gameNo
	 * @return
	 */
	public GameDeatilModel findGameDetail(String gameNo);
	
	/**
	 * 开奖中的游戏
	 * @return
	 */
	public List<LotteryInfo> findPrizingGames();
	
	/**
	 * 奖品详情
	 * @param prizeCode
	 * @return
	 */
	public GamePrizeModel findGamePrizeDetail(String prizeCode);
	
	/**
	 * 用户参与号
	 * @param userId
	 * @param gameNo
	 * @return
	 */
	public String findUserJoinNoByGameNo(@Param("userId")String userId,@Param("gameNo")String gameNo);
	
	/**
	 * 修改游戏状态：WAITING PRIZING FINISH
	 * @param gameNo
	 * @param state
	 * @return
	 */
	public int updateGameState(@Param("gameNo")String gameNo,@Param("state")String state,@Param("openTm")Date openTm,@Param("lotteryIssue")String lotteryIssue);
	/**
	 * 参与 用户列表
	 * @param gameNo
	 * @param rows
	 * @param lastTm
	 * @return
	 */
	public List<JoinUserListModel> findGameJoinUsers(@Param("gameNo")String gameNo,@Param("rows")int rows,@Param("lastTm")Long lastTm);
	/**
	 * 游戏列表
	 * @param rows
	 * @param lastTm
	 * @return
	 */
	public List<GameListModel> findGameList(@Param("rows")int rows,@Param("lastTm")Date lastTm,@Param("state")String state);
	/**
	 * 用户参与
	 * @param joinHis
	 * @return
	 */
	public int createJoinHis(GameJoinHisModel joinHis);
	
	/**
	 * 游戏参与人数
	 * @param gameNo
	 * @return
	 */
	public long findGameJoinCount(String gameNo);
	
	/**
	 * 是否已经开奖
	 * @param gameNo
	 * @return
	 */
	public long findGameWinnerIsExists(String gameNo);
	
	/**
	 * 用户参与游戏次数
	 * @param gameNo
	 * @param userId
	 * @return
	 */
	public long findGameUserJoinCount(@Param("gameNo")String gameNo,@Param("userId")String userId);
	
	/**
	 * 中奖历史
	 * @param rows
	 * @param lastTm
	 * @return
	 */
	public List<GameWinnerHisModel> findGameWinnerList(@Param("rows")int rows,@Param("lastTm")Date lastTm);
	
	
	/**
	 * 中奖者
	 * @param gameNo
	 * @return
	 */
	public GameWinnerHisModel getWinnerByGameNo(String gameNo);
	
	
	/**
	 * 参与者详情
	 * @param gameNo
	 * @param joinNo
	 * @return
	 */
	public GameJoinHisModel findGameJoinHisByJoinNo(@Param("gameNo")String gameNo,@Param("joinNo")String joinNo);
	/**
	 * 创建中奖历史
	 * @param winner
	 * @return
	 */
	public int createGameWinner(GameWinnerHisModel winner);
	
	
	/**
	 * 参与者的时间
	 * @param gameNo
	 * @param flag FIRST:第一个，LAST：最后一个
	 * @return
	 */
	public String findGameJoinerTm(@Param("gameNo")String gameNo,@Param("flag")String flag);
	
	/**
	 * 我参与的游戏
	 * @param userId
	 * @param rows
	 * @param lastTm
	 * @param state 开奖，进行，
	 * @return
	 */
	public List<GameListModel> findGameListByUserId(@Param("userId")String userId,@Param("rows")int rows,@Param("lastTm")Date lastTm,@Param("state")String state);
	
	
	/**
	 * 我的中奖历史
	 * @param userId
	 * @param rows
	 * @param lastTm
	 * @return
	 */
	public List<GameListModel> findGameWinnerByUserId(@Param("userId")String userId,@Param("rows")int rows,@Param("lastTm")Date lastTm);
	
	/**
	 * 游戏的完成进度
	 * @param gameNo
	 * @return
	 */
	public long findCompleteRate(String gameNo);
	
	
	/**
	 * 游戏订单详情
	 * @param orderNo
	 * @return
	 */
	public GameOrderModel getGameUserLastOrder(@Param("orderNo")String orderNo,@Param("userId")String userId);
	
	
	/**
	 * 中奖者设置地址
	 * @param gameNo
	 * @param userId
	 * @param addressId
	 * @return
	 */
	public int updatePrizeAddress(@Param("gameNo")String gameNo,@Param("userId")String userId,@Param("addressId")String addressId);
	
	/**
	 * 奖品发货状态
	 * @param gameNo
	 * @param userId
	 * @param prizeState
	 * @return
	 */
	public int updatePrizeState(@Param("gameNo")String gameNo,@Param("userId")String userId,@Param("prizeState")String prizeState);
	
	/**
	 * 中奖计算
	 * @param gameInstruction
	 * @return
	 */
	public int createGameInstruction(GamePrizeInstruction gameInstruction);
	
	/**
	 * 中奖详情结果
	 * @param gameNo
	 * @return
	 */
	public GamePrizeInstruction findGameInstruction(String gameNo);
	
	
	
	/**
	 * 添加游戏定单详情
	 * @param gameOrder
	 * @return
	 */
	public int createGameOrder(GameOrderModel gameOrder);
	
	/**
	 * 查询游戏定单详情
	 * @param orderNo
	 * @return
	 */
	public GameOrderModel findGameOrderDetail(String orderNo);
	
	/**
	 * 分页获取所有游戏列表
	 * @param map Map<String,Object>
	 * @return List<GameListModel>
	 */
	public List<GameListModel> findGamePage(Map<String,Object> map);
	
	/**
	 * 获取游戏里列表总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	public Integer findGameCount(Map<String,Object> map);
	
	/**
	 * 分页获取所有游戏奖品列表
	 * @param map Map<String,Object>
	 * @return List<GamePrizeModel>
	 */
	public List<GamePrizesModel> findGamePrizesPage(Map<String,Object> map);
	
	/**
	 * 分页获取所有游戏奖品列表
	 * @param map Map<String,Object>
	 * @return List<GamePrizeModel>
	 */
	public List<GamePrizesModel> findGamePrizesList(Map<String,Object> map);
	
	/**
	 * 获取游戏奖品列表总数
	 * @param map Map<String,Object>
	 * @return Integer
	 */
	public Integer findGamePrizesCount(Map<String,Object> map);
	
	/**
	 * 根据CODE获取游戏奖品
	 * @param prizeCode String
	 * @return GamePrizesModel
	 */
	public GamePrizesModel getGamePrizes(String prizeCode);
	
	/**
	 * 根据CODE获取游戏活动
	 * @param gmCode String
	 * @return GameListModel
	 */
	public GameActivitiesModel getGameActivities(String gmCode);
	
	/**
	 * 保存游戏奖品
	 * @param gamePrizesModel GamePrizesModel
	 */
	public void insertGamePrizes(GamePrizesModel gamePrizesModel);
	
	/**
	 * 保存游戏活动
	 * @param gameListModel 保存游戏活动
	 */
	public void insertGameActivities(GameActivitiesModel gameActivitiesModel);
	
	/**
	 * 修改游戏奖品
	 * @param gamePrizesModel GamePrizesModel
	 */
	public void updateGamePrizes(GamePrizesModel gamePrizesModel);
	
	/**
	 * 修改游戏活动
	 * @param gameListModel GameListModel
	 */
	public void updateGameActivities(GameActivitiesModel gameActivitiesModel);
	
	public List<GameActivitiesModel> findGames(String prizeCode);
	
	/**
	 * 获奖者记录
	 * @param map Map<String,Object>
	 * @return List<GameWinnerHisModel>
	 */
	public List<GameWinnerHisModel>  getGmGtPrizeHisPage(Map<String,Object> map);
	
	/**
	 * 获奖者记录总数
	 * @param map   Map<String,Object>
	 * @return int
	 */
	public int getGmGtPrizeHisCount(Map<String,Object> map);
	
}
