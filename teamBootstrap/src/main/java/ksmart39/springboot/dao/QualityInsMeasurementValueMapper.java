package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QualityInsMeasurementValueMapper {
	
	//품질검사 요청 목록 전체 행의 수
	public int getQualityInspectionRequestCount();
	
	//품질검사 요청 검색 모달
	public List<Map<String, Object>> searchQualityInspectionRequest(Map<String, Object> map);
}
