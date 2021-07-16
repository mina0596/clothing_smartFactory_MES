package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.QualityInsMeasurementValueMapper;
import ksmart39.springboot.domain.QualityBiochemFabricLevelStandard;
import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.domain.QualityInspectionStandard;

@Service
public class QualityInsMeasurementValueService {

	
	private static final Logger log = LoggerFactory.getLogger(QualityInsMeasurementValueService.class);

	
	@Autowired
	private QualityInsMeasurementValueMapper qualityInsMeasurementValueMapper;
	
	//원부자재 이화학검사 원단별 등급 결과값 등록
	public int addQualityInspectionResult(List<QualityInspectionResult> qualityInspectionResult) {
		int result = 0;
		int measuredLevel = 0; //등급값
		int passCheckValue = 0; //판정 기준 최소값
		String passValue = null; //최종 합/불
		
		log.info("01. 처음 들어오는 배열 :  {}", qualityInspectionResult.get(0));
		
		//01.원부자재 기준치와 값 비교
		//01-1. 측정값 변수 resultValue에 담기
		for(int i = 0; i < qualityInspectionResult.size(); i++) {
			int resultValue = qualityInspectionResult.get(i).getInspectionMeasurementValue();
			log.info("01-2. 측정값  :  {}", resultValue);
			
			//01-1.해당 원부자재의 기준치 가져오기
			List<QualityBiochemFabricLevelStandard> bioStandard 
					= qualityInsMeasurementValueMapper.getBiochemFabricLevelStandard(qualityInspectionResult.get(i));
			log.info("02. 원부자재 기준치 가져오기  :  {}", bioStandard);
			
			//01-2.측정값과 기준치 비교해서 등급 판정
			for(int j = 0; j < bioStandard.size(); j++) {
				if(bioStandard.get(j).getMinValue() <= resultValue && bioStandard.get(j).getMaxValue() >= resultValue) {
					measuredLevel = bioStandard.get(j).getMeasuredLevel();
					log.info("03. 원부자재 기준치와 비교해 등급 측정  :  {}", measuredLevel);				
				}
				
				//02.합/불 판정
				//02-1 판정 최소 값 가져오기
				List<QualityInspectionStandard> insStandard 
					= qualityInsMeasurementValueMapper.getQualityInspectionStandard(qualityInspectionResult.get(i).getQualityInspectionCode());
		
				passCheckValue = insStandard.get(0).getMinValue();
				log.info("04. 최소 등급 가져오기  :  {}", passCheckValue);
								
			}
			
			//02-2 최소 등급과 현재 등급 비교해서 합/불 판정하기
			if(measuredLevel >= passCheckValue) {
				passValue = "합격";
			}else if(measuredLevel <= passCheckValue) {
				passValue = "불합격";
			}
			log.info("05. 최종 합/불  :  {}", passValue);
			
			
			//03. 해당 DTO에 담기
			qualityInspectionResult.get(i).setInspectionMeasurementValue(resultValue);
			qualityInspectionResult.get(i).setInspectionPassCheck(passValue);
			qualityInspectionResult.get(i).setInspectionMeasurementLevelResult(measuredLevel);
			qualityInspectionResult.get(i).setMinTolerance(passCheckValue);
			//SESSION 완료 되면 바꿔야함
			qualityInspectionResult.get(i).setChargeEmployeeCode("E0014");
			log.info("06. 측정값, 최종 합/불 set  :  {}", qualityInspectionResult.get(i));
			
			//04. Insert 실행
			qualityInsMeasurementValueMapper.addQualityRawMaterialInspectionResult(qualityInspectionResult.get(i));
		}

		return result;
	};
	
	//품질검사 요청 검색 모달
	public List<Map<String, Object>> searchQualityInspectionRequest(Map<String,Object> map){			
		return qualityInsMeasurementValueMapper.searchQualityInspectionRequest(map);
	};
}
