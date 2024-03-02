package com.study.boot.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MyBoardDTO {
	private int seq;
	
	@NotBlank(message = "writer가 null, 빈문자열, 공백문자열 중 하나입니다.")
	private String writer;

	@NotBlank(message = "title이 null, 빈문자열, 공백문자열 중 하나입니다.")
	private String title;
		
	private String content;
	private LocalDate regdate;
}
