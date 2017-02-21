package com.shopping.mall.dto;

import java.util.Date;
import java.util.List;

public class PjhTransportTotDto {
		
	/*KEYVALUE*/
	private String memberId; //키값 맴버아이디
	private int orderListNo; //키값 주문번호
	private String paypalEmail;
	private String paypalPasswd;
	private String category1; //분석후 리턴 카테고리1
	private String category2; //분석후 리턴 카테고리2
	private String clientNo = "15";
	
	/*MEMBER*/	
	private String name;
	private String gender;
	private Date birth;
	private String phone;
	private String email;
	
	/*ADDRESSLIST*/
	private String zipCode;
	private String address1;
	private String address2;
	private String address3;
	
	/*PRODUCT*/
	private List<PjhTransportProDto> orderListInfo;

	
	public String toString() {
		return String.format("memberId : %s / orderListNo : %d / category1 : %s / category2 : %s / name : %s / gender : %s / birth : %s / phone : %s / email : %s / zipCode : %s / address1 : %s / address2 : %s / address3 : %s / paypalEail : %s / paypalPasswd : %s",
				memberId, orderListNo, category1, category2, name, gender, birth, phone, email, zipCode, address1, address2, address3, paypalEmail, paypalPasswd);
	}
	
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getOrderListNo() {
		return orderListNo;
	}

	public void setOrderListNo(int orderListNo) {
		this.orderListNo = orderListNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public List<PjhTransportProDto> getOrderListInfo() {
		return orderListInfo;
	}

	public void setOrderListInfo(List<PjhTransportProDto> orderListInfo) {
		this.orderListInfo = orderListInfo;
	}

	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}


	public String getPaypalEmail() {
		return paypalEmail;
	}


	public void setPaypalEmail(String paypalEmail) {
		this.paypalEmail = paypalEmail;
	}


	public String getPaypalPasswd() {
		return paypalPasswd;
	}


	public void setPaypalPasswd(String paypalPasswd) {
		this.paypalPasswd = paypalPasswd;
	}
	
	
	
}
