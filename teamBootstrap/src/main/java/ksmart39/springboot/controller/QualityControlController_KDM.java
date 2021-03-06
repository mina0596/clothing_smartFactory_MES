//package ksmart39.springboot.controller;
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import ksmart39.springboot.domain.QualityInspection;
//import ksmart39.springboot.domain.QualityInspectionRequest;
//import ksmart39.springboot.domain.QualityInspectionResult;
//import ksmart39.springboot.domain.QualityInspectionStandard;
//import ksmart39.springboot.service.QualityInsMeasurementValueService;
//import ksmart39.springboot.service.QualityInspectionStauteService;
//
//@Controller
//@RequestMapping("/quality")
//public class QualityControlController_KDM {
//	
//	private static final Logger log = LoggerFactory.getLogger(QualityControlController_KDM.class);
//	
//	@Autowired 
//	private QualityInsMeasurementValueService qualityInsMeasurementValueService;
//	@Autowired
//	private QualityInspectionStauteService qualityInsepctionStauteService;
//	
//	@Autowired
//	public QualityControlController_KDM(QualityInsMeasurementValueService qualityInsMeasurementValueService,QualityInspectionStauteService qualityInsepctionStauteService) {
//		this.qualityInsepctionStauteService = qualityInsepctionStauteService;
//		this.qualityInsMeasurementValueService =qualityInsMeasurementValueService;
//	}
//	
//	//=============================================================================
//	
//	
//	//[??????] ???????????? ?????? 
//	@PostMapping("/searchInspectionCode")
//	@ResponseBody 
//	public List<QualityInspection> searchInspectionCode(@RequestBody QualityInspection qualityInspection){
//		log.info("???????????? ????????? ???: {}", qualityInspection);
//		List<QualityInspection> inspectionCode = qualityInsMeasurementValueService.searchInspectionCode(qualityInspection);
//		return inspectionCode;
//	}
//	
//	//[??????] ??????????????? ??????
//	@PostMapping("/searchByClientName")
//	@ResponseBody 
//	public List<Map<String, Object>> searchByClientName(@RequestParam(value = "clientName", required = false)String clientName){
//		log.info("???????????? ????????? ???: {}", clientName);
//		List<Map<String, Object>> clientNameMap = qualityInsMeasurementValueService.searchByClientName(clientName);
//		return clientNameMap;
//	}
//	
//	//[??????] ???????????? ??????
//	@PostMapping("/searchByContractNum")
//	@ResponseBody
//	public List<Map<String, Object>> searchByContractNum(@RequestBody Map<String, Object> searchByContractNum){
//		log.info("???????????? ????????? ???: {}", searchByContractNum);
//		List<Map<String, Object>> ContractNumMap = qualityInsMeasurementValueService.searchByContractNum(searchByContractNum);
//		return ContractNumMap;
//	}
//
//	//[??????] ????????? ?????? ??????
//	@PostMapping("/qualityInspectionStatusNow")
//	@ResponseBody
//	public List<Map<String, Object>> qualityInspectionStatusNow(@RequestParam(value = "contractNum")String contractNum){
//		List<Map<String, Object>> resultMap = null;
//		
//		log.info("================================================");
//		log.info("???????????? ????????????: {}", contractNum);
//		log.info("================================================");
//		
//		resultMap = qualityInsMeasurementValueService.getQualityInspectionStatusNow(contractNum);
//
//		log.info("================================================");
//		log.info("DB????????? ???: {}", resultMap);
//		log.info("================================================");
//		
//		return resultMap;
//	}
//	
//	//[??????] ????????? ?????? ?????? ?????????
//	@PostMapping("/qualityInspectionStatusNowList")
//	@ResponseBody
//	public List<Map<String, Object>> qualityInspectionStatusNowList(@RequestBody Map<String, Object> searchMap) {
//		
//		log.info("???????????? ????????? ???: {}", searchMap);
//		List<Map<String, Object>> map = qualityInsMeasurementValueService.getQualityInspectionStatusNowList(searchMap);
//		log.info("================================================");
//		log.info("????????? ?????? ?????? DB????????? ???: {}", map);
//		log.info("================================================");
//		
//		return map;
//	}
//	
//	//[??????] ????????? ?????? ??????
//	@GetMapping("/qualityInspectionStatusNow")
//	public String qualityInspectionStatusNow(Model model) {		
//		
//		return "quality/qualityInspectionStatusNow";
//	}
//	
//
//	//???????????? ?????? 
//	@GetMapping("/inspectionPerformance")
//	public String inspectionPerformance(Model model) {
//		
//		model.addAttribute("title", "??????????????????:??????");
//		return"quality/inspectionPerformance";
//	}
//	
//	
//	//[??????] ???????????? ????????? ??????
//	@GetMapping("/inspectionMeasurementValueList")
//	public String inspectionMeasurementValueList(Model model) {
//		
//		List<QualityInspectionResult> list = qualityInsMeasurementValueService.getInspectionMeasurementValueList();
//		
//		model.addAttribute("list", list);
//		
//		log.info("{}", list);
//		
//		return "quality/inspectionMeasurementValueList";
//	}
//	
//	//[??????] ???????????? ????????? ??????
//	@PostMapping("/addInspectionMeasurementValue")
//	@ResponseBody
//	public boolean addInspectionMeasurementValue(@RequestBody List<QualityInspectionResult> qualityInspectionResult, HttpSession session) {
//		String sCode = (String) session.getAttribute("SCODE");
//		log.info("session?????? ???????????? employeeCode?????? :{}", sCode);
//
//		int value = qualityInsMeasurementValueService.addQualityInspectionResult(qualityInspectionResult, session);
//		boolean result = false;			
//		
//		//insert ??????
//		if(value > 0) {
//			result = true;			
//		//insert ??????
//		}else {
//			result = false;			
//		}
//		
//		return result;		
//	}
//	
//	//[??????] ???????????? ????????? ??????????????? ?????? ??? ?????????
//	@PostMapping("/getQulityInspectionCategory")
//	@ResponseBody
//	public String getQulityInspectionCategory(@RequestParam(value = "qualityInspectionCode")String qualityInspectionCode){
//		
//		List<QualityInspectionStandard> cate = qualityInsMeasurementValueService.getQualityInspectionStandard(qualityInspectionCode);
//		
//		String result = cate.get(0).getCategory();
//		
//		return result;	
//	}
//	
//	//[??????] ???????????? ????????? ?????? ??????
//	@GetMapping("/addInspectionMeasurementValue")
//	public String addInspectionMeasurementValue(Model model) {
//		return "quality/addInspectionMeasurementValue";
//	}
//	
//	
//	//[??????]???????????? ?????? ?????? ??????
//	@RequestMapping(value = "searchQualityInspectionRequest", method = RequestMethod.POST)
//	@ResponseBody
//	public List<Map<String, Object>> searchQualityInspectionRequest(@RequestParam(value = "jsonData", required = false)String jsonData) {
//				
//		log.info("1. ?????? ????????? ?????????(json?????????): jsonData: {} " , jsonData);
//		
//		JSONParser parser = new JSONParser();
//		Object obj = null;
//		try {
//			// parsering ??? Object????????? ??????
//			obj = parser.parse(jsonData);
//			log.info("2.????????? ?????????: obj: {} " , obj);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		//3. JsonObject??? ??????
//		JSONObject jsonObj = (JSONObject) obj;
//		
//	    Map<String, Object> map = new HashMap<String, Object>();
//		
//	    //json -> map?????? ??????????????????.
//		List<Map<String, Object>> map2 = qualityInsMeasurementValueService.searchQualityInspectionRequest(jsonObj);
//		log.info("searchQualityInspectionRequest: {} " , map2);
//		
//		return map2;
//	}
//	/*
//	 * //[??????]????????????????????????
//	 * 
//	 * @GetMapping("/qualityInspectionRequestList") public String
//	 * qualityControlRequestList(Model model) { List<Map<String, Object>> resultMap
//	 * = qualityInsMeasurementValueService.getQualityInspectionRequestList();
//	 * log.info("test3333{}",resultMap); model.addAttribute("list", resultMap);
//	 * return "quality/qualityInspectionRequestList";
//	 * 
//	 * }
//	 */
//	
//	//[??????] ??????????????? ????????? ?????? ?????? ??????
//	@PostMapping("/searchRequestProductCode")
//	@ResponseBody
//	public List<Map<String, Object>> searchRequestProductCode(@RequestParam(name = "contractCode")String contractCode){
//		List<Map<String, Object>> resultMap = qualityInsMeasurementValueService.searchRequestProductCode(contractCode);
//		return resultMap;
//	}
//		
//	//[??????]???????????? ?????? ??????
//	@PostMapping("/qualityInspectionRequest")
//	public String qualityInspectionRequest(QualityInspectionRequest qualityInspectionRequest) {
//		qualityInsMeasurementValueService.qualityInspectionRequest(qualityInspectionRequest);
//		return "redirect:qualityInspectionRequestList";
//	}
//	
//	//[??????]??????????????????
//	@GetMapping("/qualityInspectionRequest")
//	public String qualityControlRequest() {
//		return "quality/qualityInspectionRequest";
//	}
//	
//	//[??????]???????????? ?????? ?????? ??????
//	@PostMapping("/subClassCate")
//	@ResponseBody
//	public List<Map<String, Object>> subClassCate(@RequestParam(name = "lowClassCateName") String lowClassCateName){
//		return qualityInsMeasurementValueService.subClassCate(lowClassCateName);
//	}
//}
