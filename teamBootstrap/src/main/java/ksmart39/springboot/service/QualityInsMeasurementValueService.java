package ksmart39.springboot.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.QualityControlMapper;
import ksmart39.springboot.dao.QualityInsMeasurementValueMapper;
import ksmart39.springboot.dao.QualityInspectionFinalResultMapper;
import ksmart39.springboot.domain.QualityBiochemFabricLevelStandard;
import ksmart39.springboot.domain.QualityInspection;
import ksmart39.springboot.domain.QualityInspectionFinalResult;
import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.domain.QualityInspectionStandard;

@Service
public class QualityInsMeasurementValueService {

	
	private static final Logger log = LoggerFactory.getLogger(QualityInsMeasurementValueService.class);

	
	@Autowired
	private QualityInsMeasurementValueMapper qualityInsMeasurementValueMapper;
	@Autowired
	private QualityInspectionFinalResultMapper finalResultMapper;
	
	//품질검사 검색
	public List<QualityInspection> searchInspectionCode(QualityInspection qualityInspection){
		return qualityInsMeasurementValueMapper.searchInspectionCode(qualityInspection);
	};
	
	//거래처 검색
	public List<Map<String, Object>> searchByClientName(String clientName){
		return qualityInsMeasurementValueMapper.searchByClientName(clientName);
	}
	
	//계약번호 검색
	public List<Map<String, Object>> searchByContractNum(Map<String, Object> searchByContractNum){
		return qualityInsMeasurementValueMapper.searchByContractNum(searchByContractNum);
	};

	//품질검사 측정값 현황
	public List<Map<String, Object>> getQualityInspectionStatusNow(Map<String, Object> searchMap){
		return qualityInsMeasurementValueMapper.getQualityInspectionStatusNow(searchMap);
	}
	
	//품질검사 측정값 목록
	public List<QualityInspectionResult> getInspectionMeasurementValueList(){
		return qualityInsMeasurementValueMapper.getInspectionMeasurementValueList();
	}
	
