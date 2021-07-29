package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShipmentMapper {
	//[보람]출하지시조회
	public List<Map<String,Object>> getsearchShipmentOrder(HashMap map);

	//[보람] 출하지시 목록 
	public  List<Map<String, Object>>  getShipmentOrderList();
	
	
	//[보람] 송장목록
	public List<Map<String,Object>> getShipmentInvoiceList();
	//[보람] 송장번호 조회
	public List<Map<String,Object>>searchInvoiceCode(String shipmentInvoice);
	//[보람]송장 거래처조회
	public List<Map<String,Object>>searchClientCate(String client);
	//[보람]송장 거래처조회
	public List<Map<String,Object>>searchInvoiceClient(String invoiceClient);
	//[보람]송장 등록일 조회
	public List<Map<String,Object>>searchInvoiceRegDate(String invoiceRegDate);
}
