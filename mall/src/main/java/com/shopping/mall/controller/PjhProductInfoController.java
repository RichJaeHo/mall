package com.shopping.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.mall.dto.PjhProductDto;
import com.shopping.mall.service.PjhProductService;

@Controller
public class PjhProductInfoController {

	@Autowired
	@Qualifier(value="PjhProductService")
	private PjhProductService pjhProductService;
	
	@RequestMapping(value="/product/productinfo.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getProductInfo(int productNo){
		
		System.out.println("getProductInfo 들어옴");
		
		PjhProductDto result = pjhProductService.findItemByProductNo(productNo);
		
		System.out.println(result.toString());
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(result);
		
		return json;
	}
	
	
}
