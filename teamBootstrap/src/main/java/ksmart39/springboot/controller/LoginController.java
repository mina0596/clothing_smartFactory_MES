package ksmart39.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jdk.internal.org.jline.utils.Log;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.service.LoginService;

@Controller
public class LoginController {
	
	private final LoginService loginService;
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	//사원등록
	@GetMapping("/logout")
	public String humanResourcesEnroll(Model model) {
		 model.addAttribute("title", "인사관리-사원등록");
		return"humanResources/humanResourcesEnroll";	
	}
	
	@PostMapping("/login")
	public String login1(@RequestParam(name = "adminId", required = false)String adminId
						,@RequestParam(name = "adminPw", required = false)String adminPw
						,@RequestParam(name = "headquarterId", required = false)String headquarterId
						,@RequestParam(name = "headquarterPw", required = false)String headquarterPw
						,@RequestParam(name = "factoryId", required = false)String factoryId
						,@RequestParam(name = "factoryPw", required = false)String factoryPw
						,HttpSession session
						,RedirectAttributes reAttr) {
		
		
		HumanResources loginInfo = new HumanResources();
		if(adminId != null && !"".equals(adminId) && adminPw != null && !"".equals(adminPw)) {
			loginInfo.setLevelNum("1");
			loginInfo.setEmployeeId(adminId);
			loginInfo.setEmployeePw(adminPw);
		}else if(headquarterId != null && !"".equals(headquarterId) && headquarterPw != null && !"".equals(headquarterPw)) {
			loginInfo.setLevelNum("3");
			loginInfo.setEmployeeId(headquarterId);
			loginInfo.setEmployeePw(headquarterPw);
		}else if(factoryId != null && !"".equals(factoryId) && factoryPw != null && !"".equals(factoryPw)) {
			loginInfo.setLevelNum("2");
			loginInfo.setEmployeeId(factoryId);
			loginInfo.setEmployeePw(factoryPw);
		}
		log.info("loginInfo :{}", loginInfo);
		
		HumanResources loginResult = loginService.loginEmployee(loginInfo);
		/*
		 * if(loginResult) { session.setAttribute("SID", loginInfo.getEmployeeId());
		 * session.setAttribute("SCODE", loginInfo.); }
		 */
		
		return "/main";
		
	}
	
	//@PostMapping("/login")
	public String login1(@ModelAttribute Map<String,Object> loginInfo) {
		log.info("loginInfo: {}", loginInfo);
		return "/main";
		
	}

}
