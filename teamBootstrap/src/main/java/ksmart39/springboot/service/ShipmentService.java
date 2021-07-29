package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ShipmentMapper;

@Service
public class ShipmentService {
	@Autowired
	private ShipmentMapper shipmentMapper;

	//[보람] 출하지시 목록 
	public List<Map<String, Object>> getShipmentOrderList(){
			return shipmentMapper.getShipmentOrderList();
		}
	
	//[보람] 송장목록
		public List<Map<String,Object>> getShipmentInvoiceList(){
			return shipmentMapper.getShipmentInvoiceList();
		}
}
