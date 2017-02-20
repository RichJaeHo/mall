package com.shopping.mall.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.shopping.mall.dto.PjhMemberInterface;

public class PjhEditMyInfoDto {

	public static PjhMemberInterface editMyInfoDto(PjhMemberInterface dto, String strBirth) {
		
		// 생년월일 날짜 형변환		
		try {
			if(strBirth == null || strBirth.isEmpty()) {
				dto.setBirth(new Date());
			} else {			

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
				dto.setBirth(format.parse(strBirth));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 주소번환
		String[] arrAddress1 = dto.getAddress1().split(" ");
		String address2 = dto.getAddress2();
		
		dto.setAddress1(arrAddress1[0]);
		dto.setAddress2(arrAddress1[1]);
		
		String comAddress = "";
		for(int i = 2; i < arrAddress1.length; i++) {
			comAddress += String.format("%s ", arrAddress1[i]);			
		}
		
		comAddress += String.format("%s ", address2);
				
		dto.setAddress3(comAddress.trim());
		
		return dto;
	}
	
}
