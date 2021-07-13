package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionStatusMapper;
import ksmart39.springboot.domain.ProductionPlan;

@Service
public class ProductionService {
	
	@Autowired
	private ProductionStatusMapper productionMapper;
	

}
