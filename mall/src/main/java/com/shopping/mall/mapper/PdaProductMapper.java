package com.shopping.mall.mapper;

import java.util.List;

import com.shopping.mall.dto.PdaProductDto;
import com.shopping.mall.dto.PdaProductImageDto;


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

}
	
/*	
	//맴버생성
	public void insertMemberInfo(PjhMemberInterface pjhMemberInterface);
	
	//주소넣기
	public void insertAddressIfno(PjhMemberInterface pjhMemberInterface);
	
	//맴버정보에 주소업데이트
	public void updateAddressInfo(PjhMemberInterface pjhMemberInterface);
		
	//로그인
	public PjhMemberDto selectMemberInfoByMemberId(PjhMemberLoginDto pjhMemberLoginDto);
	
	//회원정보수정
	public void updateMemberInfoByMemberId(PjhMemberInterface pjhMemberInterface);
	
	//회원주소 검색
	public String selectAddressNoByZipCodeAddress(PjhMemberInterface pjhMemberInterface);
	
	//회원탈퇴
	public void updateMemberDeleteByMemberIdPasswd(PjhMemberLoginDto pjhMemberLoginDto);
	*/

