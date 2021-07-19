package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.RequestedProductMapper;

@Service
public class RequestedProductService {

		@Autowired
		private RequestedProductMapper requestedProductMapper;
		
		public List<Map<String,Object>> getRequestedProduct(){
			return requestedProductMapper.getRequestedProduct();
		}
}
