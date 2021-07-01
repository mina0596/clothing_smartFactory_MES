package ksmart39.springboot.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.ProductionPlan;
import ksmart39.springboot.service.ProductionService;

@Controller
public class ProductionController {

	
	private static final Logger log = LoggerFactory.getLogger(ProductionController.class);
	
	private final ProductionService productionService;
	
	public ProductionController(ProductionService productionService) {
		this.productionService = productionService;
	}
	
	//================================================================
	//[민아+한빛]의뢰품목별 상세 생산 공정 현황 등록
	@GetMapping("/productProgressList")
	public String getproductProgressList() {
		return "production/productProgressList";
	}
	
	//[민아+한빛]의뢰품목별 상세 생산 공정 현황 조회
	@GetMapping("/detailedStateByProduct")
	public String getDetailedStateByProduct() {
		return "production/detailedStateByProduct";
	}
	
	//[민아+한빛]의뢰품목별 생산 현황 조회
	@GetMapping("/stateByProduct")
	public String getStateByProduct() {
		return "production/stateByProduct";
	}
	
	//[민아+한빛]작업지시별 생산 현황 조회
	@GetMapping("/stateByWorkOrder")
	public String getStateByWorkOrder() {
		return "production/stateByWorkOrder";
	}
	
	//[민아+한빛]생산계획별 생산 현황 조회
	@GetMapping("/stateByProductionPlan")
	public String getStateByProductionPlan() {
		return "production/stateByProductionPlan";
	}
	
	//===================================================================
	//[민아]완제품 수정
	@GetMapping("/modifyCompletedProduct")
	public String modifyCompletedProduct() {
		return "production/modifyCompletedProduct";
	}
	
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
	
	//=====================================================================
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

	
	//================================================================
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
	
	
	//==================================================================
	//[다미]생산계획 일별 목록
	@GetMapping("/productionDailyPlanList")
	public String productionDailyPlanList() {
		return "production/productionDailyPlanList";
	}
	
	//[다미]생산계획 주간별 목록
	@GetMapping("/productionWeeklyPlanList")
	public String productionWeeklyPlanList() {
		return "production/productionWeeklyPlanList";
	}
	
	//[다미]생산계획 월별 목록
	@GetMapping("/productionMonthlyPlanList")
	public String getProductionMonthlyPlanList(Model model) {
//		List<ProductionPlan> monthlyResult = productionService.getProductionMonthlyPlanList();
//		log.info("=================================================");
//		log.info("생산 계획 받아온 값 : {}", monthlyResult);
//		log.info("=================================================");
		return "production/productionMonthlyPlanList";
	}
	
	//[다미]생산계획 월별 목록test
	@ResponseBody
	@RequestMapping(value="/productionMonthlyPlanList", method = RequestMethod.POST)
	public List<ProductionPlan> getProductionMonthlyPlanList(){
		return productionService.getProductionMonthlyPlanList();
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
	
	
	//====================================================================
	//생산관리 메인화면
	@GetMapping("/production")
	public String getProdcutioncontrol () {
		
		return "production/production";
		
	}
}
