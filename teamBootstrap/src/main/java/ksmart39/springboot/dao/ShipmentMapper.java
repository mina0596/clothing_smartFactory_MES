package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShipmentMapper {

	//[보람] 출하지시 목록 
	public  List<Map<String, Object>>  getShipmentOrderList();
	
	
	//[보람] 송장목록
	public List<Map<String,Object>> getShipmentInvoiceList();
}
