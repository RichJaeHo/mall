package com.shopping.mall.dto;

public class PjhTransportReqDto {
	
	private String compare;
	private String product;
	private int age;
	private String gender;
	private String area;
	
	
	public String toString(){
		return String.format("compare : %s / product : %s / age : %d / gender : %s / area : %s", 
				compare, product, age, gender, area);
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
}
