package com.shopping.mall.dto;

public class SampleDto {

	private String col1;
	
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String toString() {		
		return String.format("col1 = %s", col1);
	}
}
