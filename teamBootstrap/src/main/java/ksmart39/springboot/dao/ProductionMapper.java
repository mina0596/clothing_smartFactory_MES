package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ProductionMapper {
	
	//[민아]완제품 품목 등록
	public int addCompletedProduct(Map<String,String> comProductInfo);
	
	//[민아]생산 대기중인 품목 목록
	public List<Map<String,String>> getProductReadyToStart();
}
