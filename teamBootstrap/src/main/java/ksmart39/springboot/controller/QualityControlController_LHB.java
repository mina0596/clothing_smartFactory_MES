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
public class QualityControlController_LHB {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_LHB.class);
	@Autowired
	private QualityControlService qualityControlService;
	
	@Autowired
	private DefectiveProductService defectiveProductService;
	
	@Autowired 
	private QualityInsMeasurementValueService qualityInsMeasurementValueService;
	
	//================================================================
	//[한빛]불량품등록 -> 목록
	@PostMapping("/addDefectiveProduct")
	public String addDefectiveProduct(DefectiveProduct defectiveProduct) {
		defectiveProductService.addDefectiveProduct(defectiveProduct);
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
	
}
