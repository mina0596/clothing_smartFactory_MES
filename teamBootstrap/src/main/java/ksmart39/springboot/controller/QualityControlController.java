package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.QualityInspection;
import ksmart39.springboot.service.QualityControlService;

@Controller
public class QualityControlController {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController.class);
	@Autowired
	private QualityControlService qualityControlService;

	
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
		
		model.addAttribute("title", "품질관리");
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
	

	
	//=============================================================================

	@GetMapping("/addStandardTable")
	public String addStandardTable() {
		return "quality/addStandardTable";
	}
	//[민아]품질검사 기준표 목록
	@GetMapping("/getStandardTableList")
	public String getStandardTableList() {
		return "quality/StandardTableList";
	}
	
	
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

	//[다미&보람]수주계약별 기간별조회
		@GetMapping("/searchByPeriodContractQualityInspection")
		public String searchByPeriodContractQualityInspection() {
			return"quality/searchByPeriodContractQualityInspection";
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
	
	
	
	//====================================================================
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
	
	
	
	//=========================================================================
	//품질관리 메인화면
	@GetMapping("/qualityControl")
	public String getQulity() {
		return "quality/qualityControl";
	}
	
}
