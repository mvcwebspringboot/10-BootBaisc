package com.study.boot.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.boot.model.BoardDTO;
import com.study.boot.validator.BoardDTOValidator;

import lombok.extern.log4j.Log4j2;

@Log4j2
//@Controller
public class Ex4_1Controller {

	//예제1 - Validator, ValidationUtils
	@GetMapping("/board")
	public String board() {
		return "valid/board";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute("dto") BoardDTO dto, BindingResult result) {
		
		BoardDTOValidator validator = new BoardDTOValidator();
		validator.validate(dto, result);
		
		if(result.hasErrors()) {
			
			//Validator 구현 클래스에서 .rejectValue()로 등록한 에러코드를 받아올 수 있다.
			if(result.getFieldError("id") != null) {
				log.info("★★★★★ " + result.getFieldError("id").getCode());
			}
			
			
			if(result.getFieldError("title") != null) {
				log.info("★★★★★ " + result.getFieldError("title").getCode());
			}
			
			
			if(result.getFieldError("content") != null) {
				log.info("★★★★★ " + result.getFieldError("content").getCode());
			}			
			
			return "valid/board";
		}
		
		return "valid/registOk";
	}//regist()

}
