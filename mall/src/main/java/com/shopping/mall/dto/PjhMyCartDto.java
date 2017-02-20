package com.shopping.mall.dto;

public class PjhMyCartDto {

	private int cartNo;
	private String memberId;
	private int productNo;
	private String fileName;
	private String name;
	private int price;
	private int qty;
	private String ordered;
	private String deleted;
    private boolean checked;

    public String toString(){
        return String.format("cartNo : %d / memberId : %s / productNo : %d / fileName : %s / name : %s / price : %d / qty : %d / ordered : %s / deleted : %s / checked : %b",
                cartNo, memberId, productNo, fileName, name, price, qty, ordered, deleted, checked);
    }

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getOrdered() {
		return ordered;
	}

	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
