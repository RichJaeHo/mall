package com.shopping.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.mall.dto.PjhNoticeDto;
import com.shopping.mall.service.PjhNoticeService;

@Controller
@RequestMapping(value="/notice/noticelist.action")
public class PjhNoticeListController {

	@Autowired
	@Qualifier(value="PjhNoticeService")
	private PjhNoticeService pjhNoticeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getNoticeList(){
		System.out.println("getNoticeList 들어옴");
		
		List<PjhNoticeDto> arrResult = pjhNoticeService.findNoticeList();
		
		for(PjhNoticeDto dto : arrResult){
			System.out.println(dto);
		}
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("pjh/notice/noticelist");		
		mav.addObject("arrResult", arrResult);
		
		return mav;
	}
	
}
