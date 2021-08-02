package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.RequestedProductMapper;
import ksmart39.springboot.domain.RequestedProduct;

@Service
public class RequestedProductService {

		@Autowired
		private RequestedProductMapper requestedProductMapper;
		
		//[한빛] 주문서 목록 뿌려주기
		public List<Map<String,Object>> getRequestedProduct(){
			return requestedProductMapper.getRequestedProduct();
		}
		
		//[한빛] 미승인 버튼 누르면 업데이트
		public int completeRequest(String productRequestCode) {
			return requestedProductMapper.completeRequest(productRequestCode);
		}
		
		//[한빛] 승인완료 목록 뿌리기
		public List<RequestedProduct> getRequestedProductApproval(Map<String, Object> paramMap){
			List<RequestedProduct> approvalList = requestedProductMapper.getRequestedProductApproval(paramMap);
			return approvalList;
		}
}
