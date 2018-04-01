package com.kaipai.ck.constant;

public final class CommonConstant {
	public static final class Constant{
		public static final int WAITING_TIME = 10;// 线程等待时间
		public static final int ROWS = 10;
		public static final String RES_DATA = "data";
		public static final String RES_TOTAL = "total";
		public static final String USER_ID = "userId";
		public static final String VOTE_TYPE = "voteType";
		public static final String PAGE_INDEX = "pageIndex";
		public static final String PAGE_SIZE = "pageSize";
		public static final String KP_NO = "kpNo";
		public static final String STATE_OK = "OK";
		public static final String STATE_UN_FIX = "UN_FIX";
		public static final String STATE_FAILD = "FAILD";
		public static final String VIDEO_SELECT_PRAM = "VIDEO";
		public static final String RES_LIST = "list";
		public static final String RADOM_OUT_CHAR = "char";
		public static final String RADOM_OUT_NUM = "num";
		public static final String RADOM_OUT_ALL = "all";
	} 
	//app请求头信息
	public static final class AppHeaderKey{
		public static final String USER_ID = "_kpusrId";
		public static final String CLIENT_VER = "client_ver";
		public static final String TICKET = "_kptkt";
		public static final String PLATFORM = "platform";
		public static final String DEVICE_ID = "device_id";
		public static final String APP_TYPE = "app_type";
	}
	
	//文件上传的类型
	public static final class FileUploadType{
		//user/video/crowdfunding/recruit/vote/grils/movies/act
		public static final String TYPE_USER = "user";
		public static final String TYPE_VIDEO = "video";
		public static final String TYPE_CROWDFUNDING = "crowdfunding";
		public static final String TYPE_RECRUIT = "recruit";
		public static final String TYPE_VOTE = "vote";
		public static final String TYPE_GRILS = "grils";
		public static final String TYPE_MOVIES = "movies";
		public static final String TYPE_ACT = "act";
	}
	//客户端类型
	public static final class SourceType{
		public static final String SOURCE_PC = "PC";//电脑桌面版
		public static final String SOURCE_WX = "WX";//微信版
		public static final String SOURCE_H5 = "H5";//微信版
		public static final String SOURCE_QD = "QD";//渠道版
		public static final String SOURCE_APP = "APP";//微信版
		public static final String SOURCE_IOS = "ios";//app_ios
		public static final String SOURCE_ANDROID = "android";//app_android
	}
	
	//动态可见范围类型
	public static final class DynScopeType{
		public static final String SCOPE_PRIVATE = "0"; //私密
		public static final String SCOPE_SUBSCIBE = "1"; //订阅可见
		public static final String SCOPE_PUBLIC = "2"; //公开
	}
	
	//众筹状态
	public static final class CollectionType{
		public static final String COLL_SUCCESS = "SUCCESS";
		public static final String COLL_PRESTART = "PRE_START";
		public static final String COLL_OPEN = "OPEN";
		public static final String COLL_DRAFT = "DRAFT";
	}
	//开拍网旗下app的类型
	public static final class AppType{
		//星主页app
		public static final String TYPE_XF = "XF";
	}
	
	public static final class UserType{
		public static final String USER_U = "U";//普通用户
		public static final String USER_SYS = "SYS";//系统管理员
		public static final String USER_NETSTAR = "NETSTAR";//网红
		public static final String USER_M = "M";//运营人员
	}
	
	public static final class STATUS{
		public static final String SUCCESS = "SUCCESS";
		public static final String OK = "OK";
		public static final String FAIL = "FAIL";
		public static final String UN_FIXED = "UN_FIXED";
		public static final String UNAUDIT = "UNAUDIT";
		public static final String AUDITING = "AUDITING";
		public static final String REJECT = "REJECT";
		public static final String STATUS_0 = "0";
		public static final String STATUS_1 = "1";
		public static final String STATUS_2 = "2";
		public static final String STATUS_3 = "3";
	}
	
	public static final class WITHDRAW_TYPE{
		public static final String BANK = "BANK";
		public static final String WX = "WX";
		public static final String ZFB = "ZFB";
	}
}
