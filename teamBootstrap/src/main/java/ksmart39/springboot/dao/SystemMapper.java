package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;

@Mapper
public interface SystemMapper {
	
	public List<AccountingCategory> getAccountingSubjectList();
	
	//=========================================
	//회원전체조회(levelName포함)
	public List<HumanResources> getHumanResources();
	
	//[보람 ]품질검사 리스트 조회메서드
	public List<QualityInspection> getQualityInspectionList();

}
