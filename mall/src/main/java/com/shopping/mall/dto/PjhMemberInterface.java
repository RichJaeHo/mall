package com.shopping.mall.dto;

import java.util.Date;

public interface PjhMemberInterface {

	public String toString();
	public String getMemberId();
	public void setMemberId(String memberId);
	public String getUserType();
	public void setUserType(String userType);
	public String getPasswd();
	public void setPasswd(String passwd);
	public String getName();
	public void setName(String name);
	public String getGender();
	public void setGender(String gender);
	public Date getBirth();
	public void setBirth(Date birth);
	public String getPhone();
	public void setPhone(String phone);
	public String getEmail();
	public void setEmail(String email);
	public Date getRegdate();
	public void setRegdate(Date regdate);
	public String getActive();
	public void setActive(String active);
	public String getDeleted();
	public void setDeleted(String deleted);
	public String getZipCode();
	public void setZipCode(String zipCode);
	public String getAddress1();
	public void setAddress1(String address1);
	public String getAddress2();
	public void setAddress2(String address2);
	public String getAddress3();
	public void setAddress3(String address3);
	public int getAddressListNo();
	public void setAddressListNo(int addressListNo);
	
}
