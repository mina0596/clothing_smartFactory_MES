package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.QualityInspection;
@Mapper
public interface QualityInspectionPassRateMapper {

	//[민아]불량률높은 5위 조회
	public List<Map<String,Object>> getInspectionFailedRank();
	
}
