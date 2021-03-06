package ksmart39.springboot.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.CompletedProduct;
import ksmart39.springboot.domain.ProductProductionProcessStatus;
import ksmart39.springboot.domain.ProductionPlan;
import ksmart39.springboot.domain.WorkOrder;
import ksmart39.springboot.service.CompletedProductService;
import ksmart39.springboot.service.ProductStateService;
import ksmart39.springboot.service.ProductionPlanService;
import ksmart39.springboot.service.ProductionService;
import ksmart39.springboot.service.ProductionStatusByProductionPlanService;
import ksmart39.springboot.service.ProductionStatusService;
import ksmart39.springboot.service.WorkOrderService;

@Controller
@RequestMapping("/production")
public class ProductionController {

	
	private static final Logger log = LoggerFactory.getLogger(ProductionController.class);
	
	private final ProductStateService productStateService;
	private final WorkOrderService workOrderService;
	private final ProductionService productionService;
	private final ProductionPlanService productionPlanService;
	private final ProductionStatusService productionStatusService;
	private final CompletedProductService completedProductService;
	private final ProductionStatusByProductionPlanService productionStatusByProductionPlanService;
	
	@Autowired
	public ProductionController(ProductStateService productStateService
							  , ProductionPlanService productionPlanService
							  , WorkOrderService workOrderService
							  , ProductionStatusService productionStatusService
							  , ProductionStatusByProductionPlanService productionStatusByProductionPlanService
							  , CompletedProductService completedProductService
							  , ProductionService productionService) {
		this.productionPlanService = productionPlanService;
		this.workOrderService = workOrderService;
		this.productionStatusService = productionStatusService;
		this.productStateService = productStateService;
		this.productionStatusByProductionPlanService = productionStatusByProductionPlanService;
		this.completedProductService = completedProductService;
		this.productionService = productionService;
	}
	
	/********************************??????******************************/
	
	//[??????]??????????????????
		@GetMapping("/workOrderInfo")
		public String workOrderInfo() {
			return "production/workOrderInfo";
		}
		
	/*******************************??????***********************************/
	//[??????]???????????? ??????
	@PostMapping("/deleteProductionPlan")
	@ResponseBody
	public int deleteProductionPlan(@RequestParam(value = "delArr[]")String[] delArr) {
		int result = 1;

		for(int i = 0; i<delArr.length; i++) {
		result	= productionPlanService.deleteProductionPlan(delArr[i]);
		}
		return result;
	}
	
	//[??????]???????????? ??????
	@RequestMapping(value = "/searchProductionPlan", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> searchProductionPlan(@RequestParam(value = "genderCate", required = false) String genderCate
									   ,@RequestParam(value = "detailCate", required = false) String detailCate
									   ,@RequestParam(value = "startDate", required = false) String startDate
									   ,@RequestParam(value = "endDate", required = false) String endDate
									   ,@RequestParam(value = "range", required = false) String range) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("genderCate", genderCate);
		map.put("detailCate", detailCate);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("range", range);
		List<Map<String, Object>> listMap = productionPlanService.searchProductionPlan(map);
		log.info("{}", listMap);
		return listMap;
	}
	
	//[??????]???????????? ??????
	@PostMapping("/modifyProductionPlan")
	public String modifyProductionPlan(ProductionPlan productionPlan) {
		productionPlanService.modifyProductionPlan(productionPlan);
		return "redirect:productionPlanList";
	}
	
	//[??????]???????????? ?????? ???
	@GetMapping("/modifyProductionPlan")
	public String modifyProductionPlan(@RequestParam(value = "planCode", required = false)String planCode
									  ,Model model) {
		Map<String, Object> resultMap = productionPlanService.getProductionPlanListByCode(planCode);
		model.addAttribute("resultMap", resultMap);
		log.info("=============================================");
		log.info("??????????????? ????????? ???:            {}", resultMap);
		log.info("=============================================");
		return "production/modifyProductionPlan";
	}
	
	//[??????]???????????? ??????
	@PostMapping("/addProductionPlan")
	public String productioncontrolAdd(ProductionPlan productionPlan) {
		log.info("=============================================");
		log.info("???????????? ????????? ???:            {}", productionPlan);
		log.info("=============================================");
		
		productionPlanService.addProductionPlan(productionPlan);
		
		return "redirect:productionPlanList";
	}
	
