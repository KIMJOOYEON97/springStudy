package com.kh.spring.common.aop.test;

public class FooImpl implements Foo {

	@Override
	public void sayHello() {
		System.out.println("say fooooooooooooooooooooooooooo!");
	}

	@Override
	public String getName() {
		
		return "fooooooo";
	}

}
