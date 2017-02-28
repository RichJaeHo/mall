package com.shopping.mall.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;
import com.shopping.mall.dto.PjhMyCartOrderTempDto;
import com.shopping.mall.dto.PjhTransportTotDto;
import com.shopping.mall.service.PjhMyCartService;
import com.shopping.mall.util.Util;

@Controller
public class PjhMyCartOrderController {

	@Autowired
	@Qualifier(value="PjhMyCartService")
	private PjhMyCartService pjhMyCartService;
	
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	@RequestMapping(value="/myorder/order.action", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView postProductOrder(String json){
		
		System.out.println("postProductOrder 들어옴" + json);
		
		int[] arrCartNo = gson.fromJson(json, int[].class);
		
		List<PjhMyCartDto> arrResult = pjhMyCartService.findMyCartListForOrder(arrCartNo);
		
		for(PjhMyCartDto result : arrResult){
			System.out.println(result.toString());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pjh/order/order");
		mav.addObject("arrResult", arrResult);
		mav.addObject("arrCartNo", json);
		
		return mav;
	}
	
	
	@RequestMapping(value="/product/payfororder.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postPayForOrder(PjhMyCartOrderTempDto pjhMyCartOrderTempDto, 
								  String paypalEmail,
								  String paypalPasswd,
								  HttpSession httpSession){
		
		System.out.println("postPayForOrder 들어옴 : " + pjhMyCartOrderTempDto.toString());
		
		PjhMemberDto pjhMemberDto = (PjhMemberDto) httpSession.getAttribute("session");		
		int[] arrCartNo = gson.fromJson(pjhMyCartOrderTempDto.getArrCartNo(), int[].class);
		
		PjhMyCartOrderDto[] arrPjhMyCartOrderDto = new PjhMyCartOrderDto[arrCartNo.length];
		for(int i = 0; i < arrCartNo.length; i++) {			
			arrPjhMyCartOrderDto[i] = new PjhMyCartOrderDto();			
			arrPjhMyCartOrderDto[i].setMemberId(pjhMemberDto.getMemberId());
			arrPjhMyCartOrderDto[i].setCartNo(arrCartNo[i]);
			arrPjhMyCartOrderDto[i].setReciever(pjhMyCartOrderTempDto.getRecName());
			arrPjhMyCartOrderDto[i].setPhone(pjhMyCartOrderTempDto.getRecPhone());
			arrPjhMyCartOrderDto[i].setZipCode(pjhMyCartOrderTempDto.getRecZipCode());
			
			String[] arrAddress1 = pjhMyCartOrderTempDto.getRecAddress1().split(" ");
			String address2 = pjhMyCartOrderTempDto.getRecAddress2();
			
			arrPjhMyCartOrderDto[i].setAddress1(arrAddress1[0]);
			arrPjhMyCartOrderDto[i].setAddress2(arrAddress1[1]);
			
			String comAddress = "";
			for(int j = 2; j < arrAddress1.length; j++) {
				comAddress += String.format("%s ", arrAddress1[j]);			
			}
			
			comAddress += address2;
			
			arrPjhMyCartOrderDto[i].setAddress3(comAddress.trim());
		}
		
		int OrderListNo = pjhMyCartService.saveMyCartOrderInfo(arrPjhMyCartOrderDto);
		
		//PayPal에 키값 넘겨줌
		PjhTransportTotDto pjhTransportTotDto = new PjhTransportTotDto();
		pjhTransportTotDto.setMemberId(pjhMemberDto.getMemberId());
		pjhTransportTotDto.setOrderListNo(OrderListNo);
		pjhTransportTotDto.setPaypalEmail(paypalEmail);
		pjhTransportTotDto.setPaypalPasswd(Util.getHashedString(paypalPasswd, "SHA-256"));
		
		String json = gson.toJson(pjhTransportTotDto);
		
		System.out.println("페이팔에 보낼 키값 : " + json);
		
		return json;
	}
	
	
	@RequestMapping(value="/product/mpayfororder.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postAppPayForOrder(String session, String arrOrderDto){
		
		System.out.println("postAppPayForOrder 들어옴 : " + session);
		
		PjhMemberDto pjhMemberDto = gson.fromJson(session, PjhMemberDto.class);		
		PjhMyCartOrderDto[] arrPjhMyCartOrderDto = gson.fromJson(arrOrderDto, PjhMyCartOrderDto[].class);
		
		for(PjhMyCartOrderDto pjhMyCartOrderDto : arrPjhMyCartOrderDto) {
			
			pjhMyCartOrderDto.setMemberId(pjhMemberDto.getMemberId());
			
			String[] arrAddress1 = pjhMyCartOrderDto.getAddress1().split(" ");
			String address2 = pjhMyCartOrderDto.getAddress2();
			
			pjhMyCartOrderDto.setAddress1(arrAddress1[0]);
			pjhMyCartOrderDto.setAddress2(arrAddress1[1]);
			
			String comAddress = "";
			for(int i = 2; i < arrAddress1.length; i++) {
				comAddress += String.format("%s ", arrAddress1[i]);
			}
			
			comAddress += address2;
			pjhMyCartOrderDto.setAddress3(comAddress.trim());
		}
		
		int OrderListNo = pjhMyCartService.saveMyCartOrderInfo(arrPjhMyCartOrderDto);
		
		//PayPal에 키값 넘겨줌
		PjhTransportTotDto pjhTransportTotDto = new PjhTransportTotDto();
		pjhTransportTotDto.setMemberId(pjhMemberDto.getMemberId());
		pjhTransportTotDto.setOrderListNo(OrderListNo);
		
		String json = gson.toJson(pjhTransportTotDto);
		
		System.out.println("페이팔에 보낼 키값 : " + json);
		
		return json;
	}
	
	
	
	//페이팔에서 키값 받음
	private String dataPath = "redirect:http://210.16.214.202:8888/paypal/getorderinfo.action";
	
	@CrossOrigin
	@RequestMapping(value="/product/requestorderinfo.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	public String postConnectedFromPayPal(@RequestParam("key") String key, String paypalEmail, String paypalPasswd, 
										  RedirectAttributes ra, HttpSession session){
		
		System.out.println("postConnectedFromPayPal : " + key);
		
		PjhMemberDto pjhMemberDto = (PjhMemberDto) session.getAttribute("session");
		
		try{
			//페이팔로부터 키값 가져옴
			PjhTransportTotDto pjhTransportTotDto = (PjhTransportTotDto)gson.fromJson(key, PjhTransportTotDto.class);
			
			if(pjhTransportTotDto == null || pjhTransportTotDto.getMemberId() == null || pjhTransportTotDto.getOrderListNo() == 0){
				
				//키값이 없으면
				ra.addAttribute("result", "error");
				return dataPath;
			} else {
				
				//키값이 있으면			
				PjhTransportTotDto result = pjhMyCartService.findOrderInfoForPayPal(pjhTransportTotDto);	
								
				result.setMemberId(pjhMemberDto.getMemberId());
				result.setPaypalEmail(paypalEmail);
				result.setPaypalPasswd(paypalPasswd);
				String json = gson.toJson(result);
				
				System.out.println("페이팔에 보낼 데이터" + json);
				
				ra.addAttribute("result", json);				
				return dataPath;
			}
		} catch(Exception e) {
			
			// 형식 오류이면
			ra.addAttribute("result", "error");
			return dataPath;	
		}
	}
	
	@RequestMapping(value="/product/cancelordered.action", method={RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postCancelOrdered(Integer orderListNo) {
		
		System.out.println("postCancelOrdered 들어옴 : " + orderListNo);
		
		pjhMyCartService.cancelOrdeListNo(orderListNo);
		
		return "success";
	}
	
}

























