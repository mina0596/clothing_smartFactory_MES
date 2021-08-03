package ksmart39.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import ksmart39.springboot.domain.QualityInspection;
import ksmart39.springboot.domain.QualityInspectionRequest;
import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.domain.QualityInspectionStandard;
import ksmart39.springboot.service.QualityInsMeasurementValueService;
import ksmart39.springboot.service.QualityInspectionStauteService;

@Controller
@RequestMapping("/quality")
public class QualityControlController_KDM {
	
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_KDM.class);
	
	@Autowired 
	private QualityInsMeasurementValueService qualityInsMeasurementValueService;
	@Autowired
	private QualityInspectionStauteService qualityInsepctionStauteService;
	
	@Autowired
	public QualityControlController_KDM(QualityInsMeasurementValueService qualityInsMeasurementValueService,QualityInspectionStauteService qualityInsepctionStauteService) {
		this.qualityInsepctionStauteService = qualityInsepctionStauteService;
		this.qualityInsMeasurementValueService =qualityInsMeasurementValueService;
	}
	
	//=============================================================================
	
	
	//[다미] 품질검사 코드 
	@PostMapping("/searchInspectionCode")
	@ResponseBody 
	public List<QualityInspection> searchInspectionCode(@RequestBody QualityInspection qualityInspection){
		log.info("화면에서 받아온 값: {}", qualityInspection);
		List<QualityInspection> inspectionCode = qualityInsMeasurementValueService.searchInspectionCode(qualityInspection);
		return inspectionCode;
	}
	
	//[다미] 거래처이름 검색
	@PostMapping("/searchByClientName")
	@ResponseBody 
	public List<Map<String, Object>> searchByClientName(@RequestParam(value = "clientName", required = false)String clientName){
		log.info("화면에서 받아온 값: {}", clientName);
		List<Map<String, Object>> clientNameMap = qualityInsMeasurementValueService.searchByClientName(clientName);
		return clientNameMap;
	}
	
	//[다미] 계약번호 검색
	@PostMapping("/searchByContractNum")
	@ResponseBody
	public List<Map<String, Object>> searchByContractNum(@RequestBody Map<String, Object> searchByContractNum){
		log.info("화면에서 받아온 값: {}", searchByContractNum);
		List<Map<String, Object>> ContractNumMap = qualityInsMeasurementValueService.searchByContractNum(searchByContractNum);
		return ContractNumMap;
	}

	//[다미] 실시간 검사 현황
	@PostMapping("/qualityInspectionStatusNow")
	@ResponseBody
	public List<Map<String, Object>> qualityInspectionStatusNow(@RequestParam(value = "contractNum")String contractNum){
		List<Map<String, Object>> resultMap = null;
		
		log.info("================================================");
		log.info("화면에서 받아온값: {}", contractNum);
		log.info("================================================");
		
		resultMap = qualityInsMeasurementValueService.getQualityInspectionStatusNow(contractNum);

		log.info("================================================");
		log.info("DB조회한 값: {}", resultMap);
		log.info("================================================");
		
		return resultMap;
	}
	
	//[다미] 실시간 검사 현황 리스트
	@PostMapping("/qualityInspectionStatusNowList")
	@ResponseBody
	public List<Map<String, Object>> qualityInspectionStatusNowList(@RequestBody Map<String, Object> searchMap) {
		
		log.info("화면에서 받아온 값: {}", searchMap);
		List<Map<String, Object>> map = qualityInsMeasurementValueService.getQualityInspectionStatusNowList(searchMap);
		log.info("================================================");
		log.info("실시간 검사 현황 DB조회된 값: {}", map);
		log.info("================================================");
		
		return map;
	}
	
	//[다미] 실시간 검사 현황
	@GetMapping("/qualityInspectionStatusNow")
	public String qualityInspectionStatusNow(Model model) {		
		
		return "quality/qualityInspectionStatusNow";
	}
	

	//검사현황 실적 
	@GetMapping("/inspectionPerformance")
	public String inspectionPerformance(Model model) {
		
		model.addAttribute("title", "검사현황관리:실적");
		return"quality/inspectionPerformance";
	}
	
	
	//[다미] 품질검사 측정값 목록
	@GetMapping("/inspectionMeasurementValueList")
	public String inspectionMeasurementValueList(Model model) {
		
		List<QualityInspectionResult> list = qualityInsMeasurementValueService.getInspectionMeasurementValueList();
		
		model.addAttribute("list", list);
		
		log.info("{}", list);
		
		return "quality/inspectionMeasurementValueList";
	}
	
	//[다미] 품질검사 측정값 등록
	@PostMapping("/addInspectionMeasurementValue")
	@ResponseBody
	public boolean addInspectionMeasurementValue(@RequestBody List<QualityInspectionResult> qualityInspectionResult, HttpSession session) {
		String sCode = (String) session.getAttribute("SCODE");
		log.info("session에서 가져오는 employeeCode확인 :{}", sCode);

		int value = qualityInsMeasurementValueService.addQualityInspectionResult(qualityInspectionResult, session);
		boolean result = false;			
		
		//insert 완료
		if(value > 0) {
			result = true;			
		//insert 실패
		}else {
			result = false;			
		}
		
		return result;		
	}
	
	//[다미] 품질검사 측정값 카테고리에 맞는 행 만들기
	@PostMapping("/getQulityInspectionCategory")
	@ResponseBody
	public String getQulityInspectionCategory(@RequestParam(value = "qualityInspectionCode")String qualityInspectionCode){
		
		List<QualityInspectionStandard> cate = qualityInsMeasurementValueService.getQualityInspectionStandard(qualityInspectionCode);
		
		String result = cate.get(0).getCategory();
		
		return result;	
	}
	
	//[다미] 품질검사 측정값 등록 화면
	@GetMapping("/addInspectionMeasurementValue")
	public String addInspectionMeasurementValue(Model model) {
		return "quality/addInspectionMeasurementValue";
	}
	
	
	//[다미]품질검사 요청 목록 모달
	@RequestMapping(value = "searchQualityInspectionRequest", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> searchQualityInspectionRequest(@RequestParam(value = "jsonData", required = false)String jsonData) {
				
		log.info("1. 처음 들어온 데이터(json문자열): jsonData: {} " , jsonData);
		
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			// parsering 후 Object객체에 담음
			obj = parser.parse(jsonData);
			log.info("2.파싱한 데이터: obj: {} " , obj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//3. JsonObject로 변환
		JSONObject jsonObj = (JSONObject) obj;
		
	    Map<String, Object> map = new HashMap<String, Object>();
		
	    //json -> map으로 바꿔야합니다.
		List<Map<String, Object>> map2 = qualityInsMeasurementValueService.searchQualityInspectionRequest(jsonObj);
		log.info("searchQualityInspectionRequest: {} " , map2);
		
		return map2;
	}
	/*
	 * //[다미]품질검사요청목록
	 * 
	 * @GetMapping("/qualityInspectionRequestList") public String
	 * qualityControlRequestList(Model model) { List<Map<String, Object>> resultMap
	 * = qualityInsMeasurementValueService.getQualityInspectionRequestList();
	 * log.info("test3333{}",resultMap); model.addAttribute("list", resultMap);
	 * return "quality/qualityInspectionRequestList";
	 * 
	 * }
	 */
	
	//[다미] 계약번호로 품목별 의뢰 코드 검색
	@PostMapping("/searchRequestProductCode")
	@ResponseBody
	public List<Map<String, Object>> searchRequestProductCode(@RequestParam(name = "contractCode")String contractCode){
		List<Map<String, Object>> resultMap = qualityInsMeasurementValueService.searchRequestProductCode(contractCode);
		return resultMap;
	}
		
	//[다미]품질검사 단일 요청
	@PostMapping("/qualityInspectionRequest")
	public String qualityInspectionRequest(QualityInspectionRequest qualityInspectionRequest) {
		qualityInsMeasurementValueService.qualityInspectionRequest(qualityInspectionRequest);
		return "redirect:qualityInspectionRequestList";
	}
	
	//[다미]품질검사요청
	@GetMapping("/qualityInspectionRequest")
	public String qualityControlRequest() {
		return "quality/qualityInspectionRequest";
	}
	
	//[다미]품질검사 세부 코드 검색
	@PostMapping("/subClassCate")
	@ResponseBody
	public List<Map<String, Object>> subClassCate(@RequestParam(name = "lowClassCateName") String lowClassCateName){
		return qualityInsMeasurementValueService.subClassCate(lowClassCateName);
	}
}
