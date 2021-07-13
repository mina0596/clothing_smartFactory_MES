package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.controller.ProductionController;
import ksmart39.springboot.dao.WorkOrderMapper;
import ksmart39.springboot.domain.WorkOrder;


@Service
public class WorkOrderService {
	
	private static final Logger log = LoggerFactory.getLogger(WorkOrderService.class);
	private final WorkOrderMapper workOrderMapper;
	
	@Autowired
	public WorkOrderService(WorkOrderMapper workOrderMapper) {
		this.workOrderMapper = workOrderMapper;
	}
	
	//[민아]작업지시 목록
	public List<WorkOrder> getWorkOrderList(){
		List<WorkOrder> workOrderList = workOrderMapper.getWorkOrderList();
		log.info("workOrderList :{}", workOrderList);
		return workOrderList;
	}
	

}
