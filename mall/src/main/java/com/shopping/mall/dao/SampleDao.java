package com.shopping.mall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dto.SampleDto;
import com.shopping.mall.mapper.SampleMapper;

@Repository(value="SampleDao")
public class SampleDao {

	@Autowired
	@Qualifier(value="SampleMapper")
	private SampleMapper sampleMapper;

	public SampleDto selectSampleMessage(SampleDto sampleDto) {
		SampleDto resultDto = sampleMapper.selectSampleMessage(sampleDto);
		return resultDto;
	}
	
}
