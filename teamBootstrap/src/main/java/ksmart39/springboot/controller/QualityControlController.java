package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QualityControlController {

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
		
		model.addAttribute("title", "품질관리");
		return"quality/defectiveProductList";
	}

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
	
	//검사현황 성적서조회 및리스트
	@GetMapping("/qualityInspectionReport")
	public String qualityInspectionReport(Model model) {
		
		model.addAttribute("title", "검사현황관리:성적서조회및 리스트");
		return"quality/qualityInspectionReport";
	}
	
	
	//[다미+보람]검사현황최종결과등록
	@GetMapping("/addFinalnspectionMeasurementValue")
	public String addQualityInspectionReport(Model model) {
		
		model.addAttribute("title", "품질관리");
		return"quality/addFinalnspectionMeasurementValue";
	}
	
	//검사현황 등록
	@GetMapping("/addQualityInspectionStatus")
	public String addInspectionStatus(Model model) {
		
		model.addAttribute("title", "검사현황관리:검사현황등록");
		return"quality/addQualityInspectionStatus";
	}
	
	

	//[보람] 검사 리스트 검사번호클릭시 검사정보 경로
			@GetMapping("qualityInspectionInfo")
			public String qualityInspectionInfo() {
				return "quality/qualityInspectionInfo";
			}
			
	//[보람 ]검사 수정 완료
	@PostMapping("/modifyQualityInspection")
	public String  modifyQualityInspection() {
		
		return"redirect:/qualityInspectionList";
	}
	//[보람] 검사 수정 경로
	@GetMapping("/modifyQualityInspection")
	public String getModifyQualityInspection() {
		return "quality/modifyQualityInspection";
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
		return"quality/addQualityInspection";
	}	
	

	@GetMapping("/addStandardTable")
	public String addStandardTable() {
		return "quality/addStandardTable";
	}
	
	//[민아]품질검사 기준표 목록
	@GetMapping("/getStandardTableList")
	public String getStandardTableList() {
		return "quality/StandardTableList";
	}
	
	
	
	//[다미&보람] 품질검사 측정값 목록
	@GetMapping("/inspectionMeasurementValueList")
	public String inspectionMeasurementValueList(Model model) {
		return "quality/inspectionMeasurementValueList";
	}
	
	//[다미&보람] 품질검사 측정값 등록
	@GetMapping("/addInspectionMeasurementValue")
	public String addInspectionMeasurementValue(Model model) {
		return "quality/addInspectionMeasurementValue";
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
	
	//품질관리 메인화면
	@GetMapping("/qualityControl")
	public String getQulity() {
		return "quality/qualityControl";
	}
	
}
