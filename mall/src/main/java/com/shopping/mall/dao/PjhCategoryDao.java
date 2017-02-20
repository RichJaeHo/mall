package com.shopping.mall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.mapper.PjhCategoryMapper;

@Repository(value="PjhCategoryDao")
public class PjhCategoryDao {

	@Autowired
	@Qualifier(value="PjhCategoryMapper")
	private PjhCategoryMapper pjhCategoryMapper;
	
	//카테고리 검색
	public String[] selectCategoryList() {
		String[] arrResult = pjhCategoryMapper.selectCategoryList();
		return arrResult;
	}

}
