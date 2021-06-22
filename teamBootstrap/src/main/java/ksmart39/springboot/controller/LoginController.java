package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	//사원등록
	@GetMapping("/logout")
	public String humanResourcesEnroll(Model model) {
		 model.addAttribute("title", "인사관리-사원등록");
		return"humanResources/humanResourcesEnroll";	
	}
	
	@PostMapping("/login")
	public String login1() {
		return "/main";
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "/main";
	}

}
