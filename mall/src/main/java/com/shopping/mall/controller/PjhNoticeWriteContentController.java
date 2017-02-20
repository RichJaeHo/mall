package com.shopping.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.mall.dto.PjhNoticeDto;
import com.shopping.mall.service.PjhNoticeService;

@Controller
@RequestMapping(value="/notice/writenotice.action")
public class PjhNoticeWriteContentController {

	@Autowired
	@Qualifier(value="PjhNoticeService")
	private PjhNoticeService pjhNoticeService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String postWriteNotice(PjhNoticeDto pjhNoticeDto){
		
		System.out.println("postWriteNotice 들어옴 : " + pjhNoticeDto.toString());
		
		pjhNoticeService.writeNotice(pjhNoticeDto);
		
		return "success";
	}
	
}
