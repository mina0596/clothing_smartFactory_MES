package ksmart39.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("shipment")
public class ShipmentController {
	private static final Logger log = LoggerFactory.getLogger(ShipmentController.class);
	
	//출고관리
	@GetMapping("shipment")
	public String getShipment(){
		return "shipment/shipment";
	}
}
