package ksmart39.springboot.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.paging.Pagination;
import ksmart39.springboot.service.DefectiveProductService;
import ksmart39.springboot.service.QualityInsMeasurementValueService;

@Controller
@RequestMapping("/quality")
public class QualityControlController_LHB {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_LHB.class);
	
	@Autowired
	private DefectiveProductService defectiveProductService;
	@Autowired 
	private QualityInsMeasurementValueService qualityInsMeasurementValueService;

	

	
	//================================================================
	//[한빛]불량품 등록
	@GetMapping("/addDefectiveProduct")
	public String addDefectiveProduct(Model model, HttpSession session) {	
		String employeeCode = (String) session.getAttribute("SCODE");
		log.info("employeeCode 세션에서 가져오는 값:{}", employeeCode);
		model.addAttribute("employeeCode", employeeCode);
		model.addAttribute("title", "품질관리");
		return"quality/addDefectiveProduct";
	}		
	
	//[한빛]불량품등록 -> 목록
	@PostMapping("/addDefectiveProduct")
	public String addDefectiveProduct(DefectiveProduct defectiveProduct) {
		defectiveProductService.addDefectiveProduct(defectiveProduct);
		return "redirect:defectiveProductList";
	}
	
	//[한빛] 모달뿌려주기
	@GetMapping("/getFinalResult")
	@ResponseBody
	public List<QualityInspectionResult> getFinalResult(@RequestParam(name = "fail", required = false)String fail){
		List<QualityInspectionResult> finalResult = defectiveProductService.getFinalResult(fail);
		return finalResult;
	}
	
	//[한빛]불량품 조회
	@GetMapping("/defectiveProductList")
	public String getDefectiveProductList(@RequestParam(name = "searchKey", required = false) String searchKey,
													@RequestParam(name = "searchValue", required = false) String searchValue, 
																					Model model, Pagination paging) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);

	    Map<String, Object> resultMap = defectiveProductService.getDefectiveProduct(paging);
	    model.addAttribute("defectiveProductList", 					resultMap.get("defectiveProductList"));
	    model.addAttribute("currentPage", 					resultMap.get("currentPage"));
		model.addAttribute("lastPage", 						resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 					resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 					resultMap.get("pageEndNum"));
		model.addAttribute("searchKey", 					paramMap.get("searchKey"));
		model.addAttribute("searchValue", 					paramMap.get("searchValue"));

		return "quality/defectiveProductList";
	}
	
	//[한빛]불량품 수정
	@GetMapping("/modifyDefectiveProduct")
	public String modifyDefectiveProduct(@RequestParam(name = "defectiveProductCode", required= false) String defectiveProductCode, Model model, HttpSession session) {
		String employeeCode = (String) session.getAttribute("SCODE");
		log.info("employeeCode 세션에서 가져오는 값:{}", employeeCode);
		DefectiveProduct defectiveProduct = defectiveProductService.getProductByCode(defectiveProductCode);
		model.addAttribute("employeeCode", employeeCode);
		model.addAttribute("defectiveProduct",defectiveProduct);
		model.addAttribute("title", "불량품수정");
		return"quality/modifyDefectiveProduct";
	}
	
	//[한빛]불량품 수정
	@PostMapping("/modifyDefectiveProduct")
	public String modifyDefectiveProduct(DefectiveProduct defectiveProduct) {
		defectiveProductService.modifyDefectiveProduct(defectiveProduct);
		return "redirect:defectiveProductList";
	}
	
	//[한빛] 불량품 삭제
	@PostMapping("deleteDefectiveProduct")
	@ResponseBody
	public int deleteDefectiveProduct(@RequestParam(value = "delArr[]")List<String> delArr) {
		System.out.println(delArr);
		int result = 0;
		result = defectiveProductService.deleteDefectiveProduct(delArr);
		return result;
	}	
	
	//[한빛]품질검사요청목록
	@GetMapping("/qualityInspectionRequestList")
	public String qualityControlRequestList(Model model) {
		List<Map<String, Object>> resultMap = qualityInsMeasurementValueService.getQualityInspectionRequestList();
		log.info("test3333{}",resultMap);
		model.addAttribute("list", resultMap);
		return "quality/qualityInspectionRequestList";
		
	}
	
	//[한빛] 품질검사요청 승인
	@PostMapping("/approvalInspectionRequest")
	@ResponseBody
	public boolean approvalInspectionRequest(@RequestParam(name = "qualityInspectionRequestCode", required = false) String qualityInspectionRequestCode) {
		boolean approval = false;
		int result = qualityInsMeasurementValueService.approvalInspectionRequest(qualityInspectionRequestCode);
		if(result > 0) approval = true;
		return approval;
	}
}
