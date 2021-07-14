package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.dao.QualityInsepctionResultMapper;

@Service
public class QualityInsepctionResultService {
	private static final Logger log = LoggerFactory.getLogger(QualityInsepctionResultService.class);
	
	@Autowired
	private QualityInsepctionResultMapper qualityInsepctionResultMapper;
	
	//[다미+보람]검사현황 조회 성적서 결과값보여주기
		public List<Map<String,Object>> getQualityInspectionReport(HashMap map){
			return qualityInsepctionResultMapper.getQualityInspectionReport(map);
		}

	//[다미+보람]검사현황 조회 성적서 결과값보여주기
	public List<Map<String,Object>> getQualityInspectionReport(){
		return null;
	}
	
	//[다미+보람]검사현황 조회 성적서 모달창값전달하기
		public List<Map<String,Object>> getFinalResultReport(String requestProductCode){
			return qualityInsepctionResultMapper.getFinalResultReport(requestProductCode);
			
		}
	//[다미+보람]검사현황 조회 품목명가지고오기 
		public List<Map<String,Object>> getProductName(String requestNum){
			return qualityInsepctionResultMapper.getProductName(requestNum);
		}

	 //[다미+보람]검사현황 조회 의뢰코드명가지고오기 
		public List<Map<String,Object>>	 getRequestProductCode(String client){
			return qualityInsepctionResultMapper.getRequestProductCode(client);
		}
	
	//[다미+보람]검사현황 조회 거래처명가지고오기
		public List<Map<String, Object>> getClientName(){
			
			List<Map<String, Object>> client = qualityInsepctionResultMapper.getClientName();
			
			
			return client;
		}
		

	//[보람 ]품질검사 최종 리스트 화면
		public  List<Map<String,Object>> getInsepectionFinalResult(){
			
			return qualityInsepctionResultMapper.getInsepectionFinalResult();
		}
}
