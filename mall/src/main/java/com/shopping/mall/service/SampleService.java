package com.shopping.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dao.SampleDao;
import com.shopping.mall.dto.SampleDto;

@Repository(value="SampleService")
public class SampleService {
	
	@Autowired
	@Qualifier(value="SampleDao")
	private SampleDao sampleDao;

	public SampleDto getSampleMessage(SampleDto sampleDto) {
		SampleDto resultDto = sampleDao.selectSampleMessage(sampleDto);		
		return resultDto;
	}

}
