package com.kh.spring.tv.model.vo;

public class SamsungRemoteControl implements RemoteControl {

	@Override
	public void changeChannel(int no) {
		System.out.println("Samsung! 채널을 "+no+"번으로 변경합니다.");
	}

}
