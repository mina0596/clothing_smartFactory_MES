package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ProductionPlan;

@Mapper
public interface ProductionMapper {
	
	//[다미]생산계획 조회
	public List<ProductionPlan> getProductionMonthlyPlanList();
}
