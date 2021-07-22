package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;

import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.SubClassInspection;
import ksmart39.springboot.service.SystemService;

@Controller
@RequestMapping("/system")
public class SystemController_HBR {

	private final SystemService systemService;

	@Autowired
	public SystemController_HBR(SystemService systemService) {
		this.systemService = systemService;
	}

	private static final Logger log = LoggerFactory.getLogger(SystemController_HBR.class);


	//[보람]품질검사 삭제
	@RequestMapping(value = "/deleteInspection")
	@ResponseBody
	public String deleteQualityInspection(HttpServletRequest request) {
		//보내는것을 Requestparam으로 보내는지 아니면 서블렛request로 하는지 좀더 고민
		//checkArray에 담았으니 생각해보기
		//https://won-percent.tistory.com/48 참고한것 
		return "redirect:/system/qualityInspectionList";
	}
	
	// [보람]품질검사 대분류 ajax 처리
	@RequestMapping(value = "/highClassCate" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getHighClassCate() {
		List<Map<String,Object>> highCate =systemService.getHighClassCate();
		log.info("========================================");
		log.info("highCate {}",highCate);
		log.info("========================================");
		return highCate;
	}
	//[보람] 품질검사 중분류 가지고오기
	@RequestMapping(value = "/mediumClassCate" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getMediumClassCate(@RequestParam(value = "highClassCateName", required = false)String highClassCateName) {
		List<Map<String,Object>> mediumCate = systemService.getMediumClassCate(highClassCateName);
		log.info("========================================");
		log.info("mediumCate {}",mediumCate);
		log.info("========================================");
		
		return mediumCate;
	}
	//[보람] 품질검사 소분류 가지고오기
	@RequestMapping(value = "/lowClassCate" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getLowClassCate(@RequestParam(value = "middleClassCateName", required = false)String middleClassCateName) {
		List<Map<String,Object>> lowCate = systemService.getLowClassCate(middleClassCateName);
		log.info("========================================");
		log.info("mediumCate {}",lowCate);
		log.info("========================================");
		
		return lowCate;
	}

	// [보람] 검사 리스트 검사번호클릭시 검사정보 경로
	@GetMapping("qualityInspectionInfo")
	public String qualityInspectionInfo() {
		return "system/qualityInspectionInfo";
	}

	// [보람 ]검사 수정 완료
	@PostMapping("/modifyQualityInspection")
	public String modifyQualityInspection(SubClassInspection subClassInspection) {
		log.info("========================================");
		log.info("화면에서 입력받은 값(수정화면폼)subClassInspection:{}",subClassInspection);
		log.info("========================================");
		
		systemService.modifyQualityInspection(subClassInspection);
		return "redirect:/qualityInspectionList";
	}

	// [보람] 검사 수정 경로
	@GetMapping("/modifyQualityInspection")
	public String modifyQualityInspection(Model model
			,@RequestParam(name ="qualityInspectionCode",required = false) String qualityInspectionCode) {
		log.info("========================================");
		log.info("화면에서입력받은검사수정폼 qualityInspectionCode:{}",qualityInspectionCode);
		log.info("========================================");
		//1.검사 코드로 검사객체조회한 SubClassInspection객체
		SubClassInspection subClassInspection =systemService.getQualityInspectionCode(qualityInspectionCode);
		
		//2.Model 화면에 객체 삽입
		model.addAttribute("subClassInspection", subClassInspection);
		log.info("subClassInspection:{}",subClassInspection);
		
		return "system/modifyQualityInspection";
	}

	// [보람] 검사 리스트
	  @GetMapping("/qualityInspectionList")
	  public String getQualityInspectionList(Model model) {   
		  List<Map<String, Object>> resultMap = systemService.getQualityInspectionList();
	  
	  log.info("========================================");
	  log.info("qualityInspectionList - {}:", resultMap.toString());
	  log.info("========================================");
	  model.addAttribute("qualityInspectionList", resultMap);
	  
	  
	  return"system/qualityInspectionList"; 
	  }
	  //[보람]품질검사 등록 메서드
	  @PostMapping("/addQualityInspection")
	  public String addQualityInspection(@RequestParam(name = "highClassCode",required = false)String highClassCode,
			  							@RequestParam(name = "highMedClassCode",required = false)String highMedClassCode,
			  							@RequestParam(name = "highMedLowClassCode",required = false)String highMedLowClassCode,
			  							@RequestParam(name = "subClassName",required = false)String subClassName) {
		  log.info("========================================");
		  log.info("highClassCode {}:",highClassCode);
		  log.info("highMedClassCode {}:",highMedClassCode);
		  log.info("highMedLowClassCode {}:",highMedLowClassCode);
		  log.info("subClassName {}:",subClassName);
		  log.info("========================================");
		  systemService.addQualityInspection(highClassCode, highMedClassCode, highMedLowClassCode, subClassName);
		 
		  return "redirect:/system/qualityInspectionList";
	  }
	  
	  
	  
	  //검사종류 등록 메서드
	  
	  @GetMapping("/addQualityInspection") 
	  public String addQualityInspection(Model  model) {
	  
	  model.addAttribute("title", "품질검사:검사등록");
	  return"system/addQualityInspection"; }
	 

}
