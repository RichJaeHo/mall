package com.shopping.mall.controller;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.mall.dto.SampleDto;
import com.shopping.mall.service.SampleService;

@Controller
public class SampleController {
	
	@Autowired
	@Qualifier(value="SampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/sample.action", method=RequestMethod.GET)
	public ModelAndView sample(SampleDto sampleDto){
		
		System.out.println(sampleDto.toString());
		
		sampleDto =  sampleService.getSampleMessage(sampleDto);
		
		System.out.println(sampleDto.toString());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sample/sample");
		mv.addObject("sampleDto",sampleDto);
		
		return mv;
	}
	
}
