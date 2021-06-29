package ksmart39.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionMapper;
import ksmart39.springboot.domain.ProductionPlan;

@Service
public class ProductionService {
	
	@Autowired
	private ProductionMapper productionMapper;
	
	public List<ProductionPlan> getProductionMonthlyPlanList(){
		return productionMapper.getProductionMonthlyPlanList();
	}
}
