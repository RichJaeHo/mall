package com.shopping.mall.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dao.PjhMyCartDao;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.dto.PjhMyCartOrderDto;
import com.shopping.mall.dto.PjhTransportProDto;
import com.shopping.mall.dto.PjhTransportTotDto;

@Repository(value="PjhMyCartService")
public class PjhMyCartService {

	@Autowired
	@Qualifier(value="PjhMyCartDao")
	private PjhMyCartDao pjhMyCartDao;
	
	public void saveMyCartInfoByMemberId(List<PjhMyCartDto> arrPjhMyCartDto) {		
		for(PjhMyCartDto pjhMyCartDto : arrPjhMyCartDto){
			pjhMyCartDao.insertMyCartInfoByMemberId(pjhMyCartDto);
		}
	}

	public List<PjhMyCartDto> findMyCartList(String memberId) {
		List<PjhMyCartDto> arrResult = pjhMyCartDao.selectMyCartList(memberId);
		
		for(PjhMyCartDto result : arrResult) {
			result.setFileName(pjhMyCartDao.selectMyCartImage(result.getProductNo()));
		}
		
		return arrResult;
	}

	public void removeMyCartByCartNo(PjhMyCartDto pjhMyCartDto) {
		pjhMyCartDao.deleteMyCartByCartNo(pjhMyCartDto);
	}

	public void removeMyCartListByCartNo(List<PjhMyCartDto> arrPjhMyCartDto) {
		for(PjhMyCartDto pjhMyCartDto : arrPjhMyCartDto) {
			pjhMyCartDao.deleteMyCartByCartNo(pjhMyCartDto);
		}
	}

	public void editMyCartByCartNo(PjhMyCartDto pjhMyCartDto) {
		pjhMyCartDao.updateMyCartByCartNo(pjhMyCartDto);		
	}

	public List<PjhMyCartDto> findMyCartListForOrder(int[] arrCartNo) {

		ArrayList<PjhMyCartDto> arrResult = new ArrayList<PjhMyCartDto>();
		for(int cartNo : arrCartNo) {
			PjhMyCartDto result = pjhMyCartDao.selectMyCartByCartNo(cartNo);
			result.setFileName(pjhMyCartDao.selectMyCartImage(result.getProductNo()));
			
			arrResult.add(result);
		}
		
		return arrResult;
	}

	public int saveMyCartOrderInfo(PjhMyCartOrderDto[] arrPjhMyCartOrderDto) {
				
		//OrderListNo 가져오기
		String result = pjhMyCartDao.selectMaxOrderListNo();
		if(result == null) result = "0";
		
		for(int i = 0; i < arrPjhMyCartOrderDto.length; i++) {
			
			//ordrlistno 세팅
			arrPjhMyCartOrderDto[i].setOrderListNo(Integer.parseInt(result) + 1);
			
			//가격조회
			PjhMyCartDto result1 = pjhMyCartDao.selectMyCartByCartNo(arrPjhMyCartOrderDto[i].getCartNo());
			
			System.out.println("데이터디넝리넝ㄹ : " + result1.toString());
			
			arrPjhMyCartOrderDto[i].setPrice(result1.getPrice());

			//주소조회			
			String result2 = pjhMyCartDao.selectAddressNoByZipCodeArress(arrPjhMyCartOrderDto[i]);
			if(result2 != null){
				//주소가 있으면
				arrPjhMyCartOrderDto[i].setAddressListNo(Integer.parseInt(result2));				
			} else {
				//주소가 없으면
				pjhMyCartDao.insertAddressInfo(arrPjhMyCartOrderDto[i]);			
			}
			
			//주문정보 입력
			pjhMyCartDao.insertCartOrderInfo(arrPjhMyCartOrderDto[i]);
			
			//카트업데이트
			pjhMyCartDao.updateOrderedCartInfo(arrPjhMyCartOrderDto[i]);
		}
		
		return Integer.parseInt(result) + 1;
	}

	public List<PjhMyCartOrderDto> findOrderedListByMemberId(String memberId) {
		List<PjhMyCartOrderDto> arrResult = pjhMyCartDao.selectOrderedListByMemberId(memberId);
		return arrResult;
	}

	public PjhTransportTotDto findOrderInfoForPayPal(PjhTransportTotDto pjhTransportTotDto) {
		
		//맴버정보
		PjhTransportTotDto result = pjhMyCartDao.selectMemberInfoForPayPal(pjhTransportTotDto);
		
		//구매정보
		List<PjhTransportProDto> arrResult = pjhMyCartDao.selectOrderInfoForPayPal(pjhTransportTotDto);
		
		result.setOrderListInfo(arrResult);
		result.setOrderListNo(pjhTransportTotDto.getOrderListNo());
		
		return result;
	}

	public void cancelOrdeListNo(int orderListNo) {
		String[]arrCartNo = pjhMyCartDao.selectCartNoListByOrderListNo(orderListNo);
		
		for(String catrNo : arrCartNo) {
			pjhMyCartDao.editCartInfoByCartNo(Integer.parseInt(catrNo));
		}
		
		pjhMyCartDao.deleteOrderListNo(orderListNo);
	}	
	
}
