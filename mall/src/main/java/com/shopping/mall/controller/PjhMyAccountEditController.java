package com.shopping.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.service.PjhMemberService;
import com.shopping.mall.util.PjhEditMyInfoDto;

@Controller
@RequestMapping(value="/myaccount/editmyinfo.action")
public class PjhMyAccountEditController {
	
	@Autowired
	@Qualifier(value="PjhMemberService")
	private PjhMemberService pjhMemberService;
	
	@RequestMapping(method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postEditMyInfo(PjhMemberDto pjhMemberDto, String strBirth){
		
		System.out.println("postEditMyInfo 들어옴 : " + pjhMemberDto.toString());
		
		//생일, 주소변환
		pjhMemberDto = (PjhMemberDto)PjhEditMyInfoDto.editMyInfoDto(pjhMemberDto, strBirth);
		
		boolean result = pjhMemberService.editMemberInfoByMemberId(pjhMemberDto);
		
		return "데이터 들어옴";
	}
	
}
