package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model
						,@RequestParam(name = "loginResult", required = false) String loginResult) {
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("title","teamoneERP");
		mav.setViewName("login");
		if(loginResult != null) model.addAttribute("loginResult", loginResult);
		
		return "login/index";
	}
	
	@GetMapping("/mesmain")
	public String mesmain(Model model) {
		return "/mesmain";
	}
}
