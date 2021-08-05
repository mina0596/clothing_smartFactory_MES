/*
 * package ksmart39.springboot.controller;
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
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import ksmart39.springboot.domain.AccountingCategory; import
 * ksmart39.springboot.domain.Client; import
 * ksmart39.springboot.domain.HumanResources; import
 * ksmart39.springboot.domain.ProductionProcessList; import
 * ksmart39.springboot.domain.QualityInspection;
 * 
 * import ksmart39.springboot.domain.RawMaterials; import
 * ksmart39.springboot.domain.SubClassInspection; import
 * ksmart39.springboot.service.SystemService;
 * 
 * @Controller
 * 
 * @RequestMapping("/system") public class SystemController_PMA {
 * 
 * private final SystemService systemService;
 * 
 * @Autowired public SystemController_PMA(SystemService systemService) {
 * this.systemService = systemService; }
 * 
 * private static final Logger log =
 * LoggerFactory.getLogger(SystemController_PMA.class);
 * 
 * 
 * // [민아]원부자재 리스트 조회
 * 
 * @GetMapping("/rawMaterialsList") public String getRawMeterialsList(Model
 * model) { List<RawMaterials> materialList = systemService.getMaterialsList();
 * model.addAttribute("materialList", materialList); return
 * "system/rawMaterialsList"; }
 * 
 * // [민아]원부자재 등록화면
 * 
 * @GetMapping("/addRawMaterials") public String addRawMeterials(Model model) {
 * return "system/addRawMaterials"; }
 * 
 * //[민아]원부자재 등록 후 목록화면으로 이동
 * 
 * @PostMapping("/addRawMaterials") public String
 * addRawMaterials(@RequestParam(name = "materialName") String materialName) {
 * log.info("화면단 확인:{}", materialName); return
 * "redirect:/system/rawMaterialsList"; }
 * 
 * // [민아]원부자재정보 수정
 * 
 * @GetMapping("/modifyRawMaterials") public String modifyRawMaterialsInfo(
 * 
 * @RequestParam(name = "rawMaterialCate", required = false) String
 * rawMaterialCate,
 * 
 * @RequestParam(name = "materialCate", required = false) String materialCate,
 * 
 * @RequestParam(name = "materialName", required = false) String materialName,
 * 
 * @RequestParam(name = "colorName", required = false) String colorName,
 * 
 * @RequestParam(name = "feature", required = false) String feature,
 * 
 * @RequestParam(name = "unit", required = false) String unit, Model model) { //
 * dao랑 연결하자!
 * 
 * log.info("========================================");
 * log.info("화면에서 입력받은 값(수정) rawMaterialCate: {}", rawMaterialCate);
 * log.info("화면에서 입력받은 값(수정) materialCate: {}", materialCate);
 * log.info("화면에서 입력받은 값(수정) materialName: {}", materialName);
 * log.info("화면에서 입력받은 값(수정) colorName: {}", colorName);
 * log.info("화면에서 입력받은 값(수정) feature: {}", feature);
 * log.info("화면에서 입력받은 값(수정) unit: {}", unit);
 * log.info("========================================");
 * 
 * model.addAttribute("rawMaterialCate", rawMaterialCate);
 * model.addAttribute("materialCate", materialCate);
 * model.addAttribute("materialName", materialName);
 * model.addAttribute("colorName", colorName); model.addAttribute("feature",
 * feature); model.addAttribute("unit", unit);
 * 
 * return "system/modifyRawMaterials"; }
 * 
 * // [민아]원부자재정보 수정 후
 * 
 * @PostMapping("/modifyRawMaterials") public String modifyRawMaterials() {
 * return "redirect:/rawMaterialsList"; }
 * 
 * // [민아]원부자재 재료 구분 검색후 처리
 * 
 * @PostMapping("/searchRawMaterialName")
 * 
 * @ResponseBody public String sendMaterialsName(@RequestParam(name =
 * "materialName", required = false) String materialName, Model model) {
 * 
 * log.info("MaterialNameCheck 	materialName :::::: {}", materialName);
 * model.addAttribute("materialName", materialName); return
 * "redirect:/addRawMaterials"; }
 * 
 * // [민아]원부자재 재료 구분 검색
 * 
 * @GetMapping("/searchMaterialName") public String getSearchValue() { // 여기에
 * list DB에서 받아서 뿌려줄꺼임 return "system/searchMaterialName"; }
 * //================================================================ //[민아]생산공정
 * 등록
 * 
 * @GetMapping("/addProductionProcess") public String addProductionProcess(Model
 * model) { return "system/addProductionProcess"; }
 * 
 * //[민아]생산공정 등록 후 생산공정 목록화면으로 이동
 * 
 * @PostMapping("/addProductionProcess") public String
 * addProductionProcess(ProductionProcessList productionProcessDomain) {
 * log.info("등록화면에서 받아오는 등록정보 확인 :{}", productionProcessDomain);
 * systemService.addProductionProcess(productionProcessDomain); return
 * "redirect:/system/productionProcessList"; } //[민아]생산공정 목록
 * 
 * @GetMapping("/productionProcessList") public String
 * getProductionProcessList(Model model) { List<ProductionProcessList>
 * productionProcessList = systemService.getProductionProcessList();
 * log.info("DB에서 리스트 잘 데려오는지 확인:{}", productionProcessList);
 * model.addAttribute("productionProcessList", productionProcessList); return
 * "system/productionProcessList"; }
 * 
 * }
 */