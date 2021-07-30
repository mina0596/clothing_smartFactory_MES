package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;

import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.SubClassInspection;
import ksmart39.springboot.paging.Pagination;
import ksmart39.springboot.service.SystemService;

@Controller
@RequestMapping("/system")
public class SystemController_LHB {

	private final SystemService systemService;

	@Autowired
	public SystemController_LHB(SystemService systemService) {
		this.systemService = systemService;
	}

	private static final Logger log = LoggerFactory.getLogger(SystemController_LHB.class);


	//[한빛]사원등록
	@GetMapping("/addHumanResources")
	public String addHumanResources(Model model) {
		model.addAttribute("title", "인사관리");
		return"system/addHumanResources";	
	}
	
	
	//[한빛] 아이디 중복체크
	@PostMapping("/memberIdCheck")
	@ResponseBody
	public boolean memberIdCheck(@RequestParam(value = "employeeId") String employeeId) {
		
		log.info("============{}" + employeeId);
		boolean idCheck = true;
		
		HumanResources humanResources = systemService.getEmployeeInfoById(employeeId);
		
		if(humanResources != null) idCheck = false;
		
		return idCheck;
	}
	
	//[한빛]사원등록-> 사원목록
	@PostMapping("/addHumanResources")
	public String addHumanResources(HumanResources humanResources) {
		systemService.addHumanResources(humanResources);
		
		return "redirect:humanResourcesList";
	}
	
	//[한빛]사원목록
	@GetMapping("/humanResourcesList")
	public String getHumanResourcesList(@RequestParam(name = "searchKey", required = false) String searchKey,
					 											   @RequestParam(name = "searchValue", required = false) String searchValue,
					                                               Model model, Pagination paging) {
		
		log.info("========================================");
		log.info("화면에서 입력받은 값(회원목록) searchKey: {}", searchKey);
		log.info("화면에서 입력받은 값(회원목록) searchValue: {}", searchValue);
		log.info("========================================");
		
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		Map<String, Object> resultMap = systemService.getHumanResources(paging);		
		model.addAttribute("humanResourcesList", 						resultMap.get("humanResourcesList"));
	    model.addAttribute("currentPage", 								resultMap.get("currentPage"));
		model.addAttribute("lastPage", 									resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 								resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 								resultMap.get("pageEndNum"));
		model.addAttribute("searchKey", 								paramMap.get("searchKey"));
		model.addAttribute("searchValue", 								paramMap.get("searchValue"));

		return "system/humanResourcesList";
	}

	//[한빛]사원수정
	@GetMapping("/modifyHumanResources")
	public String modifyHumanResources(@RequestParam(name = "employeeCode", required = false) String employeeCode, Model model) {
		//1. 회원코드로 회원테이블을 조회한 HumanResources객체
		HumanResources humanResources = systemService.getEmployeeInfoByCode(employeeCode);
		//2. Model 화면에 전달할 객체 삽입
		model.addAttribute("title","회원수정폼");
		model.addAttribute("humanResources",humanResources);
		return "system/modifyHumanResources";
	}
	
	//[한빛] 사용자 수정화면 ->목록
	@PostMapping("/modifyHumanResources")
	public String modifyHumanResources(HumanResources humanResources) {
		systemService.modifyHumanResources(humanResources);
		return "redirect:humanResourcesList";
	}
	
	//[한빛]사용자 삭제
	@PostMapping("/deleteHumanResources")
	@ResponseBody
	public int deleteHumanResources(@RequestParam(value = "delArr[]")List<String> delArr) {
		System.out.println(delArr);
		int result = 0;
		result	= systemService.deleteHumanResources(delArr);
		return result;
	}


	// ==============================================================

	//[한빛]거래처 등록
	@GetMapping("/addClient")
	public String addClient(Model model) {
		model.addAttribute("title", "거래처관리");
		return "system/addClient";
	}	
	//[한빛]거래처등록 ->목록으로 이동
	@PostMapping("/addClient")
	public String addClient(Client client) {
		systemService.addClient(client);
		return "redirect:clientList";
	}
	//[한빛]거래처 조회
	@GetMapping("/clientList")
	public String getClientList(@RequestParam(name = "searchKey", required = false) String searchKey,
													@RequestParam(name = "searchValue", required = false) String searchValue, 
																					Model model, Pagination paging) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);

	    Map<String, Object> resultMap = systemService.getClient(paging);
	    model.addAttribute("clientList", 					resultMap.get("clientList"));
	    model.addAttribute("currentPage", 					resultMap.get("currentPage"));
		model.addAttribute("lastPage", 						resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 					resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 					resultMap.get("pageEndNum"));
		model.addAttribute("searchKey", 					paramMap.get("searchKey"));
		model.addAttribute("searchValue", 					paramMap.get("searchValue"));

		return "system/clientList";
	}
	//[한빛]거래처수정
	@GetMapping("/modifyClient")
	public String modifyClient(@RequestParam(name = "clientCode", required = false) String clientCode, Model model) {
		//1. 회원코드로 회원테이블을 조회한 HumanResources객체
		Client client = systemService.getClientInfoByCode(clientCode);
		//2. Model 화면에 전달할 객체 삽입
		model.addAttribute("title","거래처수정폼");
		model.addAttribute("client",client);
		return "system/modifyClient";
	}
	//[한빛] 거래처수정화면 ->목록
	@PostMapping("modifyClient")
	public String modifyClient(Client client) {
		systemService.modifyClient(client);
		log.info("=================");
		log.info("{}",client);
		return "redirect:clientList";
	}			
	//[한빛]거래처 삭제
	@PostMapping("/deleteClient")
	@ResponseBody
	public int deleteClient(@RequestParam(value = "delArr[]")List<String> delArr) {
		System.out.println(delArr);
		int result = 0;
		result	= systemService.deleteClient(delArr);
		return result;
	}

}	

