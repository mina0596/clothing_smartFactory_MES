package ksmart39.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.service.DefectiveProductService;
import ksmart39.springboot.service.QualityControlService;
import ksmart39.springboot.service.QualityInsMeasurementValueService;
import ksmart39.springboot.service.QualityInsepctionResultService;

@Controller
@RequestMapping("/quality")
public class QualityControlController_HBR {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_HBR.class);
	@Autowired
	private QualityInsepctionResultService qualityInsepctionResultService;
	
	//================================================================

		//[다미+보람]검사현황 조회 거래처명가지고오기
		@RequestMapping(value = "/clientName", method =RequestMethod.GET)
		@ResponseBody
		public List<Map<String,Object>> getClientName(){
			List<Map<String,Object>> clientList =qualityInsepctionResultService.getClientName();
			log.info("=============================================");
			log.info("거래처명 :  {}", clientList);
			log.info("=============================================");
			return clientList;
		}
	
	//검사현황 성적서조회 및리스트
	@GetMapping("/qualityInspectionReport")
	public String qualityInspectionReport(Model model) {
		List<Map<String,Object>> finalResultList = qualityInsepctionResultService.getInsepectionFinalResult();
		log.info("=============================================");
		log.info("최종성적리스트 :  {} ", finalResultList);
		log.info("=============================================");
		model.addAttribute("finalResultList", finalResultList);
		return"quality/qualityInspectionReport";
	}
	
	
	//[다미+보람]검사현황최종결과등록
	@GetMapping("/addFinalnspectionMeasurementValue")
	public String addQualityInspectionReport(Model model) {
		
		model.addAttribute("title", "품질관리");
		return"quality/addFinalnspectionMeasurementValue";
	}
	

	
	//[다미&보람]수주계약별 기간별조회
		@GetMapping("/searchByPeriodContractQualityInspection")
		public String searchByPeriodContractQualityInspection() {
			return"quality/searchByPeriodContractQualityInspection";
		}

	
	
	
	
	
	//=========================================================================

	
}