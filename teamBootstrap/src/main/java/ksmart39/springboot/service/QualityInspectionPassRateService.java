package ksmart39.springboot.service;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.QualityInspectionPassRateMapper;

@Service
public class QualityInspectionPassRateService {
	private static final Logger log = LoggerFactory.getLogger(QualityInspectionPassRateService.class);
	
	@Autowired
	private QualityInspectionPassRateMapper passRateMapper;
	
	//[민아]불량률높은 5위 조회
	public List<Map<String,Object>> getInspectionFailedRank(){
		return passRateMapper.getInspectionFailedRank();
	}
	
}	
	
	
