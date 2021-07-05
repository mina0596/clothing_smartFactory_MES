package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.QualityInspection;

@Mapper
public interface SystemMapper {
	
	
	//[다미] 계정과목 수정
	public int modifyMember(AccountingCategory account);
	
	//[다미] 계정과목 수정화면
	public AccountingCategory getAccountSubjectByCode(String categoryCode);
	
	//[다미] 계정과목 추가
	public int addAccountSubject(AccountingCategory account);
	
	//====================================================
	//회원전체조회(levelName포함)
	public List<HumanResources> getHumanResources();
	//회원가입
	public int addHumanResources(HumanResources humanResources);
	
	//회원정보 조회
	public HumanResources getEmployeeInfoByCode(String employeeCode);
	
	//회원정보 수정
	public int modifyHumanResources(HumanResources humanResources);
	//====================================================
	//[한빛] 거래처 전체조회
	public List<Client> getClient();
	//거래처 등록
	public int addClient (Client client);
	//거래처 수정
	public int modifyClient(Client client);
	//거래처 정보 가져오기 (뿌려진 화면에서)
	public Client getClientInfoByCode(String clientCode);
	//====================================================
	public List<AccountingCategory> getAccountingSubjectList(Map<String, Object> paramMap);	
	
	//=====================================================
	//[보람 ]품질검사 리스트 조회메서드
	public List<QualityInspection> getQualityInspectionList();

}
