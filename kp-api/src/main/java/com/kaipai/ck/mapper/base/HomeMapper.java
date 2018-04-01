package com.kaipai.ck.mapper.base;

import java.util.HashMap;
import java.util.List;

import com.kaipai.ck.model.base.HomeConfigDtl;

public interface HomeMapper{

	List<HomeConfigDtl> findConfigDtl(HashMap<String, Object> page);

}
