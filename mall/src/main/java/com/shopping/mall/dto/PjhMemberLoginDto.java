package com.shopping.mall.dto;

public class PjhMemberLoginDto {
	private String memberId;
	private String passwd;
	
	public String toString(){		
		return String.format("memberId : %s / passwd : %s", memberId, passwd);
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
