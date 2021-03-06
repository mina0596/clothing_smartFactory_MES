package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.dao.QualityInspectionFinalResultMapper;
import ksmart39.springboot.dao.QualityInspectionStatusMapper;

@Service
public class QualityInspectionStauteService {
	private static final Logger log = LoggerFactory.getLogger(QualityInspectionStauteService.class);
	
	@Autowired
	private QualityInspectionStatusMapper qualityInsepctionStauteMapper;
	
	
	//[보람] 수주계약별 검사 합격별조회
	public List<Map<String,Object>> getSearchQualityInspectionStatePassCheck(HashMap map3){
		//HashMAp map 에다가 RequestParam값을 담았기 때문에 인자값으로 넣어준다.	
		return qualityInsepctionStauteMapper.getSearchQualityInspectionStatePassCheck(map3);
	}
	//[보람] 수주계약별 검사 수치별조회
	public List<Map<String,Object>> getSearchQualityInspectionStateMeasurement(HashMap map2){
		//HashMAp map 에다가 RequestParam값을 담았기 때문에 인자값으로 넣어준다.	
		return qualityInsepctionStauteMapper.getSearchQualityInspectionStateMeasurement(map2);
	}
	//[보람] 수주계약별 검사 조회
		public List<Map<String,Object>> getSearchQualityInspectionState(HashMap map){
			//HashMAp map 에다가 RequestParam값을 담았기 때문에 인자값으로 넣어준다.	
		return qualityInsepctionStauteMapper.getSearchQualityInspectionState(map);
		}
	
	//[다미&보람]수주계약별 검사현황 리스트합격/불합격
	public List<Map<String, Object>> getStateBuyerContractQualityInspectionPass(){
		return qualityInsepctionStauteMapper.getStateBuyerContractQualityInspectionPass();
	}
	//[다미&보람]수주계약별 검사현황 리스트	수치
	public List<Map<String, Object>> getStateBuyerContractQualityInspectionMeasurement(){
		return qualityInsepctionStauteMapper.getStateBuyerContractQualityInspectionMeasurement();
	}
	//[다미&보람]수주계약별 검사현황 리스트
	public List<Map<String, Object>> getStateBuyerContractQualityInspection() {
		
		
		return qualityInsepctionStauteMapper.getStateBuyerContractQualityInspection();
	}
	
}	
	
	
