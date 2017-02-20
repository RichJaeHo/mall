package com.shopping.mall.dto;

public class PjhMyCartOrderTempDto {

	private String arrCartNo;
	private String recName;
	private String recPhone;
	private String recZipCode;
	private String recAddress1;
	private String recAddress2;
	
	public String toString(){
		return String.format("arrCartNo : %s / recName : %s / recphone : %s / recZipCode : %s / recAddress1 : %s / recAddress2 : %s", 
							arrCartNo, recName, recPhone, recZipCode, recAddress1, recAddress2);
	}

	public String getArrCartNo() {
		return arrCartNo;
	}

	public void setArrCartNo(String arrCartNo) {
		this.arrCartNo = arrCartNo;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public String getRecPhone() {
		return recPhone;
	}

	public void setRecPhone(String recPhone) {
		this.recPhone = recPhone;
	}

	public String getRecZipCode() {
		return recZipCode;
	}

	public void setRecZipCode(String recZipCode) {
		this.recZipCode = recZipCode;
	}

	public String getRecAddress1() {
		return recAddress1;
	}

	public void setRecAddress1(String recAddress1) {
		this.recAddress1 = recAddress1;
	}

	public String getRecAddress2() {
		return recAddress2;
	}

	public void setRecAddress2(String recAddress2) {
		this.recAddress2 = recAddress2;
	}
	
	
	
}
