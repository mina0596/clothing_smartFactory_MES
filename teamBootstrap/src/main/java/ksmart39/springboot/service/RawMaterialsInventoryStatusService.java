package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.RawMaterialsInventoryStatusMapper;
import ksmart39.springboot.domain.RawMaterialsInventory;

@Service
public class RawMaterialsInventoryStatusService {
	
	public final RawMaterialsInventoryStatusMapper materialsInventoryStatusMapper;
	
	@Autowired
	public RawMaterialsInventoryStatusService(RawMaterialsInventoryStatusMapper materialsInventoryStatusMapper) {
		this.materialsInventoryStatusMapper = materialsInventoryStatusMapper;
	}
	
	//[민아]자재 입출고 현황
	public List<RawMaterialsInventory> getRawMaterialsInventory(){
		List<RawMaterialsInventory> materialsInventoryList = materialsInventoryStatusMapper.getMaterialsTransactionList();
		return materialsInventoryList;
	}
	
	//[민아]자재 입고 수정
		public List<RawMaterialsInventory> getInventoryInfoByMCode(Map<String, Object> paramMap){
			List<RawMaterialsInventory> InventoryInfoByMCode =materialsInventoryStatusMapper.getInventoryInfoByMCode(paramMap);
			return InventoryInfoByMCode;
	}
	
	
}
