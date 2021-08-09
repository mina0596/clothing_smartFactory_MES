package ksmart39.springboot.service;


import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
	
	//[민아]연도별 불량률 조회
	public List<Map<String,Object>> getPastYearsFailedPercent(){
		return passRateMapper.getPastYearsFailedPercent();
	}
	
	//[민아]연도별 불량률 5위 상세정보
	public List<Map<String,Object>> getYearlyFailRank(){
		//일단 초기화
		List<Map<String,Object>> yearlyFailRate = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Calendar cal = Calendar.getInstance();
		
		String year = "2021";
		for(int i=0; i < 4; i++) {
			int yearNum = cal.get(Calendar.YEAR)-i;
			year = Integer.toString(yearNum);
			yearlyFailRate = passRateMapper.getYearlyFailRank(year);
			for(int j=0; j < yearlyFailRate.size(); j++) {
				yearlyFailRate.get(j).put("year", year);
				result.add(yearlyFailRate.get(j));
			}
			log.info("결과값 확인:{}", result);
			
		}
		log.info("getYearlyFailRank 결과값확인 :{}", result);
		return result;
	}
	
	//[민아]월별 연도별 불량률 조회
	public List<Map<String,Object>> getMonthlyFailRateByYear(){
		return passRateMapper.getMonthlyFailRateByYear();
	}
	
	//[민아]연도별 월 불량률 상세정보 조회
	public List<Map<String,Object>> getMonthlyFailRateRank(String selectedYear){
		return passRateMapper.getMonthlyFailRateRank(selectedYear);
	}
	
	//[민아]대분류검사별 불량률 조회
	public List<Map<String,Object>> getHighClassInspectionFailRank(){
		return passRateMapper.getHighClassInspectionFailRank();
	}
		
}	
	 
	
