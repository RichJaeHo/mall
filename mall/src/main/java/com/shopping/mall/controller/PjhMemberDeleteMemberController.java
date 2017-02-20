package com.shopping.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.mall.dto.PjhMemberLoginDto;
import com.shopping.mall.service.PjhMemberService;

@Controller
@RequestMapping(value="/myaccount/deletemyinfo.action")
public class PjhMemberDeleteMemberController {

	@Autowired
	@Qualifier(value="PjhMemberService")
	private PjhMemberService pjhMemberService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String postDeleteMember(PjhMemberLoginDto pjhMemberLoginDto, HttpSession session){
		
		System.out.println("postDeleteMember 들어옴 : " + pjhMemberLoginDto.toString());
		
		pjhMemberService.removeMemberByMemberIdPasswd(pjhMemberLoginDto);
		
		session.removeAttribute("session");
		
		return "index";
	}
	
}
