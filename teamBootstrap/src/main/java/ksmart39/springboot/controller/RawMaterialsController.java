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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.RawMaterialsInventory;
import ksmart39.springboot.service.RawMaterialsInventoryStatusService;
import ksmart39.springboot.service.RawMaterialsService;

@Controller
@RequestMapping("/rawMaterials")
public class RawMaterialsController {
	
	private static final Logger log = LoggerFactory.getLogger(RawMaterialsController.class);
	
	
	
	/**************************************************************************************************/
	
	private final RawMaterialsInventoryStatusService materialsInventoryStatusService;
	
	@Autowired
	public RawMaterialsController(RawMaterialsInventoryStatusService materialsInventoryStatusService) {
		this.materialsInventoryStatusService = materialsInventoryStatusService;
	}
	
	
	
	
	
	//=============================================================================
	//자재관리 메인화면
	@GetMapping("/rawMaterials")
	public String meterials() {
		return "rawMaterials/rawMaterials";
	}
}
