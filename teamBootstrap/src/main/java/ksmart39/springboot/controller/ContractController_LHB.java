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
import ksmart39.springboot.paging.Pagination;
import ksmart39.springboot.service.ContractService;
import ksmart39.springboot.service.OrderService;
import ksmart39.springboot.service.RequestedProductService;
import ksmart39.springboot.service.SupplierService;


@Controller
@RequestMapping("/contract")
public class ContractController_LHB {
	@Autowired
	private final OrderService orderService;
	private final ContractService contractService;
	
	 @Autowired public ContractController_LHB(OrderService orderService, ContractService contractService) {
	 this.orderService = orderService;
	 this.contractService = contractService;
	 }
	 

	
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);
	
	//----------------------------------------수주주문서-----------------------------------------------------
	//[한빛]주문서 등록
	@GetMapping("/addBuyerOrder")
	public String addBuyerOrder(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerOrder";
	}		
	
	//[한빛]주문서 등록 -> 조회
	@PostMapping("/addBuyerOrder")
	public String addBuyerOrder() {
		return "redirect:/buyerOrderList";
	}

	//[한빛]주문서 조회
	@GetMapping("/buyerOrderList")
	public String getOrderList(Model model) {
		List<Map<String,Object>> orderList = orderService.getOrderList();
		model.addAttribute("title", "수주관리");
		model.addAttribute("orderList",orderList);
		return "contract/buyerOrderList";
	}		

	//[한빛]수주 주문서 수정
	@GetMapping("/modifyBuyerOrder")
	public String modifyBuyerOrder(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderList"; //잘못됨
	}	
	
	//[한빛]수주 주문서 승인완료 목록
	@GetMapping("/buyerOrderApproval")
	public String getBuyerOrderApproval(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderApproval";
	}	
	
	//[한빛]수주 주문서 상세로!
	@GetMapping("/buyerOrderInfo")
	public String getBuyerOrderInfo(@RequestParam(name = "prCode", required = false) String prCode, Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderInfo";
	}	
	

	//---------------------------------------수주계약---------------------------------------------------------

	//[한빛]수주계약 등록
	@GetMapping("/addBuyerContract")
	public String addBuyerContract(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerContract";
	}
	
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/addBuyerContract")
	public String addBuyerContract() {
		return "redirect:/buyerContractList";
	}
	
	//[한빛]수주계약 조회
	@GetMapping("/buyerContractList")
	public String getBuyerContractList(Model model, Pagination paging) {
	    Map<String, Object> resultMap = contractService.getBuyerContract(paging);
	    model.addAttribute("buyerContractList", 					resultMap.get("clientList"));
	    model.addAttribute("currentPage", 							resultMap.get("currentPage"));
		model.addAttribute("lastPage", 								resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 						resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 						resultMap.get("pageEndNum"));

		return "contract/buyerContractList";
	}
	
	//[한빛] 수주계약 수정
	@GetMapping("/modifyBuyerContract")
	public String modifyBuyerContract() {
		return"contract/modifyBuyerContract";
	}
	
}
