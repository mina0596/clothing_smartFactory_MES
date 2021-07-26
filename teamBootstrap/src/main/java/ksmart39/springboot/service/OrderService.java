package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	//[한빛] 주문서 목록 뿌려주기
	public List<Map<String,Object>> getOrderList(){
		return orderMapper.getOrderList();
	}
}
