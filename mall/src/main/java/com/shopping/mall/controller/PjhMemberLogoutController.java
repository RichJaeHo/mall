package com.shopping.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/myaccount/logout.action")
public class PjhMemberLogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String getLogout(HttpSession session){
		System.out.println("getLogout 들어옴");
				
		//세션삭제
		session.removeAttribute("session");
		
		return "index";
	}	
	
}
