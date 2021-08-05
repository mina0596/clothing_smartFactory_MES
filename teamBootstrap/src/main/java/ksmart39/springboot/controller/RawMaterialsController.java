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

import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.RawMaterialsInventory;
import ksmart39.springboot.domain.SupplierRequest;
import ksmart39.springboot.service.RawMaterialsInventoryStatusService;
import ksmart39.springboot.service.RawMaterialsInwarehousingService;
import ksmart39.springboot.service.RawMaterialsService;

@Controller
@RequestMapping("/rawMaterials")
public class RawMaterialsController {
	
	private static final Logger log = LoggerFactory.getLogger(RawMaterialsController.class);
	
	
	
	/**************************************************************************************************/
	
	private final RawMaterialsInventoryStatusService materialsInventoryStatusService;
	private final RawMaterialsInwarehousingService rawMaterialInwarehousingService;
	
	@Autowired
	public RawMaterialsController(RawMaterialsInventoryStatusService materialsInventoryStatusService, RawMaterialsInwarehousingService rawMaterialInwarehousingService) {
		this.materialsInventoryStatusService = materialsInventoryStatusService;
		this.rawMaterialInwarehousingService = rawMaterialInwarehousingService;
	}
	
	/**************************************************************************************************/
	//[다미]자재입고 리스트
	@GetMapping("/inWarehousingList")
	public String InWarehousingList(Model model) {
		String str= null;
		List<RawMaterialsInventory> list = rawMaterialInwarehousingService.getRawMaterialInwarehousingList();
		
		log.info("getRawMaterialInwarehousingList 받아온값 {}", list);
		model.addAttribute("list", list);
		
		return "rawMaterials/inWarehousingList";
	}
	
	//[다미]자재 입고 등록 후 자재 입고 목록으로 리다이렉트 , 파라미터는 임시 값
	@PostMapping("/addInWarehousing")
	public String addInWarehousing() {
		return "redirect:inWarehousingList";
	}
	
	//[다미]자재 입고 등록
	@GetMapping("/addInWarehousing")
	public String addInWarehousing(@RequestParam(name = "materialName", required = false) String materialName
										  , Model model) {
		model.addAttribute("materialName", materialName);
		log.info("materialName 받아온값 {}", materialName);
		return "rawMaterials/addInWarehousing";
	}	
	
	
	/**************************************************************************************************/
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
	/**************************************************************************************************/
	//[민아]입출고 검색창
	@GetMapping("/inventorySearch")
	public String getInventorySearchKey() {
		return "rawMaterials/inventorySearch";
	}
	
	//[민아]원부자재 현재고 현황
	@GetMapping("/inventoryStatus")
	public String getInventoryStatus(Model model) {
		List<Map<String,Object>> inventoryStatusList = materialsInventoryStatusService.getInventoryStatusByMCode();
		model.addAttribute("inventoryStatusList", inventoryStatusList);
		return "rawMaterials/inventoryStatus";
	}
	
	//[민아]출고내역 수정
	@GetMapping("/modifyExWarehousing")
	public String modifyExWarehousing() {
		return "rawMaterials/modifyExWarehousing";
	}	
	
	//[민아]원부자재 입출고 종합 조회
	@GetMapping("/warehousingList")
	public String getWarehousingList(Model model) {
		List<RawMaterialsInventory> inventoryList = materialsInventoryStatusService.getRawMaterialsInventory();
		
		model.addAttribute("inventoryList", inventoryList);
		log.info("inventoryList -{}", inventoryList);
		
		return "rawMaterials/warehousingList";
	}
	

	//===================================================================
	//[다미]자재입고 수정 + [민아] 자재입고현황에서 수정화면으로 넘어갈때 상황 추가
	@GetMapping("/modifyInWarehousing")
	public String modifyInWarehousing(@RequestParam(value = "transactionCode", required = false)String transactionCode
									 ,String transactionCate
									 ,Model model) {
		
		
		RawMaterialsInventory InventoryInfoByCode = materialsInventoryStatusService.getTransInfoByCode(transactionCode);
		
		model.addAttribute("transactionCode", transactionCode);
		model.addAttribute("InventoryInfoByCode", InventoryInfoByCode);
		
		return "rawMaterials/modifyInWarehousing";
	}
	
	
	//[민아]자재입고 수정 후 자재입고 리스트 출력
	@PostMapping("/modifyInWarehousing")
	public String modifyInWarehousing(int transactionAmount, String transactionCode) {
		log.info("transactionAmount: {}", transactionAmount);
		log.info("transactionCode: {}", transactionCode);
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("transactionAmount", transactionAmount);
		paramMap.put("transactionCode", transactionCode);
		
		log.info("param :{}", paramMap);
		materialsInventoryStatusService.modifyMaterialIn(paramMap);
		
		return "rawMaterials/inWarehousingList";
	}	
	
	/**************************************************************************************************/

	//자재관리 메인화면
	@GetMapping("/rawMaterials")
	public String meterials() {
		return "rawMaterials/rawMaterials";
	}
}
