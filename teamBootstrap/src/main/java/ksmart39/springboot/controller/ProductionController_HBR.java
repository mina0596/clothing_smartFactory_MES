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
public class ProductionController_HBR {

	
	private static final Logger log = LoggerFactory.getLogger(ProductionController_HBR.class);
	
	private final WorkOrderService workOrderService;
	private final ProductionPlanService productionPlanService;
	private final ProductionStatusService productionStatusService;
	
	public ProductionController_HBR(ProductionPlanService productionPlanService, WorkOrderService workOrderService,ProductionStatusService productionStatusService) {
		this.productionPlanService = productionPlanService;
		this.workOrderService = workOrderService;
		this.productionStatusService = productionStatusService;
	}
	

	
	//=====================================================================
	
	
	//[보람]작업지시삭제
	@PostMapping("/deleteWorkOrder")
	public String deleteWorkOrder() {
		
		return "redirect:/workOrderList";
	}

	/*
	 * //[보람]작업지시수정
	 * 
	 * @GetMapping("/modifyWorkOrder") public String modifyWorkOrder() {
	 * 
	 * return "redirect:/workOrderList"; }
	 */
	//[보람]작업지시수정
	@GetMapping("/modifyWorkOrder")
	public String modifyWorkOrder(Model model) {
		
		return "production/workOrderList";
	}
	
	//[보람]작업지시정보
	@GetMapping("/workOrderInfo")
	public String workOrderInfo() {
		return "production/workOrderInfo";
	}
	
	
	//[보람]작업지시등록
	@GetMapping("/addWorkOrder")
	public String addWorkerOrder(Model model) {
		model.addAttribute("title", "작업지시관리: 작업지시등록");
		return "production/addWorkOrder";
	}

	

}
