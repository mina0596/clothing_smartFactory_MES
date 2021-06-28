package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HumanResourcesController {
	
	//[한빛]사원등록-> 사원목록
	@PostMapping("/addHumanResources")
	public String addHumanResources() {
		return "redirect:/humanResourcesList";
	}
	
	//[한빛]사원등록
	@GetMapping("/addHumanResources")
	public String humanResourcesEnroll(Model model) {
		 model.addAttribute("title", "인사관리");
		return"humanResources/addHumanResources";	
	}

	//[한빛]사원수정
	@GetMapping("/modifyHumanResources")
	public String modifyHumanResources() {
		return "humanResources/modifyHumanResources";
	}
	
	//[한빛]사원목록
	@GetMapping("/humanResourcesList")
	public String humanResourcesList(Model model) {
		model.addAttribute("title", "인사관리");
		return "humanResources/humanResourcesList";
	}
	
	//[한빛]인사관리 메인
	@GetMapping("/humanResources")
	public String humanResources(Model model) {
		model.addAttribute("title", "인사관리");
		return "humanResources/humanResources";
	}
	

}
