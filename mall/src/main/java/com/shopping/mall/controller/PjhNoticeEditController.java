package com.shopping.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.mall.dto.PjhNoticeDto;
import com.shopping.mall.service.PjhNoticeService;

@Controller
@RequestMapping(value="/notice/editnotice.action")
public class PjhNoticeEditController {

	@Autowired
	@Qualifier(value="PjhNoticeService")
	private PjhNoticeService pjhNoticeService;
	
	@RequestMapping(method=RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getEditNotice(PjhNoticeDto pjhNoticeDto){
		
		System.out.println("getEditNotice 들어옴");
		
		PjhNoticeDto result = pjhNoticeService.findNoticeByContentNo(pjhNoticeDto);
		
		System.out.println(result.toString());

		//json변환
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(result);
		
		return json;
	}
		
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String postEditNotice(PjhNoticeDto pjhNoticeDto){
		
		System.out.println("postEditNotice 들어옴 : " + pjhNoticeDto.toString());
		
		pjhNoticeService.editNoticeByNoticeNo(pjhNoticeDto);
		
		return "success";
	}
	
}
