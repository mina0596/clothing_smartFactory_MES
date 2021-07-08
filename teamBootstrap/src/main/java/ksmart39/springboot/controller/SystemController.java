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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;


import ksmart39.springboot.domain.RawMaterials;

import ksmart39.springboot.service.SystemService;

@Controller
public class SystemController {
	
	
	private final SystemService systemService;
	
	@Autowired
	public SystemController(SystemService systemService) {
		this.systemService = systemService;
	}

	private static final Logger log = LoggerFactory.getLogger(SystemController.class);

	
	//==============================================================
	//시스템 첫화면
	@GetMapping("/system")
	public String system(Model model) {
		model.addAttribute("title","시스템");
		return "system/system";
	}
	
	//===============================================================
	
	
	//수정화면 ->목록
	@PostMapping("modifyHumanResources")
	public String modifyHumanResources(HumanResources humanResources) {
		systemService.modifyHumanResources(humanResources);
		return "redirect:/humanResourcesList";
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
	
	//[한빛]사원등록-> 사원목록
	@PostMapping("/addHumanResources")
	public String addHumanResources(HumanResources humanResources) {
		systemService.addHumanResources(humanResources);
		
		return "redirect:/humanResourcesList";
	}
	//[한빛]사원등록
	@GetMapping("/addHumanResources")
	public String addHumanResources(Model model) {
		model.addAttribute("title", "인사관리");
		return"system/addHumanResources";	
	}
	
	//[한빛]사원목록
	@GetMapping("/humanResourcesList")
	public String humanResourcesList(Model model
									,@RequestParam(name="searchKey",required = false) String searchKey
									,@RequestParam(name="searchValue",required=false) String searchValue) {
		
		log.info("========================================");
		log.info("화면에서 입력받은 값(회원목록) searchKey: {}", searchKey);
		log.info("화면에서 입력받은 값(회원목록) searchValue: {}", searchValue);
		log.info("========================================");
		
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<HumanResources> humanResources = systemService.getHumanResources(paramMap);
		model.addAttribute("title", "인사관리");
		model.addAttribute("humanResources", humanResources);
		return "system/humanResourcesList";
	}
		
	//==============================================================
	//수정화면 ->목록
	@PostMapping("modifyClient")
	public String modifyClient(Client client) {
		systemService.modifyClient(client);
		return "redirect:/clientList";
	}
	
	//[한빛]사원수정
	@GetMapping("/modifyClient")
	public String modifyClient(@RequestParam(name = "clientCode", required = false) String clientCode, Model model) {
		//1. 회원코드로 회원테이블을 조회한 HumanResources객체
		Client client = systemService.getClientInfoByCode(clientCode);
		//2. Model 화면에 전달할 객체 삽입
		model.addAttribute("title","거래처수정폼");
		model.addAttribute("client",client);
		return "system/modifyClient";
	}
	
	//[한빛]주문등록 ->목록으로 이동
	@PostMapping("/addClient")
	public String addClient(Client client) {
		systemService.addClient(client);
		return "redirect:/clientList";
	}
	
	//[한빛]거래처 조회
	@GetMapping("/clientList")
	public String getClientList(@RequestParam(name = "searchKey", required = false) String searchKey,
													@RequestParam(name = "searchValue", required = false) String searchValue, 
																					Model model) {
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);

		List<Client> client = systemService.getClient(paramMap);
		model.addAttribute("title", "거래처관리");
		model.addAttribute("client", client);
		return "system/clientList";
	}

	//[한빛]수주거래처 등록
	@GetMapping("/addClient")
	public String addClient(Model model) {
		model.addAttribute("title", "거래처관리");
		return "system/addClient";
	}
	

	
 //==================================================================
	//[다미]계정과목 수정
	@PostMapping("/modifyAccountSubject")
	public String modifyAccountSubject(AccountingCategory accountingCategory) {
		log.info("===========================================================================");
		log.info("계정과목 수정화면에서 받아온 값: {}", accountingCategory);
		log.info("===========================================================================");
		
		systemService.modifyMember(accountingCategory);
		
		return "redirect:/accountSubjectList";
	}
	
	//[다미]계정과목 수정 화면
	@GetMapping("/modifyAccountSubject")
	public String modifyAccountSubject(@RequestParam(name = "categoryCode", required = false)String categoryCode
									   ,Model model ) {
		log.info("===========================================================================");
		log.info("화면에서 받아온 값(계정과목 등록, 계정 과목 명): {}", categoryCode);
		log.info("===========================================================================");
		
		AccountingCategory accCate = systemService.getAccountSubjectByCode(categoryCode);

		log.info("===========================================================================");
		log.info("아이디로 조회한 계정과목 카테고리: {}", accCate);
		log.info("===========================================================================");
		
		model.addAttribute("accCate", accCate);
		
		return "system/modifyAccountSubject";
	}
	
	//[다미]계정과목 등록 후 리스트로 리턴
	@PostMapping("/addAccountSubject")
	public String addAccountSubject(AccountingCategory account) {
		
		log.info("===========================================================================");
		log.info("화면에서 받아온 값(계정과목 등록, 계정 과목 명): {}", account);
		log.info("===========================================================================");
		systemService.addAccountSubject(account);
		
		return "redirect:/accountSubjectList";
	}
	
	//[다미]계정과목 등록
	@GetMapping("/addAccountSubject")
	public String addAccountSubject() {
		return "system/addAccountSubject";
	}
	
