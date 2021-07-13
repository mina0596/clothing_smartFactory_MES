package ksmart39.springboot.controller;



import java.sql.Array;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.ProductProductionProcessStatus;
import ksmart39.springboot.domain.ProductionPlan;
import ksmart39.springboot.domain.WorkOrder;
import ksmart39.springboot.service.ProductionPlanService;
import ksmart39.springboot.service.ProductionStatusService;
import ksmart39.springboot.service.WorkOrderService;

@Controller
@RequestMapping("/production")
public class ProductionController_PMA {

	
	private static final Logger log = LoggerFactory.getLogger(ProductionController_PMA.class);
	
	private final WorkOrderService workOrderService;
	private final ProductionPlanService productionPlanService;
	private final ProductionStatusService productionStatusService;
	
	public ProductionController_PMA(ProductionPlanService productionPlanService, WorkOrderService workOrderService,ProductionStatusService productionStatusService) {
		this.productionPlanService = productionPlanService;
		this.workOrderService = workOrderService;
		this.productionStatusService = productionStatusService;
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
}
