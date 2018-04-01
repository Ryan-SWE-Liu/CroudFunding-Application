package com.kaipai.ck.constant;

public class FdConstant {
	
	public static final class UserRole{
		
		/**
		 * 用户授权的小编 key
		 */
		public static final String FD_CH_USER_ASIT_KEY = "FD_CH_USER_ASIT_";
		
		/**
		 * 用户拥有的角色权限
		 */
		public static final String FD_CH_USER_ROLE_KEY = "FD_CH_USER_ROLE_";
		
	} 
	
	public static final class UGC{
		//内容類型 資訊MSG,圖集PIC,視頻VIDEOS,衆籌COLL，活動ACTI
		
		public static final String FD_CH_UGC_TYPE_MSG = "MSG";
		public static final String FD_CH_UGC_TYPE_PIC = "PIC";
		public static final String FD_CH_UGC_TYPE_VIDEOS = "VIDEOS";
		public static final String FD_CH_UGC_TYPE_COLL = "COLL";
		public static final String FD_CH_UGC_TYPE_ACTI = "ACTI";
		
		//等級類型 YEAR年付費，MONTH月付費，ALL終生付費
		public static final String FD_CH_MEM_GRADE_TYPE_YEAR = "YEAR";
		public static final String FD_CH_MEM_GRADE_TYPE_MONTH = "MONTH";
		public static final String FD_CH_MEM_GRADE_TYPE_ALL= "ALL";
		
		//观看权限VIEW    众筹转发收益权限TRAN
		public static final String FD_CH_PIC_ROLE_VIEW = "VIEW";
		public static final String FD_CH_PIC_ROLE_TRAN = "TRAN";

		//星主页粉豆UGC是否免费开关
		public static final String XF_UGC_IS_FREE_KEY = "XF_UGC_IS_FREE";
		public static final String XF_UGC_POWER_TYPE = "XF_UGC_POWER";
		
	}
	
	public static final class Sys{
		//写真图集费率
		public static final String FD_CH_PHOTO_FEE = "FD_CH_PHOTO_FEE";
		//视频费率
		public static final String FD_CH_VIDEO_FEE = "FD_CH_VIDEO_FEE";
		//购买会员费率
		public static final String FD_CH_MEM_FEE = "FD_CH_MEM_FEE";
		/**发红包会员费率**/
		public static final String FD_CH_RED_PACK_KP_FEE = "FD_CH_RED_PACK_KP_FEE";
		//粉豆圈费率类型
		public static final String FD_CH_FEE = "FD_CH_FEE";
		
		//购买会员积分类型
		public static final String FD_CH_POINT = "FD_CH_POINT";
		//购买会员送积分
		public static final String FD_CH_MEM_POINT = "FD_CH_MEM_POINT";
		
		//投票
		public static final String FD_CH_VOTE = "FD_CH_VOTE";
		//投票
		public static final String FD_CH_VOTE_SCALE = "FD_CH_VOTE_SCALE";
		
		//系统常量-积分类型
		public static final String FD_SYS_CFG_TYPE_POINT = "POINT";
		//系统常量-积分类型 签到
		public static final String FD_SYS_CFG_TYPE_POINT_KEY_SIGN = "SIGN";
		//系统常量-积分类型 消费
		public static final String FD_SYS_CFG_TYPE_POINT_KEY_CONSUME = "CONSUME";
		//系统常量-积分类型 发布
		public static final String FD_SYS_CFG_TYPE_POINT_KEY_PUBLISH = "PUBLISH";
		
		
		public static final String FD_SYS_TOKEN = "4028818758f846600158f84660e30000";
		
	}
	
	
}
