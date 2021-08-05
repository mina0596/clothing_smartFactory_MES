/*
 * package ksmart39.springboot.controller;
 * 
 * 
 * import java.util.HashMap; import java.util.List; import java.util.Map;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import ksmart39.springboot.domain.HumanResources; import
 * ksmart39.springboot.domain.RawMaterials; import
 * ksmart39.springboot.domain.RawMaterialsInventory; import
 * ksmart39.springboot.service.RawMaterialsInventoryStatusService; import
 * ksmart39.springboot.service.RawMaterialsService;
 * 
 * @Controller
 * 
 * @RequestMapping("/rawMaterials") public class RawMaterialsController_PMA {
 * 
 * private static final Logger log =
 * LoggerFactory.getLogger(RawMaterialsController_PMA.class);
 * 
 * 
 * 
 *//**************************************************************************************************//*
																										 * 
																										 * private final
																										 * RawMaterialsInventoryStatusService
																										 * materialsInventoryStatusService;
																										 * 
																										 * @Autowired
																										 * public
																										 * RawMaterialsController_PMA
																										 * (
																										 * RawMaterialsInventoryStatusService
																										 * materialsInventoryStatusService)
																										 * { this.
																										 * materialsInventoryStatusService
																										 * =
																										 * materialsInventoryStatusService;
																										 * }
																										 * 
																										 * //[민아]입출고 검색창
																										 * 
																										 * @GetMapping(
																										 * "/inventorySearch")
																										 * public String
																										 * getInventorySearchKey
																										 * () { return
																										 * "rawMaterials/inventorySearch";
																										 * }
																										 * 
																										 * //[민아]원부자재
																										 * 현재고 현황
																										 * 
																										 * @GetMapping(
																										 * "/inventoryStatus")
																										 * public String
																										 * getInventoryStatus
																										 * (Model model)
																										 * { List<Map<
																										 * String,Object
																										 * >>
																										 * inventoryStatusList
																										 * =
																										 * materialsInventoryStatusService
																										 * .
																										 * getInventoryStatusByMCode
																										 * (); model.
																										 * addAttribute(
																										 * "inventoryStatusList",
																										 * inventoryStatusList
																										 * ); return
																										 * "rawMaterials/inventoryStatus";
																										 * }
																										 * 
																										 * //[민아]출고내역 수정
																										 * 
																										 * @GetMapping(
																										 * "/modifyExWarehousing")
																										 * public String
																										 * modifyExWarehousing
																										 * () { return
																										 * "rawMaterials/modifyExWarehousing";
																										 * }
																										 * 
																										 * //[민아]원부자재
																										 * 입출고 종합 조회
																										 * 
																										 * @GetMapping(
																										 * "/warehousingList")
																										 * public String
																										 * getWarehousingList
																										 * (Model model)
																										 * { List<
																										 * RawMaterialsInventory>
																										 * inventoryList
																										 * =
																										 * materialsInventoryStatusService
																										 * .
																										 * getRawMaterialsInventory
																										 * ();
																										 * 
																										 * model.
																										 * addAttribute(
																										 * "inventoryList",
																										 * inventoryList
																										 * ); log.
																										 * info("inventoryList -{}"
																										 * ,
																										 * inventoryList
																										 * );
																										 * 
																										 * return
																										 * "rawMaterials/warehousingList";
																										 * }
																										 * 
																										 * 
																										 * //===========
																										 * =============
																										 * =============
																										 * =============
																										 * =============
																										 * ====
																										 * //[다미]자재입고 수정
																										 * + [민아]
																										 * 자재입고현황에서
																										 * 수정화면으로 넘어갈때
																										 * 상황 추가
																										 * 
																										 * @GetMapping(
																										 * "/modifyInWarehousing")
																										 * public String
																										 * modifyInWarehousing
																										 * (@
																										 * RequestParam(
																										 * value =
																										 * "transactionCode",
																										 * required =
																										 * false)String
																										 * transactionCode
																										 * ,String
																										 * transactionCate
																										 * ,Model model)
																										 * {
																										 * 
																										 * 
																										 * RawMaterialsInventory
																										 * InventoryInfoByCode
																										 * =
																										 * materialsInventoryStatusService
																										 * .
																										 * getTransInfoByCode
																										 * (
																										 * transactionCode
																										 * );
																										 * 
																										 * model.
																										 * addAttribute(
																										 * "transactionCode",
																										 * transactionCode
																										 * ); model.
																										 * addAttribute(
																										 * "InventoryInfoByCode",
																										 * InventoryInfoByCode
																										 * );
																										 * 
																										 * return
																										 * "rawMaterials/modifyInWarehousing";
																										 * }
																										 * 
																										 * 
																										 * //[민아]자재입고 수정
																										 * 후 자재입고 리스트 출력
																										 * 
																										 * @PostMapping(
																										 * "/modifyInWarehousing")
																										 * public String
																										 * modifyInWarehousing
																										 * (int
																										 * transactionAmount,
																										 * String
																										 * transactionCode)
																										 * { log.
																										 * info("transactionAmount: {}"
																										 * ,
																										 * transactionAmount
																										 * ); log.
																										 * info("transactionCode: {}"
																										 * ,
																										 * transactionCode
																										 * );
																										 * 
																										 * Map<String,
																										 * Object>
																										 * paramMap =
																										 * new HashMap<
																										 * String,Object
																										 * >();
																										 * paramMap.put(
																										 * "transactionAmount",
																										 * transactionAmount
																										 * );
																										 * paramMap.put(
																										 * "transactionCode",
																										 * transactionCode
																										 * );
																										 * 
																										 * log.
																										 * info("param :{}"
																										 * , paramMap);
																										 * materialsInventoryStatusService
																										 * .
																										 * modifyMaterialIn
																										 * (paramMap);
																										 * 
																										 * return
																										 * "rawMaterials/inWarehousingList";
																										 * }
																										 * 
																										 * }
																										 */