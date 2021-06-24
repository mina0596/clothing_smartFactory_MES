package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {
	//자주하는 질문
	@GetMapping("/qAndA")
	public String qAndA (Model model) {
		model.addAttribute("title","로비");
		return "community/qAndA";
	}
	//로비
	@GetMapping("/lobby")
	public String lobby(Model model) {
		model.addAttribute("title","로비");
		return "community/lobby";
	}
	//채팅룸
	@GetMapping("/chatroom")
	public String chatroom(Model model) {
		model.addAttribute("title","로비");
		return "community/chatroom";
	}
	
	//메신저
	@GetMapping("/messenger")
	public String messenger(Model model) {
		model.addAttribute("title","메신저");
		return "community/messenger";
	}
	//메인화면
	@GetMapping("/community")
	public String getContractmangement() {
		
		return "community/community";
	}


}
