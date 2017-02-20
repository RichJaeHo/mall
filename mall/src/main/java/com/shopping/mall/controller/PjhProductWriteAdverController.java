package com.shopping.mall.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.mall.dto.PjhImageDto;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.dto.PjhProductDto;
import com.shopping.mall.service.PjhProductService;

@Controller
public class PjhProductWriteAdverController {

	@Autowired
	@Qualifier(value="PjhProductService")
	private PjhProductService pjhProductService;
	
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	@RequestMapping(value="/product/writeadver.action", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getWriteAdver(HttpSession httpSession) {
				
		System.out.println("getWriteAdver 들어옴");
				
		PjhMemberDto session = (PjhMemberDto)httpSession.getAttribute("session");		
		List<PjhProductDto> arrResult = pjhProductService.findItemlListByMemberId(session.getMemberId());
				
		String json = gson.toJson(arrResult);
		
		return json;
	}
	
	@RequestMapping(value="/product/writeadver.action", method=RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String postWriteAdver(@RequestParam(value="arrProductNo[]") int[] arrProductNo, PjhProductAdverDto pjhProductAdverDto){
		
		pjhProductAdverDto.setProductNoList(arrProductNo);
		
		System.out.println("postWriteAdver 들어옴 : " + pjhProductAdverDto.toString());
				
		pjhProductService.writeADByMemberId(pjhProductAdverDto);
		
		return "sccess";
	}
	
	@RequestMapping(value="/product/adverimagelist.action", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getImageList(int productNo) {
		
		System.out.println("getImageList 들어옴 : " + productNo);
		
		List<PjhImageDto> arrResult = pjhProductService.findItemImageByProductNo(productNo);
		
		String json = gson.toJson(arrResult);
		
		return json;
	}
	
	
}
