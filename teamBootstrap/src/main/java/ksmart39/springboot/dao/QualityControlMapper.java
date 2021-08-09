package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.QualityInspection;
@Mapper
public interface QualityControlMapper {

	//[보람]품질검사 리스트 조회메서드
	public List<QualityInspection> getQualityInspectionList();
	
	//[민아]품질검사 기준표 리스트
	public List<Map<String,Object>> getInspectionStandard(String inspectionCate);
	
	//[민아]상세검사종류 조회
	public List<Map<String,Object>> getSubClassName(String lowClassCateName);
}
