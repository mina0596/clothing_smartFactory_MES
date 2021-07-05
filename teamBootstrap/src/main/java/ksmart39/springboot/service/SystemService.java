package ksmart39.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ksmart39.springboot.dao.SystemMapper;
import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.Client;
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
	//거래처 등록
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
	//============================================================
	//[한빛] 거래처 전체 조회
	public List<Client> getClient(){
		List<Client> client = systemMapper.getClient();
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