	//품질검사 측정값 등록
	public int addQualityInspectionResult(List<QualityInspectionResult> qualityInspectionResult, HttpSession session) {
		int result = 0;	
				
		log.info("##처음 들어오는 배열## :  {}", qualityInspectionResult);
		
		for(int i = 0; i < qualityInspectionResult.size(); i++) {
			String category = null; //품질검사 카테고리
			String passValue = null; //최종 합/불
			int measuredLevel = 0; //등급값
			int passCheckValue = 0; //판정 기준 최소값
			int resultValue = 0; //측정값
			
			
			
			String qualityInspectionCode = qualityInspectionResult.get(i).getQualityInspectionCode();
			
			//01. 등급/수치/pass인지
			List<QualityInspectionStandard> qi = qualityInsMeasurementValueMapper.getQualityInspectionStandard(qualityInspectionCode);			
			log.info("1. 품질검사코드로 조회하는 기준치 :  {}", qi);
			
			//01-1. 품질검사 카테고리 가져오기
			category = qi.get(0).getCategory();
			log.info("1-1. 카테고리 :  {}", category);
			
			//02.합.불 카테고리일때
			if(category.equals("합격/불합격")) {
				passValue = qualityInspectionResult.get(i).getInspectionPassCheck();
			
			//03.수치별 카테고리일때
			}else if(category.equals("수치")) {
				
			//04.등급별 카테고리일때
			}else if(category.equals("등급")) {
				
				//04-1.원부자재 기준치와 값 비교
				//04-2. 측정값 변수 resultValue에 담기
					log.info("[등급]: 01. 처음 들어오는 배열 :  {}", qualityInspectionResult.get(i));
					
					resultValue = qualityInspectionResult.get(i).getInspectionMeasurementValue();
					log.info("[등급]: 01-2. 측정값  :  {}", resultValue);
					
					//04-3.해당 원부자재의 기준치 가져오기
					List<QualityBiochemFabricLevelStandard> bioStandard 
						= qualityInsMeasurementValueMapper.getBiochemFabricLevelStandard(qualityInspectionResult.get(i));
					log.info("[등급]: 02. 원부자재 기준치 가져오기  :  {}", bioStandard);
					
					//04-4.측정값과 기준치 비교해서 등급 판정
					for(int j = 0; j < bioStandard.size(); j++) {

						if(bioStandard.get(j).getMinValue() <= resultValue && bioStandard.get(j).getMaxValue() >= resultValue) {
							measuredLevel = bioStandard.get(j).getMeasuredLevel();
							log.info("[등급]: 03. 원부자재 기준치와 비교해 등급 측정  :  {}", measuredLevel);
							}						
						}
					
					//04-5.합/불 판정
					//04-6 판정 최소 값 가져오기
					List<QualityInspectionStandard> insStandard 
					= qualityInsMeasurementValueMapper.getQualityInspectionStandard(qualityInspectionResult.get(i).getQualityInspectionCode());
					
					passCheckValue = insStandard.get(0).getMinValue();
					log.info("[등급]: 04. 최소 등급 가져오기  :  {}", passCheckValue);
					
					//04-7 최소 등급과 현재 등급 비교해서 합/불 판정하기
					if(measuredLevel >= passCheckValue) {
						passValue = "합격";
					}else if(measuredLevel <= passCheckValue) {
						passValue = "불합격";
					}
					log.info("[등급]: 05. 최종 합/불  :  {}", passValue);
			}else {
				result = 0;
			}
		
			//05. 해당 DTO에 담기
			qualityInspectionResult.get(i).setInspectionMeasurementValue(resultValue);
			qualityInspectionResult.get(i).setInspectionPassCheck(passValue);
			qualityInspectionResult.get(i).setInspectionMeasurementLevelResult(measuredLevel);
			qualityInspectionResult.get(i).setMinTolerance(passCheckValue);
			//SESSION 완료 되면 바꿔야함
			String employeeCode = (String) session.getAttribute("SCODE");
			qualityInspectionResult.get(i).setChargeEmployeeCode(employeeCode);
			log.info("06. 최종 결과값 set  :  {}", qualityInspectionResult.get(i));
			
			//06. Insert 실행
			qualityInsMeasurementValueMapper.addQualityRawMaterialInspectionResult(qualityInspectionResult.get(i));
			
			result = 1;			
			//품질검사 3회차 결과값 입력시 실행되는
			//품질검사 최종결과값 insert
			
			
			QualityInspectionFinalResult finalResultMap = new QualityInspectionFinalResult();
		

			String inspectionCode = qualityInspectionResult.get(i).getQualityInspectionCode();
			String inspectionRequestCode = qualityInspectionResult.get(i).getQualityInspectionRequestCode();
			Map<String,Object> finalResultParams = finalResultMapper.getMaxMeasurementNum(inspectionRequestCode); 
			log.info("회차와 검사에 대한 시간 정보 가져오는 메서드 실행값 : {}", finalResultParams);
			String maxNum = (String) finalResultParams.get("maxNum"); 
			log.info("회차와 검사에 대한 시간 정보 가져오는 회차 맥스값 : {}", maxNum);
			
			if(maxNum.equals("3회차")) {
				//최종결과값 가져오는 메서드 실행결과 담기
				String finalResult = finalResultMapper.getFinalInspectionResult(inspectionRequestCode);
				log.info("인터페이스에 존재하는 최종결과값 가져오는 메서드를 실행해서 받아오는 결과값 :{}", finalResult);
				
				//최종결과에 넣어주기 위한 데이터들 setter에 넣어주기
				finalResultMap.setChargeEmployeeCode((String) session.getAttribute("SCODE"));
				finalResultMap.setInspectionEndDate((String) finalResultParams.get("finishDate"));
				//Integer.parseInt(String.valueOf(finalResultParams.get("duration")));
				finalResultMap.setInspectionDuration(Integer.parseInt(String.valueOf(finalResultParams.get("duration"))));
				finalResultMap.setInspectionStartDate((String) finalResultParams.get("startDate"));
				finalResultMap.setQualityInspectionRequestCode(inspectionRequestCode);
				finalResultMap.setQualityInspectionCode(inspectionCode);
					
					finalResultMapper.insertFinalResult(finalResultMap);
			}	
		  
		  }
		
		return result;	
	}
	
	//품질검사 카테고리 가져오기
	public List<QualityInspectionStandard> getQualityInspectionStandard(String qualityInspectionCode) {
		return qualityInsMeasurementValueMapper.getQualityInspectionStandard(qualityInspectionCode);
	}
	
	//품질검사 요청 검색 모달
	public List<Map<String, Object>> searchQualityInspectionRequest(Map<String,Object> map){			
		return qualityInsMeasurementValueMapper.searchQualityInspectionRequest(map);
	};
}
