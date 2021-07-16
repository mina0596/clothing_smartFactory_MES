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
	
}
