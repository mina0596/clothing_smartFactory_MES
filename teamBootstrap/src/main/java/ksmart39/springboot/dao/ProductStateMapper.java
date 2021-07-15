package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ProductStateMapper {
	
	//
	public List<Map<String,Object>> getProductState();
}
