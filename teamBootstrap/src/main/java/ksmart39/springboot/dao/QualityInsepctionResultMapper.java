package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QualityInsepctionResultMapper {
	
	//[다미+보람]검사현황 조회 거래처명가지고오기
	public List<Map<String, Object>> getClientName();

	//[보람 ]품질검사 최종 리스트 화면
	public  List<Map<String,Object>> getInsepectionFinalResult();

}