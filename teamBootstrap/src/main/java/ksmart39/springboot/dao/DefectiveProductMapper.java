package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.DefectiveProduct;


@Mapper
public interface DefectiveProductMapper {
	
	public List<DefectiveProduct> getDefectiveProduct();
	
	//추가
	public int addDefectiveProduct(DefectiveProduct defectiveProduct);
}
