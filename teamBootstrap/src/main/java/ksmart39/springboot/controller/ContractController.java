package ksmart39.springboot.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.ProductCodeDetail;
import ksmart39.springboot.domain.RequestedProduct;
import ksmart39.springboot.domain.RequestedProductSize;
import ksmart39.springboot.domain.RequiredSizeList;
import ksmart39.springboot.domain.SupplierRequest;
import ksmart39.springboot.service.ContractAddBuyerOrderService;
import ksmart39.springboot.service.ContractService;
import ksmart39.springboot.service.OrderService;
import ksmart39.springboot.service.RawMaterialsInventoryStatusService;
import ksmart39.springboot.service.RequestedProductService;
import ksmart39.springboot.service.SupplierService;


@Controller
@RequestMapping("/contract")
public class ContractController {
	
	@Autowired
	private final SupplierService supplierService;
	private final RequestedProductService requestedProductService;
	private final OrderService orderService;
	private final ContractService contractService;
	private final ContractAddBuyerOrderService contractAddBuyerOrderService;
	private final RawMaterialsInventoryStatusService materialsInventoryStatusService;
	
	 @Autowired public ContractController(SupplierService supplierService
			 							, RequestedProductService requestedProductService
			 							, OrderService orderService
			 							, ContractService contractService
			 							, ContractAddBuyerOrderService contractAddBuyerOrderService
			 							, RawMaterialsInventoryStatusService materialsInventoryStatusService) {
	 this.supplierService = supplierService;
	 this.requestedProductService = requestedProductService;
	 this.orderService = orderService;
	 this.contractService = contractService;
	 this.contractAddBuyerOrderService = contractAddBuyerOrderService;
	 this.materialsInventoryStatusService = materialsInventoryStatusService;
	 }
	 
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);	

	//수/발주 메인화면
	@GetMapping("/contract")
	public String getContractmangement() {
		
		return "contract/contract";
	}
	
	//----------------------------------------수주주문서-----------------------------------------------------	
	 
	 //[다미] 주문서 등록
	 @PostMapping("/addBuyerOrderSize")
	 @ResponseBody
	 public Boolean addBuyerOrderSize(@RequestBody List<RequestedProductSize> requestedProductSize) {
		 log.info("화면에서 받아오는 값 : {}", requestedProductSize);
		 int result = contractAddBuyerOrderService.addBuyerOrderSize(requestedProductSize);
		 boolean resultB = false;
		 if(result>0) {
			 resultB = true;
		 }else {
			 resultB = false;
		 }
		 
		 return resultB;
	 }
		
	//[다미] 주문서 등록
	@PostMapping("/addBuyerOrder")
	@ResponseBody
	public boolean addBuyerOrder(@RequestBody List<RequestedProduct> requestedProduct) {
		log.info("화면에서 받아오는 값tes : {}", requestedProduct);
		int result = contractAddBuyerOrderService.addBuyerOrder(requestedProduct);
		boolean resultB = false;
		if(result>0) {
			resultB = true;
		}else {
			resultB = false;
		}
		
		return resultB;
	}
	
	//[다미]수주계약 등록 -> 조회
	@GetMapping("/addBuyerOrder")
	public String addBuyerOrder() {
		return "contract/addBuyerOrder";
	}
	
	//[다미] 품목에 따른 측정 부위 가져오기
	@PostMapping("/getMeasurementPart")
	@ResponseBody
	public List<RequiredSizeList> getMeasurementPart(@RequestParam(value = "detailCate")String detailCate){		
		return contractAddBuyerOrderService.getMeasurementPart(detailCate);
	}	
	
	// [다미] 성별에 따른 품목들 가져오기
	@PostMapping("/getDetailedCategorizedName")
	@ResponseBody
	public List<ProductCodeDetail> getDetailedCategorizedName(@RequestParam(value = "genderCategorizedCode")String genderCategorizedCode){
		List<ProductCodeDetail> result = contractAddBuyerOrderService.getDetailedCategorizedName(genderCategorizedCode);
		return result;
	}
	
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
		return "contract/modifyBuyerOrder"; 
	}	
	
	//[한빛]수주계약 등록
	@GetMapping("/addBuyerContract")
	public String addBuyerContract(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerContract";
	}
	
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/addBuyerContract")
	public String addBuyerContract() {
		return "redirect:buyerContractList";
	}
	
	//[한빛]수주계약 조회
	@GetMapping("/buyerContractList")
	public String getBuyerContract(Model model) {
		List<Map<String, Object>> buyerContractList = contractService.getBuyerContract();
		model.addAttribute("buyerContractList", buyerContractList);
		return "contract/buyerContractList";
	}
	
	
	//[한빛]수주 주문서 수정
	@GetMapping("/modifyBuyerContract")
	public String modifyBuyerContract(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/modifyBuyerContract"; 
	}
	
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/modifyBuyerContract")
	public String modifyBuyerContract() {
		return "redirect:buyerContractList";
	}
	
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/modifyBuyerOrder")
	public String modifyBuyerOrder() {
		return "redirect:buyerOrderList";
	}
	
	//[한빛]출고현황
	@GetMapping("/buyerOrderApproval")
	public String getExWarehousingList(Model model) {
		List<Map<String,Object>> approvalList = requestedProductService.getRequestedProductApproval();
		model.addAttribute("approvalList",approvalList);
		return "contract/buyerOrderApproval";
	}

	
	//[한빛]수주 주문서 상세로!
	@GetMapping("/buyerOrderInfo")
	public String getBuyerOrderInfo(@RequestParam(name = "prCode", required = false) String prCode, Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderInfo";
	}	
	
	//[한빛]미승인버튼 눌렀을 때
	@PostMapping("/completeRequest")
	@ResponseBody
	public boolean completeRequest(@RequestParam(name = "productRequestCode", required = false) String productRequestCode) {
		boolean approval = false;
		
		int result = requestedProductService.completeRequest(productRequestCode);
		
		if(result > 0) approval = true;
		
		return approval;
	}
	//------------------------------------------------------발주----------------------------------------------------------

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
	public String getSupplierContractList(Model model,@RequestParam(name = "supplierOrderSearchKey",required = false)String supplierOrderSearchKey
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
	public String modifySupplierRequest(Model model,@RequestParam(value= "rawMaterialOrder",required = false)String rawMaterialOrder) {
		SupplierRequest supplierRequest = supplierService.getSupplierRequestInfo(rawMaterialOrder);
		 model.addAttribute("supplierRequest", supplierRequest);
		return "contract/modifySupplierRequest";
	}
	//[보람]원부자재 발주등록 완료
	@PostMapping("/addSupplierRequest")
	public String addSupplierRequest(@RequestParam(name = "rawMeterialCode",required = false)String rawMeterialCode,
									@RequestParam(name = "supplierClient",required = false)String supplierClient,
									@RequestParam(name = "chargeEmployeeCode", required = false)String chargeEmployeeCode,
									@RequestParam(name = "rawMaterialAmount",required = false)int rawMaterialAmount,
									@RequestParam(name = "rawMaterialOrderExpected",required = false)String rawMaterialOrderExpected) {
		log.info("========================================");
		  log.info("rawMeterialCode {}:",rawMeterialCode);
		  log.info("supplierClient {}:",supplierClient);
		  log.info("chargeEmployeeCode {}:",chargeEmployeeCode);
		  log.info("rawMaterialAmount {}:",rawMaterialAmount);
		  log.info("========================================");
		supplierService.addSupplierRequest(rawMeterialCode, supplierClient, chargeEmployeeCode, rawMaterialAmount, rawMaterialOrderExpected);
		return "redirect:/contract/supplierRequestList";
	}
	//[보람]원부자재 발주요청 거래처별 자재 조회
	@RequestMapping(value = "searchRawMaterial",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchRawMaterial(@RequestParam(value = "selectSupplierName",required = false)String supplierName){
		
		List<Map<String,Object>> clientRawMaterial = supplierService.searchRawMaterial(supplierName);
		return clientRawMaterial;
	}
	//[보람]원부자재 발주요청 거래처 조회
	@RequestMapping(value = "searchSupplierClientCate", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchSupplierClientCate(@RequestParam(value = "clientName",required = false)String client){
		List<Map<String,Object>> clientList = supplierService.searchSupplierClientCate(client);
		return clientList;
	}
	
	
	//[보람]원부자재 발주요청메서드
	@GetMapping("/addSupplierRequest")
	public String addSupplierRequest(Model model) {
		List<Map<String,Object>> inventoryStatusList = materialsInventoryStatusService.getInventoryStatusByMCode();
		model.addAttribute("inventoryStatusList", inventoryStatusList);
		 
		return "contract/addSupplierRequest";
	}


}
