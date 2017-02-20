package com.shopping.mall.dto;

public class PjhImageDto {

	private int imageNo;
	private int productNo;
	private String oriName;
	private String fileName;
	
	public String toString() {
		return String.format("imageNo : %d / productNo : %d / oriName : %s / fileName : %s", 
								imageNo, productNo, oriName, fileName);
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getOriName() {
		return oriName;
	}

	public void setOriName(String oriName) {
		this.oriName = oriName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
