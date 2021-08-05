package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.CompletedProduct;




@Mapper
public interface CompletedProductMapper {
	
	//[민아]완제품 품목코드 + 최초시작일자 + 마지막공정완료일자 목록
	public List<CompletedProduct> getCompletedProductInfo();
	
	//[민아]완제품 품목 등록
	public int addCompletedProduct(CompletedProduct productInfo);
	
	//[민아]완제품 품목 목록
	public List<Map<String,Object>> getCompletedProductList();
	
	//[민아]완제품 자동등록을 위한 정보 가져오는 쿼리
	public CompletedProduct getProductInfoToInsertCompleted(String productCode);
}
