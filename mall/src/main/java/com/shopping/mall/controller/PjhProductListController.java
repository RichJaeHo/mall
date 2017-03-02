package com.shopping.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.dto.PjhProductDto;
import com.shopping.mall.dto.PjhTransportDataDto;
import com.shopping.mall.dto.PjhTransportReqDto;
import com.shopping.mall.service.PjhProductService;
import com.shopping.mall.util.PjhCalAge;

@Controller
public class PjhProductListController {

	@Autowired
	@Qualifier(value="PjhProductService")
	private PjhProductService pjhProductService;
	
	
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	
	//웹 카테고리 리스트
	@RequestMapping(value="/product/list.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView getProductList(String category){
		
		System.out.println("getProductList 들어옴 : " + category);	
		
		if(category == null) {
			category = "모든상품";
		}
		
		List<PjhProductAdverDto> arrResult = pjhProductService.findADListByCategory(category);
		
		for(PjhProductAdverDto temp : arrResult){
			System.out.println(temp.toString());
		}
			
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pjh/product/productlist");
		mav.addObject("repCategory", category);
		mav.addObject("arrResult", arrResult);
		
		return mav;
	}
	
	//안드로이드 카테고리 리스트
	@RequestMapping(value="/product/mlist.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postProductList(String category) {
		
		System.out.println("getProductList 들어옴 : " + category);	
		
		if(category == null) {
			category = "모든상품";
		}
		
		List<PjhProductAdverDto> arrResult = pjhProductService.findADListByCategory(category);
		
		for(PjhProductAdverDto temp : arrResult){
			System.out.println(temp.toString());
		}
			
		String json = gson.toJson(arrResult);
		
		return json;
	}
	
	
	//웹 검색리스트
	@RequestMapping(value="/product/searchlist.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView getSearchList(String keyWord) {
		
		System.out.println("getSearchList 들어옴 : " + keyWord);
		
		List<PjhProductAdverDto> arrResult = pjhProductService.findAdListByKeyWord(keyWord);
		
		for(PjhProductAdverDto temp : arrResult){
			System.out.println(temp.toString());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pjh/product/productlist");
		mav.addObject("repCategory", keyWord);
		mav.addObject("arrResult", arrResult);
		
		return mav;
	}
	
	//앱 검색리스트
	@RequestMapping(value="/product/msearchlist.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getAppSearchList(String keyWord) {
		
		System.out.println("getSearchList 들어옴 : " + keyWord);
		
		List<PjhProductAdverDto> arrResult = pjhProductService.findAdListByKeyWord(keyWord);
		
		for(PjhProductAdverDto temp : arrResult){
			System.out.println(temp.toString());
		}
		
		String json = gson.toJson(arrResult);
		return json;
	}
	
	
	//웹 상위2개 리스트
	@RequestMapping(value="/product/listtop2.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getProductListTop2(){
		
		System.out.println("getProductListTop2 들어옴");
		
		List<PjhProductAdverDto> arrResult = pjhProductService.findProductListTop2();
				
		String json = gson.toJson(arrResult);
		
		return json;
	}
	
	
	//로그인 후 상위2개 리스트
	@RequestMapping(value="/product/listtop2afterlogin.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")	
	@ResponseBody
	public String getProductListTop2AfterLogin(String paypal){
		
		System.out.println("listtop2afterlogin 들어옴 : " + paypal);
		
		PjhTransportReqDto pjhTransportReqDto = gson.fromJson(paypal, PjhTransportReqDto.class);
		
		List<PjhProductAdverDto> arrResult = null;
		
		if(pjhTransportReqDto.getData().size() < 1) {
			arrResult = pjhProductService.findProductListTop2();
		} else {		
		    arrResult = pjhProductService.findProductListTop2AfterLogin(pjhTransportReqDto.getCategoryNo1());
		}
		
		//List<PjhProductAdverDto> arrResult = pjhProductService.findProductListTop2AfterLogin(paypal);
		
		String json = gson.toJson(arrResult);
		
		System.out.println("getProductListTop2AfterLogin 조회된 데이터 : " + json);
		
		return json;
	}
	
	
	//웹 상위1제품의 카테고리 리스트
	@RequestMapping(value="/product/listtop1category.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getProductListTopCategory(){
		
		System.out.println("getProductListTopCategory 들어옴");
		
		List<PjhProductAdverDto> arrResult = pjhProductService.findProductCategoryTop1();
		
		for(PjhProductAdverDto result : arrResult) {
			System.out.println(result.toString());
		}
		
		String json = gson.toJson(arrResult);
		
		return json;
	}
	
	@RequestMapping(value="/product/listtop1categoryafterlogin.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody	
	public String getProductListTopCategoryAfterLogin(String paypal){
		
		System.out.println("listtop1categoryafterlogin 데이터 들어옴 : " + paypal);
		
		PjhTransportReqDto pjhTransportReqDto = gson.fromJson(paypal, PjhTransportReqDto.class);
		
		List<PjhProductAdverDto> arrResult = pjhProductService.findProductCategoryTop1AfterLogin(pjhTransportReqDto.getCategoryNo1());
		
		//List<PjhProductAdverDto> arrResult = pjhProductService.findProductCategoryTop1AfterLogin(paypal);
		
		for(PjhProductAdverDto result : arrResult) {
			System.out.println(result.toString());
		}
		
		String json = gson.toJson(arrResult);
		
		return json;
	}
	
	
	@RequestMapping(value="/product/makejsonforrequest.action", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getProductListAfterLogin(HttpSession session) {
		
		PjhMemberDto pjhMemberDto = (PjhMemberDto) session.getAttribute("session");
		
		PjhTransportReqDto pjhTransportReqDto = new PjhTransportReqDto();
		pjhTransportReqDto.setAge(PjhCalAge.getAges(pjhMemberDto.getBirth()));
		pjhTransportReqDto.setGender(pjhMemberDto.getGender());
		pjhTransportReqDto.setArea(pjhMemberDto.getAddress1());
		
		String json = gson.toJson(pjhTransportReqDto);
		
		System.out.println("유준형한데 보낼자료 : " + json);
		
		return json;
	}
	
}


























