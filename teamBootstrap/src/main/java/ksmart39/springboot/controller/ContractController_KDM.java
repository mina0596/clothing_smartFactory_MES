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
public class ContractController_KDM {
	@Autowired
	private final SupplierService supplierService;
	private final RequestedProductService requestedProductService;
	
	
	 @Autowired public ContractController_KDM(SupplierService supplierService, RequestedProductService requestedProductService) {
	 this.supplierService = supplierService;
	 this.requestedProductService = requestedProductService;
	 }
	 

	
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);
		
	

	// [다미] 전표 목록
	@GetMapping("/paymentInvoiceList")
	public String paymentInvoiceList(Model model) {
		return "contract/paymentInvoiceList";
	}

	// [다미] 전표 등록 화면
	@GetMapping("/addPaymentInvoice")
	public String addPaymentInvoice(Model model) {
		return "contract//addPaymentInvoice";
	}
	



}
