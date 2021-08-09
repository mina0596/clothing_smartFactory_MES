package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ContractMapper;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.ContractInfo;
import ksmart39.springboot.paging.PageMaker;
import ksmart39.springboot.paging.Pagination;

@Service
public class ContractService {
	@Autowired
	private ContractMapper contractMapper;
	
	public List<Map<String,Object>> getBuyerContract(){
		return contractMapper.getBuyerContract();
	}

}
