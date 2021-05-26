package com.kh.spring.board.model.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class BoardExt extends Board {
	
	private boolean hasAttachment;
	
	private List<Attachment> attachList;
	
	
//	public BoardExt( //없어도 그만이다 왜냐하면 기본생성자랑 setter이용
//			int no, String title, String memberId, 
//			String content, Date regDate, int readCount,
//			boolean hasAttachment) {
//		super(no, title, memberId, content, regDate, readCount);
//		this.hasAttachment = hasAttachment;
//	}
	
	
	
}
