package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.SystemMapper;
import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;

import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.SubClassInspection;

@Service
public class SystemService {
	
	@Autowired
	private SystemMapper systemMapper;


	//[민아]원부자재 전체 리스트 조회
	public List<RawMaterials> getMaterialsList(){
		List<RawMaterials> rawMaterialsList = systemMapper.getMaterialsList();
		return rawMaterialsList;
	};
	
	//============================================================
	//[한빛]회원전체조회(levelName포함)
	public List<HumanResources> getHumanResources(Map<String, Object> paramMap){
		List<HumanResources> humanResources = systemMapper.getHumanResources(paramMap);
		return humanResources;
	}
	//회원정보 등록
	public int addHumanResources (HumanResources humanResources) {
		int result = systemMapper.addHumanResources(humanResources);
		return result;
	}	
	//회원정보 조회
	public HumanResources getEmployeeInfoByCode(String employeeCode) {
		return systemMapper.getEmployeeInfoByCode(employeeCode);
	}
	//회원정보 수정
	public int modifyHumanResources (HumanResources humanResources) {
		return systemMapper.modifyHumanResources(humanResources);
	}
	//회원정보 삭제
	//============================================================
	//[한빛] 거래처 전체 조회
	public List<Client> getClient(Map<String, Object> paramMap){
		List<Client> client = systemMapper.getClient(paramMap);
		return client;
	}
	//거래처 등록
	public int addClient (Client client) {
		int result = systemMapper.addClient(client);
		return result;
	}
	//거래처 수정
	public int modifyClient (Client client) {
		return systemMapper.modifyClient(client);
	}
	//거래처 수정 뿌려주기
	public Client getClientInfoByCode(String clientCode) {
		return systemMapper.getClientInfoByCode(clientCode);
	}
	//============================================================
	
	//[다미] 계정과목 수정
	public int modifyMember(AccountingCategory account) {
		int result = systemMapper.modifyMember(account);
		return result;
	};
	
	//[다미] 계정과목 수정 화면
	public AccountingCategory getAccountSubjectByCode(String categoryCode) {		
		return systemMapper.getAccountSubjectByCode(categoryCode);
	};
	
	//[다미] 계정과목 추가
	public int addAccountSubject(AccountingCategory account) {
		int result = systemMapper.addAccountSubject(account);		
		return result;
	}
	
	//[다미] 회계과목 조회
	public List<AccountingCategory> getAccountingSubjectList(Map<String, Object> paramMap){		
		return systemMapper.getAccountingSubjectList(paramMap);
		
	}
	
	//=============================================================
	
	//[보람 ]품질검사 상세 수정 메서드
	public int modifyQualityInspection(SubClassInspection subClassInspection) {
		return systemMapper.modifyQualityInspection(subClassInspection);
		}
	//[보람 ]품질검사 한행을 가지고오는메서드
	public  SubClassInspection getQualityInspectionCode(String qualityInspectionCode) {
		return systemMapper.getQualityInspectionCode(qualityInspectionCode);
		
	}
	
	
	//[보람 ]품질검사 리스트 조회메서드
	
	 public List<Map<String, Object>> getQualityInspectionList() 
	 { return	
			  systemMapper.getQualityInspectionList();
	 }
	 
}