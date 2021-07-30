package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.ContractInfo;

@Mapper
public interface ContractMapper {

	//[한빛] 테이블 행 개수 조회
	public int getContractCount();
	//[한빛] 목록
	public List<Map<String,ContractInfo>> getBuyerContract(Map<String,Object> paramMap);
}
