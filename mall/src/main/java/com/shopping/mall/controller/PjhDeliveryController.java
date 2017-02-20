package com.shopping.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/delivery.action")
public class PjhDeliveryController {

	@RequestMapping(method = RequestMethod.GET)
	public String getDelivery(){
		System.out.println("getDelivery 들어옴");
		return "delivery";		
	}
	
}
