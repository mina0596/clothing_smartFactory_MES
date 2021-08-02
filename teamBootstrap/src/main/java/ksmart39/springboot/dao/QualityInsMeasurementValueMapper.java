package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.QualityBiochemFabricLevelStandard;
import ksmart39.springboot.domain.QualityInspection;
import ksmart39.springboot.domain.QualityInspectionRequest;
import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.domain.QualityInspectionStandard;

@Mapper
public interface QualityInsMeasurementValueMapper {

	//품질검사 검색
	public List<QualityInspection> searchInspectionCode(QualityInspection qualityInspection);
	
	//거래처 검색
	public List<Map<String, Object>> searchByClientName(String clientName);
	
	//계약번호 검색
	public List<Map<String, Object>> searchByContractNum(Map<String, Object> searchByContractNum);
	
	//실시간 검사 현황 리스트 위에 넣을 데이터들
	public Map<String, Object> getAllCount(String contractNum);
	
	//전체 합/불별 건수
	public Map<String, Object> getPassOrFailCount(String contractNum);
	
	//공정별 불량건수
	public Map<String, Object> getFailCountByHighInspection(String contractNum);
	
	//품질검사 현황
	public List<Map<String, Object>> getQualityInspectionStatusNow(Map<String, Object> searchMap);
	
	//품질검사 측정 목록
	public List<QualityInspectionResult> getInspectionMeasurementValueList();
	
	//품질검사 측정표 등록
	public int addQualityRawMaterialInspectionResult(QualityInspectionResult qualityInspectionResult);
	
	//품질검사 수치별 기준 가져오기
	public List<Map<String, Object>> getQualityInspectionStandardByNumber(String qualityInspectionCode, String qualityInspectionRequestCode);
	
	//품질검사 기준표
	public List<QualityInspectionStandard> getQualityInspectionStandard(String qualityInspectionCode);
	
	//원부자재 이화학검사 원단별 등급 기준치 
	public List<QualityBiochemFabricLevelStandard> getBiochemFabricLevelStandard(QualityInspectionResult qualityInspectionResult);
	
	//품질검사 요청 검색 모달
	public List<Map<String, Object>> searchQualityInspectionRequest(Map<String, Object> map);

	//품질검사 요청 목록
	public List<Map<String, Object>> getQualityInspectionRequestList();
	
	//품질검사 단일 요청
	public int qualityInspectionRequest(QualityInspectionRequest qualityInspectionRequest);
	
	//계약번호로 품목별 의뢰코드 검색
	public List<Map<String, Object>> searchRequestProductCode(String contractCode);
	
	//품질검사 세부 코드 검색
	public List<Map<String, Object>> subClassCate(String lowClassCateName);
}
