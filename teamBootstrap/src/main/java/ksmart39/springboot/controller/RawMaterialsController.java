package ksmart39.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RawMaterialsController {
	
	//[한빛]소요별 자재 정보 입력 후 자재 입고 목록으로 리다이렉트 , 파라미터는 임시 값
	@PostMapping("/addExWarehousing")
	public String addExWarehousing(@RequestParam(value = "raw_material_name", required = false )String raw_material_name) {
		return "redirect:/exWarehousingList";
	}
	
	//[한빛]출고현황
	@GetMapping("/exWarehousingStatus")
	public String exWarehousingStatus() {
		return "rawMaterials/exWarehousingStatus";
	}
	
	//[한빛]소요별 자재조회/목록
	@GetMapping("/exWarehousingList")
	public String exWarehousingList() {
		return "rawMaterials/exWarehousingList";
	}
	
	//[한빛]소요별 자재등록
	@GetMapping("/addExWarehousing")
	public String addExWarehousing() {
		return "rawMaterials/addExWarehousing";
	}
	
	//[민아]원부자재 등록화면
	@GetMapping("/addRawMaterials")
	public String addRawMeterials() {
		return "rawMaterials/addRawMaterials";
	}
		
	//[민아]원부자재 목록
	@GetMapping("/rawMaterialsList")
	public String getRawMeterialsList() {
		return "rawMaterials/rawMaterialsList";
	}
	
	//[다미]자재입고 수정
	@GetMapping("/inWarehousingModify")
	public String inWarehousingMaterialsModify(@RequestParam(value = "raw_material_name", required = false)String raw_material_name) {
		return "redirect:/inWarehousingList";
	}
		//TO[다미] MATERIALS 빼주세용 METHOD명에, 내가 파일이름이랑 다른것들은 바꿧어요 FROM[민아]
	//[다미]자재입고 리스트
	@GetMapping("/inWarehousingList")
	public String InWarehousingMaterialsList() {
		return "rawMaterials/inWarehousingList";
	}
	
	//[다미]자재 입고 등록 후 자재 입고 목록으로 리다이렉트 , 파라미터는 임시 값
	@PostMapping("/addInWarehousing")
	public String addInWarehousingMaterials(@RequestParam(value = "raw_material_name", required = false )String raw_material_name) {
		return "redirect:/inWarehousingList";
	}
	
	//[다미]자재 입고 등록
	@GetMapping("/addInWarehousing")
	public String addInWarehousingMaterials() {
		return "rawMaterials/addInWarehousing";
	}
	
	//자재관리 메인화면
	@GetMapping("/rawMaterials")
	public String meterials() {
		return "rawMaterials/rawMaterials";
	}
}
