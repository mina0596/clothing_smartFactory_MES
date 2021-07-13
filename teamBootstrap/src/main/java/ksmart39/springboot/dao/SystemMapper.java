package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.AccountingCategory;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.HighClassInspection;
import ksmart39.springboot.domain.HumanResources;

import ksmart39.springboot.domain.QualityInspection;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.SubClassInspection;


@Mapper
public interface SystemMapper {
	
	//[민아] 원부자재 전체 리스트 조회
	public List<RawMaterials> getMaterialsList(); 
	
	/****************************************************************************/

	//[다미] 계정과목 수정
	public int modifyMember(AccountingCategory account);
	
	//[다미] 계정과목 수정화면
	public AccountingCategory getAccountSubjectByCode(String categoryCode);
	
	//[다미] 계정과목 추가
	public int addAccountSubject(AccountingCategory account);
	public List<AccountingCategory> getAccountingSubjectList(Map<String, Object> paramMap);	
	
	/****************************************************************************/
	
	//회원전체조회(levelName포함)
	public List<HumanResources> getHumanResources(Map<String, Object> paramMap);
	//회원가입
	public int addHumanResources(HumanResources humanResources);	
	//회원정보 조회
	public HumanResources getEmployeeInfoByCode(String employeeCode);	
	//회원정보 수정
	public int modifyHumanResources(HumanResources humanResources);
	//회원정보 삭제
	/****************************************************************************/
	
	//[한빛] 거래처 전체조회
	public List<Client> getClient(Map<String, Object> paramMap);
	//거래처 등록
	public int addClient (Client client);
	//거래처 수정
	public int modifyClient(Client client);
	//거래처 정보 가져오기 (뿌려진 화면에서)
	public Client getClientInfoByCode(String clientCode);
	
	/****************************************************************************/
	
	
	/****************************************************************************/
	//[보람 ]품질검사 수정 
	public int modifyQualityInspection(SubClassInspection subClassInspection);
	
	//[보람 ]품질검사 한행 가지고오는 메서드
	public  SubClassInspection getQualityInspectionCode(String qualityInspectionCode);
	
	
	
	//[보람 ]품질검사 리스트 조회메서드
	
	 public List<Map<String, Object>> getQualityInspectionList();
	
	/** 카테고리 4번 ajax로해야고  그것을 dto로 해서 map으로 해서 등록하면 된다고하심 
	 * 일단 ajax부터 성공하고나서 dto로 map 해서 해보기 안되면 물어보기***/
	//[보람]품질검사 대분류 카테고리 가져오는 메서드
	public List<HighClassInspection> getHighClassCate();

}
