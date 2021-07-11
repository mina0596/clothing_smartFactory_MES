package ksmart39.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.DefectiveProductMapper;
import ksmart39.springboot.domain.DefectiveProduct;

@Service
public class DefectiveProductService {
	
	@Autowired
	private DefectiveProductMapper defectiveProductMapper;

	public List<DefectiveProduct> getDefectiveProduct(){
		List<DefectiveProduct> defectiveProduct = defectiveProductMapper.getDefectiveProduct();
		return defectiveProduct;
	}
}
