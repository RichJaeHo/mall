package com.shopping.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shopping.mall.dao.PjhMemberDao;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMemberLoginDto;
import com.shopping.mall.dto.PjhMemberRegisterFormDto;

@Repository(value="PjhMemberService")
public class PjhMemberService {

	@Autowired
	@Qualifier(value="PjhMemberDao")
	private PjhMemberDao pjhMemberDao;
	
	public boolean registMember(PjhMemberRegisterFormDto pjhMemberRegisterFormDto) {
		 pjhMemberDao.insertMemberInfo(pjhMemberRegisterFormDto);
		 pjhMemberDao.insertAddressIfno(pjhMemberRegisterFormDto);
		 pjhMemberDao.updateAddressInfo(pjhMemberRegisterFormDto);		 

		return true;
	}

	public PjhMemberDto findMemberInfoByMemberId(PjhMemberLoginDto pjhMemberLoginDto) {
		PjhMemberDto resultDto = pjhMemberDao.selectMemberInfoByMemberId(pjhMemberLoginDto);
		return resultDto;
	}

	public boolean editMemberInfoByMemberId(PjhMemberDto pjhMemberDto) {
		pjhMemberDao.updateMemberInfoByMemberId(pjhMemberDto);
		String result = pjhMemberDao.selectAddressNoByZipCodeAddress(pjhMemberDto);
		if(result != null) {
			//데이터가 있으면
			pjhMemberDto.setAddressListNo(Integer.parseInt(result));
			pjhMemberDao.updateAddressInfo(pjhMemberDto);
		} else {
			//데이터가 없으면 새로입력
			pjhMemberDao.insertAddressIfno(pjhMemberDto);
			pjhMemberDao.updateAddressInfo(pjhMemberDto);		
		}
		
		return true;
	}

	public void removeMemberByMemberIdPasswd(PjhMemberLoginDto pjhMemberLoginDto) {
		pjhMemberDao.updateMemberDeleteByMemberIdPasswd(pjhMemberLoginDto);
	}


	
	
}
