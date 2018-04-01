package com.kaipai.ck.constant;

public class KpContants {
	
	public static final class PAY{
		  public static final String AMT_OP_CODE_ADD = "+";
		  public static final String AMT_OP_CODE_RED = "-";
          public static final String PAY_WX_DEV_INFO = "WEB";
          
          
          /**
           * 开拍网收益账户
           */
          public static final long DEF_KP_ID = 2; 
          
          /**
           * 开拍网 - 交易手续费收益账户
           */
          public static final long DEF_KP_TD_ID = 20;
          /**
           * 开拍网 - 提现手续费收益账户
           */
          public static final long DEF_KP_WD_ID = 25;
          /**
           * 开拍网 - 转发收益账户
           */
          public static final long DEF_KP_TRAF_ID = 21;
          
          
          
          /**未审核**/
          public static final String AMT_AUDIT_STATE_UNAUDIT = "UNAUDIT";
          /**有效**/
          public static final String AMT_AUDIT_STATE_OK = "OK";
          /**用户私有信息中上次金额**/
          public static final long USER_PRIVE_LAST_AMT = 0;
          /**用户私有信息状态：有效**/
          public static final String USER_PRIVE_STATE_YES = "1";

          /**是否已經分紅 1已分红 0未分红**/
          public static final String VIDEO_TRAN_AMT_IS_BENFIED = "0";

          /**提现状态AUDITING提现中，SUCCESS提现成功 ，FAIL提现失败**/
          public static final String BI_WITHDRAW_STATE_AUDITNG = "AUDITING";
          public static final String BI_WITHDRAW_STATE_SUCCESS = "SUCCESS";
          public static final String BI_WITHDRAW_STATE_FAIL = "FAIL";
          
          /**
           * 经纪公司未审核 
           */
          public static final String BI_WITHDARW_STATE_BROKER_AUDITING = "BK_UNAUDIT";
          /**
           * 经纪公司审核通过 
           */
          public static final String BI_WITHDRAW_STATE_BROKER_SUCCESS = "BK_SUCC";
          /**
           * 经纪公司审核拒绝
           */
          public static final String BI_WITHDRAW_STATE_BROKER_FAIL = "BK_FAIL";
          /**提现审核状态UNAUDIT未审核，OK审核通过，REJECT审核失败**/
          public static final String BI_WITHDRAW_AUDIT_STATE_UN_FIXED = "UNAUDIT";
          public static final String BI_WITHDRAW_AUDIT_STATE_OK = "OK";
          public static final String BI_WITHDRAW_AUDIT_STATE_REJECT = "REJECT";
          
          public static final String PARAM_CALL_BACK_STATUS = "callBackState";
          /**用户金额明细表里用户提现KEYWORD前缀**/
          public static final String WITHDRAW_PREFIX = "withdraw";
          
          
          //视频业务VIDEO_BI，众筹业务COLL_BI，OTHER_BI其他 提现业务WITHD_BI
          
//          public static final String AMT_BSCODE_VIDEO_BI = "VIDEO_BI";//视频业务VIDEO_BI
//          public static final String AMT_BSCODE_COLL_BI = "COLL_BI";//众筹业务
//          public static final String AMT_BSCODE_OTHER_BI = "OTHER_BI";//其他
//          public static final String AMT_BSCODE_WITHD_BI = "WITHD_BI";//提现业务
          public static final String AMT_BSCODE_RECHARGE_BI = "RECHR_BI"; //充值业务
          
          public static final String PAY_ODR_STATUS_OK = "1";
          //回调状态
          public static final String CALL_BACK_STATE_SUCCESS = "SUCCESS";
          public static final String CALL_BACK_STATE_FAIL = "FAIL";
          //结算状态
          public static final String BILL_STATE_BILLED = "BILLED";
          public static final String BILL_STATE_UNBILL = "UNBILL";

