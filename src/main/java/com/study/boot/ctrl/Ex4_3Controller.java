package com.study.boot.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.boot.model.BoardDTO;
import com.study.boot.model.ContentDTO;
import com.study.boot.validator.BoardDTOValidator;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class Ex4_3Controller {

	//예제3 - @Valid를 이용한 서버사이드 검증
	//스프링에서는 hibernate-validate 모듈 필요
	//부트에서는 spring-boot-starter-validation 모듈 필요
	

	@GetMapping("/board")
	public String board() {
		return "valid/board";
	}
	
	@PostMapping("/regist")
	//@Valid로 BoardDTO에 대한 유효성 검증을 하겠다고 선언했으므로 dto에 값이 들어오면 즉시 유효성 검사가 실행된다.
	public String regist(@ModelAttribute("dto") @Valid ContentDTO dto, BindingResult result) {
		
		if(result.hasErrors()) {
			
			//Validator 구현 클래스에서 .rejectValue()로 등록한 에러코드를 받아올 수 있다.
			if(result.getFieldError("id") != null) {
				log.info("★★★★★ " + result.getFieldError("id").getDefaultMessage());
			}
			
			
			if(result.getFieldError("title") != null) {
				log.info("★★★★★ " + result.getFieldError("title").getDefaultMessage());
			}
			
			
			if(result.getFieldError("content") != null) {
				log.info("★★★★★ " + result.getFieldError("content").getDefaultMessage());
			}			
			
			return "valid/board";
		}
		
		return "valid/registOk";
	}
	
}














