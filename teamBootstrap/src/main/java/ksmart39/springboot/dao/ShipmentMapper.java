package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ShipmentOrder;

@Mapper
public interface ShipmentMapper {
	//[보람]출하지시 삭제
	public int deleteShipmentOrder(String checkArray);
	//[출하지시 수정]
	public int modifyShipmentOrder(ShipmentOrder shipmentOrder);
	//[보람]출하지시 정보 
	public ShipmentOrder shipmentOrderInfo(String shipmentOrderCode);
	//출하지시 등록시 의뢰품목코드 중복체크
	public int checkProduct(String shipmentOrderProduectCode);
	//[보람] 출하지시
		public int addShipmentOrder(Map<String, Object> shipmentOrderMap);
	//[보람]출하지시 모달 거래처조회로 완성품 목록찾기
		public List<Map<String,Object>> searchCompletClientName(String clientName);
	
	//[보람]출하지시 모달 계약조회로 완성품 목록찾기
		public List<Map<String,Object>> searchCompletContract(String contractCode);
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