          /**红包类型**/
          public static final String RED_PACKET_TYPE = "RED";
          /**红包金额**/
          public static final double RED_PACKET_PRICE = 20;
          
          
          
          
		
	}
	
	
	public static final class VIDEO{
		//收益类型 TRANSFER,投资人归属收益 INVESTORS 众筹转发用户收益权限COLLTRAN'
		/**收益类型  普通转发TRANSFER **/
        public static final String VIDEO_BENFIT_TYPE_TRANSFER = "TRANSFER";
        /**收益类型  投资人归属收益 INVESTORS **/
        public static final String VIDEO_BENFIT_TYPE_INVESTORS = "INVESTORS";
        /**收益类型  众筹转发用户收益权限COLLTRAN' **/
        public static final String VIDEO_BENFIT_TYPE_COLLTRAN = "COLLTRAN";
        public static final String VIDEO_FEE_TYPE_FREE = "0";
        public static final String VIDEO_FEE_TYPE_UNFREE = "1";
        public static final String VIDEO_ROLE_CODE = "VIEW";
        /** 众筹转发收益权限TRAN **/
        public static final String VIDEO_ROLE_CODE_TRAN = "TRAN";
        ;
        /** 转发类型 视频转发：TRANS_VI，視頻查看VIEW_VI,付費PAY_VI **/
        public static final String VIDEO_ORDER_TYPE_PAY_VI = "PAY_VI";
        public static final String VIDEO_ORDER_TYPE_VIEW_VI = "VIEW_VI";
        public static final String VIDEO_ORDER_TYPE_TRANS_VI = "TRANS_VI";

	}
	
	
	public static final class ORDER{
		  public static final String PAY_TYPE_BUY_VI = "BUY-VI";//支付视频播放
		  public static final String PAY_TYPE_COLL_MV = "COLL_MV";//支付众筹
		  public static final String PAY_TYPE_ACT_FEE = "ACT-FEE";//支付活动报名
		  public static final String PAY_TYPE_RECHARGE = "RECHARGE";//用户充值
		  public static final String PAY_TYPE_REDPACKET = "REDPACKET";//用户红包
		  public static final String PAY_TYPE_WITHDRAW = "WITHD_BI";//用户提现
		  public static final String PAY_TYPE_WITHDRAW_FEE = "WD_FEE";//用户提现
		  public static final String PAY_TYPE_KP_GET_WITHDRAW_FEE = "KP_WD_FEE";//开拍网获取手续费
		  public static final String PAY_TYPE_TARN_PROFIT = "TRAN-FIT";//转发收益
		  public static final String PAY_TYPE_DIVIDENT = "DIVIDENT";//分红
		  public static final String PAY_TYPE_GAME_ONE = "GAME-ONE";//一元夺宝游戏
		  
		  public static final String PAY_TYPE_FD_PHOTO = "FD-PHOTO";//粉豆圈写真图集-网红收入
		  public static final String PAY_TYPE_FD_VIDEO = "FD-VIDEO";//粉豆圈视频-网红收入
		  public static final String PAY_TYPE_FD_MEM = "FD-MEM";//粉豆圈会员-网红收入
		  public static final String PAY_TYPE_FD_RED_PACK = "FD-REDPACK";//粉豆圈红包-网红收入
		  
		  public static final String PAY_TYPE_FD_F_PHOTO = "FD-F-PHOTO";//粉豆圈粉丝购买写真图集
		  public static final String PAY_TYPE_FD_F_VIDEO = "FD-F-VIDEO";//粉豆圈粉丝购买视频
		  public static final String PAY_TYPE_FD_F_MEM = "FD-F-MEM";//粉豆圈粉丝购买会员
		  public static final String PAY_TYPE_FD_F_VOTE = "FD-F-VOTE";//粉豆圈投票支付
		  public static final String PAY_TYPE_FD_VOTE = "FD-VOTE";//粉豆圈投票开拍网收入
		  public static final String PAY_TYPE_FD_F_RED = "FD-F-RED";//粉豆圈用户发红包
		  
		  public static final String PAY_TYPE_FD_PHOTO_FEE = "FD-P-FEE";//粉豆圈写真图集手续费
		  public static final String PAY_TYPE_FD_VIDEO_FEE = "FD-V-FEE";//粉豆圈视频手续费
		  public static final String PAY_TYPE_FD_MEM_FEE = "FD-M-FEE";//粉豆圈会员手续费
		  public static final String PAY_TYPE_FD_REDPACK_FEE = "FD-R-FEE";//粉豆圈红包手续费
		
