package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.QualityInsMeasurementValueMapper;
import ksmart39.springboot.domain.QualityInspection;

@Service
public class QualityInsMeasurementValueService {

	
	private static final Logger log = LoggerFactory.getLogger(QualityInsMeasurementValueService.class);

	
	@Autowired
	private QualityInsMeasurementValueMapper qualityInsMeasurementValueMapper;
	

	
	//품질검사 요청 검색 모달
	public List<Map<String, Object>> searchQualityInspectionRequest(Map map){			
		return qualityInsMeasurementValueMapper.searchQualityInspectionRequest(map);
	};
}
