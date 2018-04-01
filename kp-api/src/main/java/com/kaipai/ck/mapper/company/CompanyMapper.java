package com.kaipai.ck.mapper.company;

import java.util.HashMap;

import com.kaipai.ck.model.company.CollCompany;
import com.kaipai.ck.model.company.UserCompanyModel;

public interface CompanyMapper {

	/**
	 * 查询众筹用户收益
	 */
	public CollCompany findCollCompany(HashMap<String,Object> page);

	/**
	 * 查询众筹详情
	 */
	public CollCompany findCollCompanyInfo(HashMap<String,Object> page);
	

	/**
	 * 用户跟公司对应关系
	 * @return
	 */
	public int createUserCompany(UserCompanyModel companyModel);


	/**
	 * 用户跟公司对应关系
	 * @return
	 */
	public long findCollCompanyByUserIdAndCcode(HashMap<String,Object> page);
	
	
	
}
