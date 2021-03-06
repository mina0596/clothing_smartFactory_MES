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

	//???/?????? ????????????
	@GetMapping("/contract")
	public String getContractmangement() {
		
		return "contract/contract";
	}
	
	//----------------------------------------???????????????-----------------------------------------------------	
	 
	 //[??????] ????????? ??????
	 @PostMapping("/addBuyerOrderSize")
	 @ResponseBody
	 public Boolean addBuyerOrderSize(@RequestBody List<RequestedProductSize> requestedProductSize) {
		 log.info("???????????? ???????????? ??? : {}", requestedProductSize);
		 int result = contractAddBuyerOrderService.addBuyerOrderSize(requestedProductSize);
		 boolean resultB = false;
		 if(result>0) {
			 resultB = true;
		 }else {
			 resultB = false;
		 }
		 
		 return resultB;
	 }
		
	//[??????] ????????? ??????
	@PostMapping("/addBuyerOrder")
	@ResponseBody
	public boolean addBuyerOrder(@RequestBody List<RequestedProduct> requestedProduct) {
		log.info("???????????? ???????????? ???tes : {}", requestedProduct);
		int result = contractAddBuyerOrderService.addBuyerOrder(requestedProduct);
		boolean resultB = false;
		if(result>0) {
			resultB = true;
		}else {
			resultB = false;
		}
		
		return resultB;
	}
	
	//[??????]???????????? ?????? -> ??????
	@GetMapping("/addBuyerOrder")
	public String addBuyerOrder() {
		return "contract/addBuyerOrder";
	}
	
	//[??????] ????????? ?????? ?????? ?????? ????????????
	@PostMapping("/getMeasurementPart")
	@ResponseBody
	public List<RequiredSizeList> getMeasurementPart(@RequestParam(value = "detailCate")String detailCate){		
		return contractAddBuyerOrderService.getMeasurementPart(detailCate);
	}	
	
	// [??????] ????????? ?????? ????????? ????????????
	@PostMapping("/getDetailedCategorizedName")
	@ResponseBody
	public List<ProductCodeDetail> getDetailedCategorizedName(@RequestParam(value = "genderCategorizedCode")String genderCategorizedCode){
		List<ProductCodeDetail> result = contractAddBuyerOrderService.getDetailedCategorizedName(genderCategorizedCode);
		return result;
	}
	
	//[??????]????????? ?????? ??????/?????? ??????
	@GetMapping("/addInvoicePayment")
	public String addInvoicePayment() {
		return "contract/addInvoicePayment";
	}
	
	//[??????]??????/?????? ?????? ??????
	@GetMapping("/addInvoiceClaim")
	public String addInvoiceClaim() {
		return "contract/addInvoiceClaim";
	}
	
	//[??????] ?????? ??????/?????? ??????
	@GetMapping("/expectedPaymentList")
	public String getExpectedPaymentList() {
		return "contract/expectedPaymentList";
	}

	
	//[??????] ?????? ??????
	@GetMapping("/addInvoiceApproval")
	public String addInvoiceApproval() {
		return "contract/addInvoiceApproval";
	}

	//[??????]?????? ?????? ?????? ??????
	@GetMapping("/invoiceApprovalList")
	public String getInvoiceApprovalList() {
		return "contract/invoiceApprovalList";
	}
	
	//[??????]????????? ??????
	@GetMapping("/buyerOrderList")
	public String getOrderList(Model model) {
		List<Map<String,Object>> orderList = orderService.getOrderList();
		model.addAttribute("title", "????????????");
		model.addAttribute("orderList",orderList);
		return "contract/buyerOrderList";
	}		

	//[??????]?????? ????????? ??????
	@GetMapping("/modifyBuyerOrder")
	public String modifyBuyerOrder(Model model) {
		model.addAttribute("title", "????????????");
		return "contract/modifyBuyerOrder"; 
	}	
	
	//[??????]???????????? ??????
	@GetMapping("/addBuyerContract")
	public String addBuyerContract(Model model) {
		model.addAttribute("title", "????????????");
		return "contract/addBuyerContract";
	}
	
	//[??????]???????????? ?????? -> ??????
	@PostMapping("/addBuyerContract")
	public String addBuyerContract() {
		return "redirect:buyerContractList";
	}
	
	//[??????]???????????? ??????
	@GetMapping("/buyerContractList")
	public String getBuyerContract(Model model) {
		List<Map<String, Object>> buyerContractList = contractService.getBuyerContract();
		model.addAttribute("buyerContractList", buyerContractList);
		return "contract/buyerContractList";
	}
	
	
	//[??????]?????? ????????? ??????
	@GetMapping("/modifyBuyerContract")
	public String modifyBuyerContract(Model model) {
		model.addAttribute("title", "????????????");
		return "contract/modifyBuyerContract"; 
	}
	
	//[??????]???????????? ?????? -> ??????
	@PostMapping("/modifyBuyerContract")
	public String modifyBuyerContract() {
		return "redirect:buyerContractList";
	}
	
	//[??????]???????????? ?????? -> ??????
	@PostMapping("/modifyBuyerOrder")
	public String modifyBuyerOrder() {
		return "redirect:buyerOrderList";
	}
	
	//[??????]????????????
	@GetMapping("/buyerOrderApproval")
	public String getExWarehousingList(Model model) {
		List<Map<String,Object>> approvalList = requestedProductService.getRequestedProductApproval();
		model.addAttribute("approvalList",approvalList);
		return "contract/buyerOrderApproval";
	}

	
	//[??????]?????? ????????? ?????????!
	@GetMapping("/buyerOrderInfo")
	public String getBuyerOrderInfo(@RequestParam(name = "prCode", required = false) String prCode, Model model) {
		model.addAttribute("title", "????????????");
		return "contract/buyerOrderInfo";
	}	
	
	//[??????]??????????????? ????????? ???
	@PostMapping("/completeRequest")
	@ResponseBody
	public boolean completeRequest(@RequestParam(name = "productRequestCode", required = false) String productRequestCode) {
		boolean approval = false;
		
		int result = requestedProductService.completeRequest(productRequestCode);
		
		if(result > 0) approval = true;
		
		return approval;
	}
	//------------------------------------------------------??????----------------------------------------------------------

	//[??????]??????????????????
	@PostMapping("/deleteSupplierContract")
	public String deleteSupplierContract() {
		return "redirect:/supplierContractList";
	}
	
	
	//[??????]???????????? ??????????????? ???????????? ????????? ???????????? ?????? ?????????
	@GetMapping("/supplierContractInfo")
	public String getSupplierContractInfo() {
	
	return "contract/supplierContractInfo";
	}
	//[??????]???????????? ?????? ?????? ?????? ??????
	@PostMapping("/modifySupplierContract")
	public String modifySupplierContract(Model model) {
		return"redirect:/supplierContractList";
	}
	//[??????]???????????? ?????? ?????????????????????
	@GetMapping("/modifySupplierContract")
	public String modifySupplierContract() {
		
		return "contract/modifySupplierContract";
	}
	//[??????]???????????? ?????????????????????
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

	
	//[??????]???????????? ?????? ?????? ?????? 
	@PostMapping("/addSupplierContract")
	public String addSupplierContract(Model model) {
		return"redirect/supplierContractList";
	}
	
	//[??????]???????????? ?????? ?????? ?????? 
	@GetMapping("/addSupplierContract")
	public String addSupplierContract() {
		return"contract/addSupplierContract";
	}
	
	//[??????]?????? ?????? ??????
	@PostMapping("/deleteSupplierRequest")
	public String deleteSupplierRequest() {
		
		return "redirect:/supplierRequestList";
	}
	//[??????] ?????? ????????? ??????
	@GetMapping("/supplierRequestList")
	public String supplierRequestList(Model model) {
		 List<Map<String,Object>> resultList = supplierService.getSupplierRequestList();
		 log.info("========================================");
		 log.info("supplierRequestList{}",resultList);
		 log.info("========================================");
		
		 model.addAttribute("supplierRequestList", resultList);
		 
		return "contract/supplierRequestList";
	}
	//[??????]?????? ?????? ?????? ??????
	@PostMapping("/modifySupplierRequest")
	public String modifySupplierRequest() {
		return"redirect:/supplierRequestList";
	}
	//[??????] ?????? ?????? ?????? 
	@GetMapping("/modifySupplierRequest")
	public String modifySupplierRequest(Model model,@RequestParam(value= "rawMaterialOrder",required = false)String rawMaterialOrder) {
		SupplierRequest supplierRequest = supplierService.getSupplierRequestInfo(rawMaterialOrder);
		 model.addAttribute("supplierRequest", supplierRequest);
		return "contract/modifySupplierRequest";
	}
	//[??????]???????????? ???????????? ??????
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
	//[??????]???????????? ???????????? ???????????? ?????? ??????
	@RequestMapping(value = "searchRawMaterial",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchRawMaterial(@RequestParam(value = "selectSupplierName",required = false)String supplierName){
		
		List<Map<String,Object>> clientRawMaterial = supplierService.searchRawMaterial(supplierName);
		return clientRawMaterial;
	}
	//[??????]???????????? ???????????? ????????? ??????
	@RequestMapping(value = "searchSupplierClientCate", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchSupplierClientCate(@RequestParam(value = "clientName",required = false)String client){
		List<Map<String,Object>> clientList = supplierService.searchSupplierClientCate(client);
		return clientList;
	}
	
	
	//[??????]???????????? ?????????????????????
	@GetMapping("/addSupplierRequest")
	public String addSupplierRequest(Model model) {
		List<Map<String,Object>> inventoryStatusList = materialsInventoryStatusService.getInventoryStatusByMCode();
		model.addAttribute("inventoryStatusList", inventoryStatusList);
		 
		return "contract/addSupplierRequest";
	}


}
