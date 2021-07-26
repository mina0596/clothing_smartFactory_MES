package ksmart39.springboot.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
						,HttpServletResponse response
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
		
		Map<String,Object> loginInfoMap = loginService.loginEmployee(loginInfo);
		HumanResources loginEmployeeInfo = (HumanResources) loginInfoMap.get("loginEmployeeInfo");
		if((boolean) loginInfoMap.get("loginCheck")) {
			session.setAttribute("SID", loginEmployeeInfo.getEmployeeId());
			session.setAttribute("SCODE", loginEmployeeInfo.getEmployeeCode());
			session.setAttribute("SCODE", loginEmployeeInfo.getLevelNum());
			return "/main";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('아이디와 비밀번호를 다시 확인해주세요'); location.href='/';</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "/main";
		}
	}
	

}
