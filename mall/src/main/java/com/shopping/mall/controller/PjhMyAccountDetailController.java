package com.shopping.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/myaccount.action")
public class PjhMyAccountDetailController {

	@RequestMapping(method=RequestMethod.GET)
	public String getMyAccount(){
		 System.out.println("getMyAccount 들어옴");
		 return "myaccount";
	}
	
}
