package com.shopping.mall.mapper;

import java.util.List;

import com.shopping.mall.dto.PjhImageDto;
import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.dto.PjhProductDto;

public interface PjhProductMapper {

	//카테고리 제품목록 가져오기
	public List<PjhProductAdverDto> selectADListByCategory(String category);
	
	//키워드관련 상품가져오기
	public List<PjhProductAdverDto> selectAdListByKeyWord(String keyWord);
	
	//전체카테고리 상품
	public List<PjhProductAdverDto> selectADListAll();
	
	//보드번호로 정보조회
	public List<PjhProductDto> selectItemListByBoardNo(int boardNo);
	
	//제품목록 가져오기
	public List<PjhProductDto> selectItemlListByMemberId(String memberId);
	
	//제품 이미지 가져오기
	public List<PjhImageDto> selectImageListByProductNo(int productNo);
	
	//광고글 입력하기
	public void insertADByMemberId(PjhProductAdverDto pjhProductAdverDto);
	
	//링크된 제품번호 입력하기
	public void insertLinkedProduct(PjhProductAdverDto pjhProductAdverDto);
	
	//광고글 가져오기
	public PjhProductAdverDto selectBoardByboardNo(int boardNo);
	
	//제품 번호로 정보조회
	public PjhProductDto selectItemByProductNo(int productNo); 
	
	//많이 팔리 제품2개 조회
	public List<PjhProductDto> selectProductNoListTop2();
	
	//boardNo 조회
	public String selectBoardNoByProductNo(int productNo);
	
	//카테고리top1
	public String selectCategoryTop1();
	
	//전체카테고리 상품가져오기 4개만
	public List<PjhProductAdverDto> selectADListAll4();
	
	//카테고리별 상품가져오기 4개만
	public List<PjhProductAdverDto> selectADListByCategory4(String category);
	
	//페이팔에서 받은 우선 카테고리 데이터 조회
	public List<PjhProductDto> selectProductListTop2AfterLogin(String category1);
	
}
