package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QualityInspectionPassRateMapper {

	//[민아]불량률높은 5위 조회
	public List<Map<String,Object>> getInspectionFailedRank();
	
	//[민아]연도별 불량률 조회
	public List<Map<String,Object>> getPastYearsFailedPercent();
	
	//[민아]연도별 불량률 5위 상세정보 조회
	public List<Map<String,Object>> getYearlyFailRank(String inputYear);
	
	//[민아]월별 연도별 불량률 조회
	public List<Map<String,Object>> getMonthlyFailRateByYear();
	
}
