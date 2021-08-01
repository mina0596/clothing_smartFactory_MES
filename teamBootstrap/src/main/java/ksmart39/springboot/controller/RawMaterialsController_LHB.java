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
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.RawMaterialsInventory;
import ksmart39.springboot.domain.SupplierRequest;
import ksmart39.springboot.service.RawMaterialsInventoryStatusService;
import ksmart39.springboot.service.RawMaterialsService;

@Controller
@RequestMapping("/rawMaterials")
public class RawMaterialsController_LHB {
	
	private static final Logger log = LoggerFactory.getLogger(RawMaterialsController_LHB.class);
	
	
	
	/**************************************************************************************************/
	
	private final RawMaterialsInventoryStatusService materialsInventoryStatusService;
	
	@Autowired
	public RawMaterialsController_LHB(RawMaterialsInventoryStatusService materialsInventoryStatusService) {
		this.materialsInventoryStatusService = materialsInventoryStatusService;
	}
	
	
	
	//===================================================================
	//[한빛]출고등록
	@GetMapping("/addExWarehousing")
	public String addExWarehousing(Model model, HttpSession session) {
		String employeeCode = (String) session.getAttribute("SCODE");
		log.info("employeeCode 세션에서 가져오는 값:{}", employeeCode);
		model.addAttribute("employeeCode", employeeCode);
		model.addAttribute("title","출고관리");
		return "rawMaterials/addExWarehousing";
	}
	
	//[한빛]출고 등록 -> 조회
	@PostMapping("/addExWarehousing")
	public String addExWarehousing(RawMaterialsInventory rawMaterialsInventory) {
		materialsInventoryStatusService.addExwarehousing(rawMaterialsInventory);
		return "redirect:exWarehousingList";
	}
	
	//[한빛]출고현황
	@GetMapping("/exWarehousingList")
	public String getExWarehousingList(Model model) {
		List<Map<String,Object>> exHousingList = materialsInventoryStatusService.getExwarehousing();
		model.addAttribute("exHousingList",exHousingList);
		return "rawMaterials/exWarehousingList";
	}
	
	//[한빛] 출고 수정
	@GetMapping("/modifyExHousing")
	public String modifyExHousing (@RequestParam(name = "transactionCode", required= false) String transactionCode, Model model, HttpSession session) {
		String employeeCode = (String) session.getAttribute("SCODE");
		log.info("employeeCode 세션에서 가져오는 값:{}", employeeCode);
		RawMaterialsInventory rawMaterialsInventory = materialsInventoryStatusService.getExhousingByCode(transactionCode);
		model.addAttribute("employeeCode", employeeCode);
		model.addAttribute("rawMaterialsInventory",rawMaterialsInventory);
		model.addAttribute("title", "불량품수정");
		return "rawMaterials/modifyExWarehousing";
	}
	
	//[한빛] 출고 수정
	@PostMapping("/modifyExHousing")
	public String modifyExHousing(RawMaterialsInventory rawMaterialsInventory) {
		materialsInventoryStatusService.modifyExHousing(rawMaterialsInventory);
		return "redirect:exWarehousingList";
	}
	
	//[한빛] 출고 삭제
	@PostMapping("/deleteExHousing")
	@ResponseBody
	public int deleteExHousing(@RequestParam(value = "delArr[]")List<String> delArr) {
		System.out.println(delArr);
		int result = 0;
		result = materialsInventoryStatusService.deleteExHousing(delArr);
		return result;
	}
	
	//[한빛] 모달뿌려주기
	@GetMapping("/getSupplierRequest")
	@ResponseBody
	public List<SupplierRequest> getSupplierRequest(@RequestParam(name = "approval", required = false )String approval) {
		List<SupplierRequest> supplierRequest = materialsInventoryStatusService.getSupplierRequest(approval); 
		return supplierRequest;
	}
}