		  public static final String PAY_KP_TYPE_TRADE	= "KP-TD-FEE";//股票交易
		  public static final String PAY_TYPE_CANCEL_BUY_STOCK	= "TD-C-B";//撤销订单
		  public static final String PAY_TYPE_TRADE_BUY_STOCK	= "TD-B";//买股票
		  public static final String PAY_TYPE_TRADE_BUY_STOCK_FEE= "TD-B-F";//买单费率
		  public static final String PAY_TYPE_CANCEL_SALE_STOCK	= "TD-C-S";//撤销买单
		  public static final String PAY_TYPE_TRADE_SALE_STOCK_FEE= "TD-S-F";//卖单费率
		  public static final String PAY_TYPE_TRADE_SALE_STOCK	= "TD-S";//买股票
		  public static final String PAY_TYPE_XF_COLL = "XF-COLL";//星主页认购
		  public static final String PAY_TYPE_PRIV_WITHDRAWAL  ="WITHDRAWAL";//提现申请
		  public static final String PAY_TYPE_PRIV_WITHDRAWAL_OK  ="RECHARGE_OK";//提现通过
		  public static final String PAY_TYPE_WITHDRAW_REJ = "WI_REJ_BI";//用户提现驳回
		  public static final String PAY_TYPE_INIT_PRIV_USER = "INIT_PRIV_USR";//用户资金帐号初始化
		  
		  public static final String PAY_TYPE_BONUS_BY_STOCK_S = "BONUS-S"; //被分红
		  public static final String PAY_TYPE_BONUS_BY_STOCK_C = "BONUS-C"; //分红
		  
		  public static final String PAY_TYPE_REFUND = "REFUND"; //退款
		  
		  public static final String PAY_KP_TYPE_WD_COMMON	= "KP-WD-CM";//提现 公共账号更新

          public static final String AMT_INFO_TRANFER = " tranfer get benfit!"; 
          public static final String PAY_CALLBACK_STATE_KEY = "callBackState";
          public static final String PAY_STATE_KEY = "state";
          public static final String PAY_CALLBACK_ORDER_NO = "outTradeNo";
          public static  final String  PARAM_TRANFER_USR_ID = "tranferUsrId";
          public static  final String  PARAM_VIDEO_ID = "videoId";
          public static  final String  PARAM_ORDER_NO = "orderNo";

          public static  final String  PARAM_COLL_BEN_ID = "collBenId";
          public static  final String  PARAM_COLL_NO = "collNo";
          public static  final String  PARAM_COLL_GIT_NUM = "gitNum";
          public static  final String  PARAM_COMPANY_CODE = "companyCode";//所属公司代码

          public static  final String  PARAM_ACT_NO = "actNo";//所属公司代码
          public static  final String  PARAM_ACT_RECRUIT_SIGN_ID = "actRecruitSignId";//所属公司代码

          public static final String ORDER_STATE_OK ="1"; //处理成功
          public static final String ORDER_STATE_UNPAY ="0";//没有处理
          public static final String ORDER_STATE_FAIL = "9";//处理失败
          /**订单的付款状态**/
          public static final String PAY_ORDER_SETATE_UN = "UN";//未付
          public static final String PAY_ORDER_SETATE_ING = "ING";//付款中
          public static final String PAY_ORDER_SETATE_SUCCESS = "SUCCESS";//付款成功
          
		
	}
	
	
	
	public static final class Collection{
		public static final String STATE_VAL_IS_VALIAD = "1";
		public static final String STATE_NT_IS_VALIAD = "0";
		public static final String COLL_GIT_NUM_DEFAULT_VAL = "1";

	}
	
	public static final class SYSTEM{
		
		/** OSS服务系统配置KEY  */
	    public static final String SYSTEM_OSS_KEY = "OSS_OPEN_CLOSE";
		/** OSS服务系统配置TYPE */
	    public static final String SYSTEM_OSS_TYPE = "SYS_OC_PARAM";

		/** OSS服务系统配置VALUE  */
	    public static final String SYSTEM_OSS_VALUE_OPEN = "OPEN";
	    

		/** 删除状态 未删除**/
		public static final String DELETE_STATE_FALSE = "0";
		/** 删除状态  删除**/
		public static final String DELETE_STATE_TRUE = "1";


		/**开拍兑-兑换-比特兑  key**/
		public static final String COIN_KPD_BTD_KEY = "COIN_RMB_BTD"; 
		/**开拍兑-兑换-比特兑  type**/
		public static final String SYS_COIN_CHANGE_TYPE = "SYS_COIN_CHANGE"; 
		

