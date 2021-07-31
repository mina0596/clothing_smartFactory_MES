package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart39.springboot.dao.ShipmentMapper;
import ksmart39.springboot.domain.ShipmentOrder;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentMapper shipmentMapper;
	//[출하지시 수정]
	public int modifyShipmentOrder(ShipmentOrder shipmentOrder) {
		return shipmentMapper.modifyShipmentOrder(shipmentOrder);
	}
	
	//[보람] 출하지시 정보  
	public ShipmentOrder shipmentOrderInfo(String shipmentOrderCode){
		return shipmentMapper.shipmentOrderInfo(shipmentOrderCode);
	}
	

	//출하지시 등록시 의뢰품목코드 중복확인
	public int checkProduct(String shipmentOrderProduectCode){
	return shipmentMapper.checkProduct(shipmentOrderProduectCode);
	}
	//[보람 ]출하지시 등록
	public int addShipmentOrder(String shipmentRequestCode,String shipmentOrderProduectCode,String shipmentOrderProductName,String contractState,String chargeEmployeeCode,String shipmentOrderDate) {
		Map<String, Object> shipmentOrderMap = new HashMap<String,Object>();
		shipmentOrderMap.put("shipmentRequestCode", shipmentRequestCode);
		shipmentOrderMap.put("shipmentOrderProduectCode", shipmentOrderProduectCode);
		shipmentOrderMap.put("shipmentOrderProductName", shipmentOrderProductName);
		shipmentOrderMap.put("contractState", contractState);
		shipmentOrderMap.put("chargeEmployeeCode", chargeEmployeeCode);
		shipmentOrderMap.put("shipmentOrderDate", shipmentOrderDate);
		return shipmentMapper.addShipmentOrder(shipmentOrderMap);
		
	}
	
	
	//[보람]출하지시 모달 거래처조회로 완성품 목록찾기
	public List<Map<String,Object>> searchCompletClientName(String clientName){
		return shipmentMapper.searchCompletClientName(clientName);
	}
	//[보람]출하지시 모달 계약조회로 완성품 목록찾기
	public List<Map<String,Object>> searchCompletContract(String contractCode){
		return shipmentMapper.searchCompletContract(contractCode);
	}
	
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
