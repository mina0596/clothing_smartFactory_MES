package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.RawMaterialsInventoryStatusMapper;
import ksmart39.springboot.dao.SystemMapper;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.RawMaterialsInventory;

@Service
public class RawMaterialsInventoryStatusService {
	
	public final RawMaterialsInventoryStatusMapper materialsInventoryStatusMapper;
	public final SystemMapper systemMapper;
	
	@Autowired
	public RawMaterialsInventoryStatusService(RawMaterialsInventoryStatusMapper materialsInventoryStatusMapper, SystemMapper systemMapper) {
		this.materialsInventoryStatusMapper = materialsInventoryStatusMapper;
		this.systemMapper = systemMapper;
	}
	
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
	public List<RawMaterialsInventory> getInventoryStatusByMCode(String materialCode){
		
		systemMapper.getMaterialsList();
		 
		return null;
	}
	
}
