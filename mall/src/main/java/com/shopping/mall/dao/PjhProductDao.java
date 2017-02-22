package com.shopping.mall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dto.PjhImageDto;
import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.dto.PjhProductDto;
import com.shopping.mall.mapper.PjhProductMapper;

@Repository(value="PjhProductDao")
public class PjhProductDao {

	@Autowired
	@Qualifier(value="PjhProductMapper")
	private PjhProductMapper pjhProductMapper;
	
	//카테고리별 상품가져오기
	public List<PjhProductAdverDto> selectADListByCategory(String category) {
		List<PjhProductAdverDto> arrResult = pjhProductMapper.selectADListByCategory(category);
		return arrResult;
	}

	//키워드관련 상품가져오기
	public List<PjhProductAdverDto> selectAdListByKeyWord(String keyWord) {
		List<PjhProductAdverDto> arrResult = pjhProductMapper.selectAdListByKeyWord(keyWord);
		return arrResult;
	}

	//전체카테고리 상품가져오기
	public List<PjhProductAdverDto> selectADListAll() {
		List<PjhProductAdverDto> arrResult = pjhProductMapper.selectADListAll();
		return arrResult;
	}
	
	//상품번호로 정보조회
	public List<PjhProductDto> selectItemListByBoardNo(int boardNo) {
		List<PjhProductDto> arrResult = pjhProductMapper.selectItemListByBoardNo(boardNo);
		return arrResult;
	}

	//제품목록 가져오기
	public List<PjhProductDto> selectItemlListByMemberId(String memberId) {
		List<PjhProductDto> arrResult = pjhProductMapper.selectItemlListByMemberId(memberId);
		return arrResult;
	}

	//제품이미지 가져오기
	public List<PjhImageDto> selectImageListByProductNo(int productNo) {
		List<PjhImageDto> arrResult = pjhProductMapper.selectImageListByProductNo(productNo);
		return arrResult;
	}

	//광고글 입력하기
	public void insertADByMemberId(PjhProductAdverDto pjhProductAdverDto) {
		pjhProductMapper.insertADByMemberId(pjhProductAdverDto);		
	}

	//링크된 제품번호 입력하기
	public void insertLinkedProduct(PjhProductAdverDto pjhProductAdverDto) {
		pjhProductMapper.insertLinkedProduct(pjhProductAdverDto);
	}

	//광고글 가져오기
	public PjhProductAdverDto selectBoardByboardNo(int boardNo) {
		PjhProductAdverDto result = pjhProductMapper.selectBoardByboardNo(boardNo);
		return result;
	}

	//제품 번호로 정보조회
	public PjhProductDto selectItemByProductNo(int productNo) {
		PjhProductDto result = pjhProductMapper.selectItemByProductNo(productNo);
		return result;
	}

	//많이 팔리 제품2개 조회
	public List<PjhProductDto> selectProductNoListTop2() {
		List<PjhProductDto> arrResult = pjhProductMapper.selectProductNoListTop2();
		return arrResult;
	}

	//boardNo 조회
	public String selectBoardNoByProductNo(int productNo) {
		String result = pjhProductMapper.selectBoardNoByProductNo(productNo);
		return result;
	}

	//카테고리top1
	public String selectCategoryTop1() {
		String result = pjhProductMapper.selectCategoryTop1();
		return result;
	}

	//전체카테고리 상품가져오기 4개만
	public List<PjhProductAdverDto> selectADListAll4() {
		List<PjhProductAdverDto> arrResult = pjhProductMapper.selectADListAll4();
		return arrResult;
	}
	
	//카테고리별 상품가져오기 4개만
	public List<PjhProductAdverDto> selectADListByCategory4(String category) {
		List<PjhProductAdverDto> arrResult = pjhProductMapper.selectADListByCategory4(category);
		return arrResult;
	}

	//페이팔에서 받은 우선 카테고리 데이터 조회
	public List<PjhProductDto> selectProductListTop2AfterLogin(String category1) {
		List<PjhProductDto> arrResult = pjhProductMapper.selectProductListTop2AfterLogin(category1);
		return arrResult;
	}

}
