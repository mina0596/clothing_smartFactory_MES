package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.QualityControlMapper;
import ksmart39.springboot.domain.QualityInspection;
@Service
public class QualityControlService {
	@Autowired
	private QualityControlMapper qualityControlMapper;
	
	//[보람]품질검사 리스트 조회메서드
	public List<QualityInspection> getQualityInspectionList(){
		List<QualityInspection> qualityInspectionList = qualityControlMapper.getQualityInspectionList();
	
		return   qualityInspectionList;
	}
	
	//[민아]품질검사 기준표 리스트
	public List<Map<String,Object>> getInspectionStandard(String inspectionCate){
		return qualityControlMapper.getInspectionStandard(inspectionCate);
	}
		
	//[민아]상세검사종류 조회
	public List<Map<String,Object>> getSubClassName(String lowClassCateName){
		return qualityControlMapper.getSubClassName(lowClassCateName);
	}
}
