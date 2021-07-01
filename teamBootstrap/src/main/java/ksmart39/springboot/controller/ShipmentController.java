package ksmart39.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShipmentController {
	private static final Logger log = LoggerFactory.getLogger(ShipmentController.class);
	
	
	//==========================================================
	//[보람] 송장 수정화면 완료
	@PostMapping("/modifyShipmentInvoice")
	public String modifyShipmentInvoice() {
		return"redirect:/shipmentInvoiceList";
	}
	//[보람]송장 수정화면
	@GetMapping("/modifyShipmentInvoice")
	public String shipmentInvoiceModify(){
		return"shipment/modifyShipmentInvoice";
	}
	//송장관리의 송장 목록및 조회
	@GetMapping("/shipmentInvoiceList")
	public String getShipmentInvoiceList(Model model) {
		model.addAttribute("title","송장관리: 운송장 조회 및 조회");
		return"shipment/shipmentInvoiceList";
	}
	
	//송장관리의 송장등록
	@GetMapping("/addShipmentInvoice")
	public String addShipmentInvoice(Model model) {
		model.addAttribute("title", "송장관리:운송장등록");
		
		return"shipment/addShipmentInvoice";
	}
	
	//[보람 ]출하지시  수정화면 수정후
	@PostMapping("/modifyShipmentOrder")
	public String modifyShipmentOrder1() {
		
		//DAO 만들고나서 메서드 명 변경할거임
		return "redirect:/shipmentOrderList";
	}
	//[보람] 출하지시 리스트 수정화면 경로 메서드
	@GetMapping("/modifyShipmentOrder")
	public String modifyShipmentOrder() {
		
		
		return "shipment/modifyShipmentOrder";
	}
	
	//[보람] 출하지시리스트 순번 클릭시 출하지시정보
			@GetMapping("/shipmentOrderInfo")
			public String shipmentOrderInfo() {
				return"shipment/shipmentOrderInfo";
			}
	
	//출하지시조회및리스트
	@GetMapping("/shipmentOrderList")
	public String getShipmentOrderList(Model model) {
		model.addAttribute("title", "출하지시리스트 및 조회");
		
		return"shipment/shipmentOrderList";
	}
	
	//출하지시등록
	@GetMapping("/addShipmentOrder")
	public String addShipmentOrder(Model model) {
		
		model.addAttribute("title", "출하관리:출하지시등록");
		
		return"shipment/addShipmentOrder";
	}
	
	
	//출고관리
	@GetMapping("shipment")
	public String getShipment(){
		return "shipment/shipment";
	}
	//운송회사 정보
	@GetMapping("/courierList")
	public String getCourierList() {
		return "shipment/courierList";
	}
	//출고등록
	@GetMapping("/addShipment")
	public String addShippedProductInfo() {
		return "shipment/addShipment";
	}
	
	//출고리스트
	@GetMapping("/shipmentList")
	public String getShipmentList() {
		return "shipment/shipmentList";
	}
}
