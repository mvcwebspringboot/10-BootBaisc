package com.study.boot.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.boot.model.BoardDTO;
import com.study.boot.validator.BoardDTOValidator;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
//@Controller
public class Ex4_2Controller {

	//예제2 - 예제1의 강한 결합을 약한 결합으로 변환
	
	@InitBinder
//프로젝트가 시작할 때 WebDataBinder에 유효성 검사할 DTO를 등록
//binder에 설정한 객체에 에러가 있으면 컨트롤러의 result 변수에 담아둔다.
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardDTOValidator());
	}
	
	@GetMapping("/board")
	public String board() {
		return "valid/board";
	}
	
	@PostMapping("/regist")
	//@Valid로 BoardDTO에 대한 유효성 검증을 하겠다고 선언했으므로 dto에 값이 들어오면 즉시 유효성 검사가 실행된다.
	public String regist(@ModelAttribute("dto") @Valid BoardDTO dto, BindingResult result) {
		
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
	}
	
}














