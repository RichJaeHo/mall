package com.shopping.mall.dto;

import java.util.Date;

public class PjhNoticeDto {

	private int noticeNo;
	private String title;
	private String content;
	private String memberId;
	private Date regdate;
	private String deleted;
	
	public String toString(){
		return String.format("noticeNo : %d / title : %s / content : %s / memberId : %s / regdate : %s / deleted : %s", 
							noticeNo, title, content, memberId, regdate, deleted);
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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
	
}
