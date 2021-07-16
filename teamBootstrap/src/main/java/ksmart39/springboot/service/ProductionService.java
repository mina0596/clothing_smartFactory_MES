package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.controller.ProductionController_PMA;
import ksmart39.springboot.dao.ProductionMapper;
import ksmart39.springboot.dao.WorkOrderMapper;
import ksmart39.springboot.domain.ProductProductionProcessStatus;
import ksmart39.springboot.domain.ProductionProcessList;
import ksmart39.springboot.domain.RequestedProduct;


@Service
public class ProductionService {
	private static final Logger log = LoggerFactory.getLogger(ProductionService.class);
	private final ProductionMapper productionMapper;
	private final WorkOrderMapper workOrderMapper;
	
	@Autowired
	public ProductionService(ProductionMapper productionMapper, WorkOrderMapper workOrderMapper) {
		this.productionMapper = productionMapper;
		this.workOrderMapper = workOrderMapper;
	}
	
	//[민아]완제품 품목 등록
	public int addCompletedProduct(Map<String,String> comProductInfo) {
		return productionMapper.addCompletedProduct(comProductInfo);
	}
	
	//[민아]생산 대기중인 품목 목록
	public List<Map<String,Object>> getProductReadyToStart(){
		List<Map<String,Object>> workOrderList = workOrderMapper.getWorkOrderList();
		
		return workOrderList;
	}
		
	//[민아]생산 시작하기 - 생산현황에 첫공정 insert
	public int startProduction(String sentPCode) {
		return productionMapper.startProduction(sentPCode);
	}
	
	//[민아]거래처명 검색 모달 결과
	public List<Map<String,Object>> searchClientName(Map<String,Object> infoMap){
		return productionMapper.searchClientName(infoMap);
	}
	
	//[민아]의뢰 품목별로의 생산현황 검색 결과
	public List<Map<String,Object>> searchProductToStart(Map<String,Object> searchKeys){
		//생산프로세스에 대한 디테일 정보를 separate mapper를 이용해서 service단에서 합쳐서 보내주는것이 좋을까 고민했...
		//안그러면 지금 사용하는게 inner join 이 4개나 있어서...
		List<Map<String,Object>> productToStartInfo = productionMapper.searchProductToStart(searchKeys);
		log.info("productToStartInfo 맵퍼에서 가져오는 값 확인 : {}", productToStartInfo);
		
		return productionMapper.searchProductToStart(searchKeys);
	}
	
	//[민아]생산공정 완료 버튼을 누르면 완료시간들어감
	public int completeProcess(ProductProductionProcessStatus processStatus) {
		return productionMapper.completeProcess(processStatus);
	}
	
	//[민아]생산공정 완료 버튼 누르면 다음 공정 insert됨
	public int insertNextProcess(ProductProductionProcessStatus processStatus) {
		String previousProcessCode = processStatus.getProductionProcessCode();
		log.info("===============================================");
		log.info("previousProcessCode : {}", previousProcessCode);
		//맨마지막 숫자만 자르고 int로 변환
		int processOrderNum = Integer.parseInt(previousProcessCode.substring(9,10));
		log.info("processOrderNum : {}", processOrderNum);
		String NextProcessNum = Integer.toString(processOrderNum + 1);
		log.info("NextProcessNum : {}", NextProcessNum);
		String NextProcessCode = (previousProcessCode.substring(0, 9)).concat(NextProcessNum);
		log.info("NextProcessCode : {}", NextProcessCode);
		processStatus.setProductionProcessCode(NextProcessCode);
		log.info("processStatus 프로세스코드에 1을 더해 setting해준 dto :{}", processStatus);
		
		return productionMapper.insertNextProcess(processStatus);
	}
	
	//[민아]생산시작 버튼 누르면 시간 update
	public int startProcess(ProductProductionProcessStatus processStatus) {
		return productionMapper.startProcess(processStatus);
	}
}
