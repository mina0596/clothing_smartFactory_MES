package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.SupplierMapper;
import ksmart39.springboot.domain.SupplierRequest;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierMapper supplierMapper;
	//[보람]발주요청 정보 
	 public  SupplierRequest getSupplierRequestInfo(String rawMaterialOrder){
		return supplierMapper.getSupplierRequestInfo(rawMaterialOrder);
	}
	//[보람] 발주 요청 거래처 정보
	public List<Map<String,Object>> searchSupplierClientCate(String client){
		
		return supplierMapper.searchSupplierClientCate(client);
	}
	//[보람] 원부자재 정보 
	public  List<Map<String,Object>> searchRawMaterial(String supplierName){
	
		return supplierMapper.searchRawMaterial(supplierName);
	}
	//[보람] 발주요청 등록
	public int addSupplierRequest(String rawMeterialCode,String supplierClient,String chargeEmployeeCode,int rawMaterialAmount,String rawMaterialOrderExpected) {
		Map<String, Object> rawMaterialOrderMap = new HashMap<String,Object>();
		rawMaterialOrderMap.put("rawMeterialCode",rawMeterialCode);
		rawMaterialOrderMap.put("supplierClient",supplierClient);
		rawMaterialOrderMap.put("chargeEmployeeCode",chargeEmployeeCode);
		rawMaterialOrderMap.put("rawMaterialAmount",rawMaterialAmount);
		rawMaterialOrderMap.put("rawMaterialOrderExpected",rawMaterialOrderExpected);
		
		return supplierMapper.addSupplierRequest(rawMaterialOrderMap);
	}
	//[보람]발주요청 리스트
	public List<Map<String,Object>> getSupplierRequestList(){
		return supplierMapper.getSupplierRequestList();
	}
	//[보람]계약 리스트 
	public List<Map<String,Object>> getSupplierContractList(){
		
		return supplierMapper.getSupplierContractList();
	}

}
