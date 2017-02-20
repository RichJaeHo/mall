package com.shopping.mall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dto.PjhNoticeDto;
import com.shopping.mall.mapper.PjhNoticeMapper;

@Repository(value="PjhNoticeDao")
public class PjhNoticeDao {

	@Autowired
	@Qualifier(value="PjhNoticeMapper")
	private PjhNoticeMapper pjhNoticeMapper;
	
	//공지사항 리스트 가져오기
	public List<PjhNoticeDto> selectNoticeList() {
		List<PjhNoticeDto> arrResult = pjhNoticeMapper.selectNoticeList();
		return arrResult;
	}

	//공지사항 작성
	public void insertNotice(PjhNoticeDto pjhNoticeDto) {
		pjhNoticeMapper.insertNotice(pjhNoticeDto);
	}

	//공지사항 조회
	public PjhNoticeDto selectNoticeByContentNo(PjhNoticeDto pjhNoticeDto) {
		PjhNoticeDto result = pjhNoticeMapper.selectNoticeByContentNo(pjhNoticeDto);
		return result;
	}

	//공지사항 수정
	public void updateNoticeByNoticeNo(PjhNoticeDto pjhNoticeDto) {
		pjhNoticeMapper.updateNoticeByNoticeNo(pjhNoticeDto);
	}

}
