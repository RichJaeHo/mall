package com.shopping.mall.mapper;

import java.util.List;

import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;
import com.shopping.mall.dto.PjhTransportProDto;
import com.shopping.mall.dto.PjhTransportTotDto;

public interface PjhMyCartMapper {

	//카트에 추가
	public void insertMyCartInfoByMemberId(PjhMyCartDto pjhMyCartDto);
	
	//카트리스트 가져오기
	public List<PjhMyCartDto> selectMyCartList(String memberId);
	
	//파일이름 가져오기
	public String selectMyCartImage(int productNo);
	
	//카트삭제
	public void deleteMyCartByCartNo(PjhMyCartDto pjhMyCartDto);
	
	//카트 수량업데이트
	public void updateMyCartByCartNo(PjhMyCartDto pjhMyCartDto);
	
	//카트정보 가져오기
	public PjhMyCartDto selectMyCartByCartNo(int cartNo);
	
	//주소조회
	public String selectAddressNoByZipCodeArress(PjhMyCartOrderDto pjhMyCartOrderDto);
	
	//주소넣기
	public void insertAddressInfo(PjhMyCartOrderDto pjhMyCartOrderDto);
	
	//리스트넘버 가져오기
	public String selectMaxOrderListNo();
	
	//주문정보 넣기
	public void insertCartOrderInfo(PjhMyCartOrderDto pjhMyCartOrderDto);
	
	//주문된 카트정보 수정
	public void updateOrderedCartInfo(PjhMyCartOrderDto pjhMyCartOrderDto);
	
	//맴버아이디로 주문목록
	public List<PjhMyCartOrderDto> selectOrderedListByMemberId(String memberId);
	
	//맴버정보 페이팔용
	public PjhTransportTotDto selectMemberInfoForPayPal(PjhTransportTotDto pjhTransportTotDto);
	
	//구매정보 페이팔용
	public List<PjhTransportProDto> selectOrderInfoForPayPal(PjhTransportTotDto pjhTransportTotDto);
	
	public void deleteOrderListNo(int orderListNo);
	
	public String[] selectCartNoListByOrderListNo(int orderListNo);
	
	public void editCartInfoByCartNo(int catrNo);
	
}
