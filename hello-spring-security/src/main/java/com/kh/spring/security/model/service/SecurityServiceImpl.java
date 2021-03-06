package com.kh.spring.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.spring.security.model.dao.SecurityDao;

import lombok.extern.slf4j.Slf4j;

//id 직겁 명시
@Service("securityService")
@Slf4j
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private SecurityDao securityDao;
	
	//security를 authentication-manager에서 얘를 호출해서 사용할 것임
	//비밀번호 맞니 안맞니는 authentication-manager에서 해줄 것이다.
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		// id로 DB에 조회 -> member객체 리턴 member가 UerDetails의 자식 클래스<다형성>
		UserDetails member = securityDao.loadUserByUsername(id);
		log.debug("member={}",member);
		if(member == null)
			throw new UsernameNotFoundException(id);
		return member;
	}

}
