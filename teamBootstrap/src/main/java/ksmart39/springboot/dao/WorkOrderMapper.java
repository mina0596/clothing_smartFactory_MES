package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.WorkOrder;


@Mapper
public interface WorkOrderMapper {
	
	//[민아]작업지시 목록
	public List<WorkOrder> getWorkOrderList();

}
