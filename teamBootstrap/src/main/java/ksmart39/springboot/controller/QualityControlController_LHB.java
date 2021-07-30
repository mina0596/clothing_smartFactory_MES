package ksmart39.springboot.controller;



import java.util.List;

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
import ksmart39.springboot.service.DefectiveProductService;

@Controller
@RequestMapping("/quality")
public class QualityControlController_LHB {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_LHB.class);
	
	@Autowired
	private DefectiveProductService defectiveProductService;
	

	
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
	public String getDefectiveProductList(Model model) {
		List<DefectiveProduct> defectiveProduct = defectiveProductService.getDefectiveProduct();
		model.addAttribute("title", "품질관리");
		model.addAttribute("defectiveProduct", defectiveProduct);
		return"quality/defectiveProductList";
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
}
