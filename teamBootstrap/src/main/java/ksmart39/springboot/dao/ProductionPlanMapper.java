package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ProductionPlan;

@Mapper
public interface ProductionPlanMapper {
	
	//[다미]생산계획 전체 조회
	public List<Map<String, Object>>getProductionAllPlanList();
	
	//[다미]생산계획 등록
	public int addProductionPlan(ProductionPlan productionPlan);
	
	//[다미]생산계획 등록 폼 - 소분류 조회
	public List<Map<String, Object>> getDetailCode(String gender);
	
	//[다미]생산계획 등록 폼 - 제품 코드 조회
	public List<Map<String, Object>> getProductCode();
	
	//[다미]생산계획 월별 조회
	public List<ProductionPlan> getProductionMonthlyPlanList();
}
