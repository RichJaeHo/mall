package com.shopping.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMemberLoginDto;
import com.shopping.mall.service.PjhMemberService;

@Controller
public class PjhMemberLoginController {
	
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	@Autowired
	@Qualifier(value="PjhMemberService")
	private PjhMemberService pjhMemberService;
	
	@RequestMapping(value="/myaccount/login.action", method = RequestMethod.GET)
	public String getLogin(PjhMemberLoginDto pjhMemberLoginDto){
		System.out.println("getLogin 들어옴");
		return "pjh/member/loginform";
	}
	
	@RequestMapping(value="/myaccount/login.action", method = RequestMethod.POST)
	public String postLogin(PjhMemberLoginDto pjhMemberLoginDto, HttpSession session){
		
		System.out.println("postLogin 들어옴");	
				
		if(session.getAttribute("session") == null){
			session.removeAttribute("session");
		}
		
		//MemberService
		PjhMemberDto resultDto = pjhMemberService.findMemberInfoByMemberId(pjhMemberLoginDto);
		
		//조회된값이 Null이면 다시 로그인 //조회된 자료 있으면 홈으로
		if(resultDto == null || resultDto.getMemberId() == null || resultDto.getMemberId().isEmpty()) {
			System.out.println("로그인 결과값 :  NULL");
			return "pjh/member/loginform";
		} else {
			System.out.println(resultDto);
			session.setAttribute("session", resultDto);
			return "index";
		}
	}
	
	@RequestMapping(value="/myaccount/mlogin.action", method = {RequestMethod.POST, RequestMethod.GET}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postMLogin(HttpSession session, PjhMemberLoginDto pjhMemberLoginDto) {
		
		System.out.println("postMLogin 들어옴 : " + pjhMemberLoginDto.toString());
		
		if(session.getAttribute("session") == null) {
			session.removeAttribute("session");
		}
		
		//MemberService
		PjhMemberDto resultDto = pjhMemberService.findMemberInfoByMemberId(pjhMemberLoginDto);
		
		if(resultDto == null || resultDto.getMemberId() == null || resultDto.getMemberId().isEmpty()) {
			
			System.out.println("로그인 결과값 :  NULL");
			return "failed";
		} else {
			
			System.out.println("조회값 : " + resultDto.toString());			
			String json = gson.toJson(resultDto);
			session.setAttribute("session", json);	
			return json;
		}
	}
	
}