		/** APP升级类型  and**/
		public static final String SYS_UPGRADE_AND = "SYS_UPGRADE_AND";
		/** APP升级类型  ios**/
		public static final String SYS_UPGRADE_IOS = "SYS_UPGRADE_IOS";
		/** APP升级版本 **/
		public static final String APP_CURR_VERSION = "CURR_VERSION";
		/** APP升级地址 **/
		public static final String APP_GRADE_URL = "GRADE_URL";
		/** APP是否升级 **/
		public static final String APP_IS_MASE_GRADE_FLG = "IS_MASE_GRADE_FLG";
		/** APP需升级版本 **/
		public static final String APP_MUST_GRADE_VER = "MUST_GRADE_VER";
		/** APP升级描述 **/
		public static final String APP_UPGRADE_DESC = "UPGRADE_DESC";
		/** APP升级标题 **/
		public static final String APP_VERSION_TITLE = "VERSION_TITLE";
		
		/**星主页Ios评价**/
		public static final String APP_XF_IOS_COMMENT = "XF_IOS_COMMENT";
		
		/**
		 * 星主页app首页显示 
		 */
		public static final String APP_XF_INDEX_SHOW = "APP_XF_INDEX_SHOW";
		
		/**
		 * 行情显示
		 */
		
		public static final String APP_XF_INDEX_SHOW_STOCK = "APP_XF_STOCK";
		
		/**
		 * 项目显示菜单
		 */
		public static final String APP_XF_INDEX_COLL_MENU = "APP_XF_COLL_MENU";
		
		/**
		 * 1.1.2版本后显示菜单内容
		 */
		public static final String APP_XF_INDEX_COLL_MENU_112 = "APP_XF_COLL_MENU_112";
		
		/**
		 * 新手指引
		 */
		public static final String APP_XF_TYPE_GREEN_HAND_GUIDE = "XF_GREEN_HAND_GUIDE";
		
		/**
		 * 认识开拍网
		 */
		public static final String APP_XF_KEY_KNOW_KP = "KNOW_KP";
		
		/**
		 * 上映还是制作
		 */
		public static final String APP_XF_MOVIE_STATUS = "MOV_STATUS";
		/**
		 * 剧情类型
		 */
		public static final String APP_XF_MOVIE_TYPE = "MOV_TYPE";
		/**
		 * 地区
		 */
		public static final String APP_XF_MOVIE_AREA = "MOV_AREA";
		
		/**
		 * 收益规则
		 */
		public static final String APP_XF_MOVIE_PROFIT_RULE = "PROFIT_RULE";
		
		/**
		 * 星主页app 各类配置
		 */
		public static final String APP_XF_COLL = "XF_COLL";
		
		
		
		/** 星主页APP升级类型  and**/
		public static final String SYS_XF_UPGRADE_AND = "SYS_XF_UPGRADE_AND";
		/** 星主页APP升级类型  ios**/
		public static final String SYS_XF_UPGRADE_IOS = "SYS_XF_UPGRADE_IOS";
		/** APP升级版本 **/
		public static final String APP_XF_CURR_VERSION = "XF_CURR_VERSION";
		/** APP升级地址 **/
		public static final String APP_XF_GRADE_URL = "XF_GRADE_URL";
		/** APP是否升级 **/
		public static final String APP_XF_IS_MASE_GRADE_FLG = "XF_IS_MASE_GRADE_FLG";
		/** APP需升级版本 **/
		public static final String APP_XF_MUST_GRADE_VER = "XF_MUST_GRADE_VER";
		/** APP升级描述 **/
		public static final String APP_XF_UPGRADE_DESC = "XF_UPGRADE_DESC";
		/** APP升级标题 **/
		public static final String APP_XF_VERSION_TITLE = "XF_VERSION_TITLE";
		/** 星主页app相关rul**/
		public static final String APP_XF_URL = "APP_XF_URL";
		
		/**一元夺宝游戏分享**/
		public static final String APP_XF_TYPE_GAME = "APP_XF_GAME";
		
		public static final String APP_XF_SHARE_GAME_SHARE_URL = "APP_XF_GAME_SHARE_URL";
		public static final String APP_XF_SHARE_GAME_SHARE_ICON = "APP_XF_GAME_SHARE_ICON";
		public static final String APP_XF_SHARE_GAME_SHARE_TITLE = "APP_XF_GAME_SHARE_TITLE";
		public static final String APP_XF_SHARE_GAME_SHARE_DESC = "APP_XF_GAME_SHARE_DESC";
		
		
		
		
		

		/** APP众筹分享链接地址 **/
		public static final String APP_CROWD_SHARE_URL = "http://wap.kaipai.net/dist/index.html#crowdfunding/detail/";

		/** APP众筹分享链接描述 **/
		public static final String APP_CROWD_SHARE_DESC = "聚集众人的力量及资金来完成一部你喜欢的作品！";
		
