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
import ksmart39.springboot.service.ProductStateService;
import ksmart39.springboot.service.ProductionPlanService;
import ksmart39.springboot.service.ProductionStatusService;
import ksmart39.springboot.service.WorkOrderService;

@Controller
@RequestMapping("/production")
public class ProductionController_LHB {

	
	private static final Logger log = LoggerFactory.getLogger(ProductionController_LHB.class);
	
	private final ProductionStatusService productionStatusService;
	private final ProductStateService productStateService;
	
	public ProductionController_LHB(ProductionStatusService productionStatusService, ProductStateService productStateService) {
		this.productionStatusService = productionStatusService;
		this.productStateService = productStateService;
	}
	
	
	//[민아+한빛]작업지시별 생산 현황 조회
	@GetMapping("/stateByWorkOrder")
	public String getStateByWorkOrder(Model model) {
		List<Map<String, Object>> resultMap = productionStatusService.getProductionStatus();
		model.addAttribute("title","생산현황");
		model.addAttribute("productProductionProcessStatus",resultMap);
		log.info("resultMap :{}", resultMap);
		return "production/stateByWorkOrder";
	}

	//===================================================================

	@GetMapping("/detailedStateByProduct")
	public String getProductState(Model model) {
		List<Map<String,Object>> resultMap = productStateService.getProductState();
		model.addAttribute("title", "생산현황");
		model.addAttribute("productState", resultMap);
		log.info("resultMap:{}", resultMap);
		return "production/detailedStateByProduct";
	}
	
	
	

}
