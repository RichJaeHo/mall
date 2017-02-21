package com.shopping.mall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dao.PdaProductDao;
import com.shopping.mall.dto.PdaProductDto;
import com.shopping.mall.dto.PdaProductImageDto;
import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.dto.PjhProductDto;


@Repository(value="PdaProductService")
public class PdaProductService {

	@Autowired
	@Qualifier(value="PdaProductDao")
	private PdaProductDao pdaProductDao;

	public List<PdaProductDto> requestCategory1List(PdaProductDto pdaProductDto) {
		
		return pdaProductDao.selectCategory1List(pdaProductDto);

	}

	public List<PdaProductDto> requestCategory2List(PdaProductDto pdaProductDto) {
		return pdaProductDao.selectCategory2List(pdaProductDto);
	}

	public void registerProductInfo(PdaProductDto pdaProductDto, List<String> oriNameList, List<String> fileNameList) {

		pdaProductDao.insertProductInfo(pdaProductDto);
		
		PdaProductImageDto imageDto = new PdaProductImageDto();
		
/*		for (PdaProductImageDto uf : oriNameList) {
		System.out.println("ProductNo" + pdaProductDto.getProductNo());
		uf.setProductNo(pdaProductDto.getProductNo());
		pdaProductDao.insertProductImage(uf);
		}*/
		
		if (oriNameList != null) {
			for (int i = 0; i < oriNameList.size(); i++) {
				if (oriNameList.get(i) != null) {
					imageDto.setOriName(oriNameList.get(i));
					imageDto.setFileName(fileNameList.get(i));
					imageDto.setProductNo(pdaProductDto.getProductNo());
					pdaProductDao.insertProductImage(imageDto);
				} else {
					return;
				}
				
			}
		}
	}

	public List<PdaProductDto> findMyProductList(String memberId) {
		
		return pdaProductDao.selectProductList(memberId);
	}

	public PdaProductDto findDetailInfoByProductNo(int productNo) {
		
		PdaProductDto product = pdaProductDao.selectDetailInfoByProductNo(productNo);
		
		product.setArrPdaProductImageDto(pdaProductDao.selectImageListByProductNo(productNo));
		
		return product;
	}

	public void removeProductByProductNo(String productNo) {
		System.out.println(productNo);
		pdaProductDao.deleteProductByProductNo(productNo);
		pdaProductDao.deleteProductImageByProductNo(productNo);
		
	}

	public void modifyProductInfoByProductNo(PdaProductDto pdaProductDto) {
		pdaProductDao.updateProductInfoByProductNo(pdaProductDto);
		
	}

	

	
	
}