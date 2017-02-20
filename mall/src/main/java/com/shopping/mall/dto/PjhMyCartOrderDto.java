package com.shopping.mall.dto;

import java.util.Date;

public class PjhMyCartOrderDto {

	private String memberId;
	private int cartNo;
	private int orderListNo;
	private int productNo;
	private String name;
	private int price;
	private int qty;
	private String reciever;
	private String phone;
	private int addressListNo;
	private String zipCode;
	private String address1;
	private String address2;
	private String address3;
	private String status;
	private Date orderDate;
	
	public String toString(){
		return String.format("memberId : %s / cartNo : %d / orderListNo : %d / price : %d / reciever : %s / phone : %s / " + 
							 "addressListNo : %d / zipCode : %s/ address1 : %s/ address2 : %s / address3 : %s / " + 
							 "productNo : %d / name : %s / qty : %d / status : %s / orderDate : %s", 
				memberId, cartNo, orderListNo, price, reciever, phone, addressListNo, zipCode, address1, address2, address3,
				productNo, name, qty, status, orderDate);
	}	
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getOrderListNo() {
		return orderListNo;
	}

	public void setOrderListNo(int orderListNo) {
		this.orderListNo = orderListNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAddressListNo() {
		return addressListNo;
	}

	public void setAddressListNo(int addressListNo) {
		this.addressListNo = addressListNo;
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

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}
