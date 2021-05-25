package com.kh.spring.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
	
	private int no;
	private int boardNo;
	private String originalFilename;
	private String renamedFilename;
	private int downloadCount;
	private boolean status;			//status ----- 'Y','N' ->커스텀 타입핸들러 필요
	
}
