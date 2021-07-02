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
	
	//[민아]수주계약 등록 -> 조회
	@GetMapping("/addBuyerOrder_Minah")
	public String addBuyerOrder_Minah() {
		return "contract/addbuyerOrder_Minah";
	}
	
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/addBuyerOrder")
	public String addBuyerOrder() {
		return "redirect:/buyerOrderList";
	}
	
	//[한빛]수주 주문서 승인완료 목록
	@GetMapping("/buyerOrderApproval")
	public String buyerOrderApproval(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderApproval";
	}	
	
	//[한빛]수주 주문서 상세로!
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
	
	//------------------------------------------------------발주----------------------------------------------------------
	//to[보람] 원부자재라는 단어를 발주로 바꿔주세요 + 메서드명이랑 경로랑 이름 연관성있게 from [민아]
	//[보람]원부자재 발주리스트 발주코드 클릭시 발주정보 경로 메서드
	@GetMapping("/supplierContractInfo")
	public String getSupplierContractInfo() {
	
	return "contract/supplierContractInfo";
	}
	//[보람]원부자재 발주 계약 수정 완료
	@PostMapping("/modifySupplierContract")
	public String modifySupplierContractCompelte() {
		return"redirect:/supplierContractList";
	}
	//[보람]원부자재 발주 계약수정메서드
	@GetMapping("/modifySupplierContract")
	public String supplierContractModify() {
		
		return "contract/modifySupplierContract";
	}
	//[보람]원부자재 발주계약리스트
	@GetMapping("/supplierContractList")
	public String getRawmaterialsOrderList(Model model,@RequestParam(name = "supplierOrderSearchKey",required = false)String supplierOrderSearchKey
			,@RequestParam(name ="supplierOrderSearchValue",required = false )String supplierOrderSearchValue) {
		
		model.addAttribute("title","원부자재 발주 리트스");
		return"contract/supplierContractList";
	}

	
	//[보람]원부자재 발주 계약 완료 
	@PostMapping("/addSupplierContract")
	public String addSupplierContractCompelte() {
		return"redirect/supplierContractList";
	}
	
	//[보람]원부자재 발주 계약 등록 
	@GetMapping("/addSupplierContract")
	public String addSupplierContract() {
		return"contract/addSupplierContract";
	}
	
	//[보람] 발주 리스트 경로
	@GetMapping("/supplierRequestList")
	public String supplierRequestList() {
		return "contract/supplierRequestList";
	}
	//[보람]발주 수정 완료 경로
	@PostMapping("/modifySupplierRequest")
	public String modifySupplierRequestComplete() {
		return"redirect:/supplierRequestList";
	}
	//[보람] 발주 수정 경로 
	@GetMapping("/modifySupplierRequest")
	public String modifySupplierRequest() {
		return "contract/modifySupplierRequest";
	}
	//[보람]원부자재 발주등록 완료
	@PostMapping("/addSupplierRequest")
	public String addSupplierRequestComplete() {
		return "redirect:/supplierRequestList";
	}
	
	//[보람]원부자재 발주등록메서드
	@GetMapping("/addSupplierRequest")
	public String rawMaterialsOrder(Model model) {
		
		return "contract/addSupplierRequest";
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

	
	// 결제 등록
	@GetMapping("/addInvoiceApproval")
	public String addInvoiceApproval() {
		return "contract/addInvoiceApproval";
	}

	// 결제 승인 현황 목록
	@GetMapping("/invoiceApprovalList")
	public String getInvoiceApprovalList() {
		return "contract/invoiceApprovalList";
	}
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
	

	//수/발주 메인화면
	@GetMapping("/contract")
	public String getContractmangement() {
		
		return "contract/contract";
	}

}
