package com.kh.spring.member.model.vo;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	
	@NotNull 
	//@RequiredArgsConstructor  -> NotNull사용가능
	private String id;
	
	private String password;
	private String name;
	private String gender;
	private Date birthday;
	//시분초 정보필요시 util 사용
	private String email;
	private String phone;
	private String address;
	private String[] hobby;
	private String enrollDate;
	private boolean enabled; // 회원활성화여부 ->DB에서 1(true, 기본값)과 0(fasle)으로 관리되고 있다.

}
