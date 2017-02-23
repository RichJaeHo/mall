package com.shopping.mall.dto;

import java.util.List;

public class PjhTransportReqDto {
	
	private String compare;
	private String product;
	private String gender;
	private String area;
	private String category1;
	private String period;
	private int quantity;
	private int age;
	
	
	private List<PjhTransportDataDto> data;
	
	
	public String toString(){
		return String.format("compare : %s / product : %s / gender : %s / area : %s / category1 : %s / period : %s / quantity : %s / age : %d", 
							compare, product, gender, area, category1, period, quantity, age);
	}

	public String getCompare() {
		return compare;
	}

	public void setCompare(String compare) {
		this.compare = compare;
	}

	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<PjhTransportDataDto> getData() {
		return data;
	}

	public void setData(List<PjhTransportDataDto> data) {
		this.data = data;
	}
	
	public String getCategoryNo1(){
		String category = "";
		int max = -1;
		for(PjhTransportDataDto dto : data) {
			if(!dto.getCategory1().equals("모든상품") && dto.getQuantity() > max) {
				category = dto.getCategory1();
			}
		}
		
		return category;
	}

	
}
