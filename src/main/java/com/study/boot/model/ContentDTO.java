package com.study.boot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

//빌더패턴을 통해 인스턴스를 만들려면 기본 초기값을 인식시키기 위해서 반드시 @Builder.Default가 필요하다.

@Data
public class ContentDTO {
	
	@NotEmpty(message = "id값이 null or 빈문자열")
	private String id;
	
	@NotBlank(message = "title값이 null or 빈문자열 or 공백문자")
	private String title;
	
	@NotBlank(message = "content값이 null or 빈문자열 or 공백문자")
	@Size(min=5, message = "content는 최소 5글자 이상이어야 합니다.") //문자열에는 @Size, 숫자는 @Max(),@Min()
	private String content;
}
