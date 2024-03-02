package com.study.boot.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.boot.model.InfoDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Ex3Controller {

	//예제1
	@GetMapping("/login")
	public String login() {
		return "form/login";
	}
	
	@PostMapping("/loginOk")
	public String loginOk(HttpServletRequest req, Model model) {
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		model.addAttribute("userid",userid);
		model.addAttribute("userpw",userpw);
		
		return "form/loginOk";
	}

	//예제2
	@GetMapping("/join")
	public String join() {
		return "form/join";
	}	
	
	@PostMapping("/joinOk")
	//파라미터가 많아지면 약간 불편함
	public String joinOk(@RequestParam("userid") String id, @RequestParam("userpw") String pw, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "form/joinOk";
	}	
	
	
	//예제3
	@GetMapping("/info")
	public String info() {
		return "form/info";
	}
	
	@PostMapping("/infoOk")
	//커맨드객체를 이용하면 쉽고 간편하게 많은 데이터를 받아서 처리할 수 있다.
	//이경우 Model과 별도로 객체 자체를 클래스명의 첫글자를 소문자로 바꾼 이름(infoDTO)으로 View에 전달할 수 있다.
	public String infoOk(InfoDTO info) {
		System.out.println(info.toString());
		return "form/infoOk";
	}
	
	
	//예제4
	@GetMapping("/my")
	public String check() {
		return "form/my";
	}
	
	@GetMapping("/mypage/{userid}/{username}")
	//패스 자체에 변수를 넣어줄 수 있다.
	public ModelAndView mypage(@PathVariable String userid, @PathVariable String username) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("id", userid);
		mv.addObject("name", username);
		
		mv.setViewName("form/mypage");
		
		return mv;
	}
	
}

























