package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.QualityInspection;
@Mapper
public interface QualityControlMapper {

	//[보람 ]품질검사 리스트 조회메서드
	public List<QualityInspection> getQualityInspectionList();
	
}
