package com.kaipai.ck.mapper.article;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaipai.ck.model.article.StockArticleModel;


public interface StockArticleMapper{
	/**
	 * 新增文创研究文章
	 * @param kpStockArticle
	 */
	public int insertStockArticle(StockArticleModel StockArticle);
	
	/**
	 * 修改文创研究文章
	 * @param kpStockArticle
	 */
	public int updateStockArticle(StockArticleModel kpStockArticle);

	/**
	 * 删除文章
	 * @param id
	 */
	public int deleteStockArticle(Integer id);
	
	/**
	 * 根据ID 查询文章详细信息
	 * @param id
	 * @return
	 */
	public StockArticleModel getStockArticle(Integer id);
	
	/**
	 * 获取文章列表总数
	 * @param map
	 * @return
	 */
	public int getStockArticleCount(Map<String,Object> map);

	/**
	 * 获取文章列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<StockArticleModel> getStockArticleList(Map<String,Object> map);
	/**
	 * 根据时间获取分页列表
	 * @param createTm
	 * @return
	 */
	public List<StockArticleModel> getStockArticlePageList(@Param("createTm")Date createTm,@Param("type")Integer type);
	
}
