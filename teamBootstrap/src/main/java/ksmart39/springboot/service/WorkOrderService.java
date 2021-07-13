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
		log.info("workOrderList :{}", workOrderList);
		return workOrderList;
	}
	
	//[민아]작업지시목록에서의 생산현황표시
	public String getProcessStatusByWorkOrder(){
		List<String> pCodeFromProductionStatus = new ArrayList<String>();
		//pCodeFromProductionStatus = workOrderMapper.getPcodeFromProcessStatus();
		
		log.info("pCodeFromProductionStatus :{}", pCodeFromProductionStatus);

		

		
		return null;
	}
	

}
