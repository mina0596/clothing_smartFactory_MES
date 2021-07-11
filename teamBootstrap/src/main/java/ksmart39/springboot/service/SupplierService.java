package ksmart39.springboot.service;

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
	//[보람] 발주요청에 자재 현황 리스트
	public List<Map<String,Object>> getRawInventoryState(){
		return supplierMapper.getRawInventoryState();
		
	}
	//[보람] 발주 요청 거래처 정보
	public List<Map<String,Object>> getClientInfo(){
		
		return supplierMapper.getClientInfo();
	}
	//[보람] 원부자재 정보 
	public  List<Map<String,Object>> getRawInfo(){
	
		return supplierMapper.getRawInfo();
	}
	//[보람] 발주요청 등록
	public int addSupplierRequest(SupplierRequest supplierRequest) {
		return supplierMapper.addSupplierRequest(supplierRequest);
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