		/** APP电影分享链接地址 **/
		public static final String APP_VIDEO_SHARE_URL = "http://wap.kaipai.net/dist/index.html#video/detail/";
		
		/** APP电影分享链接描述 **/
		public static final String APP_VIDEO_SHARE_DESC = "开拍网|高清大片，付费观影后，转发出去即可获得收益分成！";

		/** APP项目分享链接地址 **/
		public static final String APP_MOVIE_SHARE_URL = "http://wap.kaipai.net/dist/index.html#movie/movieDetail/";
		
		/** APP电影分享链接描述 **/
		public static final String APP_MOVIE_SHARE_DESC = "聚集众人的力量及资金来完成一部你喜欢的作品！";
		
		
		/** APP报名投票分享标题 **/
		public static final String APP_VOTE_SHARE_TITLE = "{0}正在参加{1}，请你给TA投票";
		/** APP报名投票分享图片 **/
		public static final String APP_VOTE_SHARE_ICON_URL = "";
		/** APP报名投票分享链接地址   http://wap.kaipai.net/dist/index.html#vote/actor/288/ACT20161012100344000000000000005/kpxy**/
		public static final String APP_VOTE_SHARE_URL = "http://wap.kaipai.net/dist/index.html#vote/actor/{0}/{1}/kpxy";
		/** APP报名投票分享链接描述 **/
		public static final String APP_VOTE_SHARE_DESC = "为{0}的梦想投上一票，竞选成功还有惊喜哦。更多精彩，尽在星主页APP！";
				
		
		
	}
	
	

	public static final class TRADE{
		/**交易状态， 上架UPED **/
        public static final String TRADE_STATE_UPED = "UPED";
		/**交易状态，SLEEPING停牌中**/
        public static final String TRADE_STATE_SLEEPING = "SLEEPING";
		/**BS系统交易状态，交易中TRADING**/
        public static final String TRADE_STATE_TRADING = "TRADING";
		/**XF系统交易状态，交易中SALING**/
        public static final String TRADE_STATE_SALING = "SALING";
		/**交易状态，下市CLOSED**/
        public static final String TRADE_STATE_CLOSED = "CLOSED";
        
        public static final String TRADE_BUY_FLG = "B";
        public static final String TRADE_SALE_FLG ="S";
        
        public static final String STOCK_HIS_BUS_CODE_BUY = "T-BUY";
        public static final String STOCK_HIS_BUS_CODE_SALE = "T-SALE";
        public static final String STOCK_HIS_BUS_CODE_CANCEL_BUY = "T-C-BUY";
        public static final String STOCK_HIS_BUS_CODE_CANCEL_SALE = "T-C-SALE";
        public static final String STOCK_HIS_BUS_CODE_TRAN_IN = "TRAN-I";//转入
        public static final String STOCK_HIS_BUS_CODE_TRAN_OUT = "TRAN-O";//转出
        public static final String STOCK_HIS_BUS_CODE_VM_RECHARGE = "VM-RECHARG";//虚拟币充值
        public static final String STOCK_HIS_BUS_CODE_VM_WITHDRAW = "VM-WITHDRA";//虚拟币提现
        
        
        /**提现手续费*/
        public static final String TRADE_CFG_WITHDRAW_RATE = "WD_RATE";
        /**微信提现手续费*/
        public static final String TRADE_CFG_WX_WITHDRAW_RATE = "WD_WX_RATE";
        /**支付宝提现手续费*/
        public static final String TRADE_CFG_ZFB_WITHDRAW_RATE = "WD_ZFB_RATE";
        /**虚拟货币提现手续费*/
        public static final String TRADE_CFG_VM_WITHDRAW_RATE = "WD_VM_RATE";
        /**虚拟货币提现次数**/
        public static final String TRADE_CFG_VM_WITHDRAW_TIMES_LIMIT = "WD_VM_LIMTI";
        
        /**  交易下单接口  **/
        public static final String TRADE_WT_ORDER_URL = "http://www.kaipai.net/xf-trade-web/service/proxy/wtStockOrder";
	}
	
	public static class CacheConstant{
		public final static String STOCK_CONFIG_PREFIX = "stock_config_";
		public final static String TRADE_CONFIG_PREFIX = "trade_config_";
		public final static String SYSTEM_CONFIG_PREFIX = "system_config_";
		public final static String SYSTEM_CONFIG_PREFIX_LIST = "system_config_list_";
	}

}