	//[다미]계정과목 목록&검색
	@GetMapping("/accountSubjectList")
	public String getAccountCategoryList(@RequestParam(name="searchKey", required = false) String searchKey
										,@RequestParam(name="searchValue", required = false)String searchValue
										,Model model) {
		
		log.info("===================================================");
		log.info("검색 조건 (searchKey):     {}" , searchKey);
		log.info("검색 조건 (searchValue):     {}" , searchValue);
		log.info("===================================================");
	
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<AccountingCategory> accountingCategoryList = systemService.getAccountingSubjectList(paramMap);
		
		log.info("===================================================");
		log.info("계정과목 목록 :     {}" , accountingCategoryList);
		log.info("===================================================");
		
		model.addAttribute("accountingCategoryList", accountingCategoryList);
		return "system/accountSubjectList";
	}
	
	
	//==============================================
	
	//[민아]원부자재 리스트 조회
		@GetMapping("/rawMaterialsList")
		public String getRawMeterialsList(Model model) {
			List<RawMaterials> materialList = systemService.getMaterialsList();
			model.addAttribute("materialList", materialList);
			return "system/rawMaterialsList";
		}
	
	//[민아]원부자재 등록화면
	@GetMapping("/addRawMaterials")
	public String addRawMeterials(Model model) {
		
		return "system/addRawMaterials";
	}
	//[민아]모달 실험
	@GetMapping("/modalBody")
	public String testModaltest(Model model) {
		
		return "system/modalBody";
	}
	//[민아]원부자재정보 수정
	@GetMapping("/modifyRawMaterials")
	public String modifyRawMaterialsInfo(@RequestParam(name = "rawMaterialCate", required = false) String rawMaterialCate
										,@RequestParam(name = "materialCate", required = false) String materialCate
										,@RequestParam(name = "materialName", required = false) String materialName
										,@RequestParam(name = "colorName", required = false) String colorName
										,@RequestParam(name = "feature", required = false) String feature
										,@RequestParam(name = "unit", required = false) String unit
										, Model model) {
		//dao랑 연결하자!
		
		log.info("========================================");
		log.info("화면에서 입력받은 값(수정) rawMaterialCate: {}", rawMaterialCate);
		log.info("화면에서 입력받은 값(수정) materialCate: {}", materialCate);
		log.info("화면에서 입력받은 값(수정) materialName: {}", materialName);
		log.info("화면에서 입력받은 값(수정) colorName: {}", colorName);
		log.info("화면에서 입력받은 값(수정) feature: {}", feature);
		log.info("화면에서 입력받은 값(수정) unit: {}", unit);
		log.info("========================================");
		
		model.addAttribute("rawMaterialCate", rawMaterialCate);
		model.addAttribute("materialCate", materialCate);
		model.addAttribute("materialName", materialName);
		model.addAttribute("colorName", colorName);
		model.addAttribute("feature", feature);
		model.addAttribute("unit", unit);
		
		return "system/modifyRawMaterials";
	}
	
	//[민아]원부자재정보 수정 후
	@PostMapping("/modifyRawMaterials")
	public String modifyRawMaterials() {
		return "redirect:/rawMaterialsList";
	}
	
	//[민아]원부자재 재료 구분 검색후 처리
	@PostMapping("/searchRawMaterialName")
	@ResponseBody
	public String sendMaterialName(@RequestParam(name = "materialName", required = false) String materialName
								  , Model model) {
		
		log.info("MaterialNameCheck 	materialName :::::: {}", materialName);
		model.addAttribute("materialName", materialName);
		return "redirect:/addRawMaterials";
	}
	
	
	//[민아]원부자재 재료 구분 검색
	@GetMapping("/searchMaterialName")
	public String getSearchValue() {
		//여기에 list DB에서 받아서 뿌려줄꺼임
		return "system/searchMaterialName";
	}

	//===============================================================
	
	//[보람]품질검사 대분류 
	@GetMapping()
	public String getHighClassCate() {
		
		return null;
	}
	//[보람] 검사 리스트 검사번호클릭시 검사정보 경로
			@GetMapping("qualityInspectionInfo")
			public String qualityInspectionInfo() {
				return "system/qualityInspectionInfo";
			}
			
	//[보람 ]검사 수정 완료
	@PostMapping("/modifyQualityInspection")
	public String  modifyQualityInspection() {
		
		return"redirect:/qualityInspectionList";
	}
	//[보람] 검사 수정 경로
	@GetMapping("/modifyQualityInspection")
	public String getModifyQualityInspection() {
		return "system/modifyQualityInspection";
	}
	
	
	//검사종류 리스트 메서드
	/*
	 * @GetMapping("/qualityInspectionList") public String
	 * getQualityInspectionList(Model model) { List<SubClassInspection>
	 * qualityInspectionList = systemService.getQualityInspectionList();
	 * 
	 * log.info("========================================");
	 * log.info("qualityInspectionList - {}:", qualityInspectionList.toString());
	 * log.info("========================================");
	 * model.addAttribute("qualityInspectionList", qualityInspectionList);
	 * 
	 * 
	 * return"system/qualityInspectionList"; }
	 * 
	 * //검사종류 등록 메서드
	 * 
	 * @GetMapping("/addQualityInspection") public String addQualityInspection(Model
	 * model) {
	 * 
	 * model.addAttribute("title", "품질검사:검사등록");
	 * return"system/addQualityInspection"; }
	 */
	

}
