package com.kaipai.ck.constant;

public class PersonalConstant {
	public static final class ProjectStateConstant{
		//'审核通过OK,草稿中:DRAFT，未审核 UN_FIXED 驳回REJECT',
		public static final String OK="OK";
		public static final String DRAFT="DRAFT";
		public static final String UN_FIXED="UN_FIXED";
		public static final String REJECT="REJECT";
		//1,是，0，否
		public static final String ISDELYES="1";
		public static final String ISDELNO="0";
	}
	public static final class PhotoState{
		public static final String UN_AUDIT="UN_AUDIT";//未审核
		public static final String DRAFT="DRAFT";//草稿
	}
	public static final class ArticleState{
		public static final String UN_AUDIT="UN_AUDIT";//未审核
		public static final String DRAFT="DRAFT";//草稿
	}
}
