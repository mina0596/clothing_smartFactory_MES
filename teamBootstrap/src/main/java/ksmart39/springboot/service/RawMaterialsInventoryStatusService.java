package ksmart39.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ksmart39.springboot.controller.RawMaterialsController;
import ksmart39.springboot.dao.RawMaterialsInventoryStatusMapper;
import ksmart39.springboot.dao.SystemMapper;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.RawMaterialsInventory;
import ksmart39.springboot.domain.SupplierRequest;

@Service
public class RawMaterialsInventoryStatusService {
	
	private static final Logger log = LoggerFactory.getLogger(RawMaterialsController.class);
	public final RawMaterialsInventoryStatusMapper materialsInventoryStatusMapper;
	public final SystemMapper systemMapper;
	
	@Autowired
	public RawMaterialsInventoryStatusService(RawMaterialsInventoryStatusMapper materialsInventoryStatusMapper, SystemMapper systemMapper) {
		this.materialsInventoryStatusMapper = materialsInventoryStatusMapper;
		this.systemMapper = systemMapper;
	}
	
	
	//[한빛] 출고 등록
	public int addExwarehousing(RawMaterialsInventory rawMaterialsInventory) {
		int result = materialsInventoryStatusMapper.addExwarehousing(rawMaterialsInventory);
		return result;
	}
	
	//[한빛] 출고 현황
	public List<Map<String,Object>> getExwarehousing(){
		List<Map<String,Object>> exHousingList = materialsInventoryStatusMapper.getExwarehousing();
		return exHousingList;
	}
	
	
	//==========================================
	
	//[민아]자재 입출고 현황
	public List<RawMaterialsInventory> getRawMaterialsInventory(){
		List<RawMaterialsInventory> materialsInventoryList = materialsInventoryStatusMapper.getMaterialsTransactionList();
		return materialsInventoryList;
	}
	
	//[민아]자재 입고 수정 화면
		public RawMaterialsInventory getTransInfoByCode(String transactionCode){
			RawMaterialsInventory InventoryInfoByMCode =materialsInventoryStatusMapper.getTransInfoByCode(transactionCode);
			return InventoryInfoByMCode;
	}
	
	//[민아]자재 입고 수정 처리
	public int modifyMaterialIn(Map<String,Object> paramMap) {
		int modifyMaterialInInfo = materialsInventoryStatusMapper.modifyMaterialIn(paramMap);
		return modifyMaterialInInfo;
	}
	
	//[민아]자재 현재고 리스트
	public List<Map<String,Object>> getInventoryStatusByMCode(){
		
		//materialCode 있는거 다 받아오는 과정
		List<RawMaterials> materialCodeList = systemMapper.getMaterialsList();
		//materialCodeList.get(0).getRawMaterialCode();
		//List<String> materialCodeArray = new ArrayList<String>();
		
		List<Map<String,Object>> getInventoryStatusResult = new ArrayList<Map<String,Object>>();
		
		for(int i=0; i < materialCodeList.size(); i++) {
			String materialCodeFromSystem = materialCodeList.get(i).getRawMaterialCode();
			//materialCodeArray.add(materialCodeFromSystem);
			//list에 담아서 가져온 materialCode를 하나씩 꺼내서 현재자재현황 mapper의 메서드에 넣어서 실행시키기
			//getInventoryStatusResult.add(null)
			
			//if(getInventoryStatusResult)
			Map<String,Object> inventoryStatusResult = materialsInventoryStatusMapper.getInventoryStatusByMCode(materialCodeFromSystem);
			if(inventoryStatusResult != null) {
			getInventoryStatusResult.add(inventoryStatusResult);
			}
		}

		Map<String, Object> print = getInventoryStatusResult.get(0);
		log.info("print :{}", print);
		log.info("getInventoryStatusResult :{}", getInventoryStatusResult);
		return getInventoryStatusResult;
	}
	
	public List<SupplierRequest> getSupplierRequest(String approval){
		List<SupplierRequest> supplierRequest = materialsInventoryStatusMapper.getSupplierRequest(approval);
		return supplierRequest;
	}
}
