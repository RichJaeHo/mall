package com.shopping.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/about.action")
public class PjhAboutController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAbout(){		
		System.out.println("getAbout 들어옴");		
		return "about";
	}

}
