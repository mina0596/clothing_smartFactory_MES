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
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.MapUtils;

import ksmart39.springboot.domain.SupplierRequest;
import ksmart39.springboot.service.RequestedProductService;
import ksmart39.springboot.service.SupplierService;


@Controller
@RequestMapping("/contract")
public class ContractController_PMA {
	@Autowired
	private final SupplierService supplierService;
	private final RequestedProductService requestedProductService;
	
	
	 @Autowired public ContractController_PMA(SupplierService supplierService, RequestedProductService requestedProductService) {
	 this.supplierService = supplierService;
	 this.requestedProductService = requestedProductService;
	 }
	 

	
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);
	
	//----------------------------------------수주주문서-----------------------------------------------------
	
	//[민아]수주계약 등록 -> 조회
	@GetMapping("/addBuyerOrder_Minah")
	public String addBuyerOrder_Minah() {
		return "contract/addbuyerOrder_Minah";
	}
	
	

	//=========================================================
	//[민아]계약후 예정 수금/출금 등록
	@GetMapping("/addInvoicePayment")
	public String addInvoicePayment() {
		return "contract/addInvoicePayment";
	}
	
	//[민아]수금/출금 청구 등록
	@GetMapping("/addInvoiceClaim")
	public String addInvoiceClaim() {
		return "contract/addInvoiceClaim";
	}
	
	//[민아] 예정 수금/출금 목록
	@GetMapping("/expectedPaymentList")
	public String getExpectedPaymentList() {
		return "contract/expectedPaymentList";
	}

	
	//[민아] 결제 등록
	@GetMapping("/addInvoiceApproval")
	public String addInvoiceApproval() {
		return "contract/addInvoiceApproval";
	}

	//[민아]결제 승인 현황 목록
	@GetMapping("/invoiceApprovalList")
	public String getInvoiceApprovalList() {
		return "contract/invoiceApprovalList";
	}
	
	


	

}
