package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.SupplierRequest;

@Mapper
public interface SupplierMapper {
	//[보람] 발주요청에 자재 현황 리스트
	public List<Map<String,Object>> getRawInventoryState();
	
	//[보람] Modal창 거래처 정보 리스트
	public List<Map<String,Object>> getClientInfo();

	
	//[보람] 원부자재 정보 
		public  List<Map<String,Object>> getRawInfo();
	//[보람] 발주요청 등록
		public int addSupplierRequest(SupplierRequest supplierRequest);
	//[보람]발주요청 리스트
		public List<Map<String,Object>> getSupplierRequestList();	
	//[보람]계약 리스트 
		public List<Map<String,Object>> getSupplierContractList();
}
