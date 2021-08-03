package ksmart39.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.ProductCodeDetail;
import ksmart39.springboot.domain.RequestedProduct;
import ksmart39.springboot.domain.RequestedProductSize;
import ksmart39.springboot.domain.RequiredSizeList;
import ksmart39.springboot.service.ContractAddBuyerOrderService;


@Controller
@RequestMapping("/contract")
public class ContractController_KDM {
	
	
	private static final Logger log = LoggerFactory.getLogger(ContractController_KDM.class);

	
	@Autowired
	private final ContractAddBuyerOrderService contractAddBuyerOrderService;
	
	
	 @Autowired public ContractController_KDM(ContractAddBuyerOrderService contractAddBuyerOrderService) {
	 this.contractAddBuyerOrderService = contractAddBuyerOrderService;
	 }
	 
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
	
	// [다미] 전표 목록
	@GetMapping("/paymentInvoiceList")
	public String paymentInvoiceList(Model model) {
		return "contract/paymentInvoiceList";
	}

	// [다미] 전표 등록 화면
	@GetMapping("/addPaymentInvoice")
	public String addPaymentInvoice(Model model) {
		return "contract/addPaymentInvoice";
	}
	



}
