package com.kaipai.ck.mapper.base;

import org.apache.ibatis.annotations.Param;

public interface StockCodeSeqMapper {

	public long findStockCodeSeq(@Param("prefixCode")String prefixCode);
	public void updateStockCodeInc(@Param("prefixCode")String prefixCode);
}
