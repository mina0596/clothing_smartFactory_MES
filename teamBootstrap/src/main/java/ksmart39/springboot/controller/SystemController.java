package ksmart39.springboot.controller;

import java.util.List;

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
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;
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
	
	//[한빛]사원등록-> 사원목록
	@PostMapping("/addHumanResources")
	public String addHumanResources() {
		return "redirect:/humanResourcesList";
	}
	
	//[한빛]사원등록
	@GetMapping("/addHumanResources")
	public String humanResourcesEnroll(Model model) {
		 model.addAttribute("title", "인사관리");
		return"system/addHumanResources";	
	}

	//[한빛]사원수정
	@GetMapping("/modifyHumanResources")
	public String modifyHumanResources() {
		return "system/modifyHumanResources";
	}
	
	//[한빛]사원목록
	@GetMapping("/humanResourcesList")
	public String humanResourcesList(Model model) {
		List<HumanResources> humanResources = systemService.getHumanResources();
		model.addAttribute("title", "인사관리");
		model.addAttribute("humanResources", humanResources);
		return "system/humanResourcesList";
	}
	
	
	//==============================================================
	//[한빛]수주주문등록 ->목록으로 이동
	@PostMapping("/addClient")
	public String addClient() {
		return "redirect:/clientList";
	}
	
	//[한빛] 수주거래처 수정
	@GetMapping("/modifyClient")
	public String modifyClient() {
		return"system/modifyClient";
	}
	
	//[한빛]수주거래처 조회
	@GetMapping("/clientList")
	public String clientList(Model model) {
		model.addAttribute("title", "수주관리");
		return "system/clientList";
	}

	//[한빛]수주거래처 등록
	@GetMapping("/addClient")
	public String addClient(Model model) {
		model.addAttribute("title", "수주관리");
		return "system/addClient";
	}
	
	
 //==================================================================
	//[다미]계정과목 등록 후 리스트로 리턴
	@PostMapping("/addAccountSubject")
	public String addAccountSubject(@RequestParam(value="account_category_name", required = false )String account_category_name
									,@RequestParam(value="account_category_content", required = false)String account_category_content) {
		
		log.info("===========================================================================");
		log.info("화면에서 받아온 값(계정과목 등록, 계정 과목 명): {}", account_category_name);
		log.info("화면에서 받아온 값(계정과목 등록, 적요): {}", account_category_content);
		log.info("===========================================================================");
		
		return "redirect:/accountSubjectList";
	}
	
	//[다미]계정과목 등록
	@GetMapping("/addAccountSubject")
	public String addAccountSubject() {
		return "system/addAccountSubject";
	}
	
	//[다미]계정과목 목록
	@GetMapping("/accountSubjectList")
	public String getAccountCategoryList(Model model) {
		List<AccountingCategory> accountingCategoryList = systemService.getAccountingSubjectList();
		
		log.info("===================================================");
		log.info("계정과목 목록 :     {}" , accountingCategoryList);
		log.info("===================================================");

		model.addAttribute("accountingCategoryList", accountingCategoryList);
		return "system/accountSubjectList";
	}
	
	//==============================================
	//[민아]원부자재 목록
	@GetMapping("/rawMaterialsList")
	public String getRawMeterialsList() {
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
	@GetMapping("/qualityInspectionList")
	public String getQualityInspectionList(Model model) {
		List<QualityInspection> qualityInspectionList =systemService.getQualityInspectionList();
		
		log.info("========================================");
		log.info("qualityInspectionList:",qualityInspectionList);
		log.info("========================================");
		model.addAttribute("qualityInspectionList", qualityInspectionList);
	
		
		return"system/qualityInspectionList";
	}
	
	//검사종류 등록 메서드
	@GetMapping("/addQualityInspection")
	public String addQualityInspection(Model model) {
		
		model.addAttribute("title", "품질검사:검사등록");
		return"system/addQualityInspection";
	}	
	
	

}
