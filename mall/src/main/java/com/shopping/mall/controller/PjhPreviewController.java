package com.shopping.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.dto.PjhProductDto;
import com.shopping.mall.service.PjhProductService;

@Controller
@RequestMapping(value="/product/preview.action")
public class PjhPreviewController {

	@Autowired
	@Qualifier(value="PjhProductService")
	private PjhProductService pjhProductService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getPreview(int boardNo){
		
		System.out.println("getPreview 들어옴 boardNo : " + boardNo);
		
		//상세정보
		PjhProductAdverDto result =  pjhProductService.findItemListByBoardNo(boardNo);
	
		//관련카테고리 정보
		List<PjhProductAdverDto> arrResult = pjhProductService.findADList4ByCategory(result.getPreCategory1());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("preview");
		mav.addObject("result", result);
		mav.addObject("arrResult", arrResult);
		
		return mav;
	}
	
}
