package com.shopping.mall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dto.PdaProductDto;
import com.shopping.mall.dto.PdaProductImageDto;
import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;
import com.shopping.mall.mapper.PdaProductMapper;



@Repository(value="PdaProductDao")
public class PdaProductDao {

	@Autowired
	@Qualifier("PdaProductMapper")
	private PdaProductMapper pdaProductMapper;

	
	public List<PdaProductDto> selectCategory1List(PdaProductDto pdaProductDto) {
		
		return pdaProductMapper.selectCategory1List(pdaProductDto);
	}
	
	public List<PdaProductDto> selectCategory2List(PdaProductDto pdaProductDto) {
		
		return pdaProductMapper.selectCategory2List(pdaProductDto);
	}

	public void insertProductInfo(PdaProductDto pdaProductDto) {
		System.out.println("상품등록 Dao 들어옴");
		pdaProductMapper.insertProductInfo(pdaProductDto);		
	}

	public void insertProductImage(PdaProductImageDto uf) {
		pdaProductMapper.insertProductImage(uf);
	}

	public List<PdaProductDto> selectProductList(String memberId) {

		return pdaProductMapper.selectProductList(memberId);
	}

	public PdaProductDto selectDetailInfoByProductNo(int productNo) {

		return pdaProductMapper.selectDetailInfoByProductNo(productNo);
	}

	public List<PdaProductImageDto> selectImageListByProductNo(int productNo) {
		
		return pdaProductMapper.selectImageListByProductNo(productNo);
	}

	public void deleteProductByProductNo(String productNo) {
		
		pdaProductMapper.deleteProductByProductNo(productNo);
	}

	public void deleteProductImageByProductNo(String productNo) {

		pdaProductMapper.deleteProductImageByProductNo(productNo);
	}

	public void updateProductInfoByProductNo(PdaProductDto pdaProductDto) {
		
		pdaProductMapper.updateProductInfoByProductNo(pdaProductDto);
	}

	public List<PdaProductDto> selectProductListByBoardNo(int boardNo) {

		return pdaProductMapper.selectProductListByBoardNo(boardNo);
	}

	public void insertProductListToCart(PjhMyCartDto pjhMyCartDto) {
		
		pdaProductMapper.insertProductListToCart(pjhMyCartDto);
	}

	public List<PjhMyCartOrderDto> mSelectOrderedListByMemberId(String memberId) {
		
		return pdaProductMapper.mSelectOrderedListByMemberId(memberId);
	}
	

	
}
