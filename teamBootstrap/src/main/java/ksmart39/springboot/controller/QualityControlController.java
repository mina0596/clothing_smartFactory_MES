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

@Controller
@RequestMapping("/quality")
public class QualityControlController {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController.class);
	@Autowired
	private QualityControlService qualityControlService;
	
	@Autowired
	private DefectiveProductService defectiveProductService;
	
	@Autowired 
	private QualityInsMeasurementValueService qualityInsMeasurementValueService;
	
	//================================================================
	//[한빛]불량품등록 -> 목록
	@PostMapping("/addDefectiveProduct")
	public String addDefectiveProduct() {
		return "redirect:/defectiveProductList";
	}
	

	//[한빛]불량품 등록
	@GetMapping("/addDefectiveProduct")
	public String addDefectiveProduct(Model model) {
		
		model.addAttribute("title", "품질관리");
		return"quality/addDefectiveProduct";
	}
		
	//[한빛]불량품 수정
	@GetMapping("/modifyDefectiveProduct")
	public String modifyDefectiveProduct(Model model) {
		model.addAttribute("title", "불량품수정");
		return"quality/modifyDefectiveProduct";
	}
	
	//[한빛]불량품 조회
	@GetMapping("/defectiveProductList")
	public String getDefectiveProductList(Model model) {
		List<DefectiveProduct> defectiveProduct = defectiveProductService.getDefectiveProduct();
		model.addAttribute("title", "품질관리");
		model.addAttribute("defectiveProduct", defectiveProduct);
		return"quality/defectiveProductList";
	}

	
	//================================================================
	//검사현황 실적 
	@GetMapping("/inspectionPerformance")
	public String inspectionPerformance(Model model) {
		
		model.addAttribute("title", "검사현황관리:실적");
		return"quality/inspectionPerformance";
	}
	
	//[한빛]불량현황등록 메서드
	@GetMapping("/addDefectInspectionResultStatus")
	public String addDefectInspectionResultStatus(Model model) {
		
		model.addAttribute("title", "검사현황관리:불량현황");
		return"quality/addDefectInspectionResultStatus";
	}
	
	
	//=============================================================================

	@GetMapping("/addStandardTable")
	public String addStandardTable() {
		return "quality/addStandardTable";
	}
	//[민아]품질검사 기준표 목록
	@GetMapping("/standardTableList")
	public String getStandardTableList() {
		return "quality/standardTableList";
	}
	
	
	//품질관리 메인화면
	@GetMapping("/qualityControl")
	public String getQulity() {
		return "quality/qualityControl";
	}
	
}
