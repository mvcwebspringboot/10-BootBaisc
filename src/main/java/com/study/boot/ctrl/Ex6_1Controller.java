package com.study.boot.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.boot.srv.BuyTicketService;

//@Controller
public class Ex6_1Controller {
	
	@Autowired
	@Qualifier("buyTicketServiceImpl")
	BuyTicketService buySrv;

	@GetMapping("/buyTicket")
	public String buyTicket() {
		return "transaction/buyTicket";
	}
	
	@PostMapping("/buyTicketCard")
	public String buyTicketCard(
			@RequestParam("customerid") String id,
			@RequestParam("amount") int amount, //String으로 받을 경우 @RequestParam 필요 없음
			String error,
			Model model) {
		
		
		model.addAttribute("customerid",id);
		model.addAttribute("amount", amount);
		
		int result = buySrv.buy(id, amount, error);
		
		if(result==1) {
			return "transaction/buyTicketOk";
		}else {
			return "transaction/buyTicketError";
		}
		
		
	}
}
