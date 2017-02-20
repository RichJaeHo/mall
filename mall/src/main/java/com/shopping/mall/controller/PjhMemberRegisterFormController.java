package com.shopping.mall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.mall.dto.PjhMemberRegisterFormDto;
import com.shopping.mall.service.PjhMemberService;
import com.shopping.mall.util.PjhEditMyInfoDto;

@Controller
@RequestMapping(value="/myaccount/regist.action")
public class PjhMemberRegisterFormController {

	@Autowired
	@Qualifier(value="PjhMemberService")
	private PjhMemberService pjhMemberService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRegisterFrom(PjhMemberRegisterFormDto pjhMemberRegisterFormDto) {		
		System.out.println("getRegisterFrom 들어옴" + pjhMemberRegisterFormDto.toString());		
		return "pjh/member/registerform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postRegisterForm(@Valid @ModelAttribute("pjhMemberRegisterFormDto") PjhMemberRegisterFormDto pjhMemberRegisterFormDto, 
									BindingResult br, String strBirth) {	
		
		if(br.hasErrors()) {
			
			System.out.println("에러발생");
			return "pjh/member/registerform";
		} else {	
			
			//생일, 주소변환
			pjhMemberRegisterFormDto = (PjhMemberRegisterFormDto)PjhEditMyInfoDto.editMyInfoDto(pjhMemberRegisterFormDto, strBirth);
						
			//데이터 체크
			System.out.println("postRegisterForm 들어옴" + pjhMemberRegisterFormDto.toString());
			
			// MemberService
			boolean result = pjhMemberService.registMember(pjhMemberRegisterFormDto);
			
			return "redirect:/home.action";
		}
	}
	
}
