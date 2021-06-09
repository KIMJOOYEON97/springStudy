package com.kh.spring.member.model.vo;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member implements UserDetails{

	private String id;			//username
	private String password;	//password
	private String name;
	private String gender;
	private Date birthday;
	private String email;
	private String phone;
	private String address;
	private String[] hobby;
	private Date enrollDate;
	
	//복수개의 권한을 관리
	//문자열data("ROLE_USER", "ROLE_ADMIN")를 처리할 수 있는 GrantedAuthority의 하위클래스
	private List<SimpleGrantedAuthority> authorities; //authorities
	
	private boolean enabled; //활성화 여부
	
	/**
	 * Collection - List/Set
	 * 
	 * Collection<? extends GrantedAuthority> 
	 * 	- <GrantedAuthority를 싱속하는 ?> -> GrantedAuthority의 자식타입을 오케이 (상한선)
	 *  - <? super Integer> -> Integer 부모타입 (하한선) -> Integer보다 밑의 타입은 없다
	 * Collection<GrantedAuthority>
	 * 
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getUsername() {
		return id;
	}
	@Override //유효기간이 만료되지는 않았니?
	public boolean isAccountNonExpired() {
		return true; //사용가능
	} 
	@Override //잠기진 않았니?
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override //비밀번호 유효기간 만료되지 않았니?
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
}
