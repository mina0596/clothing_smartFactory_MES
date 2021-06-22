package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductionController {
	//작업지시 목록
		@GetMapping("/workOrderList")
		public String workerOrderList(Model model,@RequestParam(name = "workOrderSearchKey",required = false)String workOrderSearchKey
				,@RequestParam(name ="workOrderSearchValue",required = false )String workOrderSearchValue) {
			
			model.addAttribute("title", "작업지시관리: 작업지시목록");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("workOrderSearchKey", workOrderSearchKey);
			paramMap.put("workOrderSearchValue", workOrderSearchValue);
			return "production/!workOrderList";
		}
		//작업지시등록
		@GetMapping("/addWorkOrder")
		public String addWorkerOrder(Model model) {
			model.addAttribute("title", "작업지시관리: 작업지시등록");
			return "production/!addWorkOrder";
		}

	
	@GetMapping("/addProductionProcess")
	public String addProductionProcess() {
		return "production/addProductionProcess";
	}
	
	@GetMapping("/productionProcessList")
	public String getProductionProcessList() {
		return "production/productionProcessList";
	}
	
	@GetMapping("/productioncontrolList")
	public String productioncontrolList(){
		return "production/productioncontrolList";
	}
	
	@GetMapping("/productioncontrolAdd")
	public String productioncontrolAdd() {
		return "production/productioncontrolAdd";
	}
	
	@GetMapping("/production")
	public String getProdcutioncontrol () {
		
		return "production/production";
		
	}
}
