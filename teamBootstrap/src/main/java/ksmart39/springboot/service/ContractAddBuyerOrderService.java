package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ContractAddBuyerOrderMapper;
import ksmart39.springboot.domain.ProductCodeDetail;
import ksmart39.springboot.domain.RequestedProduct;
import ksmart39.springboot.domain.RequestedProductSize;
import ksmart39.springboot.domain.RequiredSizeList;

@Service
public class ContractAddBuyerOrderService {
	
	
	private static final Logger log = LoggerFactory.getLogger(ContractAddBuyerOrderService.class);


	@Autowired
	private ContractAddBuyerOrderMapper contractAddBuyerOrderMapper;
	
	//의뢰 사이즈 등록
	public int addBuyerOrderSize(List<RequestedProductSize> requestedProductSize) {
		for(int i = 0; i<requestedProductSize.size(); i++) {
			
			//품목별 의뢰 코드, 등록 직원 가져오기
			Map<String, Object> codeMap = contractAddBuyerOrderMapper.getRequestProductCode(requestedProductSize.get(i).getRequestedProductCode());
			
			requestedProductSize.get(i).setChargedEmployeeCode((String) codeMap.get("charge_employee_code"));
			requestedProductSize.get(i).setRequestedProductCode((String) codeMap.get("requested_product_code"));
						
		}
		//의뢰 사이즈 등록
		int result = contractAddBuyerOrderMapper.addBuyerOrderSize(requestedProductSize);

		return result;
	}
	
	//품목별 의뢰 등록
	public int addBuyerOrder(List<RequestedProduct> requestedProduct) {
	String productCode = null;
	String productRequestCode = null;
	
	log.info("01. 처음 들어온 값: {}", requestedProduct);
	
		//01. 마지막 의뢰코드 + 1
		String productRequestCodeDB = contractAddBuyerOrderMapper.getProductRequestCode();
		log.info("02. 의뢰 코드: {}", productRequestCodeDB);
		
		for(int i = 0; i <requestedProduct.size(); i++) {
			
			productCode = requestedProduct.get(i).getProductCode();
			
			//02. 품목별 의뢰 코드 만들기
			productRequestCode = productRequestCodeDB + "_" + productCode;
			log.info("03. 품목별 의뢰 코드: {}", productRequestCode);
			
			//03. 품목별 의뢰 코드 셋팅, 의뢰코드 셋팅
			requestedProduct.get(i).setRequestedProductCode(productRequestCode);
			requestedProduct.get(i).setProductRequestCode(productRequestCodeDB);
		}
		log.info("04. 셋팅된 값: {}", requestedProduct);
		//04. 품목별 의뢰 insert
		int result = contractAddBuyerOrderMapper.addBuyerOrder(requestedProduct);
		
		return result;
	};
	
	//품목에 따른 측정부위 가져오기
	public List<RequiredSizeList> getMeasurementPart(String detailedCategorizedCode){
		return contractAddBuyerOrderMapper.getMeasurementPart(detailedCategorizedCode);
	};
	
	//성별에 따른 품목들 가져오기
	public List<ProductCodeDetail> getDetailedCategorizedName(String genderCategorizedName){
		return contractAddBuyerOrderMapper.getDetailedCategorizedName(genderCategorizedName); 
	};
}
