package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("title","teamoneERP");
		mav.setViewName("login");
		
		return "login/index";
	}
}
