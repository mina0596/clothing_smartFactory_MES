package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.runtime.typehandling.IntegerMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.controller.ProductionController_PMA;
import ksmart39.springboot.dao.ProductionPlanMapper;
import ksmart39.springboot.dao.ProductionStatusByProductionPlanMapper;
import ksmart39.springboot.domain.ProductionPlan;

@Service
public class ProductionStatusByProductionPlanService {
	private static final Logger log = LoggerFactory.getLogger(ProductionStatusByProductionPlanService.class);
	@Autowired
	private ProductionStatusByProductionPlanMapper productStatusByProductionPlanMapper;

	//[민아] 생상계획별 달성률 조회
	public List<Map<String,Object>> getAchievePercentageByPlan(){
		List<Map<String,Object>> productStatusList = productStatusByProductionPlanMapper.getAchievePercentageByPlan();
		
		log.info("productStatusList :{}", productStatusList);
		String completedPercentage = null;
		int leftNum = 0;
		for(int i=0; i<productStatusList.size(); i++) {
			int plannedNum = Integer.parseInt(String.valueOf(productStatusList.get(i).get("quantityNum")));
			log.info("plannedNum :{}", plannedNum);
			int productedNum = Integer.parseInt(String.valueOf(productStatusList.get(i).get("completedProductNum")));
			log.info("productedNum :{}", productedNum);
			leftNum = plannedNum - productedNum;
			log.info("leftNum :{}", leftNum);
			String percentNum = String.valueOf(productStatusList.get(i).get("achievePercentageNum"));
			completedPercentage = percentNum + '%';
			double percentOnlyNum = Double.parseDouble(percentNum);
			
			productStatusList.get(i).put("leftNum", leftNum);
			productStatusList.get(i).put("completedPercentage", completedPercentage);
			if(percentOnlyNum < 100) {
				productStatusList.get(i).put("status", "진행중");
			}else {
				productStatusList.get(i).put("status", "달성");
			}
		}
		return productStatusList;
	}
	
	//[민아] 끝난 생산계획 정보 조회
	public List<Map<String,Object>> getFinishedProductionPlanInfo(){
		List<Map<String,Object>> finishedProductionPlanList = productStatusByProductionPlanMapper.getFinishedProductionPlanInfo();
		String completedPercentage = null;
		int leftNum = 0;
		for(int i=0; i<finishedProductionPlanList.size(); i++) {
			int plannedNum = Integer.parseInt(String.valueOf(finishedProductionPlanList.get(i).get("quantityNum")));
			log.info("plannedNum :{}", plannedNum);
			int productedNum = Integer.parseInt(String.valueOf(finishedProductionPlanList.get(i).get("completedProductNum")));
			log.info("productedNum :{}", productedNum);
			leftNum = plannedNum - productedNum;
			log.info("leftNum :{}", leftNum);
			String percentNum = String.valueOf(finishedProductionPlanList.get(i).get("achievePercentageNum"));
			completedPercentage = percentNum + '%';
			double percentOnlyNum = Double.parseDouble(percentNum);
			
			finishedProductionPlanList.get(i).put("leftNum", leftNum);
			finishedProductionPlanList.get(i).put("completedPercentage", completedPercentage);
			
			if(percentOnlyNum < 100) {
				finishedProductionPlanList.get(i).put("status", "미달성");
			}else {
				finishedProductionPlanList.get(i).put("status", "달성");
			}
		}
		return finishedProductionPlanList;
	}

}
