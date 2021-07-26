package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

	//[한빛] 주문서 목록 뿌려주기
	public List<Map<String,Object>> getOrderList();
}
