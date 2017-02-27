package com.shopping.mall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dao.PjhProductDao;
import com.shopping.mall.dto.PjhImageDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;
import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.dto.PjhProductDto;

@Repository(value="PjhProductService")
public class PjhProductService {

	@Autowired
	@Qualifier(value="PjhProductDao")
	private PjhProductDao pjhProductDao;
	
	public List<PjhProductAdverDto> findADListByCategory(String category) {
		
		List<PjhProductAdverDto> arrResult;
		
		if(category.equals("모든상품")){
			arrResult = pjhProductDao.selectADListAll();			
		} else {
			arrResult = pjhProductDao.selectADListByCategory(category);
		}
		
		return arrResult;
	}

	public List<PjhProductAdverDto> findAdListByKeyWord(String keyWord) {
		List<PjhProductAdverDto> arrResult = pjhProductDao.selectAdListByKeyWord(keyWord);
		return arrResult;
	}

	public PjhProductAdverDto findItemListByBoardNo(int boardNo) {
		
		PjhProductAdverDto result = pjhProductDao.selectBoardByboardNo(boardNo);
		
		List<PjhProductDto> arrResult = pjhProductDao.selectItemListByBoardNo(boardNo);
		for(PjhProductDto result2 : arrResult){
			List<PjhImageDto> arrResult2 = pjhProductDao.selectImageListByProductNo(result2.getProductNo());			
			result2.setArrPjhImageDto(arrResult2);
		}
		
		result.setArrPjhProductDto(arrResult);
		
		return result;
	}

	public List<PjhProductDto> findItemlListByMemberId(String memberId) {
		
		//제품정보 불러오기
		List<PjhProductDto> arrResult = pjhProductDao.selectItemlListByMemberId(memberId);
		
		//제품이미지 불러오기
		for(PjhProductDto result : arrResult) {			
			List<PjhImageDto> arrResult2 = pjhProductDao.selectImageListByProductNo(result.getProductNo());			
			result.setArrPjhImageDto(arrResult2);
		}
		
		return arrResult;
	}

	public List<PjhImageDto> findItemImageByProductNo(int productNo) {
		 List<PjhImageDto> arrResult = pjhProductDao.selectImageListByProductNo(productNo);		
		return arrResult;
	}

	public void writeADByMemberId(PjhProductAdverDto pjhProductAdverDto) {
		  pjhProductDao.insertADByMemberId(pjhProductAdverDto);
		  
		  for(int no : pjhProductAdverDto.getProductNoList()){
			  pjhProductAdverDto.setPreProductNo(no);
			  pjhProductDao.insertLinkedProduct(pjhProductAdverDto);
		  }
	}

	public PjhProductDto findItemByProductNo(int productNo) {
		PjhProductDto result = pjhProductDao.selectItemByProductNo(productNo);		
					  result.setArrPjhImageDto(pjhProductDao.selectImageListByProductNo(productNo));
		return result;
	}

	public List<PjhProductAdverDto> findProductListTop2() {

		ArrayList<PjhProductAdverDto> arrpjhProductAdverDto = new ArrayList<PjhProductAdverDto>();
		
		//productNo 2 조회
		List<PjhProductDto> arrResult = pjhProductDao.selectProductNoListTop2();
		
		
		for(PjhProductDto result : arrResult){
			
			//boardNo 조회
			String boardNo = pjhProductDao.selectBoardNoByProductNo(result.getProductNo());
			
			//boardInfo 조회
			PjhProductAdverDto pjhProductAdverDto = pjhProductDao.selectBoardByboardNo(Integer.parseInt(boardNo));
			
			//연결된 product 조회
			List<PjhProductDto> arrPjhProductDto = pjhProductDao.selectItemListByBoardNo(Integer.parseInt(boardNo));
			for(PjhProductDto pjhProductDto : arrPjhProductDto){
				
				//이미지조회
				pjhProductDto.setArrPjhImageDto(pjhProductDao.selectImageListByProductNo(pjhProductDto.getProductNo()));
			}
			
			//boardInfo 에 product list 넣기
			pjhProductAdverDto.setArrPjhProductDto(arrPjhProductDto);
			
			//boardList에 board넣기
			arrpjhProductAdverDto.add(pjhProductAdverDto);
		}
		
		return arrpjhProductAdverDto;
	}

	public List<PjhProductAdverDto> findProductCategoryTop1() {
		
		//productNo 1 category 조회
		String result = pjhProductDao.selectCategoryTop1();
		
		List<PjhProductAdverDto> arrResult;
		if(result == null){
			arrResult = pjhProductDao.selectADListAll4();			
		} else {
			arrResult = pjhProductDao.selectADListByCategory4(result);
		}
		
		return arrResult;
	}

	public List<PjhProductAdverDto> findADList4ByCategory(String preCategory1) {
		List<PjhProductAdverDto> arrResult = pjhProductDao.selectADListByCategory4(preCategory1);
		return arrResult;
	}

	public List<PjhProductAdverDto> findProductListTop2AfterLogin(String category1) {

		ArrayList<PjhProductAdverDto> arrpjhProductAdverDto = new ArrayList<PjhProductAdverDto>();

		//productNo 2 조회
		List<PjhProductDto> arrResult = pjhProductDao.selectProductListTop2AfterLogin(category1);
		
		for(PjhProductDto result : arrResult){
			
			//boardNo 조회
			String boardNo = pjhProductDao.selectBoardNoByProductNo(result.getProductNo());
			
			//boardInfo 조회
			PjhProductAdverDto pjhProductAdverDto = pjhProductDao.selectBoardByboardNo(Integer.parseInt(boardNo));
			
			//연결된 product 조회
			List<PjhProductDto> arrPjhProductDto = pjhProductDao.selectItemListByBoardNo(Integer.parseInt(boardNo));
			for(PjhProductDto pjhProductDto : arrPjhProductDto){
				
				//이미지조회
				pjhProductDto.setArrPjhImageDto(pjhProductDao.selectImageListByProductNo(pjhProductDto.getProductNo()));
			}
			
			//boardInfo 에 product list 넣기
			pjhProductAdverDto.setArrPjhProductDto(arrPjhProductDto);
			
			//boardList에 board넣기
			arrpjhProductAdverDto.add(pjhProductAdverDto);
		}
		
		return arrpjhProductAdverDto;
	}

	public List<PjhProductAdverDto> findProductCategoryTop1AfterLogin(String category1) {

		List<PjhProductAdverDto> arrResult;
		if(category1 == null){
			arrResult = pjhProductDao.selectADListAll4();			
		} else {
			arrResult = pjhProductDao.selectADListByCategory4(category1);
		}
		
		return arrResult;
	}


}
