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


	//품질관리 메인화면
	@GetMapping("/qualityControl")
	public String getQulity() {
		return "quality/qualityControl";
	}
	
}
