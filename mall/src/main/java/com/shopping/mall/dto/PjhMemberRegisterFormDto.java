package com.shopping.mall.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class PjhMemberRegisterFormDto implements PjhMemberInterface {

	@NotEmpty(message="아이디를 입력하세요")
	private String memberId;
	
	private String userType;
	
	@NotEmpty(message="비밀번호를 입력하세요")
	private String passwd;
	
	@NotEmpty(message="이름을 입력하세요")
	private String name;
	
	private String gender;
		
	private Date birth;
	
	@Pattern(regexp="01[0-9]{1}[0-9]{3,4}[0-9]{4}", message="핸드폰 번호를 확인하세요")
	private String phone;
	
	@NotEmpty(message="이메일 주소를 입력하세요")
	@Email(message="유효하지 않은 이메일 형식입니다")
	private String email;
		
	private Date regdate;
	private String active;
	private String deleted;
		
	private String zipCode;
	private String address1;
	
	@NotEmpty(message="거주지 주소를 입력하세요")
	private String address2;
	private String address3;
	private int addressListNo;
	
	public String toString(){
		return String.format("memberId : %s / userType : %s / passwd : %s / name : %s / " + 
							 "gender : %s / birth : %s / phone : %s / email : %s / regdate : %s / " + 
				             "active : %s / deleted : %s / zipCode : %s / address1 : %s / address2 : %s / address3 : %s / addressListNo : %d", 
				             memberId, userType, passwd, name, gender, birth, phone, email, regdate, active, deleted, zipCode, address1, address2, address3, addressListNo);
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
