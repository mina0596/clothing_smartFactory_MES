package ksmart39.springboot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import ksmart39.springboot.service.RawMaterialsService;

@Controller
public class RawMaterialsController {
	
	private static final Logger log = LoggerFactory.getLogger(RawMaterialsController.class);
	
	
	
	//=================================================================
	//[민아]원부자재 현재고 현황
	@GetMapping("/inventoryStatus")
	public String getInventoryStatus() {
		
		return "rawMaterials/inventoryStatus";
	}
	
	//[민아]원부자재 입출고 종합 조회
	@GetMapping("/warehousingList")
	public String getWarehousingList() {
		
		return "rawMaterials/warehousingList";
	}
	

	//===================================================================
	
	//[한빛]출고현황
	@GetMapping("/exWarehousingList")
	public String exWarehousingList() {
		return "rawMaterials/exWarehousingList";
	}
	//[한빛]출고등록
	@GetMapping("/addExWarehousing")
	public String addExWarehousing() {
		return "rawMaterials/addExWarehousing";
	}	
	
	//[한빛]소요별 자재 정보 입력 후 자재 입고 목록으로 리다이렉트 , 파라미터는 임시 값
	@PostMapping("/addMaterialsUse")
	public String addExWarehousing(@RequestParam(value = "raw_material_name", required = false )String raw_material_name) {
		
		return "redirect:/materialsUseList";
	}
	//[한빛]소요별 자재조회/목록
	@GetMapping("/materialsUseList")
	public String materialsUseList() {
		return "rawMaterials/materialsUseList";
	}
	
	//[한빛]소요별 자재등록
	@GetMapping("/addMaterialsUse")
	public String addMaterialsUse() {
		return "rawMaterials/addMaterialsUse";
	}
	

	//===================================================================
	//[다미]자재입고 수정
	@GetMapping("/modifyInWarehousing")
	public String modifyInWarehousing(@RequestParam(value = "raw_material_name", required = false)String raw_material_name) {
		return "rawMaterials/modifyInWarehousing";
	}
		//TO[다미] MATERIALS 빼주세용 METHOD명에, 내가 파일이름이랑 다른것들은 바꿧어요 FROM[민아]
	//[다미]자재입고 리스트
	@GetMapping("/inWarehousingList")
	public String InWarehousingList() {
		return "rawMaterials/inWarehousingList";
	}
	
	//[다미]자재 입고 등록 후 자재 입고 목록으로 리다이렉트 , 파라미터는 임시 값
	@PostMapping("/addInWarehousing")
	public String addInWarehousing(@RequestParam(value = "raw_material_name", required = false )String raw_material_name) {
		return "redirect:/inWarehousingList";
	}
	
	//[다미]자재 입고 등록
	@GetMapping("/addInWarehousing")
	public String addInWarehousing(@RequestParam(name = "materialName", required = false) String materialName
										  , Model model) {
		model.addAttribute("materialName", materialName);
		log.info("materialName 받아온값 {}", materialName);
		return "rawMaterials/addInWarehousing";
	}
	
	
	//=============================================================================
	//자재관리 메인화면
	@GetMapping("/rawMaterials")
	public String meterials() {
		return "rawMaterials/rawMaterials";
	}
}
