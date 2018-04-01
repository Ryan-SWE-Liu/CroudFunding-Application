package com.kaipai.ck.mapper.base;

import java.util.HashMap;
import java.util.List;

import com.kaipai.ck.model.base.PcAddress;

public interface PcAddressMapper {

	PcAddress findProvince(HashMap<String, Object> map);

	List<PcAddress> findProvinceList();

	List<PcAddress> findCityList(HashMap<String, Object> map);
}
