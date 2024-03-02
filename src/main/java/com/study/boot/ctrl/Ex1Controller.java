package com.study.boot.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex1Controller {

	//요청매핑을 통해서 특정 url 경로를 요청하면 jsp 파일이 호출되도록 설정한다.
	//만약 요청경로를 "/"로 할경우 정적설정인 index.html 보다 우선한다. 
	@RequestMapping(path="/index", method=RequestMethod.GET)
	public String root() {
		//리턴하는 이름에 설정된 prefix, suffix를 붙여서 해당 파일을 찾아 실행하고 그 결과를 리턴한다.
		return "index";
	}
	
	@GetMapping("/dongdo")
	public String dongdo() {
		return "sub/dongdo";
	}
	
	@GetMapping("/dokdo")
	@ResponseBody //비동기 요청에 대한 결과값을 클라이언트에 전달할때 사용한다.
	public String dokdo() {
		return "<h1>독도는 우리땅~!</h1>";//태그 적용됨
	}
	
}
