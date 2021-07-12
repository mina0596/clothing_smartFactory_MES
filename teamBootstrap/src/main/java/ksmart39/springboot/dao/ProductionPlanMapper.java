package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ProductionPlan;

@Mapper
public interface ProductionPlanMapper {

	//[다미]생산계획 삭제
	public int deleteProductionPlan(String delArr);
	
	//[다미]생산계획 검색
	public List<Map<String, Object>> searchProductionPlan(HashMap map);	
	
	//[다미]생산계획 수정 등록
	public int modifyProductionPlan(ProductionPlan productionPlan);
	
	//[다미]생산계획 수정 폼
	public Map<String, Object> getProductionAllPlanList(String planCode);
	
	//[다미]생산계획 전체 조회
	public List<Map<String, Object>> getProductionAllPlanList();
	
	//[다미]생산계획 등록
	public int addProductionPlan(ProductionPlan productionPlan);
	
	//[다미]생산계획 등록 폼 - 소분류 조회
	public List<Map<String, Object>> getDetailCode(String gender);
	
	//[다미]생산계획 등록 폼 - 제품 코드 조회
	public List<Map<String, Object>> getProductCode();
	
}
