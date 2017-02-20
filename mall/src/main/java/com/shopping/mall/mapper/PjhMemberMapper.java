package com.shopping.mall.mapper;

import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMemberInterface;
import com.shopping.mall.dto.PjhMemberLoginDto;
import com.shopping.mall.dto.PjhMemberRegisterFormDto;

public interface PjhMemberMapper {
	
	//맴버생성
	public void insertMemberInfo(PjhMemberInterface pjhMemberInterface);
	
	//주소넣기
	public void insertAddressIfno(PjhMemberInterface pjhMemberInterface);
	
	//맴버정보에 주소업데이트
	public void updateAddressInfo(PjhMemberInterface pjhMemberInterface);
		
	//로그인
	public PjhMemberDto selectMemberInfoByMemberId(PjhMemberLoginDto pjhMemberLoginDto);
	
	//회원정보수정
	public void updateMemberInfoByMemberId(PjhMemberInterface pjhMemberInterface);
	
	//회원주소 검색
	public String selectAddressNoByZipCodeAddress(PjhMemberInterface pjhMemberInterface);
	
	//회원탈퇴
	public void updateMemberDeleteByMemberIdPasswd(PjhMemberLoginDto pjhMemberLoginDto);
}
