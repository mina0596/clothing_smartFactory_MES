package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.RequestedProduct;

@Mapper
public interface RequestedProductMapper {
	
	//[한빛] 주문서 목록 뿌려주기
	public List<Map<String,Object>> getRequestedProduct();
	
	//[한빛]
	public int completeRequest(String productRequestCode);
	
	//[한빛] 승인완료 목록 뿌리기 
	public List<RequestedProduct> getRequestedProductApproval(Map<String, Object> paramMap);
}
