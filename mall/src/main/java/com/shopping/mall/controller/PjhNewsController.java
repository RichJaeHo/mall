package com.shopping.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/news.action")
public class PjhNewsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getNews(){
		System.out.println("getNews 들어옴");
		return "news";
	}

}
