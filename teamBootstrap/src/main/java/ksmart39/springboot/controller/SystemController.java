package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

	//전체사용자관리
	@GetMapping("/userManagement")
	public String userManagement(Model model) {
		model.addAttribute("title","시스템");
		return "system/userManagement";
	}
	//시스템 첫화면
	@GetMapping("/system")
	public String system(Model model) {
		model.addAttribute("title","시스템");
		return "system/system";
	}
	


}
