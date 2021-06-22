package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QualityControlController {

	
	//불량품 등록
		@GetMapping("/addDefectiveProduct")
		public String addDefectiveProduct(Model model) {
			
			model.addAttribute("title", "불량품 등록");
			return"quality/#addDefectiveProduct";
		}
		
	//불량품 조회
	@GetMapping("/defectiveProductList")
	public String getDefectiveProductList(Model model) {
		
		model.addAttribute("title", "불량품 조회");
		return"quality/#defectiveProductList";
	}

	//검사현황 실적 
	@GetMapping("/inspectionPerformance")
	public String inspectionPerformance(Model model) {
		
		model.addAttribute("title", "검사현황관리:실적");
		return"quality/inspectionPerformance";
	}
	//불량현황등록 메서드
	@GetMapping("/addDefectInspectionResultStatus")
	public String addDefectInspectionResultStatus(Model model) {
		
		model.addAttribute("title", "검사현황관리:불량현황");
		return"quality/addDefectInspectionResultStatus";
	}
	//검사현황 성적서조회 및리스트
	@GetMapping("/qualityInspectionReport")
	public String qualityInspectionReport(Model model) {
		
		model.addAttribute("title", "검사현황관리:성적서조회및 리스트");
		return"quality/qualityInspectionReport";
	}
	//검사현황 성적서등록
	@GetMapping("/addQualityInspectionReport")
	public String addQualityInspectionReport(Model model) {
		
		model.addAttribute("title", "검사현황관리:성적서등록");
		return"quality/addQualityInspectionReport";
	}
	//검사현황 등록
	@GetMapping("/addQualityInspectionStatus")
	public String addInspectionStatus(Model model) {
		
		model.addAttribute("title", "검사현황관리:검사현황등록");
		return"quality/addQualityInspectionStatus";
	}

	//검사종류 리스트 메서드
	@GetMapping("/qualityInspectionList")
	public String getQualityInspectionList(Model model,@RequestParam(name = "qualityInspectionSearchkey",required = false)String qualityInspectionSearchkey
			,@RequestParam(name ="qualityInspectionSearchValue",required = false )String qualityInspectionSearchValue) {
	
		
		model.addAttribute("title", "품질검사:검사목록 및 조회목록");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("qualityInspectionSearchkey", qualityInspectionSearchkey);
		paramMap.put("qualityInspectionSearchValue", qualityInspectionSearchValue);
		return"quality/qualityInspectionList";
	}
	
	//검사종류 등록 메서드
	@GetMapping("/addQualityInspection")
	public String addQualityInspection(Model model) {
		
		model.addAttribute("title", "품질검사:검사등록");
		return"quality/!addQualityInspection";
	}	
	

	@GetMapping("/addStandardTable")
	public String addStandardTable() {
		return "quality/addStandardTable";
	}
	
	@GetMapping("/getStandardTableList")
	public String getStandardTableList() {
		return "quality/StandardTableList";
	}
	@GetMapping("/qualityControlRequestList")
	public String qualityControlRequestList() {
		return "quality/qualityControlRequestList";
	}
	
	@GetMapping("/qualityControlRequest")
	public String qualityControlRequest() {
		return "quality/qualityControlRequest";
	}
	
	@GetMapping("/qualityControl")
	public String getQulity() {
		return "quality/qualityControl";
	}
	
}
