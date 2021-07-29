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
	
	public Map<String,Object> getBuyerContract(Pagination paging){
		PageMaker pageMaker = new PageMaker();
	    pageMaker.setPaging(paging);
	    
	    pageMaker.setTotalCount(contractMapper.getContractCount());
		
	    Map<String, Object> paramMap = new HashMap<String, Object>();
  		paramMap.put("rowStart", paging.getRowStart());
  		paramMap.put("rowPerPage", paging.getRowPerPage());
  		
  		List<Map<String, ContractInfo>> buyerContractList = contractMapper.getBuyerContract(paramMap);
  		Map<String, Object> resultMap = new HashMap<String, Object>();
  		resultMap.put("currentPage", paging.getCurrentPage());
  		resultMap.put("buyerContractList", buyerContractList);
  		resultMap.put("lastPage", pageMaker.getLastPage());
  		resultMap.put("pageStartNum", pageMaker.getPageStartNum());
  		resultMap.put("pageEndNum", pageMaker.getPageEndNum());

		return resultMap;
	}

}