	//[??????]????????? ???????????? ?????? ????????? ????????????
	@RequestMapping(value = "/detailCode", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getDetailCode(@RequestParam(value = "gender", required = false)String gender){
		List<Map<String, Object>> name = productionPlanService.getDetailCode(gender);
		log.info("=============================================");
		log.info("???????????? ????????? ???:            {}", gender);
		log.info("???????????? ?????? :            {}", name);
		log.info("=============================================");
		
		return name;
	}
	
	//[??????]????????? ????????? ??? ????????????
	@RequestMapping(value="/productCode", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getProductionCode() {
		List<Map<String, Object>> list = productionPlanService.getProductCode();
		log.info("=============================================");
		log.info("???????????? ?????? :            {}", list);
		log.info("=============================================");
		return list;
	}

	
	//[??????]???????????? ????????? ??????
	@GetMapping("/productionWeeklyPlanList")
	public String productionWeeklyPlanList() {
		return "production/productionWeeklyPlanList";
	}
	
	//[??????]???????????? ?????? ??????
	@GetMapping("/productionMonthlyPlanList")
	public String getProductionMonthlyPlanList(Model model) {

		return "production/productionMonthlyPlanList";
	}
	
	//[??????]???????????? ????????? ????????????
	@RequestMapping(value="/monthPlan", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> monthPlan() {
		List<Map<String, Object>> list = productionPlanService.getProductionAllPlanList();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		HashMap<String, Object> hash = new HashMap<String, Object>();		
		
		log.info("{}",list);
		
		for(int i=0; i < list.size(); i++) {			
			String genderCate = (String) list.get(i).get("gender_categorized_name");
			String cateName = (String) list.get(i).get("detailed_categorized_name");
			
			hash.put("title", genderCate + "/" + cateName);
			hash.put("start", list.get(i).get("expected_production_start_date"));
			hash.put("end", list.get(i).get("expected_production_end_date"));
			
			if(genderCate.equals("????????????")) {
				hash.put("color", "#F08080");
			}else if(genderCate.equals("????????????")){
				hash.put("color", "#006400");				
			}
			
			jsonObj = new JSONObject(hash);
			jsonArr.add(jsonObj);
		}
		
		log.info("jsonArr{}", jsonArr);
		
		return jsonArr;
	}
	
	//[??????]???????????? ?????? ??????test
	@ResponseBody
	@RequestMapping(value="/production/productionMonthlyPlanList", method = RequestMethod.POST)
	public String getProductionMonthlyPlanList(){
		return "production/productionMonthlyPlanList";
	}

	//[??????]?????? ???????????? ??????
	@GetMapping("/productionPlanList")
	public String productionPlanList(Model model) {
		List<Map<String, Object>> resultMap = productionPlanService.getProductionAllPlanList();
		log.info("==============================================");
		log.info("?????? ???????????? ??????:         {}", resultMap);
		log.info("==============================================");
		
		model.addAttribute("list", resultMap);
		
		return "production/productionPlanList";
	}
	
	//[??????]???????????? ??????
	@GetMapping("/addProductionPlan")
	public String productioncontrolAdd() {
		return "production/addProductionPlan";
	}
	
	/*******************************??????***********************************/
	
	//[??????+??????]??????????????? ?????? ?????? ??????
	@GetMapping("/stateByWorkOrder")
	public String getStateByWorkOrder(Model model) {
		List<Map<String, Object>> workOrderList = workOrderService.getWorkOrderList();
		model.addAttribute("title","????????????");
		model.addAttribute("workOrderList", workOrderList);
		return "production/stateByWorkOrder";
	}

	//===================================================================

	// [??????]??????????????? ?????? ?????? ?????? 
	@GetMapping("/stateByProduct")
	public String getStateByProduct(Model model ,@RequestParam(name="productCode",required=false) String productCode) {
		List<Map<String,Object>> stateByProductList = productStateService.getProductState();
		List<Map<String,Object>> searchByProductList = productStateService.searchProductState(productCode);
		model.addAttribute("stateByProductList",stateByProductList);
		model.addAttribute("searchByProductList",searchByProductList);
		log.info("stateByProductList:{}",stateByProductList);
		return "production/stateByProduct";
	}
	
	/*******************************??????***********************************/
	
	// [??????]??????????????? ???????????? ??????
	@GetMapping("/orderProductionProcess")
	public String orderProductionProcess(Model model) {
		List<Map<String,Object>> productToStartList = productionService.searchProductToStart(null);
		model.addAttribute("productToStartList", productToStartList);
		return "production/orderProductionProcess";
	}
	
	
	//[??????]?????? ????????? ???????????? ?????? ??????
	@PostMapping("/searchProductToStart")
	@ResponseBody
	public List<Map<String,Object>> getProductToStartResult(@RequestBody Map<String,Object> searchKeyAndValue){

		log.info("ajax?????? ???????????? map : {}", searchKeyAndValue);
		
		List<Map<String,Object>> productToStartInfo = productionService.searchProductToStart(searchKeyAndValue);
		
		return productToStartInfo;
	}
	
	
	//[??????]?????????????????? ????????????
	@PostMapping("/stopProcessByProduct")
	@ResponseBody
	public ProductProductionProcessStatus stopProcess(@RequestBody ProductProductionProcessStatus selectedProductInfo) {
		log.info("ajax?????? ??? ???????????????? {}", selectedProductInfo);
		productionService.completeProcess(selectedProductInfo);
		if(selectedProductInfo.getProductionProcessCode().equals("process_07")) {
			CompletedProduct completedInfo = completedProductService.getProductInfoToInsertCompleted(selectedProductInfo.getRequestedProductCode());
			log.info("completedInfo????????????: {}", completedInfo);
			completedProductService.addCompletedProduct(completedInfo);
		}else {
			productionService.insertNextProcess(selectedProductInfo);			
		}
		return selectedProductInfo;
	}
	
	//[??????]?????????????????? ????????????
	@PostMapping("/startProcessByProduct")
	@ResponseBody
	public ProductProductionProcessStatus startProcess(@RequestBody ProductProductionProcessStatus selectedProductInfo) {
		productionService.startProcess(selectedProductInfo);
		return selectedProductInfo;
	}
	
	
	//[??????]???????????? ????????? ?????? ???????????? ?????? modal
	@RequestMapping(value = "searchOrderProductionProcess", method = RequestMethod.POST)
	
	public @ResponseBody Object getSearchKey(@RequestParam(value = "param", required = false) String param, Model model){
		log.info("json?????? ????????? param ???: {}", param);
		
		Map<String,Object> paramMap = new HashMap<String,Object>();

		//????????? ?????? ????????? ???????????? ????????? java ???????????? map??? ???????????? ??????
		net.sf.json.JSONArray array = net.sf.json.JSONArray.fromObject(param);
		
		log.info("fromObject????????? ?????????: {}", array);
		
		for(int i=0; i<array.size(); i++) {
			net.sf.json.JSONObject obj = array.getJSONObject(i);
			
			
			paramMap.put("clientCode", obj.get("clientCode"));
			paramMap.put("clientName", obj.get("clientName"));
			paramMap.put("requestRegDateFrom", obj.get("requestRegDateFrom"));
			paramMap.put("requestRegDateTo", obj.get("requestRegDateTo"));
			paramMap.put("contractCode", obj.get("contractCode"));
			paramMap.put("contractAcceptCheck", obj.get("contractAcceptCheck"));
		}
		

		log.info("paramMap ?????? : {}", paramMap);
		
		//DB?????? ???????????? ???????????? modal??? ????????????
		List<Map<String,Object>> searchClientNameResult = productionService.searchClientName(paramMap);
		log.info("DB?????? ?????? ???????????? clinetName List : {}", searchClientNameResult);

		return searchClientNameResult;
	}
	  
	
	
	// [??????+??????]??????????????? ?????? ?????? ?????? ?????? 
	@GetMapping("/productionOrderList")
	public String getProductionOrderList(Model model) {

		List<Map<String, Object>> workOrderList = workOrderService.getWorkOrderList();
		List<Map<String, Object>> readyProductInfoList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> workOrderValues : workOrderList) {
			String workOrderStatus = (String) workOrderValues.get("status");
			if (workOrderStatus.equals("?????????")) {
				readyProductInfoList.add(workOrderValues);
			}
		}

		log.info("readyProductInfoList :{}", readyProductInfoList);

		model.addAttribute("readyProductInfo", readyProductInfoList);

		return "/production/productionOrderList";
	}

	
	// [??????]???????????? ?????? - ??????????????? insert???
	@PostMapping("/pCodeToStartSend")
	public @ResponseBody String startPCodeProduction(@RequestParam(value = "pCodeToStart") String sentPCode) {
		log.info("sentPCode :{}", sentPCode);
		// ????????? ????????? ??????????????? ????????? insert ??? ????????? ???????????? ????????????
		productionService.startProduction(sentPCode);
		return null;
	}

	// ================================================================

	//[??????]????????? ?????? ????????? ??????
	@GetMapping("/prodcutionRateByPeriod")
	public String getProductionRateByPeriod() {
		return "production/prodcutionRateByPeriod";
	}
	
	// [??????]??????????????? ?????? ?????? ??????
	@GetMapping("/stateByProductionPlan")
	public String getStateByProductionPlan(Model model) {
		
		List<Map<String,Object>> achievePercentageByPlanList = productionStatusByProductionPlanService.getAchievePercentageByPlan();
		List<Map<String,Object>> finishedProductionPlanList = productionStatusByProductionPlanService.getFinishedProductionPlanInfo();
		model.addAttribute("achievePercentageByPlanList", achievePercentageByPlanList);
		model.addAttribute("finishedProductionPlanList", finishedProductionPlanList);
		log.info("achievePercentageByPlanList : {}", achievePercentageByPlanList);
		
		return "production/stateByProductionPlan";
	}

	// ===================================================================

	// [??????]????????? ??????
	@GetMapping("/completedProductList")
	public String getCompletedProductList(Model model) {
		List<Map<String,Object>> completedProductList = completedProductService.getCompletedProductList();
		log.info("????????? ?????? :{}", completedProductList);
		model.addAttribute("completedProductList", completedProductList);
		return "production/completedProductList";
	}

	// =====================================================================
	//[??????]???????????? ?????? ????????? ????????????
	@GetMapping("/workOrderList")
	public String getWorkerOrderList(Model model) {

		List<Map<String, Object>> workOrderList = workOrderService.getWorkOrderList();
		model.addAttribute("workOrderList", workOrderList);

		return "production/workOrderList";
	}
	
	
	//[??????]???????????? ???????????? + [??????]????????????
	@GetMapping("/addWorkOrder")
	public String addWorkOrder() {
		
		return "production/addWorkOrder";
	}
	
	//[??????]???????????? ?????? ??????
	@PostMapping("/addWorkOrder")
	public String addWorkOrder(WorkOrder workOrder) {
		log.info("?????????????????? :{}", workOrder);
		workOrderService.addWorkOrder(workOrder);
		return "redirect:/production/workOrderList";
	}
	
	//[??????]???????????? ?????????????????? ??????
	@GetMapping("/modifyWorkOrder")
	public String modifyWorkOrder(@RequestParam(value = "workOrderCode") String workOrderCode, Model model) throws ParseException {
		log.info("workOrderCode ???????????? ??????????????? :{}", workOrderCode);
		Map<String,Object> workOrderInfo = workOrderService.getWorkOrderInfoByWorkOrderCode(workOrderCode);
		log.info("DB?????? workOrderCode??? ???????????? ????????? ??????  :{}", workOrderInfo);
		
		//DB?????? ???????????? ?????? ?????? java?????? datetime-local??? ???????????????
		Date startDate = (Date) workOrderInfo.get("startDate");
		Date endDate = (Date) workOrderInfo.get("endDate");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		String newStartDate = dateFormat.format(startDate);
		String newEndDate = dateFormat.format(endDate);
		log.info("parsing??? startDate??? ?????? :{}", newStartDate);
		workOrderInfo.replace("startDate", newStartDate);
		workOrderInfo.replace("endDate", newEndDate);
		
		
		log.info("?????? ?????? ????????? workOrderCode??? ???????????? ????????? ??????  :{}", workOrderInfo);
		model.addAttribute("workOrderInfo", workOrderInfo);
		return "production/modifyWorkOrder";
	}
	
	//[??????]???????????? ???????????? ??? ????????????????????? ??????
	@PostMapping("/modifyWorkOrder")
	public String modifyWorkOrder(WorkOrder workOrder) {
		log.info("workOrder ???????????? ??????:{}", workOrder);
		workOrderService.modifyWorkOrder(workOrder);
		
		return "redirect:/production/workOrderList";
	}
	
	
	//[??????]?????????????????????????????? ???????????? ?????? ??????
	@PostMapping("/searchContractCodeModal")
	@ResponseBody
	public List<Map<String,Object>> getContractCode(@RequestBody Map<String,Object> paramMap){
		List<Map<String,Object>> searchContractCodeResult = productionService.searchClientName(paramMap);
		return searchContractCodeResult;
	}
	
	
	//???????????? ????????????
	@GetMapping("/production")
	public String getProdcutioncontrol () {
		
		return "production/production";
		
	}
}
