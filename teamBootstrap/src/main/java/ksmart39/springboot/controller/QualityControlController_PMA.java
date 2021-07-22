package ksmart39.springboot.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.service.QualityControlService;


@Controller
@RequestMapping("/quality")
public class QualityControlController_PMA {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_PMA.class);
	
	@Autowired
	private QualityControlService qualityControlService;
	

	
	//=============================================================================
	
	
	//[민아]품질검사 기준표 등록
	@GetMapping("/addStandardTable")
	public String addStandardTable() {
		return "quality/addStandardTable";
	}
	//[민아]품질검사 기준표 목록
	@GetMapping("/standardTableList")
	public String getStandardTableList(Model model) {
		String levelCate = "등급";
		String numCate = "수치";
		String passCate = "합격/불합격";
		List<Map<String,Object>> levelStandardList = qualityControlService.getInspectionStandard(levelCate);
		List<Map<String,Object>> numStandardList = qualityControlService.getInspectionStandard(numCate);
		List<Map<String,Object>> passStandardList = qualityControlService.getInspectionStandard(passCate);
		model.addAttribute("levelStandardList", levelStandardList);
		model.addAttribute("numStandardList", numStandardList);
		model.addAttribute("passStandardList", passStandardList);
		return "quality/standardTableList";
	}
	
	@PostMapping("/sendProductInfoForInspection")
	@ResponseBody
	public Map<String,Object> getProductInfoForInspection(@RequestBody Map<String,Object> productInfo, Model model){
		log.info("productInfo :{}", productInfo);
		return productInfo;
	}
	
	//[민아]품질검사별 불량률 현황
	@GetMapping("/defectiveRateStatus")
	public String getDefectiveRate(Model model) {
		
		model.addAttribute("title", "검사현황관리:불량현황");
		return"quality/defectiveRateStatus";
	}
	
	
	
}
