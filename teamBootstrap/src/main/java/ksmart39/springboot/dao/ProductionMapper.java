package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ProductionProcessList;
import ksmart39.springboot.domain.RequestedProduct;



@Mapper
public interface ProductionMapper {
	
	//[민아]완제품 품목 등록
	public int addCompletedProduct(Map<String,String> comProductInfo);
	
	//[민아]생산 대기중인 품목 목록
	public List<Map<String,String>> getProductReadyToStart();
	
	//[민아]생산 시작하기 - 생산현황에 첫공정 insert
	public int startProduction(String sentPCode);
	
	//[민아]거래처명 검색 모달 결과
	public List<Map<String,Object>> searchClientName(Map<String,Object> infoMap);
	
	//[민아]의뢰 품목별로의 생산현황 검색 결과
	public List<Map<String,Object>> searchProductToStart(Map<String,Object> searchKeys);
	
	//[민아]생산 프로세스의 정보 가겨오기
	public ProductionProcessList getProcessDetails(String processCode);
}
