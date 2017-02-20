package com.shopping.mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.service.PjhMyCartService;

@Controller

public class PjhMyCartController {

	@Autowired
	@Qualifier(value="PjhMyCartService")
	private PjhMyCartService pjhMyCartService;
	
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	@RequestMapping(value="/mycart.action", method=RequestMethod.GET)
	public ModelAndView getMyCart(HttpSession httpSession){
		System.out.println("getMyCart 들어옴");
		
		PjhMemberDto session = (PjhMemberDto)httpSession.getAttribute("session");
		
		//자료가져오기
		List<PjhMyCartDto> arrResult = pjhMyCartService.findMyCartList(session.getMemberId());
		
		for(PjhMyCartDto pjhMyCartDto : arrResult) {
			System.out.println(pjhMyCartDto.toString());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pjh/mycart/mycart");
		mav.addObject("arrResult", arrResult);
		
		return mav;
	}
	
	
	@RequestMapping(value="/mycart/mcart.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postMMyCart(HttpSession httpSession, String session){
		
		System.out.println("getMyCart 들어옴 : " + session);
		
		PjhMemberDto pjhMemberDto = gson.fromJson(session, PjhMemberDto.class);
		
		//자료가져오기
		List<PjhMyCartDto> arrResult = pjhMyCartService.findMyCartList(pjhMemberDto.getMemberId());
		
		for(PjhMyCartDto pjhMyCartDto : arrResult) {
			System.out.println(pjhMyCartDto.toString());
		}
		
		String json = gson.toJson(arrResult);
		return json;
	}
	
	
	
	
	@RequestMapping(value="/mycart/addproduct.action", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postAddMyCart(@RequestParam(value="cartData") String json, HttpSession httpSession){
		
		//세션가져오기
		PjhMemberDto session = (PjhMemberDto)httpSession.getAttribute("session");
		
		String[][] arrCartData = gson.fromJson(json, String[][].class);
		
		//자료담기
		ArrayList<PjhMyCartDto> arrPjhMyCartDto = new ArrayList<PjhMyCartDto>();		
		for(String[] cartData : arrCartData) {
			PjhMyCartDto pjhMyCartDto = new PjhMyCartDto();
			pjhMyCartDto.setMemberId(session.getMemberId());
			pjhMyCartDto.setProductNo(Integer.parseInt(cartData[0]));
			pjhMyCartDto.setQty(Integer.parseInt(cartData[2]));
			
			System.out.println(pjhMyCartDto.toString());
			
			arrPjhMyCartDto.add(pjhMyCartDto);
		}
		
		//서비스에 넘기기
		pjhMyCartService.saveMyCartInfoByMemberId(arrPjhMyCartDto);
		
		return "success";
	};	
	
	
	@RequestMapping(value="/mycart/editproduct.action", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postEditMyCart(PjhMyCartDto pjhMyCartDto, HttpSession httpSession) {
		
		System.out.println("postEditMyCart 들어옴" + pjhMyCartDto.toString());
		
		PjhMemberDto session = (PjhMemberDto)httpSession.getAttribute("session");
		
		pjhMyCartDto.setMemberId(session.getMemberId());
		
		pjhMyCartService.editMyCartByCartNo(pjhMyCartDto);
		
		return "success";
	}
	
	
	@RequestMapping(value="/mycart/deleteproduct.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getDelMyCart(PjhMyCartDto pjhMyCartDto, HttpSession httpSession){
		
		System.out.println("getDelMyCart 들어옴 : " + pjhMyCartDto.toString());
		
		PjhMemberDto session = (PjhMemberDto)httpSession.getAttribute("session");
		
		pjhMyCartDto.setMemberId(session.getMemberId());
		
		pjhMyCartService.removeMyCartByCartNo(pjhMyCartDto);
		
		return "success";
	}
	
	@RequestMapping(value="/mycart/mdeleteproduct.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getDelMyCart(String session, String arrCartDto){
		
		System.out.println(session);
		System.out.println("getDelMyCart 들어옴" + arrCartDto);
		
		//session
		PjhMemberDto pjhMemberDto = gson.fromJson(session, PjhMemberDto.class);
		
		//자료
		List<PjhMyCartDto> arrPjhMyCartDto = gson.fromJson(arrCartDto, new TypeToken<List<PjhMyCartDto>>(){}.getType());
		for(PjhMyCartDto pjhMyCartDto : arrPjhMyCartDto) {
			pjhMyCartDto.setMemberId(pjhMemberDto.getMemberId());
		}
		
		pjhMyCartService.removeMyCartListByCartNo(arrPjhMyCartDto);
		
		return "success";
	}
	
}



