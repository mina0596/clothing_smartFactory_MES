package ksmart39.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.domain.QualityInspection;
import ksmart39.springboot.domain.QualityInspectionRequest;
import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.domain.QualityInspectionStandard;
import ksmart39.springboot.paging.Pagination;
import ksmart39.springboot.service.DefectiveProductService;
import ksmart39.springboot.service.QualityControlService;
import ksmart39.springboot.service.QualityInsMeasurementValueService;
import ksmart39.springboot.service.QualityInspectionFinalResultService;
import ksmart39.springboot.service.QualityInspectionPassRateService;
import ksmart39.springboot.service.QualityInspectionStauteService;


@Controller
@RequestMapping("/quality")
public class QualityControlController {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController.class);
	@Autowired
	private QualityInspectionFinalResultService qualityInsepctionFinalResultService;
	@Autowired 
	private QualityInsMeasurementValueService qualityInsMeasurementValueService;
	@Autowired
	private QualityInspectionStauteService qualityInsepctionStauteService;
	@Autowired
	private DefectiveProductService defectiveProductService;
	@Autowired
	private QualityControlService qualityControlService;
	@Autowired
	private QualityInspectionPassRateService passRateService;
	
	//==============================================품질검사요청,측정값,품질검사실시간현황[다미]===============================
	//[다미] 품질검사 코드 
	@PostMapping("/searchInspectionCode")
	@ResponseBody 
	public List<QualityInspection> searchInspectionCode(@RequestBody QualityInspection qualityInspection){
		log.info("화면에서 받아온 값: {}", qualityInspection);
		List<QualityInspection> inspectionCode = qualityInsMeasurementValueService.searchInspectionCode(qualityInspection);
		return inspectionCode;
	}
	
	//[다미] 거래처이름 검색
	@PostMapping("/searchByClientName")
	@ResponseBody 
	public List<Map<String, Object>> searchByClientName(@RequestParam(value = "clientName", required = false)String clientName){
		log.info("화면에서 받아온 값: {}", clientName);
		List<Map<String, Object>> clientNameMap = qualityInsMeasurementValueService.searchByClientName(clientName);
		return clientNameMap;
	}
	
	//[다미] 계약번호 검색
	@PostMapping("/searchByContractNum")
	@ResponseBody
	public List<Map<String, Object>> searchByContractNum(@RequestBody Map<String, Object> searchByContractNum){
		log.info("화면에서 받아온 값: {}", searchByContractNum);
		List<Map<String, Object>> ContractNumMap = qualityInsMeasurementValueService.searchByContractNum(searchByContractNum);
		return ContractNumMap;
	}
	
	//[다미] 실시간 검사 현황
	@PostMapping("/qualityInspectionStatusNow")
	@ResponseBody
	public List<Map<String, Object>> qualityInspectionStatusNow(@RequestParam(value = "contractNum")String contractNum){
		List<Map<String, Object>> resultMap = null;
		
		log.info("================================================");
		log.info("화면에서 받아온값: {}", contractNum);
		log.info("================================================");
		
		resultMap = qualityInsMeasurementValueService.getQualityInspectionStatusNow(contractNum);
	
		log.info("================================================");
		log.info("DB조회한 값: {}", resultMap);
		log.info("================================================");
		
		return resultMap;
	}
	
	//[다미] 실시간 검사 현황 리스트
	@PostMapping("/qualityInspectionStatusNowList")
	@ResponseBody
	public List<Map<String, Object>> qualityInspectionStatusNowList(@RequestBody Map<String, Object> searchMap) {
		
		log.info("화면에서 받아온 값: {}", searchMap);
		List<Map<String, Object>> map = qualityInsMeasurementValueService.getQualityInspectionStatusNowList(searchMap);
		log.info("================================================");
		log.info("실시간 검사 현황 DB조회된 값: {}", map);
		log.info("================================================");
		
		return map;
	}
	
	//[다미] 실시간 검사 현황
	@GetMapping("/qualityInspectionStatusNow")
	public String qualityInspectionStatusNow(Model model) {		
		
		return "quality/qualityInspectionStatusNow";
	}
	
	
	//검사현황 실적 
	@GetMapping("/inspectionPerformance")
	public String inspectionPerformance(Model model) {
		
		model.addAttribute("title", "검사현황관리:실적");
		return"quality/inspectionPerformance";
	}
	
	//[다미] 품질검사 측정값 목록
		@GetMapping("/inspectionMeasurementValueList")
		public String inspectionMeasurementValueList(Model model) {
			
			List<QualityInspectionResult> list = qualityInsMeasurementValueService.getInspectionMeasurementValueList();
			
			model.addAttribute("list", list);
			
			log.info("{}", list);
			
			return "quality/inspectionMeasurementValueList";
		}
		
	//[다미] 품질검사 측정값 등록
	@PostMapping("/addInspectionMeasurementValue")
	@ResponseBody
	public boolean addInspectionMeasurementValue(@RequestBody List<QualityInspectionResult> qualityInspectionResult, HttpSession session) {
		String sCode = (String) session.getAttribute("SCODE");
		log.info("session에서 가져오는 employeeCode확인 :{}", sCode);

		int value = qualityInsMeasurementValueService.addQualityInspectionResult(qualityInspectionResult, session);
		boolean result = false;			
		
		//insert 완료
		if(value > 0) {
			result = true;			
		//insert 실패
		}else {
			result = false;			
		}
		
		return result;		
	}
	
	//[다미] 품질검사 측정값 카테고리에 맞는 행 만들기
	@PostMapping("/getQulityInspectionCategory")
	@ResponseBody
	public String getQulityInspectionCategory(@RequestParam(value = "qualityInspectionCode")String qualityInspectionCode){
		
		List<QualityInspectionStandard> cate = qualityInsMeasurementValueService.getQualityInspectionStandard(qualityInspectionCode);
		
		String result = cate.get(0).getCategory();
		
		return result;	
	}
	
	//[다미] 품질검사 측정값 등록 화면
	@GetMapping("/addInspectionMeasurementValue")
	public String addInspectionMeasurementValue(Model model) {
		return "quality/addInspectionMeasurementValue";
	}

	//[다미]품질검사 요청 목록 모달
	@RequestMapping(value = "searchQualityInspectionRequest", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> searchQualityInspectionRequest(@RequestParam(value = "jsonData", required = false)String jsonData) {
				
		log.info("1. 처음 들어온 데이터(json문자열): jsonData: {} " , jsonData);
		
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			// parsering 후 Object객체에 담음
			obj = parser.parse(jsonData);
			log.info("2.파싱한 데이터: obj: {} " , obj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//3. JsonObject로 변환
		JSONObject jsonObj = (JSONObject) obj;
		
	    Map<String, Object> map = new HashMap<String, Object>();
		
	    //json -> map으로 바꿔야합니다.
		List<Map<String, Object>> map2 = qualityInsMeasurementValueService.searchQualityInspectionRequest(jsonObj);
		log.info("searchQualityInspectionRequest: {} " , map2);
		
		return map2;
	}

	
//[다미] 계약번호로 품목별 의뢰 코드 검색
	@PostMapping("/searchRequestProductCode")
	@ResponseBody
	public List<Map<String, Object>> searchRequestProductCode(@RequestParam(name = "contractCode")String contractCode){
		List<Map<String, Object>> resultMap = qualityInsMeasurementValueService.searchRequestProductCode(contractCode);
		return resultMap;
	}
		
	//[다미]품질검사 단일 요청
	@PostMapping("/qualityInspectionRequest")
	public String qualityInspectionRequest(QualityInspectionRequest qualityInspectionRequest) {
		qualityInsMeasurementValueService.qualityInspectionRequest(qualityInspectionRequest);
		return "redirect:qualityInspectionRequestList";
	}
	//[다미]품질검사요청
		@GetMapping("/qualityInspectionRequest")
		public String qualityControlRequest() {
			return "quality/qualityInspectionRequest";
		}
		
	//[다미]품질검사 세부 코드 검색
	@PostMapping("/subClassCate")
	@ResponseBody
	public List<Map<String, Object>> subClassCate(@RequestParam(name = "lowClassCateName") String lowClassCateName){
		return qualityInsMeasurementValueService.subClassCate(lowClassCateName);
	}
	//==============================================품질측정값의성적서,품질검사계약별검사현황[보람]===============================

	//[다미&보람]수주계약별 검색 품질검사 현황
		@GetMapping("/qualityInspectionStatusContract")
		public String qualityInspectionStatusContract(Model model,@RequestParam(name = "contactNumber",required = false)String contactNumber,
				@RequestParam(name = "clientName",required = false)String clientName,
				@RequestParam(name = "inspectionStartDate", required = false)String inspectionStartDate,
				@RequestParam(name = "inspectionEndDate", required = false)String inspectionEndDate){

			//등급별
			List<Map<String, Object>> inspectionStateList = qualityInsepctionStauteService.getStateBuyerContractQualityInspection();
			//수치별
			List<Map<String, Object>> inspectionStateMeasurement =qualityInsepctionStauteService.getStateBuyerContractQualityInspectionMeasurement();
			//합격/불합격
			List<Map<String, Object>> inspectionStatePassCheck =qualityInsepctionStauteService.getStateBuyerContractQualityInspectionPass();
			
			//등급별 검색
			HashMap<String,Object> map = new HashMap<String,Object>();
			//객체화된map에.put 메서드로  RequestParam값 넣기
			map.put("contactNumber", contactNumber);
			map.put("clientName", clientName);			
			map.put("inspectionStartDate", inspectionStartDate);
			map.put("inspectionEndDate", inspectionEndDate);
			log.info("map  {}",map);
			//수치별 검색
			HashMap<String,Object> map2 = new HashMap<String,Object>();
			map2.put("contactNumber",contactNumber);
			map2.put("clientName",clientName);
			map2.put("inspectionStartDate",inspectionStartDate);
			map2.put("inspectionEndDate",inspectionEndDate);
			//합격/불합격 검색
			HashMap<String,Object> map3 = new HashMap<String,Object>();
			map3.put("contactNumber",contactNumber);
			map3.put("clientName",clientName);
			map3.put("inspectionStartDate",inspectionStartDate);
			map3.put("inspectionEndDate",inspectionEndDate);
			//등급별검색 			
			List<Map<String, Object>> stateMap = qualityInsepctionStauteService.getSearchQualityInspectionState(map);
			//수치별검색
			List<Map<String, Object>> meansureMap = qualityInsepctionStauteService.getSearchQualityInspectionStateMeasurement(map2);
			//합격불합격검색
			List<Map<String, Object>> passCheckMap = qualityInsepctionStauteService.getSearchQualityInspectionStatePassCheck(map3);
			
			model.addAttribute("stateMap", stateMap);
			model.addAttribute("meansureMap", meansureMap);
			model.addAttribute("passCheckMap", passCheckMap);
		
			model.addAttribute("inspectionStateList", inspectionStateList);
			model.addAttribute("inspectionStateMeasurement", inspectionStateMeasurement);
			model.addAttribute("inspectionStatePassCheck", inspectionStatePassCheck);
			
			return "quality/qualityInspectionStatusContract";
		}
	
	
	//[다미+보람]품질검사 최종등록 검색모달창 
	@RequestMapping(value = "/addfinalresult",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchRequesetInspection(){
		 List<Map<String,Object>> requestList = qualityInsepctionFinalResultService.searchRequesetInspection();
		 log.info("=============================================");
		  	log.info("requestList  {}",requestList);
		  	log.info("=============================================");
		return requestList;
	}
	
	
	@GetMapping("/qualityInspectionReportInfo")
	public String qualityInspectionReportInfo(Model model, @RequestParam(value = "requestProductCode", required = false)String requestProductCode) {
		List<Map<String,Object>> finalResultReportInfo = qualityInsepctionFinalResultService.getFinalResultReport(requestProductCode);
		model.addAttribute("finalResultReportInfo",finalResultReportInfo);
		
		return "quality/qualityInspectionReportInfo";
	}
	

	
	
	
	
	
	//[다미+보람]검사현황 조회 성적서 결과값보여주기
	@RequestMapping(value = "/searchfinalResult",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getQualityInspectionReport(@RequestParam(value ="clientCate",required = false)String clientCate,
															@RequestParam(value = "requestCate",required = false)String requestCate,
															@RequestParam(value = "productCate",required = false)String productCate,
															@RequestParam(value = "InspectionStartDate",required = false)String InspectionStartDate,
															@RequestParam(value = "inspectionEndDate",required = false)String inspectionEndDate){
		HashMap<String, Object> map = new HashMap<>();
		map.put("clientCate", clientCate);
		map.put("requestCate", requestCate);
		map.put("productCate", productCate);
		map.put("InspectionStartDate",InspectionStartDate);
		map.put("inspectionEndDate", inspectionEndDate);
		List<Map<String,Object>> searchListMap = qualityInsepctionFinalResultService.getQualityInspectionReport(map);
		log.info("검색 :  {}", searchListMap);
		
		return searchListMap;
	}
	
	
	
	//[다미+보람]검사현황 조회 품목명 가지고오기
	@RequestMapping(value = "/requestName", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getProductName(@RequestParam(value = "requestNum", required = false)String requestNum){
		List<Map<String,Object>> productName = qualityInsepctionFinalResultService.getProductName(requestNum);
		
		return productName;
	}
	
	  //[다미+보람]검사현황 조회 의뢰코드가지고오기
	  
	  @RequestMapping(value = "/requestCode", method = RequestMethod.GET)
	  @ResponseBody 
	  public List<Map<String,Object>> getRequestProductCode(@RequestParam(value = "client",required =	  false)String client ){ 
		 List<Map<String,Object>> reqeustCode =	 qualityInsepctionFinalResultService.getRequestProductCode(client);
	  	
	 return reqeustCode; 
	 }
	
	

	//[다미+보람]검사현황 조회 거래처명가지고오기
	@RequestMapping(value = "/clientName", method =RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getClientName(){
		List<Map<String,Object>> clientList =qualityInsepctionFinalResultService.getClientName();
		log.info("=============================================");
		log.info("거래처명 :  {}", clientList);
		log.info("=============================================");
		return clientList;
	}
	
	//검사현황 성적서조회 및리스트
	@GetMapping("/qualityInspectionReport")
	public String getQualityInspectionReport(Model model) {
		List<Map<String,Object>> finalResultList = qualityInsepctionFinalResultService.getInsepectionFinalResult();
		log.info("=============================================");
		log.info("최종성적리스트 :  {} ", finalResultList);
		log.info("=============================================");
		model.addAttribute("finalResultList", finalResultList);
		return"quality/qualityInspectionReport";
	}
	
	
	//[다미+보람]검사현황최종결과등록
	@GetMapping("/addFinalnspectionMeasurementValue")
	public String addQualityInspectionReport(Model model) {
		
		model.addAttribute("title", "품질관리");
		return"quality/addFinalnspectionMeasurementValue";
	}
	

	
	//[다미&보람]수주계약별 기간별조회
		@GetMapping("/searchByPeriodContractQualityInspection")
		public String searchByPeriodContractQualityInspection() {
			return"quality/searchByPeriodContractQualityInspection";
		}

	//==============================================품질관리 기준표,품질관리 현황합격율[민아]===============================

		//[민아]품질검사 기준표 등록
		@GetMapping("/addStandardTable")
		public String addStandardTable() {
			return "quality/addStandardTable";
		}
		
		//[민아]품질검사 기준표 등록화면에서 상세검사 가져오기
		@GetMapping("/subClassCate")
		@ResponseBody
		public List<Map<String,Object>> getMediumClassCate(@RequestParam(value = "lowClassCateName", required = false)String lowClassCateName) {
			List<Map<String,Object>> subCate = qualityControlService.getSubClassName(lowClassCateName);
			log.info("========================================");
			log.info("subCate {}",subCate);
			log.info("========================================");
			
			return subCate;
		}
		
		//[민아]품질검사 기준표 목록
		@GetMapping("/standardTableList")
		public String getStandardTableList(Model model) {
			String levelCate = "등급";
			String numCate = "수치";
			String passCate = "합격/불합격";
			List<Map<String,Object>> levelStandardList = qualityControlService.getInspectionStandard(levelCate);
			List<Map<String,Object>> numStandardList = qualityControlService.getInspectionStandard(numCate);
			List<Map<String,Object>> passStandardList = qualityControlService.getInspectionStandard(passCate);
			model.addAttribute("levelStandardList", levelStandardList);
			model.addAttribute("numStandardList", numStandardList);
			model.addAttribute("passStandardList", passStandardList);
			return "quality/standardTableList";
		}
		
		@PostMapping("/sendProductInfoForInspection")
		@ResponseBody
		public Map<String,Object> getProductInfoForInspection(@RequestBody Map<String,Object> productInfo, Model model){
			log.info("productInfo :{}", productInfo);
			return productInfo;
		}
		
		//[민아]품질검사 기준표 등록 처리 없이 목록화면으로 이동
		@PostMapping("/addStandardTable")
		public String addStandardTable(@RequestParam(name = "qualityInspectionCode")String qualityInspectionCode) {
			
			return "redirect:/quality/standardTableList";
		}
		
		//[민아]품질검사별 불량률 현황
		@GetMapping("/qualityInspectionFailRateList")
		public String getDefectiveRate(Model model) {
			List<Map<String,Object>> failedRank = passRateService.getInspectionFailedRank();
			log.info("불합격률 DB에서 가져오는거 확인:{}", failedRank);
			model.addAttribute("failedRank", failedRank);
			
			//그래프에 뿌려줄 연도별 불량률
			List<Map<String,Object>> failedRateByYear = passRateService.getPastYearsFailedPercent();
			log.info("지난3년간의 불량률 조회 DB에서 가져오는거 확인:{}", failedRateByYear);
			model.addAttribute("failedRateByYear", failedRateByYear);
			
			//표에 뿌려줄 연도별 5위 상세정보
			List<Map<String,Object>> yearlyFailRate = passRateService.getYearlyFailRank();
			log.info("표에 뿌려줄 연도별 5위 상세정보 확인 :{}", yearlyFailRate);
			model.addAttribute("yearlyFailRate", yearlyFailRate);
			
			//월별 불량률 
			List<Map<String,Object>> monthlyFailRate = passRateService.getMonthlyFailRateByYear();
			log.info("월별 연도별 불량률 확인 :{}", monthlyFailRate);
			model.addAttribute("monthlyFailRate", monthlyFailRate);
			
			//대분류검사별 불량률 
			List<Map<String,Object>> highInspectionFailRate = passRateService.getHighClassInspectionFailRank();
			log.info("대분류검사별 불량률 확인:{}", highInspectionFailRate);
			model.addAttribute("highInspectionFailRate", highInspectionFailRate);
				
			
			return"quality/qualityInspectionFailRateList";
		}
		
		//연도별 월 불량률 상세정보 조회
		@PostMapping("/addFailRank")
		@ResponseBody
		public List<Map<String,Object>> getMonthlyFailRank(@RequestBody Map<String,Object> selectYearMap){
			log.info("ajax로 연도 데려오는 값 확인:{}", selectYearMap);
			String selectedYear = (String) selectYearMap.get("selectedYear"); 
			log.info("Map안에 값 확인:{}", selectedYear);
			List<Map<String,Object>> monthlyFailRank = passRateService.getMonthlyFailRateRank(selectedYear);
			return monthlyFailRank;
		}	
		//==============================================품질관리불량품관리[한빛]===============================
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
		    model.addAttribute("defectiveProductList", 			resultMap.get("defectiveProductList"));
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
		
		//[한빛]품질검사요청 수정
		@GetMapping("/modifyQualityInspectionRequest")
		public String modifyQualityInspectionRequest(Model model) {
			model.addAttribute("title", "수주관리");
			return "quality/modifyQualityInspectionRequest"; 
		}
		
		//[한빛]품질검사요청 수정
		@PostMapping("/modifyQualityInspectionRequest")
		public String modifyQualityInspectionRequest() {
			return "redirect:qualityInspectionRequestList";
		}
	//품질관리 메인화면
	@GetMapping("/qualityControl")
	public String getQulity() {
		return "quality/qualityControl";
	}
	
}
