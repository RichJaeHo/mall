package com.shopping.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dao.PjhCategoryDao;

@Repository(value="PjhCategoryService")
public class PjhCategoryService {

	@Autowired
	@Qualifier(value="PjhCategoryDao")
	private PjhCategoryDao pjhCategoryDao;
	
	public String[] findCategoryList() {
		String[] arrResult = pjhCategoryDao.selectCategoryList();
		return arrResult;
	}

}
