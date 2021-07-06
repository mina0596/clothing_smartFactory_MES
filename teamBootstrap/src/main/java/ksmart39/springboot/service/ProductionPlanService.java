package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionMapper;
import ksmart39.springboot.dao.ProductionPlanMapper;
import ksmart39.springboot.domain.ProductionPlan;

@Service
public class ProductionPlanService {
	
	@Autowired
	private ProductionPlanMapper productionPlanMapper;
	
	//[다미]소분류 조회
	public List<Map<String, Object>> getDetailCode(String gender){
		return productionPlanMapper.getDetailCode(gender);
	}
	
	//[다미]생산코드 조회
	public List<Map<String, Object>> getProductCode(){
		return productionPlanMapper.getProductCode();
	}	
	
	public List<ProductionPlan> getProductionMonthlyPlanList(){
		return productionPlanMapper.getProductionMonthlyPlanList();
	}
}