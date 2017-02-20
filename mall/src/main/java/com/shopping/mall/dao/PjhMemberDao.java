package com.shopping.mall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMemberInterface;
import com.shopping.mall.dto.PjhMemberLoginDto;
import com.shopping.mall.dto.PjhMemberRegisterFormDto;
import com.shopping.mall.mapper.PjhMemberMapper;

@Repository(value="PjhMemberDao")
public class PjhMemberDao {

	@Autowired
	@Qualifier("PjhMemberMapper")
	private PjhMemberMapper pjhMemberMapper;
	
	//맴버생성
	public void insertMemberInfo(PjhMemberInterface pjhMemberInterface) {				
		pjhMemberMapper.insertMemberInfo(pjhMemberInterface);
	}

	//주소넣기
	public void insertAddressIfno(PjhMemberInterface pjhMemberInterface) {
		pjhMemberMapper.insertAddressIfno(pjhMemberInterface);		
	}

	//맴버정보에 주소업데이트
	public void updateAddressInfo(PjhMemberInterface pjhMemberInterface) {
		pjhMemberMapper.updateAddressInfo(pjhMemberInterface);		
	}

	//로그인
	public PjhMemberDto selectMemberInfoByMemberId(PjhMemberLoginDto pjhMemberLoginDto) {		
		PjhMemberDto resultDto = pjhMemberMapper.selectMemberInfoByMemberId(pjhMemberLoginDto);
		return resultDto;
	}

	//회원정보수정
	public void updateMemberInfoByMemberId(PjhMemberInterface pjhMemberInterface) {
		pjhMemberMapper.updateMemberInfoByMemberId(pjhMemberInterface);
	}

	//회원주소 검색
	public String selectAddressNoByZipCodeAddress(PjhMemberInterface pjhMemberInterface) {
		String result = pjhMemberMapper.selectAddressNoByZipCodeAddress(pjhMemberInterface);				
		return result;		
	}

	//회원탈퇴
	public void updateMemberDeleteByMemberIdPasswd(PjhMemberLoginDto pjhMemberLoginDto) {
		pjhMemberMapper.updateMemberDeleteByMemberIdPasswd(pjhMemberLoginDto);		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
