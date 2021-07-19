package ksmart39.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shipment")
public class ShipmentController_PMA {
	private static final Logger log = LoggerFactory.getLogger(ShipmentController_PMA.class);
	
	
	//==========================================================	

	//[민아]운송회사 정보
	@GetMapping("/courierList")
	public String getCourierList() {
		return "shipment/courierList";
	}
	//[민아]출고등록
	@GetMapping("/addShipment")
	public String addShippedProductInfo() {
		return "shipment/addShipment";
	}
	//[민아]출고수정
	@GetMapping("/modifyShipment")
	public String modifyShipment() {
		return "shipment/modifyShipment";
	}
	
	//[민아]출고리스트
	@GetMapping("/shipmentList")
	public String getShipmentList() {
		return "shipment/shipmentList";
	}
}
