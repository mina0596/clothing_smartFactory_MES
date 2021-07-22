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
import ksmart39.springboot.service.OrderService;
import ksmart39.springboot.service.RequestedProductService;
import ksmart39.springboot.service.SupplierService;


@Controller
@RequestMapping("/contract")
public class ContractController_LHB {
	@Autowired
	private final RequestedProductService requestedProductService;
	private final OrderService orderService;
	
	
	 @Autowired public ContractController_LHB(RequestedProductService requestedProductService, OrderService orderService) {
	 this.requestedProductService = requestedProductService;
	 this.orderService = orderService;
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
	public String getBuyerOrderList(Model model) {
		List<Map<String,Object>> resultMap = orderService.getOrderList();
		model.addAttribute("title", "수주관리");
		model.addAttribute("orderList",resultMap);
		return "contract/buyerOrderList";
	}		

	//[한빛]수주 주문서 수정
	@GetMapping("/modifyBuyerOrder")
	public String modifyBuyerOrder(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderList";
	}	
	
	//[한빛]수주 주문서 승인완료 목록
	@GetMapping("/buyerOrderApproval")
	public String getBuyerOrderApproval(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderApproval";
	}	
	
	//[한빛]수주 주문서 상세로!
	@GetMapping("/buyerOrderInfo")
	public String getBuyerOrderInfo(Model model) {
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
	public String getBuyerContractList(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerContractList";
	}
	
	//[한빛] 수주계약 수정
	@GetMapping("/modifyBuyerContract")
	public String modifyBuyerContract() {
		return"contract/modifyBuyerContract";
	}

}
