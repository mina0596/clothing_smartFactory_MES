package ksmart39.springboot.dao;

import java.util.List;

import ksmart39.springboot.domain.QualityInspection;

public interface QualityControlMapper {
	//[보람]품질검사 조회 메서드
	public QualityInspection getQualityInspectionByCode(String qualityInspectionCode );
	//[보람 ]품질검사 리스트 조회메서드
	public List<QualityInspection> getQualityInspectionList();
	
}
