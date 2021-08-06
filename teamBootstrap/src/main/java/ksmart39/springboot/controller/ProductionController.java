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
	
	/********************************보람******************************/
	
	//[보람]작업지시정보
		@GetMapping("/workOrderInfo")
		public String workOrderInfo() {
			return "production/workOrderInfo";
		}
		
	/*******************************다미***********************************/
	//[다미]생산계획 삭제
	@PostMapping("/deleteProductionPlan")
	@ResponseBody
	public int deleteProductionPlan(@RequestParam(value = "delArr[]")String[] delArr) {
		int result = 1;

		for(int i = 0; i<delArr.length; i++) {
		result	= productionPlanService.deleteProductionPlan(delArr[i]);
		}
		return result;
	}
	
	//[다미]생산계획 검색
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
	
	//[다미]생산계획 수정
	@PostMapping("/modifyProductionPlan")
	public String modifyProductionPlan(ProductionPlan productionPlan) {
		productionPlanService.modifyProductionPlan(productionPlan);
		return "redirect:productionPlanList";
	}
	
	//[다미]생산계획 수정 폼
	@GetMapping("/modifyProductionPlan")
	public String modifyProductionPlan(@RequestParam(value = "planCode", required = false)String planCode
									  ,Model model) {
		Map<String, Object> resultMap = productionPlanService.getProductionPlanListByCode(planCode);
		model.addAttribute("resultMap", resultMap);
		log.info("=============================================");
		log.info("계획코드로 조회한 값:            {}", resultMap);
		log.info("=============================================");
		return "production/modifyProductionPlan";
	}
	
	//[다미]생산계획 등록
	@PostMapping("/addProductionPlan")
	public String productioncontrolAdd(ProductionPlan productionPlan) {
		log.info("=============================================");
		log.info("화면에서 받아온 값:            {}", productionPlan);
		log.info("=============================================");
		
		productionPlanService.addProductionPlan(productionPlan);
		
		return "redirect:productionPlanList";
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
	
	//[다미]성별별 양복명 값 가져오기
	@RequestMapping(value="/productCode", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getProductionCode() {
		List<Map<String, Object>> list = productionPlanService.getProductCode();
		log.info("=============================================");
		log.info("생산코드 조회 :            {}", list);
		log.info("=============================================");
		return list;
	}

	
	//[다미]생산계획 주간별 목록
	@GetMapping("/productionWeeklyPlanList")
	public String productionWeeklyPlanList() {
		return "production/productionWeeklyPlanList";
	}
	
	//[다미]생산계획 월별 목록
	@GetMapping("/productionMonthlyPlanList")
	public String getProductionMonthlyPlanList(Model model) {

		return "production/productionMonthlyPlanList";
	}
	
	//[다미]생산계획 데이터 가져오기
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
			
			if(genderCate.equals("신사양복")) {
				hash.put("color", "#F08080");
			}else if(genderCate.equals("숙녀양복")){
				hash.put("color", "#006400");				
			}
			
			jsonObj = new JSONObject(hash);
			jsonArr.add(jsonObj);
		}
		
		log.info("jsonArr{}", jsonArr);
		
		return jsonArr;
	}
	
	//[다미]생산계획 월별 목록test
	@ResponseBody
	@RequestMapping(value="/production/productionMonthlyPlanList", method = RequestMethod.POST)
	public String getProductionMonthlyPlanList(){
		return "production/productionMonthlyPlanList";
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
	
	/*******************************한빛***********************************/
	
	//[민아+한빛]작업지시별 생산 현황 조회
	@GetMapping("/stateByWorkOrder")
	public String getStateByWorkOrder(Model model) {
		List<Map<String, Object>> workOrderList = workOrderService.getWorkOrderList();
		model.addAttribute("title","생산현황");
		model.addAttribute("workOrderList", workOrderList);
		return "production/stateByWorkOrder";
	}

	//===================================================================

	// [한빛]의뢰품목별 생산 현황 조회 
	@GetMapping("/stateByProduct")
	public String getStateByProduct(Model model ,@RequestParam(name="productCode",required=false) String productCode) {
		List<Map<String,Object>> stateByProductList = productStateService.getProductState();
		List<Map<String,Object>> searchByProductList = productStateService.searchProductState(productCode);
		model.addAttribute("stateByProductList",stateByProductList);
		model.addAttribute("searchByProductList",searchByProductList);
		log.info("stateByProductList:{}",stateByProductList);
		return "production/stateByProduct";
	}
	
	/*******************************민아***********************************/
	
	// [민아]의뢰품목별 생산공정 지시
	@GetMapping("/orderProductionProcess")
	public String orderProductionProcess(Model model) {
		List<Map<String,Object>> productToStartList = productionService.searchProductToStart(null);
		model.addAttribute("productToStartList", productToStartList);
		return "production/orderProductionProcess";
	}
	
	
	//[민아]의뢰 품목별 생산공정 현황 조회
	@PostMapping("/searchProductToStart")
	@ResponseBody
	public List<Map<String,Object>> getProductToStartResult(@RequestBody Map<String,Object> searchKeyAndValue){

		log.info("ajax에서 받아오는 map : {}", searchKeyAndValue);
		
		List<Map<String,Object>> productToStartInfo = productionService.searchProductToStart(searchKeyAndValue);
		
		return productToStartInfo;
	}
	
	
	//[민아]공정마침버튼 눌렀을때
	@PostMapping("/stopProcessByProduct")
	@ResponseBody
	public ProductProductionProcessStatus stopProcess(@RequestBody ProductProductionProcessStatus selectedProductInfo) {
		log.info("ajax에서 잘 받아오나요? {}", selectedProductInfo);
		productionService.completeProcess(selectedProductInfo);
		if(selectedProductInfo.getProductionProcessCode().equals("process_07")) {
			CompletedProduct completedInfo = completedProductService.getProductInfoToInsertCompleted(selectedProductInfo.getRequestedProductCode());
			completedProductService.addCompletedProduct(completedInfo);
		}else {
			productionService.insertNextProcess(selectedProductInfo);			
		}
		
		
		return selectedProductInfo;
	}
	
	//[민아]공정시작버튼 눌렀을때
	@PostMapping("/startProcessByProduct")
	@ResponseBody
	public ProductProductionProcessStatus startProcess(@RequestBody ProductProductionProcessStatus selectedProductInfo) {
		productionService.startProcess(selectedProductInfo);
		return selectedProductInfo;
	}
	
	
	//[민아]생산공정 지시를 위한 의뢰코드 검색 modal
	@RequestMapping(value = "searchOrderProductionProcess", method = RequestMethod.POST)
	
	public @ResponseBody Object getSearchKey(@RequestParam(value = "param", required = false) String param, Model model){
		log.info("json으로 받아온 param 값: {}", param);
		
		Map<String,Object> paramMap = new HashMap<String,Object>();

		//직렬화 시켜 가져온 오브젝트 배열을 java 형식으로 map에 넣어주는 과정
		net.sf.json.JSONArray array = net.sf.json.JSONArray.fromObject(param);
		
		log.info("fromObject메서드 사용한: {}", array);
		
		for(int i=0; i<array.size(); i++) {
			net.sf.json.JSONObject obj = array.getJSONObject(i);
			
			
			paramMap.put("clientCode", obj.get("clientCode"));
			paramMap.put("clientName", obj.get("clientName"));
			paramMap.put("requestRegDateFrom", obj.get("requestRegDateFrom"));
			paramMap.put("requestRegDateTo", obj.get("requestRegDateTo"));
			paramMap.put("contractCode", obj.get("contractCode"));
			paramMap.put("contractAcceptCheck", obj.get("contractAcceptCheck"));
		}
		

		log.info("paramMap 보장 : {}", paramMap);
		
		//DB에서 검색결과 받아와서 modal에 보내주기
		List<Map<String,Object>> searchClientNameResult = productionService.searchClientName(paramMap);
		log.info("DB에서 결과 받아오는 clinetName List : {}", searchClientNameResult);

		return searchClientNameResult;
	}
	  
	
	
	// [민아+한빛]의뢰품목별 상세 생산 공정 현황 
	@GetMapping("/productionOrderList")
	public String getProductionOrderList(Model model) {

		List<Map<String, Object>> workOrderList = workOrderService.getWorkOrderList();
		List<Map<String, Object>> readyProductInfoList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> workOrderValues : workOrderList) {
			String workOrderStatus = (String) workOrderValues.get("status");
			if (workOrderStatus.equals("대기중")) {
				readyProductInfoList.add(workOrderValues);
			}
		}

		log.info("readyProductInfoList :{}", readyProductInfoList);

		model.addAttribute("readyProductInfo", readyProductInfoList);

		return "/production/productionOrderList";
	}

	
	// [민아]생산공정 시작 - 생산현황에 insert됨
	@PostMapping("/pCodeToStartSend")
	public @ResponseBody String startPCodeProduction(@RequestParam(value = "pCodeToStart") String sentPCode) {
		log.info("sentPCode :{}", sentPCode);
		// 여기에 받아온 품목코드를 가지고 insert 문 해주는 처리과정 넣어주기
		productionService.startProduction(sentPCode);
		return null;
	}

	// ================================================================

	//[민아]기간별 전체 생산량 조회
	@GetMapping("/prodcutionRateByPeriod")
	public String getProductionRateByPeriod() {
		return "production/prodcutionRateByPeriod";
	}
	
	// [민아]생산계획별 생산 현황 조회
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

	// [민아]완제품 목록
	@GetMapping("/completedProductList")
	public String getCompletedProductList(Model model) {
		List<Map<String,Object>> completedProductList = completedProductService.getCompletedProductList();
		log.info("완제품 목록 :{}", completedProductList);
		model.addAttribute("completedProductList", completedProductList);
		return "production/completedProductList";
	}

	// =====================================================================
	//[민아]작업지시 목록 화면에 뿌려주기
	@GetMapping("/workOrderList")
	public String getWorkerOrderList(Model model) {

		List<Map<String, Object>> workOrderList = workOrderService.getWorkOrderList();
		model.addAttribute("workOrderList", workOrderList);

		return "production/workOrderList";
	}
	
	
	//[보람]작업지시 등록화면 + [민아]처리과정
	@GetMapping("/addWorkOrder")
	public String addWorkOrder() {
		
		return "production/addWorkOrder";
	}
	
	//[민아]작업지시 등록 처리
	@PostMapping("/addWorkOrder")
	public String addWorkOrder(WorkOrder workOrder) {
		log.info("들어오는정보 :{}", workOrder);
		workOrderService.addWorkOrder(workOrder);
		return "redirect:/production/workOrderList";
	}
	
	//[민아]작업지시 수정화면으로 이동
	@GetMapping("/modifyWorkOrder")
	public String modifyWorkOrder(@RequestParam(value = "workOrderCode") String workOrderCode, Model model) throws ParseException {
		log.info("workOrderCode 화면에서 받아오는거 :{}", workOrderCode);
		Map<String,Object> workOrderInfo = workOrderService.getWorkOrderInfoByWorkOrderCode(workOrderCode);
		log.info("DB에서 workOrderCode로 가져오는 정보값 확인  :{}", workOrderInfo);
		
		//DB에서 가져오는 날짜 포맷 java에서 datetime-local로 변경시켜줌
		Date startDate = (Date) workOrderInfo.get("startDate");
		Date endDate = (Date) workOrderInfo.get("endDate");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		String newStartDate = dateFormat.format(startDate);
		String newEndDate = dateFormat.format(endDate);
		log.info("parsing한 startDate값 확인 :{}", newStartDate);
		workOrderInfo.replace("startDate", newStartDate);
		workOrderInfo.replace("endDate", newEndDate);
		
		
		log.info("날짜 포맷 변경후 workOrderCode로 가져오는 정보값 확인  :{}", workOrderInfo);
		model.addAttribute("workOrderInfo", workOrderInfo);
		return "production/modifyWorkOrder";
	}
	
	//[민아]작업지시 수정완료 후 리스트화면으로 이동
	@PostMapping("/modifyWorkOrder")
	public String modifyWorkOrder(WorkOrder workOrder) {
		log.info("workOrder 수정된거 확인:{}", workOrder);
		workOrderService.modifyWorkOrder(workOrder);
		
		return "redirect:/production/workOrderList";
	}
	
	
	//[민아]작업지시등록화면에서 계약번호 검색 모달
	@PostMapping("/searchContractCodeModal")
	@ResponseBody
	public List<Map<String,Object>> getContractCode(@RequestBody Map<String,Object> paramMap){
		List<Map<String,Object>> searchContractCodeResult = productionService.searchClientName(paramMap);
		return searchContractCodeResult;
	}
	
	
	//생산관리 메인화면
	@GetMapping("/production")
	public String getProdcutioncontrol () {
		
		return "production/production";
		
	}
}
