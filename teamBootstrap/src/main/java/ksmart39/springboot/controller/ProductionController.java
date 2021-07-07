package ksmart39.springboot.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.ProductionPlan;
import ksmart39.springboot.service.ProductionPlanService;
import ksmart39.springboot.service.ProductionService;

@Controller
public class ProductionController {

	
	private static final Logger log = LoggerFactory.getLogger(ProductionController.class);
	
	private final ProductionPlanService productionPlanService;
	
	public ProductionController(ProductionPlanService productionPlanService) {
		this.productionPlanService = productionPlanService;
	}
	
	//[민아+한빛]의뢰품목별 상세 생산 공정 현황 등록
	@GetMapping("/productionOrderList")
	public String productionOrderList() {
		return "production/productionOrderList";
	}
	
	//[민아+한빛]의뢰품목별 상세 생산 공정 현황 등록
	@GetMapping("/test")
	public String test() {
		return "production/test";
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
	
	//[다미]생산계획 등록
	@PostMapping("/addProductionPlan")
	public String productioncontrolAdd(ProductionPlan productionPlan) {
		log.info("=============================================");
		log.info("화면에서 받아온 값:            {}", productionPlan);
		log.info("=============================================");
		
		productionPlanService.addProductionPlan(productionPlan);
		
		return "redirect:/productionPlanList";
	}
	
	//[다미]성별별 양복명에 맞는 소분류 가져오기
	@RequestMapping(value = "/detailCode", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getDetailCode(@RequestParam(value = "gender", required = false)String gender){
		List<Map<String, Object>> name = productionPlanService.getDetailCode(gender);
		log.info("=============================================");
		log.info("화면에서 받아온 값:            {}", gender);
		log.info("생산코드 조회 :            {}", name);
		log.info("=============================================");
		
		return name;
	}
	
	//[다미] 성별별 양복명 값 가져오기
	@RequestMapping(value="/productCode", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getProductionCode() {
		List<Map<String, Object>> list = productionPlanService.getProductCode();
		log.info("=============================================");
		log.info("생산코드 조회 :            {}", list);
		log.info("=============================================");
		return list;
	}
	
	
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
		return productionPlanService.getProductionMonthlyPlanList();
	}

	//[다미]전체 생산계획 목록
	@GetMapping("/productionPlanList")
	public String productionPlanList(Model model) {
		List<Map<String, Object>> resultMap = productionPlanService.getProductionAllPlanList();
		log.info("==============================================");
		log.info("전체 생산계획 목록:         {}", resultMap);
		log.info("==============================================");
		
		model.addAttribute("list", resultMap);
		
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
