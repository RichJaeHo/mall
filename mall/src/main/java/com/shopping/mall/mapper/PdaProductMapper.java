package com.shopping.mall.mapper;

import java.util.List;

import com.shopping.mall.dto.PdaProductDto;
import com.shopping.mall.dto.PdaProductImageDto;
import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;


public interface PdaProductMapper {
	
	//카테고리1 조회
	public List<PdaProductDto> selectCategory1List(PdaProductDto pdaProductDto);

	//카테고리2 조회
	public List<PdaProductDto> selectCategory2List(PdaProductDto pdaProductDto);

	public void insertProductInfo(PdaProductDto pdaProductDto);

	public void insertProductImage(PdaProductImageDto uf);

	public List<PdaProductDto> selectProductList(String memberId);

	public PdaProductDto selectDetailInfoByProductNo(int productNo);

	public List<PdaProductImageDto> selectImageListByProductNo(int productNo);

	public void deleteProductByProductNo(String productNo);

	public void deleteProductImageByProductNo(String productNo);

	public void updateProductInfoByProductNo(PdaProductDto pdaProductDto);

	public List<PdaProductDto> selectProductListByBoardNo(int boardNo);

	public void insertProductListToCart(PjhMyCartDto pjhMyCartDto);

	public List<PjhMyCartOrderDto> mSelectOrderedListByMemberId(String memberId);

}

