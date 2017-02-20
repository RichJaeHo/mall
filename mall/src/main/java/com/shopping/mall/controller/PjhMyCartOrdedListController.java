package com.shopping.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;
import com.shopping.mall.service.PjhMyCartService;

@Controller
public class PjhMyCartOrdedListController {

	@Autowired
	@Qualifier(value="PjhMyCartService")
	private PjhMyCartService pjhMyCartService;
	
	@RequestMapping(value="/myorder/orderlist.action", method=RequestMethod.GET)
	public ModelAndView getOrderedList(HttpSession httpSession){
		
		System.out.println("getOrderedList 들어옴");		
		
		PjhMemberDto pjhMemberDto = (PjhMemberDto) httpSession.getAttribute("session");
		
		List<PjhMyCartOrderDto> arrResult = pjhMyCartService.findOrderedListByMemberId(pjhMemberDto.getMemberId());
		
		for(PjhMyCartOrderDto result : arrResult) {
			System.out.println(result.toString());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName( "pjh/order/orderedlist");
		mav.addObject("arrResult", arrResult);
		
		return mav;
	}
	
}
