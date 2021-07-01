package ksmart39.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ksmart39.springboot.dao.SystemMapper;
import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;

@Service
public class SystemService {
	
	@Autowired
	private SystemMapper systemMapper;

	
	
	//============================================================
	//[한빛]회원전체조회(levelName포함)
	public List<HumanResources> getHumanResources(){
		List<HumanResources> humanResources = systemMapper.getHumanResources();
		return humanResources;
	}
	
	//============================================================
	//[다미] 회계과목 조회
	public List<AccountingCategory> getAccountingSubjectList(){		
		return systemMapper.getAccountingSubjectList();
		
	}
	
	//=============================================================
	
	//[보람 ]품질검사 리스트 조회메서드
	public List<QualityInspection> getQualityInspectionList(){
		List<QualityInspection> qualityInspectionList = systemMapper.getQualityInspectionList();
	
		return   qualityInspectionList;
	}
}