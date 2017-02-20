package com.shopping.mall.dto;

import java.util.Date;
import java.util.List;

public class PjhProductAdverDto {

	private int boardNo;	
	private String preCategory1;
	private String title;
	private String content;
	private int[] productNoList;
	private int preProductNo;
	private String name;
	private int preImageNo;
	private String fileName;
	private int price;
	private String memberId;
	private Date regdate;
	private String deleted;
	
	private List<PjhProductDto> arrPjhProductDto;
	
	public String toString(){
		return String.format("boardNo : %d / preCategory1 : %s / title : %s / Content : %s / preProductNo : %d / preImageNo : %d / fileName : %s / price : %d / memberId : %s / regdate : %s / deleted : %s", 
							boardNo, preCategory1, title, content, preProductNo, preImageNo, fileName, price, memberId, regdate, deleted);
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getPreCategory1() {
		return preCategory1;
	}

	public void setPreCategory1(String preCategory1) {
		this.preCategory1 = preCategory1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPreProductNo() {
		return preProductNo;
	}

	public void setPreProductNo(int preProductNo) {
		this.preProductNo = preProductNo;
	}

	public int getPreImageNo() {
		return preImageNo;
	}

	public void setPreImageNo(int preImageNo) {
		this.preImageNo = preImageNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int[] getProductNoList() {
		return productNoList;
	}

	public void setProductNoList(int[] productNoList) {
		this.productNoList = productNoList;
	}

	public List<PjhProductDto> getArrPjhProductDto() {
		return arrPjhProductDto;
	}

	public void setArrPjhProductDto(List<PjhProductDto> arrPjhProductDto) {
		this.arrPjhProductDto = arrPjhProductDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
