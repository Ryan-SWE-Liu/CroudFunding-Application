package com.kaipai.ck.constant;

public class DiscoveryConstant {
	
	//redis保留七天数据，失效后到mongodb获取
	public static final Integer seconds = 60 * 60;
	//public static final Integer seconds = 60 * 60 * 24 * 7;
	
	public static final String fUserId= "fUserId";
	
	public static final String userId= "userId";
	
	public static final String cirId= "cirId";
	
	public static final String timeline= "timeline";
	
	
	public class MsgCode{
		
		public static final String SUCCESS = "0";
		
		public static final String FAIL = "1";
	}

	
	public class FollowKey{
		/**
		 * 关注 key
		 */
		public static final String CIR_FOLLOW_KEY = "CIR_FOLLOW_";
		/**
		 * 关注 偶像 key
		 */
		public static final String CIR_FOLLOW_IDOL_KEY = "IDOL_";
		/**
		 * 被粉丝关注 key
		 */
		public static final String CIR_FOLLOW_FANS_KEY = "FANS_";
		
		/**
		 * 好友关注 key
		 */
		public static final String CIR_FOLLOW_FRIEND_KEY = "FRIEND_";
	}
	
	public class FriendsCircleKey{
		/**
		 * 朋友圈 feed key
		 */
		public static final String CIR_FEED_KEY = "CIR_FEED_";
		
		/**
		 * 时间轴 key
		 */
		public static final String CIR_TIME_LINE_KEY = "CIR_TIME_LINE";
		
		/**
		 * push 消息限制时间
		 */
		public static final String CIR_PUSH_LIMIT_TIME_KEY = "CIR_PUSH_LIMIT_TIME_";
		
		/**
		 * pull 消息限制时间
		 */
		public static final String CIR_PULL_LIMIT_TIME_KEY = "CIR_PULL_LIMIT_TIME_";
		
		/**
		 * 点赞key
		 */
		public static final String CIR_PRAISE_KEY = "CIR_PRAISE_";
		
		/**
		 * 评论key
		 */
		public static final String CIR_DISCUSS_KEY = "CIR_DISCUSS_";
		
		/**
		 * 相册key
		 */
		public static final String CIR_PHOTO_KEY = "CIR_PHOTO_";
		
		/**
		 * 链接key
		 */
		public static final String CIR_LINK_KEY = "CIR_LINK_";
		
		
		
		
	}
}
