package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {
	//자주하는 질문
	@GetMapping("/qAndA")
	public String qAndA (Model model) {
		model.addAttribute("title","로비");
		return "system/qAndA";
	}
	//로비
	@GetMapping("/lobby")
	public String lobby(Model model) {
		model.addAttribute("title","로비");
		return "system/lobby";
	}
	
	//메신저
	@GetMapping("/messenger")
	public String messenger(Model model) {
		model.addAttribute("title","메신저");
		return "system/messenger";
	}
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
	
	//이메일주소 누르면 이메일 보내는 화면
	@GetMapping("/sendEmail")
	public String sendEmail(Model model) {
		
		return "system/sendEmail";
	}

}
