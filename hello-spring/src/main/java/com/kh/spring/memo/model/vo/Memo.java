package com.kh.spring.memo.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@NoArgsConstructor //기본생성자
@AllArgsConstructor // 모든 파라미터 생성자
public class Memo {

	private int no;
	private String memo;
	private Date regDate; //util로.
	
}
