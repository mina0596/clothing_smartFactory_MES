package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductStateMapper;
import ksmart39.springboot.domain.ProductProductionProcessStatus;


@Service
public class ProductStateService {
	
	@Autowired
	private ProductStateMapper productStateMapper;
	
	public List<Map<String,Object>> getProductState(){
		return productStateMapper.getProductState();
	}
}
