package com.shopping.mall.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PdaProductDto implements Serializable {

	private int productNo;
	private String memberId;
	private String category1;
	private String category2;
	private String name;
	private int price;
	private int qty;
	private Date regDate;
	private String active;
	private String deleted;

	private List<PdaProductImageDto> arrPdaProductImageDto;
	

	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	public List<PdaProductImageDto> getArrPdaProductImageDto() {
		return arrPdaProductImageDto;
	}
	public void setArrPdaProductImageDto(List<PdaProductImageDto> arrPdaProductImageDto) {
		this.arrPdaProductImageDto = arrPdaProductImageDto;
	}
}
