package ksmart39.springboot.controller;


import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.service.DefectiveProductService;
import ksmart39.springboot.service.QualityControlService;
import ksmart39.springboot.service.QualityInsMeasurementValueService;

@Controller
@RequestMapping("/quality")
public class QualityControlController_PMA {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_PMA.class);
	
	@Autowired
	private QualityControlService qualityControlService;
	

	
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
	
	@PostMapping("/sendProductInfoForInspection")
	@ResponseBody
	public Map<String,Object> getProductInfoForInspection(@RequestBody Map<String,Object> productInfo, Model model){
		log.info("productInfo :{}", productInfo);
		return productInfo;
	}
}
