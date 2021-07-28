package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ShipmentMapper;

@Service
public class ShipmentService {
	@Autowired
	private ShipmentMapper shipmentMapper;
	
	
	//[보람]출하지시조회
	public List<Map<String,Object>> getsearchShipmentOrder(HashMap map){
		return shipmentMapper.getsearchShipmentOrder(map);
	}

	//[보람] 출하지시 목록 
	public List<Map<String, Object>> getShipmentOrderList(){
			return shipmentMapper.getShipmentOrderList();
		}
	
	//[보람] 송장목록
	public List<Map<String,Object>> getShipmentInvoiceList(){
			return shipmentMapper.getShipmentInvoiceList();
		}
	
	//[보람]송장번호조회
	public List<Map<String,Object>>searchInvoiceCode(String shipmentInvoice){
			System.out.println("ShipmentService shipmentInvoiceCode : " + shipmentInvoice);
			return shipmentMapper.searchInvoiceCode(shipmentInvoice);
		}
	//[보람]송장 거래처조회
	public List<Map<String,Object>>searchClientCate(String client){
		
		return shipmentMapper.searchClientCate(client);
	}
	//[보람]송장 택배사조회
	public List<Map<String,Object>>searchInvoiceClient(String invoiceClient){
		
		return shipmentMapper.searchInvoiceClient(invoiceClient);
	}
	//[보람]송장 등록일 조회
	public List<Map<String,Object>>searchInvoiceRegDate(String invoiceRegDate){
		
		return shipmentMapper.searchInvoiceRegDate(invoiceRegDate);
	}
}
