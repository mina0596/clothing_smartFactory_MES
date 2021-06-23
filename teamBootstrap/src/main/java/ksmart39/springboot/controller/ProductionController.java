package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductionController {

	
	//[민아]완제품 등록
	@GetMapping("/addCompletedProduct")
	public String addCompletedProduct() {
		return "production/addCompletedProduct";
	}
	
	//[민아]완제품 목록
	@GetMapping("/completedProductList")
	public String getCompletedProductList() {
		return "production/completedProductList";
	}
	
	//[보람]작업지시정보
	@GetMapping("/workOrderInfo")
	public String workOrderInfo() {
		return "production/workOrderInfo";
	}
	//[보람]작업지시 목록
	@GetMapping("/workOrderList")
	public String workerOrderList() {
		
		/*
		 * model.addAttribute("title", "작업지시관리: 작업지시목록"); Map<String, Object> paramMap =
		 * new HashMap<String, Object>(); paramMap.put("workOrderSearchKey",
		 * workOrderSearchKey); paramMap.put("workOrderSearchValue",
		 * workOrderSearchValue);
		 */
		return "production/workOrderList";
	}
	
	//[보람]작업지시등록
	@GetMapping("/addWorkOrder")
	public String addWorkerOrder(Model model) {
		model.addAttribute("title", "작업지시관리: 작업지시등록");
		return "production/addWorkOrder";
	}

	//[민아]생산공정 등록
	@GetMapping("/addProductionProcess")
	public String addProductionProcess() {
		return "production/addProductionProcess";
	}
	
	//[민아]생산공정 목록
	@GetMapping("/productionProcessList")
	public String getProductionProcessList() {
		return "production/productionProcessList";
	}
	
	//[다미]생산계획 목록
	@GetMapping("/productionPlanList")
	public String productioncontrolList(){
		return "production/productionPlanList";
	}
	
	//[다미]생산계획 등록
	@GetMapping("/addProductionPlan")
	public String productioncontrolAdd() {
		return "production/addProductionPlan";
	}
	
	//생산관리 메인화면
	@GetMapping("/production")
	public String getProdcutioncontrol () {
		
		return "production/production";
		
	}
}
