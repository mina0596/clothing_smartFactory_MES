package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QualityInsepctionStauteMapper {

	//[다미&보람]수주계약별 검사현황
	public List<Map<String,Object>> getStateBuyerContractQualityInspection();


}
