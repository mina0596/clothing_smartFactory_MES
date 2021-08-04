package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QualityInspectionStatusMapper {
	
	//[보람]수주계약별 수치검사현황
	public List<Map<String,Object>> getSearchQualityInspectionStatePassCheck(HashMap map3);
	
	//[보람]수주계약별 수치검사현황
	public List<Map<String,Object>> getSearchQualityInspectionStateMeasurement(HashMap map2);
	//[보람] 수주계약별 검사 조회
	public List<Map<String,Object>> getSearchQualityInspectionState(HashMap map);

	//[다미&보람]수주계약별 검사현황 합격불합격
	public List<Map<String, Object>>getStateBuyerContractQualityInspectionPass();
	//[다미&보람]수주계약별 검사현황수치
	public List<Map<String, Object>>getStateBuyerContractQualityInspectionMeasurement();
	//[다미&보람]수주계약별 검사현황등급
	public List<Map<String, Object>> getStateBuyerContractQualityInspection();


}
