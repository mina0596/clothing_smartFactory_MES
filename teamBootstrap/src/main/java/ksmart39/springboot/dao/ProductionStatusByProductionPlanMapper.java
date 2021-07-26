package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ProductionStatusByProductionPlanMapper {
	

	//[민아] 생상계획별 달성률 조회
	public List<Map<String,Object>> getAchievePercentageByPlan();
	
	//[민아] 생산계획 끝난 계획의 정보
	public List<Map<String,Object>> getFinishedProductionPlanInfo();

}
