package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionStatusMapper;

@Service
public class ProductionStatusService {

	@Autowired
	private ProductionStatusMapper productionStatusMapper;
	
	public List<Map<String, Object>> getProductionStatus(){
		
		System.out.println("test" + productionStatusMapper.getProductionStatus());
		return productionStatusMapper.getProductionStatus();
	}
}