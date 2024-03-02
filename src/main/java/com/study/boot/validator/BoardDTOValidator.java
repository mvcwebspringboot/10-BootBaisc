package com.study.boot.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.study.boot.model.BoardDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardDTOValidator implements Validator{

	@Override
	//Validator로 검증할 수 있는 타입인지 검사하는 메소드 
	public boolean supports(Class<?> clazz) {
		return BoardDTO.class.isAssignableFrom(clazz);
	}

	@Override
	//전달받은 객체를 검증하고, 오류결과를 Errors에 담는 메소드
	public void validate(Object target, Errors errors) {
		BoardDTO dto = (BoardDTO) target;
		
		//rejectValue() 메소드로 에러를 등록하면
		//컨트롤러에서 .hasErrors() 호출시 true를 리턴한다.
		
		//유효성 검증을 할 때 값이 null인지 공백인지를 검사하는 부분은 필수사항이다.
		if(dto.getId()==null || dto.getId().isEmpty()) {
			//log.info("id 값이 null 또는 빈문자열입니다.");
			errors.rejectValue("id", "ErrorCode : id 값이 없습니다.");//컨트롤러에서 .getCode()로 값을 전달받을 수 있다.
		}
		
		String title = dto.getTitle();
		if(title==null || title.isBlank()) {
			//log.info("title 값이 null 또는 빈문자열, 공백으로만 이루어진 문자열입니다.");
			errors.rejectValue("title", "ErrorCode : title 값이 없습니다.");//에러등록
		}		
		
		//데이터를 검증하고 에러가 있을때 에러처리 까지 한번에 할 수 있다.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "ErrorCode : content 값이 null 또는 빈문자열, 공백으로만 이루어진 문자열입니다.");
				
		String content = dto.getContent();
		if(content.length()<5) {
			//log.info("내용은 5글자 이상이어야 합니다.");
			errors.rejectValue("content", "글 내용의 길이가 너무 짧습니다.");//에러등록
		}
		
	}//validate()

}
