package ksmart39.springboot.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart39.springboot.service.ShipmentService;
@Controller
@RequestMapping("shipment")
public class ShipmentController {
	private static final Logger log = LoggerFactory.getLogger(ShipmentController.class);
	@Autowired
	private ShipmentService shipmentService;
	//출고관리
	@GetMapping("shipment")
	public String getShipment(Model model){
		List<Map<String, Object>> shimpmentOrder =shipmentService.getShipmentOrderList();
		model.addAttribute("title", "출하지시리스트 및 조회");
		model.addAttribute("shimpmentOrder", shimpmentOrder);
		return "shipment/shipment";
	}
}
