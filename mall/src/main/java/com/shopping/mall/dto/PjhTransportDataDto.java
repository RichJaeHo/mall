package com.shopping.mall.dto;

public class PjhTransportDataDto {

	private int quantity;
	private String gender;
	private int age;
	private String address;
	private String category1;
	
	
	public String toString(){
		return String.format("quantity : %d / gender : %s / age : %d / address : %s / category1 : %s", 
				quantity, gender, age, address, category1);
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCategory1() {
		return category1;
	}


	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	
	
	
	
	
	
}
