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
import ksmart39.springboot.service.SystemService;

@Controller
@RequestMapping("/system")
public class SystemController_KDM {

	private final SystemService systemService;

	@Autowired
	public SystemController_KDM(SystemService systemService) {
		this.systemService = systemService;
	}

	private static final Logger log = LoggerFactory.getLogger(SystemController_KDM.class);



	

	// ==================================================================
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

}
