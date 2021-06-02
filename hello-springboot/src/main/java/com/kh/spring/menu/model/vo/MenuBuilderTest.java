package com.kh.spring.menu.model.vo;

public class MenuBuilderTest {
	
	public static void main(String[] args) {
		MenuBuilderTest mt = new MenuBuilderTest();
		mt.test1();
		
	}
	
	private void test1() {
		//new 연산자를 이용하는 방법
		//1. 기본생성자 + setter
		//2. 파라미터 생성자
		
		//3. Builder 패턴 .id.name 다 static 메소드 이다 => @Builder 어노테이션으로 자동 생성
		Menu m =
		Menu.builder()
				.id(1)
				.name("도토릭묵")
				.restaurant("다람쥐네")
				.price(8000)
				.build();
		//메뉴 객체가 된다
		System.out.println(m);
	}

}
