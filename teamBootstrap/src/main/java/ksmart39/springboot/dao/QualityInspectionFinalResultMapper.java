package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QualityInspectionFinalResultMapper {
	
	//[다미+보람]검사등록  검사결과 모달창 리스트
	public List<Map<String,Object>> searchRequesetInspection();
	
	//[다미+보람]검사현황 조회 성적서 결과값보여주기
	public List<Map<String,Object>> getQualityInspectionReport(HashMap map);
	
	//[다미+보람]검사현황 조회 성적서 모달창값전달하기
	public List<Map<String,Object>> getFinalResultReport(String requestProductCode);
	
	//[다미+보람]검사현황 조회 품목명가지고오기 
	public List<Map<String,Object>> getProductName(String requestNum);
	
	//[다미+보람]검사현황 조회 의뢰코드명가지고오기 
	public List<Map<String,Object>>	 getRequestProductCode(String client);
	
	
	//[다미+보람]검사현황 조회 거래처명가지고오기
	public List<Map<String, Object>> getClientName();

	//[보람 ]품질검사 최종 리스트 화면
	public  List<Map<String,Object>> getInsepectionFinalResult();
	
	//[민아]품질검사 최종결과값 가져오기
	public String getFinalInspectionResult(String finalResult);
	
	//[민아]품질검사 최종회차 가져오기
	public Map<String,Object> getMaxMeasurementNum(String requestInspectionCode);

}
