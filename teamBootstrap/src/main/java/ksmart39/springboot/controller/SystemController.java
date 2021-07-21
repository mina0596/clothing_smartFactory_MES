package ksmart39.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {


	// 시스템 첫화면
	@GetMapping("/system")
	public String system(Model model) {
		model.addAttribute("title", "시스템");
		return "system/system";
	}
}
	
	
	
