package com.study.boot.model;

import lombok.Data;

//빌더패턴을 통해 인스턴스를 만들려면 기본 초기값을 인식시키기 위해서 반드시 @Builder.Default가 필요하다.

@Data
public class BoardDTO {
	private String id;
	private String title;
	private String content;
}
