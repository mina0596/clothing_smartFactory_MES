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
public class ContractController_HBR {
	@Autowired
	private final SupplierService supplierService;
	private final RequestedProductService requestedProductService;
	
	
	 @Autowired public ContractController_HBR(SupplierService supplierService, RequestedProductService requestedProductService) {
	 this.supplierService = supplierService;
	 this.requestedProductService = requestedProductService;
	 }
	 

	
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);
	
	
	//------------------------------------------------------발주----------------------------------------------------------
	//to[보람] 원부자재라는 단어를 발주로 바꿔주세요 + 메서드명이랑 경로랑 이름 연관성있게 from [민아]

	//[보람]발주계약삭제
	@PostMapping("/deleteSupplierContract")
	public String deleteSupplierContract() {
		return "redirect:/supplierContractList";
	}
	
	
	//[보람]원부자재 발주리스트 발주코드 클릭시 발주정보 경로 메서드
	@GetMapping("/supplierContractInfo")
	public String getSupplierContractInfo() {
	
	return "contract/supplierContractInfo";
	}
	//[보람]원부자재 발주 계약 수정 완료
	@PostMapping("/modifySupplierContract")
	public String modifySupplierContract(Model model) {
		return"redirect:/supplierContractList";
	}
	//[보람]원부자재 발주 계약수정메서드
	@GetMapping("/modifySupplierContract")
	public String modifySupplierContract() {
		
		return "contract/modifySupplierContract";
	}
	//[보람]원부자재 발주계약리스트
	@GetMapping("/supplierContractList")
	public String supplierContractList(Model model,@RequestParam(name = "supplierOrderSearchKey",required = false)String supplierOrderSearchKey
			,@RequestParam(name ="supplierOrderSearchValue",required = false )String supplierOrderSearchValue) {
		List<Map<String,Object>> resultContract = supplierService.getSupplierContractList();
		log.info("========================================");
		log.info("supplierContractList{}",resultContract);
		log.info("========================================");
		model.addAttribute("supplierContractList", resultContract);
	
		return"contract/supplierContractList";
	}

	
	//[보람]원부자재 발주 계약 완료 
	@PostMapping("/addSupplierContract")
	public String addSupplierContract(Model model) {
		return"redirect/supplierContractList";
	}
	
	//[보람]원부자재 발주 계약 등록 
	@GetMapping("/addSupplierContract")
	public String addSupplierContract() {
		return"contract/addSupplierContract";
	}
	
	//[보람]발주 삭제 경로
	@PostMapping("/deleteSupplierRequest")
	public String deleteSupplierRequest() {
		
		return "redirect:/supplierRequestList";
	}
	//[보람] 발주 리스트 경로
	@GetMapping("/supplierRequestList")
	public String supplierRequestList(Model model) {
		 List<Map<String,Object>> resultList = supplierService.getSupplierRequestList();
		 log.info("========================================");
		 log.info("supplierRequestList{}",resultList);
		 log.info("========================================");
		
		 model.addAttribute("supplierRequestList", resultList);
		 
		return "contract/supplierRequestList";
	}
	//[보람]발주 수정 완료 경로
	@PostMapping("/modifySupplierRequest")
	public String modifySupplierRequest() {
		return"redirect:/supplierRequestList";
	}
	//[보람] 발주 수정 경로 
	@GetMapping("/modifySupplierRequest")
	public String modifySupplierRequest(Model model) {
		return "contract/modifySupplierRequest";
	}
	//[보람]원부자재 발주등록 완료
	@PostMapping("/addSupplierRequest")
	public String addSupplierRequest(SupplierRequest supplierRequest) {
		supplierService.addSupplierRequest(supplierRequest);
		return "redirect:/supplierRequestList";
	}
	
	//[보람]원부자재 발주요청메서드
	@GetMapping("/addSupplierRequest")
	public String addSupplierRequest(Model model) {
		 List<Map<String,Object>> resultMap1 = supplierService.getRawInventoryState();
		 List<Map<String,Object>> resultMap2 = supplierService.getClientInfo();
		 List<Map<String,Object>> resultMap3 = supplierService.getRawInfo();
		
		 log.info("========================================");
		 log.info("addSupplierRequeststate{}",resultMap1);
		 log.info("========================================");
		 model.addAttribute("rawInventoryList", resultMap1);
		 model.addAttribute("clientList", resultMap2);
		 model.addAttribute("rawMeterialList", resultMap3);
		 
		return "contract/addSupplierRequest";
	}


	

}
