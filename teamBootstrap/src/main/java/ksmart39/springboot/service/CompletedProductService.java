package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ksmart39.springboot.dao.CompletedProductMapper;
import ksmart39.springboot.domain.CompletedProduct;



@Service
public class CompletedProductService {
	private static final Logger log = LoggerFactory.getLogger(CompletedProductService.class);
	private final CompletedProductMapper completedProductMapper;
	
	@Autowired
	public CompletedProductService(CompletedProductMapper completedProductMapper) {
		this.completedProductMapper = completedProductMapper;
	}

	
	//[민아]완제품 품목 등록
	public int addCompletedProduct(CompletedProduct productInfo) {
		//완제품 품목코드 + 최초시작일자 + 마지막공정완료일자 목록
		List<CompletedProduct> productInfoList = completedProductMapper.getCompletedProductInfo();
		int addWorkCheck = 0;
		for(int i=0; i < productInfoList.size(); i++) {
			completedProductMapper.addCompletedProduct(productInfoList.get(i));
			addWorkCheck = 1;
		}
		return addWorkCheck;
	}
	
	//[민아]완제품 품목 목록
	public List<Map<String,Object>> getCompletedProductList(){
		return completedProductMapper.getCompletedProductList();
	}
}
