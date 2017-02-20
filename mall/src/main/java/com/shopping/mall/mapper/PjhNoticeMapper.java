package com.shopping.mall.mapper;

import java.util.List;

import com.shopping.mall.dto.PjhNoticeDto;

public interface PjhNoticeMapper {

	//공지사항 리스트 가져오기
	public List<PjhNoticeDto> selectNoticeList();
	
	//공지사항 작성
	public void insertNotice(PjhNoticeDto pjhNoticeDto);
	
	//공지사항 조회
	public PjhNoticeDto selectNoticeByContentNo(PjhNoticeDto pjhNoticeDto);
	
	//공지사항 업데이트
	public void updateNoticeByNoticeNo(PjhNoticeDto pjhNoticeDto);
}
