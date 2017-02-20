package com.shopping.mall.dto;

public class PjhTransportProDto {
	
	/*PRODUCT*/
	private String category1;
	private String category2;
	private String productName;
	private int price;
	private int qty;
	
	
	public String toString() {
		return String.format("category1 : %s / category2 : %s / productName : %s / price : %d / qty : %d", 
								category1, category2, productName, price, qty);
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	
}
