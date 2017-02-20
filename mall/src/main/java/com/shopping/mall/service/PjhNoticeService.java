package com.shopping.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dao.PjhNoticeDao;
import com.shopping.mall.dto.PjhNoticeDto;

@Repository(value="PjhNoticeService")
public class PjhNoticeService {

	@Autowired
	@Qualifier("PjhNoticeDao")
	private PjhNoticeDao pjhNoticeDao;
	
	public List<PjhNoticeDto> findNoticeList() {
		List<PjhNoticeDto> arrResult = pjhNoticeDao.selectNoticeList();		
		return arrResult;
	}

	public void writeNotice(PjhNoticeDto pjhNoticeDto) {
		pjhNoticeDao.insertNotice(pjhNoticeDto);
	}

	public PjhNoticeDto findNoticeByContentNo(PjhNoticeDto pjhNoticeDto) {
		PjhNoticeDto result = pjhNoticeDao.selectNoticeByContentNo(pjhNoticeDto);
		return result;
	}

	public void editNoticeByNoticeNo(PjhNoticeDto pjhNoticeDto) {
		pjhNoticeDao.updateNoticeByNoticeNo(pjhNoticeDto);
	}

}
