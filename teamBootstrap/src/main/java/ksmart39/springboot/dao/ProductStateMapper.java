package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductStateMapper {
	
	//[한빛] 목록 뿌려주기
	public List<Map<String,Object>> getProductState();
	
	//[한빛] 검색목록 뿌려주기
	public List<Map<String,Object>> searchProductState();
}
