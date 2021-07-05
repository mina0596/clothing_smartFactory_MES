package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ProductionPlan;

@Mapper
public interface ProductionMapper {
	
	//[다미]소분류 조회
	public List<Map<String, Object>> getDetailCode(String gender);
	
	//[다미]제품 코드 조회
	public List<Map<String, Object>> getProductCode();
	
	//[다미]생산계획 조회
	public List<ProductionPlan> getProductionMonthlyPlanList();
}
