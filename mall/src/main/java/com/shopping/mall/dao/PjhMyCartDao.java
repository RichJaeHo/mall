package com.shopping.mall.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;
import com.shopping.mall.dto.PjhTransportProDto;
import com.shopping.mall.dto.PjhTransportTotDto;
import com.shopping.mall.mapper.PjhMyCartMapper;

@Repository(value="PjhMyCartDao")
public class PjhMyCartDao {

	@Autowired
	@Qualifier(value="PjhMyCartMapper")
	private PjhMyCartMapper pjhMyCartMapper;
	
	//카트에 추가
	public void insertMyCartInfoByMemberId(PjhMyCartDto pjhMyCartDto) {
		pjhMyCartMapper.insertMyCartInfoByMemberId(pjhMyCartDto);
	}

	//카트리스트 가져오기
	public List<PjhMyCartDto> selectMyCartList(String memberId) {
		List<PjhMyCartDto> arrResult = pjhMyCartMapper.selectMyCartList(memberId);
		return arrResult;
	}

	//파일이름 가져오기
	public String selectMyCartImage(int productNo) {
		String result = pjhMyCartMapper.selectMyCartImage(productNo);
		return result;
	}

	//카트삭제
	public void deleteMyCartByCartNo(PjhMyCartDto pjhMyCartDto) {
		pjhMyCartMapper.deleteMyCartByCartNo(pjhMyCartDto);
	}

	//카트 수량업데이트
	public void updateMyCartByCartNo(PjhMyCartDto pjhMyCartDto) {
		pjhMyCartMapper.updateMyCartByCartNo(pjhMyCartDto);
	}

	//카트정보 가져오기
	public PjhMyCartDto selectMyCartByCartNo(int cartNo) {
		PjhMyCartDto result = pjhMyCartMapper.selectMyCartByCartNo(cartNo);
		return result;
	}

	//주소조회
	public String selectAddressNoByZipCodeArress(PjhMyCartOrderDto pjhMyCartOrderDto) {
		String result = pjhMyCartMapper.selectAddressNoByZipCodeArress(pjhMyCartOrderDto);
		return result;
	}

	//주소넣기
	public void insertAddressInfo(PjhMyCartOrderDto pjhMyCartOrderDto) {
		pjhMyCartMapper.insertAddressInfo(pjhMyCartOrderDto);
	}

	//리스트넘버 가져오기
	public String selectMaxOrderListNo() {
		String result = pjhMyCartMapper.selectMaxOrderListNo();
		return result;
	}

	//주문정보 넣기
	public void insertCartOrderInfo(PjhMyCartOrderDto pjhMyCartOrderDto) {
		pjhMyCartMapper.insertCartOrderInfo(pjhMyCartOrderDto);
	}

	//주문된 카트정보 수정
	public void updateOrderedCartInfo(PjhMyCartOrderDto pjhMyCartOrderDto) {
		pjhMyCartMapper.updateOrderedCartInfo(pjhMyCartOrderDto);	
	}

	//맴버아이디로 주문목록
	public List<PjhMyCartOrderDto> selectOrderedListByMemberId(String memberId) {
		List<PjhMyCartOrderDto> arrResult = pjhMyCartMapper.selectOrderedListByMemberId(memberId);
		return arrResult;
	}

	//맴버정보 페이팔용
	public PjhTransportTotDto selectMemberInfoForPayPal(PjhTransportTotDto pjhTransportTotDto) {
		PjhTransportTotDto result = pjhMyCartMapper.selectMemberInfoForPayPal(pjhTransportTotDto);		
		return result;
	}

	//구매정보 페이팔용
	public List<PjhTransportProDto> selectOrderInfoForPayPal(PjhTransportTotDto pjhTransportTotDto) {
		List<PjhTransportProDto> arrResult = pjhMyCartMapper.selectOrderInfoForPayPal(pjhTransportTotDto);
		return arrResult;
	}

	public void deleteOrderListNo(int orderListNo) {
		pjhMyCartMapper.deleteOrderListNo(orderListNo);
	}

	public String[] selectCartNoListByOrderListNo(int orderListNo) {
		String[] result = pjhMyCartMapper.selectCartNoListByOrderListNo(orderListNo);
		return result;
	}

	public void editCartInfoByCartNo(int catrNo) {
		pjhMyCartMapper.editCartInfoByCartNo(catrNo);
	}
	
}
