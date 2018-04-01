package com.kaipai.ck.mapper.ad;

import java.util.List;

import com.kaipai.ck.model.ad.AdConfigModel;

public interface AdConfigMapper {
	
	public int createAdConfig(AdConfigModel adConfig);
	public int updateAdConfig(AdConfigModel adConfig);
	public List<AdConfigModel> findAdConfig();
	public int deleteAdConfig(long id);

}
