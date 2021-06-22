package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContractController {
	//수주주문 조회
	@GetMapping("/buyerContractList")
	public String buyerContractList(Model model) {
		model.addAttribute("title", "수주거래처조회");
		return "contract/buyerContractList";
	}
	//수주주문 등록
	@GetMapping("/addBuyerContract")
	public String addBuyerContract(Model model) {
		model.addAttribute("title", "수주거래처등록");
		return "contract/addBuyerContract";
	}
	//수주거래처 조회
	@GetMapping("/buyerList")
	public String buyerList(Model model) {
		model.addAttribute("title", "수주거래처조회");
		return "contract/buyerList";
	}
	//수주거래처 등록
	@GetMapping("/addBuyer")
	public String addBuyer(Model model) {
		model.addAttribute("title", "수주거래처등록");
		return "contract/addBuyer";
	}
	//원부자재 발주리스트
			@GetMapping("/supplierContractList")
			public String getRawmaterialsOrderList(Model model,@RequestParam(name = "supplierOrderSearchKey",required = false)String supplierOrderSearchKey
					,@RequestParam(name ="supplierOrderSearchValue",required = false )String supplierOrderSearchValue) {
				
				model.addAttribute("title","원부자재 발주 리트스");
				return"contract/!supplierContractList";
			}


		//원부자재 발주등록메서드
		@GetMapping("/supplierContract")
		public String rawMaterialsOrder(Model model) {
			model.addAttribute("title","원부자재발주등록");
			return "contract/!supplierContract";
		}
		
		//원부자재거래처목록경로메서드
			@GetMapping("/supplierList")
			public String getSupplierList(Model model
											,@RequestParam(name = "supplierSearchKey",required = false)String supplierSearchKey
											,@RequestParam(name ="supplierSearchValue",required = false )String supplierSearchValue) {
				
				model.addAttribute("title","거래처목록");
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("supplierSearchKey", supplierSearchKey);
				paramMap.put("supplierSearchValue", supplierSearchValue);
				
				return"contract/!supplierList";
			}
		
		
		//원자재거래처 등록 경로 메서드
		@GetMapping("/addSupplier")
		public String supplierAccount(Model model) {
			model.addAttribute("title", "원자재거래처등록");
			return"contract/!addSupplier";
		
		}
	
	@GetMapping("/contract")
	public String getContractmangement() {
		
		return "contract/contract";
	}

}
