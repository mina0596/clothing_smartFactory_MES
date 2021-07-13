package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionMapper;
import ksmart39.springboot.dao.WorkOrderMapper;


@Service
public class ProductionService {
	
	private final ProductionMapper productionMapper;
	private final WorkOrderMapper workOrderMapper;
	
	@Autowired
	public ProductionService(ProductionMapper productionMapper, WorkOrderMapper workOrderMapper) {
		this.productionMapper = productionMapper;
		this.workOrderMapper = workOrderMapper;
	}
	
	//[민아]완제품 품목 등록
	public int addCompletedProduct(Map<String,String> comProductInfo) {
		return productionMapper.addCompletedProduct(comProductInfo);
	}
	
	//[민아]생산 대기중인 품목 목록
		public List<Map<String,Object>> getProductReadyToStart(){
			List<Map<String,Object>> workOrderList = workOrderMapper.getWorkOrderList();
			
			return workOrderList;
		}

}
