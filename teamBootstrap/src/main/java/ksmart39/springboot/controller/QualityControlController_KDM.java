package ksmart39.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.service.QualityInsMeasurementValueService;

@Controller
@RequestMapping("/quality")
public class QualityControlController_KDM {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_KDM.class);
	
	@Autowired 
	private QualityInsMeasurementValueService qualityInsMeasurementValueService;
	
	//=============================================================================
	//[다미] 실시간 검사 현황
	@GetMapping("/qualityInspectionStatusNow")
	public String qualityInspectionStatusNow() {
		return "quality/qualityInspectionStatusNow";
	}
	
	//[다미&보람]수주계약별 검색 품질검사 현황
	@GetMapping("/qualityInspectionStatusContract")
	public String qualityInspectionStatusContract() {
		return "quality/qualityInspectionStatusContract";
	}
		
	//[다미&보람]수주계약별 검사현황
		@GetMapping("/stateBuyerContractQualityInspection")
		public String stateBuyerContractQualityInspection() {
			return"quality/stateBuyerContractQualityInspection";
		}


	//[다미&보람]의뢰품목별검사현황
		@GetMapping("/stateByProductQualityInspection")
		public String stateByProductQualityInspection() {
			return"quality/stateByProductQualityInspection";
		}
	//[다미&보람]의뢰품목별 기간별조회
		@GetMapping("/searchByPeriodByProductQualityInspection")
		public String searchByPeriodByProductQualityInspection() {
			return"quality/searchByPeriodByProductQualityInspection";
		}
	
	//[다미] 품질검사 측정값 목록
	@GetMapping("/inspectionMeasurementValueList")
	public String inspectionMeasurementValueList(Model model) {
		return "quality/inspectionMeasurementValueList";
	}
	
	//[다미] 품질검사 측정값 등록
	@PostMapping("/addInspectionMeasurementValue")
	public String addInspectionMeasurementValue(QualityInspectionResult qualityInspectionResult) {
												
		log.info("qualityInspectionResult: {}",qualityInspectionResult );
		
		
		
		return "redirect:inspectionMeasurementValueList";		
	}
	
	//[다미] 품질검사 측정값 등록 화면
	@GetMapping("/addInspectionMeasurementValue")
	public String addInspectionMeasurementValue(Model model) {
		return "quality/addInspectionMeasurementValue";
	}
	
	
	
	//====================================================================
	
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
		
		String str = (String)jsonObj.get("qualityInspectionRequestCode");
		log.info("3. String으로 변환 {}", str);
		
	    Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> map2 = qualityInsMeasurementValueService.searchQualityInspectionRequest(jsonObj);
		log.info("searchQualityInspectionRequest: {} " , map2);
		
		return map2;
	}
	
	//[다미]품질검사요청목록
	@GetMapping("/qualityInspectionRequestList")
	public String qualityControlRequestList() {
		return "quality/qualityInspectionRequestList";
		
	}
		
	//[다미]품질검사요청 메서드
	@PostMapping("/qualityInspectionRequest")
	public String qualityInspectionRequest(@RequestParam(name = "qualityInspection", required = false)String qualityInspection) {
		return "redirect:/qualityInspectionRequestList";
	}
	
	//[다미]품질검사요청
	@GetMapping("/qualityInspectionRequest")
	public String qualityControlRequest() {
		return "quality/qualityInspectionRequest";
	}
	
	
}
