package com.shopping.mall.dto;

import java.util.Date;

public class PjhMemberDto implements PjhMemberInterface {

	private String cookie;
	private String memberId;
	private String userType;
	private String passwd;
	private String name;
	private String gender;
	private Date birth;
	private String phone;
	private String email;
	private Date regdate;
	private String active;
	private String deleted;
	private String zipCode;
	private String address1;
	private String address2;
	private String address3;
	private int addressListNo;
	
	public String toString(){
		return String.format("memberId : %s / userType : %s / passwd : %s / name : %s / " + 
							 "gender : %s / birth : %s / phone : %s / email : %s / regdate : %s / " + 
				             "active : %s / deleted : %s / zipCode : %s / address1 : %s / address2 : %s / address3 : %s / addressListNo : %d", 
				             memberId, userType, passwd, name, gender, birth, phone, email, regdate, active, deleted, zipCode, address1, address2, address3, addressListNo);
	}

	
	
	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public int getAddressListNo() {
		return addressListNo;
	}

	public void setAddressListNo(int addressListNo) {
		this.addressListNo = addressListNo;
	}

}
