package com.shopping.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/", "/home.action"})
public class PjhHomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String getHome() { //get방식 홈
		System.out.println("getHome 들어옴");		
		return "index";
	}
	
}
