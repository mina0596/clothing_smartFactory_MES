package ksmart39.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.controller.ProductionController;
import ksmart39.springboot.dao.ProductionStatusMapper;
import ksmart39.springboot.dao.WorkOrderMapper;
import ksmart39.springboot.domain.WorkOrder;


@Service
public class WorkOrderService {
	
	private static final Logger log = LoggerFactory.getLogger(WorkOrderService.class);
	private final WorkOrderMapper workOrderMapper;
	private final ProductionStatusMapper productionStatusMapper;
	
	@Autowired
	public WorkOrderService(WorkOrderMapper workOrderMapper, ProductionStatusMapper productionStatusMapper) {
		this.workOrderMapper = workOrderMapper;
		this.productionStatusMapper = productionStatusMapper;		
	}
	
	//[민아]작업지시 목록
	public List<Map<String,Object>> getWorkOrderList(){
		List<Map<String,Object>> workOrderList = workOrderMapper.getWorkOrderList();
		
		String status = "";
		List<Map<String,Object>> pCodeFromProductionStatus = workOrderMapper.getPcodeFromProcessStatus();
		List<String> pCodeListFromProcess = new ArrayList<String>();
		List<String> pCodeListFromWorkOrder = new ArrayList<String>();
		
		for (Map<String, Object> pCodeList : pCodeFromProductionStatus) {
			String pCodeFromProcess = (String) pCodeList.get("pCode");
			pCodeListFromProcess.add(pCodeFromProcess);
		}
		
		for(int i=0; i < workOrderList.size(); i++) {
			String pCode = (String) workOrderList.get(i).get("pCode");
			pCodeListFromWorkOrder.add(pCode);
		}
			
		for(int i=0; i < pCodeListFromWorkOrder.size(); i++) {
			String searchPCode = pCodeListFromWorkOrder.get(i);
			int pCodeCheck = pCodeListFromProcess.indexOf(searchPCode);
			if(pCodeCheck >= 0) {
				status = "진행중";
			}else {
				status = "대기중";
			}
			workOrderList.get(i).put("status", status);
		}
		return workOrderList;
	}
	
	//[민아]작업지시 등록
	public int addWorkOrder(WorkOrder workOrder) {
		return workOrderMapper.addWorkOrder(workOrder);
	}
	
	//[민아]작업지시 수정
	public int modifyWorkOrder(WorkOrder workOrder) {
		return workOrderMapper.modifyWorkOrder(workOrder);
	}
	
	//[민아]작업지시코드로 작업지시 정보 조회
	public Map<String,Object> getWorkOrderInfoByWorkOrderCode(String workOrderCode) {
		return workOrderMapper.getWorkOrderInfoByWorkOrderCode(workOrderCode);
	}


}
