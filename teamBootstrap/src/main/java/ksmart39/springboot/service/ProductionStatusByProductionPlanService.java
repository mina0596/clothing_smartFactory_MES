package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionPlanMapper;
import ksmart39.springboot.dao.ProductionStatusByProductionPlanMapper;
import ksmart39.springboot.domain.ProductionPlan;

@Service
public class ProductionStatusByProductionPlanService {
	
	@Autowired
	private ProductionStatusByProductionPlanMapper productStatusByProductionPlanMapper;

	//[민아] 생상계획별 달성률 조회
	public List<Map<String,Object>> getAchievePercentageByPlan(){
		return productStatusByProductionPlanMapper.getAchievePercentageByPlan();
	}
	

}
