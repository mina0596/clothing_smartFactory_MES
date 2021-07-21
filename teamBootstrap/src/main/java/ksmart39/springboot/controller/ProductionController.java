package ksmart39.springboot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart39.springboot.service.ProductionPlanService;
import ksmart39.springboot.service.ProductionStatusService;
import ksmart39.springboot.service.WorkOrderService;

@Controller
@RequestMapping("/production")
public class ProductionController {

	
	private static final Logger log = LoggerFactory.getLogger(ProductionController.class);
	
	private final WorkOrderService workOrderService;
	private final ProductionPlanService productionPlanService;
	private final ProductionStatusService productionStatusService;
	
	public ProductionController(ProductionPlanService productionPlanService, WorkOrderService workOrderService,ProductionStatusService productionStatusService) {
		this.productionPlanService = productionPlanService;
		this.workOrderService = workOrderService;
		this.productionStatusService = productionStatusService;
	}
	


	
	
	
	//생산관리 메인화면
	@GetMapping("/production")
	public String getProdcutioncontrol () {
		
		return "production/production";
		
	}
}
