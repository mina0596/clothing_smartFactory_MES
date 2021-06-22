package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HumanResourcesController {
	
	//사원등록
	@GetMapping("/humanResourcesEnroll")
	public String humanResourcesEnroll(Model model) {
		 model.addAttribute("title", "인사관리-사원등록");
		return"humanResources/humanResourcesEnroll";	
	}

	@GetMapping("/humanResourcesLookup")
	public String humanResourcesLookup(Model model) {
		model.addAttribute("title", "인사관리-사원조회");
		return "humanResources/humanResourcesLookup";
	}
	
	@GetMapping("/humanResources")
	public String humanResources(Model model) {
		model.addAttribute("title", "인사관리-사원조회");
		return "humanResources/humanResources";
	}
	

}
