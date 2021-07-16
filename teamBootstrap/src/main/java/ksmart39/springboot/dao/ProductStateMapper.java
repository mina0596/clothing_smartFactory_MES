package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ProductProductionProcessStatus;



@Mapper
public interface ProductStateMapper {
	
	//
	public List<ProductProductionProcessStatus> getProductState();
}
