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
import ksmart39.springboot.domain.ProductionProcessList;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.SubClassInspection;
import ksmart39.springboot.paging.Pagination;
import ksmart39.springboot.service.SystemService;

@Controller
@RequestMapping("/system")
public class SystemController {

	private final SystemService systemService;
	
	@Autowired
	public SystemController(SystemService systemService) {
		this.systemService = systemService;
	}
	
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);
 
	//*********************************************************************************************************
	//[한빛]사원등록
	@GetMapping("/addHumanResources")
	public String addHumanResources(Model model) {
		model.addAttribute("title", "사용자관리");
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
		model.addAttribute("title","사용자관리");
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

	//***********************************************************************************************************************
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

	//***********************************************************************************************************************
	// [다미]계정과목 수정
	@PostMapping("/modifyAccountSubject")
	public String modifyAccountSubject(AccountingCategory accountingCategory) {
		log.info("===========================================================================");
		log.info("계정과목 수정화면에서 받아온 값: {}", accountingCategory);
		log.info("===========================================================================");

		systemService.modifyMember(accountingCategory);

		return "redirect:/accountSubjectList";
	}

	// [다미]계정과목 수정 화면
	@GetMapping("/modifyAccountSubject")
	public String modifyAccountSubject(@RequestParam(name = "categoryCode", required = false) String categoryCode,
			Model model) {
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

	// [다미]계정과목 등록 후 리스트로 리턴
	@PostMapping("/addAccountSubject")
	public String addAccountSubject(AccountingCategory account) {

		log.info("===========================================================================");
		log.info("화면에서 받아온 값(계정과목 등록, 계정 과목 명): {}", account);
		log.info("===========================================================================");
		systemService.addAccountSubject(account);

		return "redirect:/accountSubjectList";
	}

	// [다미]계정과목 등록
	@GetMapping("/addAccountSubject")
	public String addAccountSubject() {
		return "system/addAccountSubject";
	}

	// [다미]계정과목 목록&검색
	@GetMapping("/accountSubjectList")
	public String getAccountCategoryList(@RequestParam(name = "searchKey", required = false) String searchKey,
			@RequestParam(name = "searchValue", required = false) String searchValue, Model model) {

		log.info("===================================================");
		log.info("검색 조건 (searchKey):     {}", searchKey);
		log.info("검색 조건 (searchValue):     {}", searchValue);
		log.info("===================================================");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);

		List<AccountingCategory> accountingCategoryList = systemService.getAccountingSubjectList(paramMap);

		log.info("===================================================");
		log.info("계정과목 목록 :     {}", accountingCategoryList);
		log.info("===================================================");

		model.addAttribute("accountingCategoryList", accountingCategoryList);
		return "system/accountSubjectList";
	}
	
	//***********************************************************************************************************************
	// [민아]원부자재 리스트 조회
	@GetMapping("/rawMaterialsList")
	public String getRawMeterialsList(Model model) {
		List<RawMaterials> materialList = systemService.getMaterialsList();
		model.addAttribute("materialList", materialList);
		return "system/rawMaterialsList";
	}

	// [민아]원부자재 등록화면
	@GetMapping("/addRawMaterials")
	public String addRawMeterials(Model model) {
		return "system/addRawMaterials";
	}
	
	//[민아]원부자재 등록 후 목록화면으로 이동
	@PostMapping("/addRawMaterials")
	public String addRawMaterials(@RequestParam(name = "materialName") String materialName) {
		log.info("화면단 확인:{}", materialName);
		return "redirect:/system/rawMaterialsList";
	}

	// [민아]원부자재정보 수정
	@GetMapping("/modifyRawMaterials")
	public String modifyRawMaterialsInfo(
			@RequestParam(name = "rawMaterialCate", required = false) String rawMaterialCate,
			@RequestParam(name = "materialCate", required = false) String materialCate,
			@RequestParam(name = "materialName", required = false) String materialName,
			@RequestParam(name = "colorName", required = false) String colorName,
			@RequestParam(name = "feature", required = false) String feature,
			@RequestParam(name = "unit", required = false) String unit, Model model) {
		// dao랑 연결하자!

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

	// [민아]원부자재정보 수정 후
	@PostMapping("/modifyRawMaterials")
	public String modifyRawMaterials() {
		return "redirect:/rawMaterialsList";
	}

	// [민아]원부자재 재료 구분 검색후 처리
	@PostMapping("/searchRawMaterialName")
	@ResponseBody
	public String sendMaterialsName(@RequestParam(name = "materialName", required = false) String materialName,
			Model model) {

		log.info("MaterialNameCheck 	materialName :::::: {}", materialName);
		model.addAttribute("materialName", materialName);
		return "redirect:/addRawMaterials";
	}

	// [민아]원부자재 재료 구분 검색
	@GetMapping("/searchMaterialName")
	public String getSearchValue() {
		// 여기에 list DB에서 받아서 뿌려줄꺼임
		return "system/searchMaterialName";
	}
	
	//***********************************************************************************************************************
	//[민아]생산공정 등록
	@GetMapping("/addProductionProcess")
	public String addProductionProcess(Model model) {
		return "system/addProductionProcess";
	}
	
	//[민아]생산공정 등록 후 생산공정 목록화면으로 이동
	@PostMapping("/addProductionProcess")
	public String addProductionProcess(ProductionProcessList productionProcessDomain) {
		log.info("등록화면에서 받아오는 등록정보 확인 :{}", productionProcessDomain);
		systemService.addProductionProcess(productionProcessDomain);
		return "redirect:/system/productionProcessList";
	}
	//[민아]생산공정 목록
	@GetMapping("/productionProcessList")
	public String getProductionProcessList(Model model) {
		List<ProductionProcessList> productionProcessList = systemService.getProductionProcessList();
		log.info("DB에서 리스트 잘 데려오는지 확인:{}", productionProcessList);
		model.addAttribute("productionProcessList", productionProcessList);
		return "system/productionProcessList";
	}
	
	//***********************************************************************************************************************
	//[보람]품질검사 항목 검색
	@RequestMapping(value = "/searchInspectionList",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchInspectionList(@RequestParam(value ="highClassCateName",required = false )String highClassCateName,
														@RequestParam(value = "middleClassCateName",required = false)String middleClassCateName,
														@RequestParam(value = "lowClassCateName",required = false)String lowClassCateName
														){
		//ReqeusetParam의 값을 map을 담기
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("highClassCateName", highClassCateName);
		map.put("middleClassCateName", middleClassCateName);
		map.put("lowClassCateName", lowClassCateName);
		List<Map<String,Object>> searchListMap= systemService.searchInspectionList(map);
		
		return searchListMap;
	}

	//[보람]품질검사 삭제
	@RequestMapping(value = "/deleteInspection")
	@ResponseBody
	public int deleteQualityInspection(@RequestParam(value = "checkArray[]")String[] checkArray) {
		int result =1;
		for(int i =0; i<checkArray.length; i++) {
			result = systemService.deleteQualityInspection(checkArray[i]);
		}
		log.info("========================================");
		log.info("result {}",result);
		log.info("========================================");
		//https://won-percent.tistory.com/48 참고한것 
		return result;
	}
	
	// [보람]품질검사 대분류 ajax 처리
	@RequestMapping(value = "/highClassCate" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getHighClassCate() {
		List<Map<String,Object>> highCate =systemService.getHighClassCate();
		log.info("========================================");
		log.info("highCate {}",highCate);
		log.info("========================================");
		return highCate;
	}
	//[보람] 품질검사 중분류 가지고오기
	@RequestMapping(value = "/mediumClassCate" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getMediumClassCate(@RequestParam(value = "highClassCateName", required = false)String highClassCateName) {
		List<Map<String,Object>> mediumCate = systemService.getMediumClassCate(highClassCateName);
		log.info("========================================");
		log.info("mediumCate {}",mediumCate);
		log.info("========================================");
		
		return mediumCate;
	}
	//[보람] 품질검사 소분류 가지고오기
	@RequestMapping(value = "/lowClassCate" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getLowClassCate(@RequestParam(value = "middleClassCateName", required = false)String middleClassCateName) {
		List<Map<String,Object>> lowCate = systemService.getLowClassCate(middleClassCateName);
		log.info("========================================");
		log.info("mediumCate {}",lowCate);
		log.info("========================================");
		
		return lowCate;
	}

	// [보람] 검사 리스트 검사번호클릭시 검사정보 경로
	@GetMapping("qualityInspectionInfo")
	public String qualityInspectionInfo() {
		return "system/qualityInspectionInfo";
	}

	// [보람 ]검사 수정 완료
	@PostMapping("/modifyQualityInspection")
	public String modifyQualityInspection(SubClassInspection subClassInspection) {
		log.info("========================================");
		log.info("화면에서 입력받은 값(수정화면폼)subClassInspection:{}",subClassInspection);
		log.info("========================================");
		
		systemService.modifyQualityInspection(subClassInspection);
		return "redirect:/system/qualityInspectionList";
	}

	// [보람] 검사 수정 경로
	@GetMapping("/modifyQualityInspection")
	public String modifyQualityInspection(Model model
			,@RequestParam(name ="qualityInspectionCode",required = false) String qualityInspectionCode) {
		log.info("========================================");
		log.info("화면에서입력받은검사수정폼 qualityInspectionCode:{}",qualityInspectionCode);
		log.info("========================================");
		//1.검사 코드로 검사객체조회한 SubClassInspection객체
		SubClassInspection subClassInspection =systemService.getQualityInspectionCode(qualityInspectionCode);
		
		//2.Model 화면에 객체 삽입
		model.addAttribute("subClassInspection", subClassInspection);
		log.info("subClassInspection:{}",subClassInspection);
		
		return "system/modifyQualityInspection";
	}

	// [보람] 검사 리스트
	  @GetMapping("/qualityInspectionList")
	  public String getQualityInspectionList(Model model) {   
		  List<Map<String, Object>> resultMap = systemService.getQualityInspectionList();
	  
	  log.info("========================================");
	  log.info("qualityInspectionList - {}:", resultMap.toString());
	  log.info("========================================");
	  model.addAttribute("qualityInspectionList", resultMap);
	  
	  
	  return"system/qualityInspectionList"; 
	  }
	  //[보람]품질검사 등록 메서드
	  @PostMapping("/addQualityInspection")
	  public String addQualityInspection(@RequestParam(name = "highClassCode",required = false)String highClassCode,
			  							@RequestParam(name = "highMedClassCode",required = false)String highMedClassCode,
			  							@RequestParam(name = "highMedLowClassCode",required = false)String highMedLowClassCode,
			  							@RequestParam(name = "subClassName",required = false)String subClassName) {
		  log.info("========================================");
		  log.info("highClassCode {}:",highClassCode);
		  log.info("highMedClassCode {}:",highMedClassCode);
		  log.info("highMedLowClassCode {}:",highMedLowClassCode);
		  log.info("subClassName {}:",subClassName);
		  log.info("========================================");
		  systemService.addQualityInspection(highClassCode, highMedClassCode, highMedLowClassCode, subClassName);
		 
		  return "redirect:/system/qualityInspectionList";
	  }
	  
	  
	  
	  //검사종류 등록 메서드
	  
	  @GetMapping("/addQualityInspection") 
	  public String addQualityInspection(Model  model) {
	  
	  model.addAttribute("title", "품질검사:검사등록");
	  return"system/addQualityInspection"; }
	 
	//***********************************************************************************************************************
	// 시스템 첫화면
	@GetMapping("/system")
	public String system(Model model) {
		model.addAttribute("title", "시스템");
		return "system/system";
	}
}
	
	
	
