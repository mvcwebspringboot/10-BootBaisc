package com.study.boot.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex2Controller {

	@GetMapping("/about")
	//Model 객체를 이용해서 데이터를 바인딩해서 뷰(JSP)에 전달할 수 있다.
	public String island(Model model) {
		model.addAttribute("main", "동도와 서도");
		model.addAttribute("num", "91");
		return "sub/about";
	}
	
	@GetMapping("/what")
	public ModelAndView what() {
		//ModelAndView 객체를 이용해서 데이터와 뷰경로를 바인딩해서 뷰(JSP)로 전달할 수 있다.
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<String>();
		list.add("1. 독도는 동도와 서도로 이루어져 있습니다.");
		list.add("2. 독도에 사는 해양생물은 흑돔, 홍게, 거북손등의 무척추동물이 있습니다.");
		list.add("3. 독도강치는 독도를 수호하던 바다사자 입니다.");
		
		mv.addObject("list", list);
		mv.setViewName("sub/what");
		
		return mv;
	}
}
