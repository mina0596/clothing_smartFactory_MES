package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestedProductMapper {
	public List<Map<String,Object>> getRequestedProduct();
}
