package com.shopping.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.mall.service.PjhCategoryService;

@Controller
public class PjhCategoryListController {

	@Autowired
	@Qualifier(value="PjhCategoryService")
	private PjhCategoryService pjhCategoryService;	
	
	@RequestMapping(value="/category/list.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getCategoryList() {
		
		String[] arrResult = pjhCategoryService.findCategoryList();
				
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(arrResult);
		
		return json;
	}
	
}
