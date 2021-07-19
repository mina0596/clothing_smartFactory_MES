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
	

	
	//=====================================================================
	
	
	
	
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
		
		log.info("안되겠지..?아냐 될거야ㅜㅜ {}", jsonArr);
		
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
	
	
	//====================================================================
	//생산관리 메인화면
	@GetMapping("/production")
	public String getProdcutioncontrol () {
		
		return "production/production";
		
	}
}
