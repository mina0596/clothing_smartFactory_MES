package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ProductCodeDetail;
import ksmart39.springboot.domain.RequestedProduct;
import ksmart39.springboot.domain.RequestedProductSize;
import ksmart39.springboot.domain.RequiredSizeList;

@Mapper
public interface ContractAddBuyerOrderMapper {
	
	
	//의뢰 품목 사이즈 등록
	public int addBuyerOrderSize(List<RequestedProductSize> requestedProductSize);
	
	//바로 전 품목별 의뢰 코드 가져오기
	public Map<String, Object> getRequestProductCode(String productCode);
	
	//의뢰 등록
	public int addBuyerOrder(List<RequestedProduct> requestedProduct);
	
	//의뢰코드 마지막 + 1해서 가져오기
	public String getProductRequestCode();
	
	//품목에 따른 측정부위 가져오기
	public List<RequiredSizeList> getMeasurementPart(String detailedCategorizedCode);
	
	//성별에 따른 품목들 가져오기
	public List<ProductCodeDetail> getDetailedCategorizedName(String genderCategorizedName);
}
