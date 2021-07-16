package ksmart39.springboot.controller;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

import com.sun.el.parser.AstTrue;

import ksmart39.springboot.domain.ProductProductionProcessStatus;
import ksmart39.springboot.domain.ProductionPlan;
import ksmart39.springboot.domain.RequestedProduct;
import ksmart39.springboot.domain.WorkOrder;
import ksmart39.springboot.service.ProductionPlanService;
import ksmart39.springboot.service.ProductionService;
import ksmart39.springboot.service.ProductionStatusService;
import ksmart39.springboot.service.WorkOrderService;
import net.sf.json.JSON;

@Controller
@RequestMapping("/production")
public class ProductionController_PMA {

	private static final Logger log = LoggerFactory.getLogger(ProductionController_PMA.class);

	private final WorkOrderService workOrderService;
	private final ProductionService productionService;

	public ProductionController_PMA(ProductionService productionService, WorkOrderService workOrderService) {
		this.productionService = productionService;
		this.workOrderService = workOrderService;
	}

	// [민아]의뢰품목별 생산공정 지시
	@GetMapping("/orderProductionProcess")
	public String orderProductionProcess() {
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
	
	
	//[민아]공정완료버튼 눌렀을때
	@PostMapping("/stopProcessByProduct")
	@ResponseBody
	public String stopProcess(@RequestBody ProductProductionProcessStatus selectedProductInfo) {
		log.info("ajax에서 잘 받아오나요? {}", selectedProductInfo);
		String test="test";
		String productCode = selectedProductInfo.getRequestedProductCode();
		log.info("processCode :{}", productCode);
		productionService.completeProcess(selectedProductInfo);
		return test;
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

		log.info("어디모델이지? :{}", model.toString());
		
		return searchClientNameResult;
	}
	  
	 
	
	// [민아+한빛]의뢰품목별 상세 생산 공정 현황 등록
	@GetMapping("/productionOrderList")
	public String productionOrderList(Model model) {

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

	// [민아+한빛]의뢰품목별 상세 생산 공정 현황 등록
	@GetMapping("/test")
	public String test() {
		return "production/test";
	}

	// ================================================================
	// [민아+한빛]의뢰품목별 상세 생산 공정 현황 등록
	@GetMapping("/productProgressList")
	public String getproductProgressList() {
		return "production/productProgressList";
	}

	// [민아+한빛]의뢰품목별 생산 현황 조회
	@GetMapping("/stateByProduct")
	public String getStateByProduct() {
		return "production/stateByProduct";
	}

	// [민아+한빛]생산계획별 생산 현황 조회
	@GetMapping("/stateByProductionPlan")
	public String getStateByProductionPlan() {
		return "production/stateByProductionPlan";
	}

	// ===================================================================
	// [민아]완제품 수정
	@GetMapping("/modifyCompletedProduct")
	public String modifyCompletedProduct() {
		return "production/modifyCompletedProduct";
	}

	// [민아]완제품 등록
	@GetMapping("/addCompletedProduct")
	public String addCompletedProduct() {

		return "production/addCompletedProduct";
	}

	@PostMapping("/addCompletedProduct")
	public String addCompletedProduct(@RequestParam(name = "productCode", required = true) String productCode,
			Model model) {
		Map<String, String> completedProductInfo = new HashMap<String, String>();
		productionService.addCompletedProduct(completedProductInfo);
		return "production/addCompletedProduct";
	}

	// [민아]완제품 목록
	@GetMapping("/completedProductList")
	public String getCompletedProductList() {
		return "production/completedProductList";
	}

	// =====================================================================
	// [보람]작업지시 목록 + [민아]작업지시 목록 화면에 뿌려주기
	@GetMapping("/workOrderList")
	public String workerOrderList(Model model) {

		List<Map<String, Object>> workOrderList = workOrderService.getWorkOrderList();
		model.addAttribute("workOrderList", workOrderList);

		return "production/workOrderList";
	}
}
