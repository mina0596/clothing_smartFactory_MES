package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.WorkOrder;


@Mapper
public interface WorkOrderMapper {
	
	//[민아]작업지시 목록
	public List<Map<String,Object>> getWorkOrderList();
	
	//[민아]생산을 시작한 품목코드 리스트
	public List<Map<String,Object>> getPcodeFromProcessStatus();
	
	//[민아]작입지시 등록
	public int addWorkOrder(WorkOrder workOrder);
	
	//[민아]작업지시 수정
	public int modifyWorkOrder(WorkOrder workOrder);
	
	//[민아]작업지시코드로 작업지시 정보 조회
	public Map<String,Object> getWorkOrderInfoByWorkOrderCode(String workOrderCode);

}
