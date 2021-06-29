package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContractController {
	//----------------------------------------수주주문서-----------------------------------------------------
	
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/addBuyerOrder")
	public String addBuyerOrder() {
		return "redirect:/buyerOrderList";
	}
	
	//[한빛]수주 주문서 수정
	@GetMapping("/buyerOrderInfo")
	public String buyerOrderInfo(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderInfo";
	}	
	//[한빛]수주 주문서 수정
	@GetMapping("/modifyBuyerOrder")
	public String modifyBuyerOrder(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderList";
	}	
	
	//[한빛]수주 주문서 조회
	@GetMapping("/buyerOrderList")
	public String buyerOrderList(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderList";
	}		
	
	//[한빛]수주 주문서 등록
	@GetMapping("/addBuyerOrder")
	public String addBuyerOrder(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerOrder";
	}	
	//---------------------------------------수주계약---------------------------------------------------------
	//[한빛] 수주계약 수정
	@GetMapping("/modifyBuyerContract")
	public String modifyBuyerContract() {
		return"contract/modifyBuyerContract";
	}
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/addBuyerContract")
	public String addBuyerContract() {
		return "redirect:/buyerContractList";
	}
	
	//[한빛]수주계약 조회
	@GetMapping("/buyerContractList")
	public String buyerContractList(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerContractList";
	}
	
	
	//[한빛]수주계약 등록
	@GetMapping("/addBuyerContract")
	public String addBuyerContract(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerContract";
	}
	//------------------------------------------수주의뢰---------------------------------------------------------
	//[한빛] 수주의뢰 수정
	@GetMapping("/modifyBuyerRequest")
	public String modifyBuyerRequest() {
		return"contract/modifyBuyerRequest";
	}
	//[한빛]수주의뢰 조회
	@GetMapping("/buyerRequestList")
	public String buyerRequestList(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerRequestList";
	}
	//[한빛]수주주문등록 ->목록으로 이동
	@PostMapping("/addBuyerRequest")
	public String addBuyerRequest() {
		return "redirect:/buyerRequestList";
	}
		
	//[한빛]수주의뢰 등록
	@GetMapping("/addBuyerRequest")
	public String addBuyerRequest(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerRequest";
	}
	
	//---------------------------------------------수주거래처------------------------------------------------------
	//[한빛]수주주문등록 ->목록으로 이동
	@PostMapping("/addBuyer")
	public String addBuyer() {
		return "redirect:/buyerList";
	}
	
	//[한빛] 수주거래처 수정
	@GetMapping("/modifyBuyer")
	public String modifyBuyer() {
		return"contract/modifyBuyer";
	}
	
	//[한빛]수주거래처 조회
	@GetMapping("/buyerList")
	public String buyerList(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerList";
	}

	//[한빛]수주거래처 등록
	@GetMapping("/addBuyer")
	public String addBuyer(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyer";
	}
	//------------------------------------------------------발주----------------------------------------------------------
	//to[보람] 원부자재라는 단어를 발주로 바꿔주세요 + 메서드명이랑 경로랑 이름 연관성있게 from [민아]
	//[보람]원부자재 발주리스트 발주코드 클릭시 발주정보 경로 메서드
	@GetMapping("/supplierContractInfo")
	public String getSupplierContractInfo() {
		
		return "contract/supplierContractInfo";
	}
	//[보람]원부자재 발주 수정메서드
	@GetMapping("/supplierContractModify")
	public String supplierContractModify() {
		
		return "contract/supplierContractModify";
	}
	//[보람]원부자재 발주리스트
	@GetMapping("/supplierContractList")
	public String getRawmaterialsOrderList(Model model,@RequestParam(name = "supplierOrderSearchKey",required = false)String supplierOrderSearchKey
			,@RequestParam(name ="supplierOrderSearchValue",required = false )String supplierOrderSearchValue) {
		
		model.addAttribute("title","원부자재 발주 리트스");
		return"contract/supplierContractList";
	}

	

	//[보람]원부자재 발주등록메서드
	@GetMapping("/addSupplierContract")
	public String rawMaterialsOrder(Model model) {
		model.addAttribute("title","원부자재발주등록");
		return "contract/addSupplierContract";
	}
	
	//[보람]원부자재 거래처 리스트에서 코드 클릭시 거래처정보 경로 메서드
	@GetMapping("/supplierInfo")
	public String getSupplierInfo() {
		
		return "contract/supplierInfo";
	}
	
	//[보람]원부자재거래처목록경로메서드
	@GetMapping("/supplierList")
	public String getSupplierList(Model model) {
									
		model.addAttribute("title","거래처목록");
		return"contract/supplierList";
	}
	
	//[보람]원부자재 거래처 수정 경로 메서드 DB연결되면제대로할예정
	@GetMapping("/supplierModify")
	public String supplierModify() {
		return"contract/supplierModify";
	}
	
	//[보람]원부자재 거래처 등록후 redirect
	@PostMapping("/addSuppler")
	public String addsuplier() {
		
		return"redirect:/supplierList";
	}
	//[보람]원자재거래처 등록 경로 메서드
	@GetMapping("/addSupplier")
	public String supplierAccount(Model model) {
		model.addAttribute("title", "수/발주관리");
		return"contract/addSupplier";
	
	}

	//수/발주 메인화면
	@GetMapping("/contract")
	public String getContractmangement() {
		
		return "contract/contract";
	}

}
