package ksmart39.springboot.dao;

import java.util.ArrayList;
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

}
