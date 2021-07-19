package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionPlanMapper;
import ksmart39.springboot.domain.ProductionPlan;

@Service
public class ProductionPlanService {
	
	@Autowired
	private ProductionPlanMapper productionPlanMapper;

	//[다미]생산계획 삭제
	public int deleteProductionPlan(String delArr) {
		return productionPlanMapper.deleteProductionPlan(delArr);
	};	
	
	//[다미]생산계획 검색
	public List<Map<String, Object>> searchProductionPlan(HashMap map){
		return productionPlanMapper.searchProductionPlan(map);
	};
	
	//[다미]코드로 검색
	public Map<String, Object> getProductionPlanListByCode(String planCode){
		return productionPlanMapper.getProductionAllPlanList(planCode);
	}
	
	//[다미]생산계획 수정 등록
	public int modifyProductionPlan(ProductionPlan productionPlan) {
		return productionPlanMapper.modifyProductionPlan(productionPlan);
	};
	
	//[다미]생산계획 전체 조회
	public List<Map<String, Object>>getProductionAllPlanList(){
		return productionPlanMapper.getProductionAllPlanList();
	};
	
	//[다미]생산계획 등록
	public int addProductionPlan(ProductionPlan productionPlan) {
		return productionPlanMapper.addProductionPlan(productionPlan);
	};
	
	//[다미]소분류 조회
	public List<Map<String, Object>> getDetailCode(String gender){
		return productionPlanMapper.getDetailCode(gender);
	}
	
	//[다미]생산코드 조회
	public List<Map<String, Object>> getProductCode(){
		return productionPlanMapper.getProductCode();
	}	
	

}
