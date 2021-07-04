package com.kh.jdk8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Optional
 * - 존재할 수도 있고, 안할수도 있는 객체를 감싸고 있는 wrapper객체
 * - 변수명에 maybeMember, optUser와 같이 Optional타입을 암묵적으로 제시한다.
 * 
 * 1. Optional.empty() : 비어있는 Optional 객체
 * 2. Optional.of(obj) : 결코 null이 아닌 객체를 담은 Optional객체
 * 3. Optional.ofNullable(obj) : null일수도 있는 Optional객체
 * 
 * - get()
 * - orElse(T)
 * - orElseGet(Supplier)
 * - orElseThrow(Supplier)
 * - isPresent:boolean
 * - ifPersent:(Consumer)
 * 
 * 
 * 
 * if(s != null)
 * 		s.foo()
 * 
 *
 */
public class OptionalStudy {

	public static void main(String[] args) {
		OptionalStudy study = new OptionalStudy();
//		study.test1();
		study.test2();
	}
	
	
	public void test2() {
		getEmailOfMemberFromOrder(null);
		getEmailOfMemberFromOrder(new Order());
		
		Member member = new Member();
		member.setEmail("honggd@naver.com");
		Order order = new Order();
		order.setMember(member);
		System.out.println(getEmailOfMemberFromOrder(order));
		
		System.out.println(getEmailOfMemberFromOrder(null));
		System.out.println(getEmailOfMemberFromOrder(new Order()));
		
	}
	
	public String getEmailOfMemberFromOrder(Order order) {
		return Optional.ofNullable(order)
					   .map(Order::getMember)
					   .map(Member::getEmail)
					   .orElse("메일이 존재하지 않습니다.");
		
//		return Optional.ofNullable(order)
//				.map(o -> o.getMember())
//				.map(member -> member.getEmail())
//				.orElse("메일이 존재하지 않습니다.");
		
//		if(order != null) {
//			Member member = order.getMember();
//			if(member != null) {
//				String email = member.getEmail();
//				return email;
//			}
//		}
//		return "메일이 존재하지 않습니다.";
//		return order.getMember().getEmail();
	}
	
	@Data
	@NoArgsConstructor
	static class Order{
		Member member;
		int count;
	}
	@Data
	@NoArgsConstructor
	static class Member{
		String id;
		String email;
	}


	public void test1() {
		List<String> list = Arrays.asList("홍길동","신사",null,"");
		list.stream()
			.forEach(s -> System.out.println(s+":"+getStringLength(s)));
	}

	private int getStringLength(String str) {
		/*
		 * if(s != null) return s.length(); else return 0;
		 */
		Optional<String> maybeStr = Optional.ofNullable(str);
		return maybeStr
					.map(s -> s.length())
//					.orElse(0);
					.orElseThrow(() ->new RuntimeException(str));
	}
	
}
