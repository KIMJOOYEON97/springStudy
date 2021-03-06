package com.kh.spring.tv.model.vo;

public class SamsungTv implements Tv {
	
	private RemoteControl remocon;
	
	/**
	 * property setter
	 * @param remocon
	 */
	public void setRemocon(RemoteControl remocon) {
		this.remocon = remocon;
	}
	
	/**
	 * constructor inint
	 * @param remocon
	 */
	public SamsungTv(RemoteControl remocon) {
		System.out.println("SamsungTv 객체생성 : " +remocon);
		this.remocon = remocon;
	}
	
	
	public SamsungTv() {
		System.out.println("SamsungTv 객체를 생성했습니다.");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTv의 전원을 켰습니다.");
	}

	public void changeChannel(int no) {
		this.remocon.changeChannel(no);
	}

}
