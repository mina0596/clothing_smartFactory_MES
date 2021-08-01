package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import ksmart39.springboot.domain.ShipmentOrder;
import ksmart39.springboot.service.ShipmentService;

@Controller
@RequestMapping("shipment")
public class ShipmentController_HBR {
	
	private static final Logger log = LoggerFactory.getLogger(ShipmentController_HBR.class);
	@Autowired
	private ShipmentService shipmentService;
	
	//==========================================================
	//[보람]송장삭제
	@PostMapping("/deleteShipmentInvoice")
	public String deleteShipmentInvoice() {
		return "redirect:/shipmentInvoiceList";
	}
	
	//[보람] 송장 수정화면 완료
	@PostMapping("/modifyShipmentInvoice")
	public String modifyShipmentInvoice() {
		return"redirect:/shipmentInvoiceList";
	}
	//[보람]송장 수정화면
	@GetMapping("/modifyShipmentInvoice")
	public String modifyShipmentInvoice(Model model){
		return"shipment/modifyShipmentInvoice";
	}
	//[보람]송장등록일조회
	@RequestMapping(value = "searchInvoiceRegDate",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>>searchInvoiceRegDate(@RequestParam(value = "invoiceRegDate",required = false) String invoiceRegDate){
		
		
		List<Map<String,Object>> invoiceRegDateList= shipmentService.searchInvoiceRegDate(invoiceRegDate);
		log.info("=========================");
		log.info("invoiceRegDateList{}",invoiceRegDateList);
		log.info("=========================");
		return invoiceRegDateList;
	}
	//[보람]택배사명으로찾기
	@RequestMapping(value = "searchInvoiceClient",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>>searchInvoiceClient(@RequestParam(value = "invoiceClient",required = false) String invoiceClient){
		
		
		List<Map<String,Object>> invoiceClientList =shipmentService.searchInvoiceClient(invoiceClient);
		log.info("=========================");
		log.info("invoiceList{}",invoiceClientList);
		log.info("=========================");
		return invoiceClientList;
	}
	//[보람]거래처조회
	@RequestMapping(value = "searchClientCate",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>>searchClientCate(@RequestParam(value = "client",required = false) String client){
		
		
		List<Map<String,Object>> clientList = shipmentService.searchClientCate(client);
		log.info("=========================");
		log.info("invoiceList{}",clientList);
		log.info("=========================");
		return clientList;
	}
	//[보람]송장번호 조회
	@RequestMapping(value = "searchInvoiceCode",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>>searchInvoiceCode(@RequestParam(value = "shipmentInvoice",required = false) String shipmentInvoice){
		
		System.out.println("ShipmentController shipmentInvoiceCode : " + shipmentInvoice );
		List<Map<String,Object>> invoiceList = shipmentService.searchInvoiceCode(shipmentInvoice);
		log.info("=========================");
		log.info("invoiceList{}",invoiceList);
		log.info("=========================");
		return invoiceList;
	}
	//송장관리의 송장 목록및 조회
	@GetMapping("/shipmentInvoiceList")
	public String getShipmentInvoiceList(Model model) {
		List<Map<String,Object>> invoiceList = shipmentService.getShipmentInvoiceList();
		model.addAttribute("title","송장관리: 운송장 조회 및 조회");
		model.addAttribute("invoiceList",invoiceList);
		return"shipment/shipmentInvoiceList";
	}
	
	//송장관리의 송장등록
	@GetMapping("/addShipmentInvoice")
	public String addShipmentInvoice(Model model) {
		model.addAttribute("title", "송장관리:운송장등록");
		
		return"shipment/addShipmentInvoice";
	}
	
	
	
	
	
	//[보람]출하지시모달창 거래처 조회 완성품목록
	@RequestMapping(value = "searchCompletClientName",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchCompletClientName(@RequestParam(value = "clientName", required = false)String clientName){
		List<Map<String,Object>> completeClientList = shipmentService.searchCompletClientName(clientName);
		log.info("=========================");
		log.info("completeClientList{}",completeClientList);
		log.info("=========================");
		return completeClientList;
	}
	//[보람]출하지시모달창 계약 조회 완성품목록
	@RequestMapping(value = "searchCompletContract",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchCompletContract(@RequestParam(value = "contractCode", required = false)String contractCode){
		List<Map<String,Object>> completeContarctList =shipmentService.searchCompletContract(contractCode);
		log.info("=========================");
		log.info("completeContarctList{}",completeContarctList);
		log.info("=========================");
		return completeContarctList;
	}
	//[보람]출하지시조회
	@RequestMapping(value = "searchShipmentOrder",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getsearchShipmentOrder(@RequestParam(value = "shipmentOrderCode", required = false)String shipmentOrderCode,
														@RequestParam(value = "productName",required = false)String productName,
														@RequestParam(value = "clientName",required = false)String clientName,
														@RequestParam(value = "shipmentOrderDate",required = false)String shipmentOrderDate){
		
	HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("shipmentOrderCode", shipmentOrderCode);
		map.put("productName", productName);
		map.put("clientName", clientName);
		map.put("shipmentOrderDate", shipmentOrderDate);
		List<Map<String,Object>> shipmentOrderList = shipmentService.getsearchShipmentOrder(map);
		log.info("=========================");
		log.info("shipmentOrderList{}",shipmentOrderList);
		log.info("=========================");
		return shipmentOrderList;
	}
	
	//[보람]출하지시 삭제
	@RequestMapping("/deleteShipmentOrder")
	public int deleteShipmentOrder(@RequestParam(value = "checkArray[]")String[] checkArray) {
		int result =1;
		for(int i =0; i<checkArray.length; i++) {
			result =shipmentService.deleteShipmentOrder(checkArray[i]);
		}
		return result;
	}
	//[보람 ]출하지시  수정화면 수정후
	@PostMapping("/modifyShipmentOrder")
	public String modifyShipmentOrder(ShipmentOrder shipmentOrder) {
		log.info("========================================");
		log.info("화면에서 입력받은 값(수정화면폼)shipmentOrder:{}",shipmentOrder);
		log.info("========================================");
		shipmentService.modifyShipmentOrder(shipmentOrder);
		return "redirect:/shipment/shipmentOrderList";
	}
	//[보람] 출하지시 리스트 수정화면 경로 메서드
	@GetMapping("/modifyShipmentOrder")
	public String modifyShipmentOrder(Model model,@RequestParam(name = "shipmentOrderCode",required = false)String shipmentOrderCode) {
		ShipmentOrder shipmentOrder = shipmentService.shipmentOrderInfo(shipmentOrderCode);
		model.addAttribute("shipmentOrder", shipmentOrder);
		
		return "shipment/modifyShipmentOrder";
	}
	
	//[보람] 출하지시리스트 순번 클릭시 출하지시정보
	@GetMapping("/shipmentOrderInfo")
	public String shipmentOrderInfo(Model model,@RequestParam(name = "shipmentOrderCode",required = false)String shipmentOrderCode) {
		ShipmentOrder shipmentOrder = shipmentService.shipmentOrderInfo(shipmentOrderCode);
		model.addAttribute("shipmentOrder", shipmentOrder);
		
		return"shipment/shipmentOrderInfo";
	}

	//출하지시조회및리스트
	@GetMapping("/shipmentOrderList")
	public String getShipmentOrderList(Model model) {
		List<Map<String, Object>> shimpmentOrder =shipmentService.getShipmentOrderList();
		model.addAttribute("title", "출하지시리스트 및 조회");
		model.addAttribute("shimpmentOrder", shimpmentOrder);
	 
		
		return"shipment/shipmentOrderList";
	}
	//출하지시등록시 품목의뢰코드 중복체크
	@RequestMapping("/checkProduct")
	@ResponseBody
	public Map<String,Object>checkProduct(@RequestParam(name = "shipmentOrderProduectCode",required = false)String shipmentOrderProduectCode){
		int count =0;
		Map<String,Object> map = new HashMap<String,Object>();
		count =shipmentService.checkProduct(shipmentOrderProduectCode);
		map.put("cnt", count);
		return map;
	}
	//출하지시등록
	@PostMapping("/addShipmentOrder")
	public String addShipmentOrder(@RequestParam(name ="shipmentRequestCode", required = false)String shipmentRequestCode,
									@RequestParam(name = "shipmentOrderProduectCode",required = false)String shipmentOrderProduectCode,
									@RequestParam(name = "shipmentOrderProductName",required = false)String shipmentOrderProductName,
									@RequestParam(name = "contractState",required = false)String contractState,
									@RequestParam(name = "chargeEmployeeCode",required = false)String chargeEmployeeCode,
									@RequestParam(name = "shipmentOrderDate",required = false)String shipmentOrderDate) {
		 log.info("========================================");
		  log.info("shipmentRequestCode {}:",shipmentRequestCode);
		  log.info("shipmentOrderProduectCode {}:",shipmentOrderProduectCode);
		  log.info("shipmentOrderProductName {}:",shipmentOrderProductName);
		  log.info("========================================");
		shipmentService.addShipmentOrder(shipmentRequestCode, shipmentOrderProduectCode, shipmentOrderProductName, contractState,chargeEmployeeCode, shipmentOrderDate);
		
		return"redirect:/shipment/shipmentOrderList";
	}
	//출하지시등록
	@GetMapping("/addShipmentOrder")
	public String addShipmentOrder(Model model) {
		
		model.addAttribute("title", "출하관리:출하지시등록");
		
		return"shipment/addShipmentOrder";
	}

}
