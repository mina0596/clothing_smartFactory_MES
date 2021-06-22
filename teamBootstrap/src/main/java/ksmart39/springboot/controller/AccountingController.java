package ksmart39.springboot.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccountingController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AccountingController.class);

	//계정과목 등록 후 리스트로 리턴
	@PostMapping("/addAccountSubject")
	public String addAccountSubject(@RequestParam(value="account_category_name", required = false )String account_category_name
									,@RequestParam(value="account_category_content", required = false)String account_category_content) {
		
		log.info("===========================================================================");
		log.info("화면에서 받아온 값(계정과목 등록, 계정 과목 명): {}", account_category_name);
		log.info("화면에서 받아온 값(계정과목 등록, 적요): {}", account_category_content);
		log.info("===========================================================================");
		
		return "redirect:/accountSubjectList";
	}
	
	//계정과목 등록
	@GetMapping("/addAccountSubject")
	public String addAccountSubject() {
		return "accounting/addAccountSubject";
	}
	
	//회계 메인화면
	@GetMapping("/accounting")
	public String account() {
		return "accounting/accounting";
		
	}
	//결제 등록
	@GetMapping("/addInvoiceApproval")
	public String addInvoiceApproval() {
		return "accounting/addInvoiceApproval";
	}
	
	//결제 승인 현황 목록
	@GetMapping("/invoiceApprovalList")
	public String getInvoiceApprovalList() {
		return "accounting/invoiceApprovalList";
	}
	
	//계정과목 목록
	@GetMapping("/accountSubjectList")
	public String getAccountCategoryList() {
		return "accounting/accountSubjectList";
	}
			

}
