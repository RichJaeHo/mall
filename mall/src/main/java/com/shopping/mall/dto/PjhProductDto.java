package com.shopping.mall.dto;

import java.util.Date;
import java.util.List;

public class PjhProductDto {

	private int count;
	private String repCategory;
	private int productNo;
	private String memberId;
	private String category1;
	private String category2;
	private String name;
	private int price;
	private int qty;
	private Date regdate;
	private String active;
	private String deleted;
	
	private List<PjhImageDto> arrPjhImageDto;
	
	public String toString() {
		return String.format("productNo : %d / memberId : %s / category1 : %s / category2 : %s / name : %s / price : %d / qty : %d/ regdate : %s / active : %s / deleted : %s ", 
								productNo, memberId, category1, category2, name, price, qty, regdate, active, deleted);
	}	
	
	public String getRepCategory() {
		return repCategory;
	}
	public void setRepCategory(String repCategory) {
		this.repCategory = repCategory;
	}
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

	public List<PjhImageDto> getArrPjhImageDto() {
		return arrPjhImageDto;
	}

	public void setArrPjhImageDto(List<PjhImageDto> arrPjhImageDto) {
		this.arrPjhImageDto = arrPjhImageDto;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
