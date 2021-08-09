package ksmart39.springboot.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.DefectiveProductMapper;
import ksmart39.springboot.domain.Client;
import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.domain.QualityInspectionResult;
import ksmart39.springboot.paging.PageMaker;
import ksmart39.springboot.paging.Pagination;

@Service
public class DefectiveProductService {
	
	@Autowired
	private DefectiveProductMapper defectiveProductMapper;

	
	//[한빛] 불량품 등록
	public int addDefectiveProduct(DefectiveProduct defectiveProduct) {
		int result = defectiveProductMapper.addDefectiveProduct(defectiveProduct);
		return result;
	}
	
	//[한빛] 불량품 모달 뿌려주기 
	public List<QualityInspectionResult> getFinalResult(String fail){
		List<QualityInspectionResult> finalResult = defectiveProductMapper.getFinalResult(fail);
		return finalResult;
	}
	
	//[한빛] 불량품 수정
	public int modifyDefectiveProduct(DefectiveProduct defectiveProduct) {
		return defectiveProductMapper.modifyDefectiveProduct(defectiveProduct);
	}
	
	//[한빛] 불량품 코드로 가져오기
	public DefectiveProduct getProductByCode(String defectiveProductCode) {
		return defectiveProductMapper.getProductByCode(defectiveProductCode);
	}
	
	//[한빛] 불량품 목록
	public Map<String, Object> getDefectiveProduct(Pagination paging){
		
		PageMaker pageMaker = new PageMaker();
		
		paging.setRowPerPage(10);
	    pageMaker.setPaging(paging);
	    
	    pageMaker.setTotalCount(defectiveProductMapper.defectiveProductCount());

	    Map<String, Object> paramMap = new HashMap<String, Object>();
  		paramMap.put("rowStart", paging.getRowStart());
  		paramMap.put("rowPerPage", paging.getRowPerPage());

  		List<Map<String, DefectiveProduct>> defectiveProductList = defectiveProductMapper.getDefectiveProduct(paramMap);
  		Map<String, Object> resultMap = new HashMap<String, Object>();
  		resultMap.put("currentPage", paging.getCurrentPage());
  		resultMap.put("defectiveProductList", defectiveProductList);
  		resultMap.put("lastPage", pageMaker.getLastPage());
  		resultMap.put("pageStartNum", pageMaker.getPageStartNum());
  		resultMap.put("pageEndNum", pageMaker.getPageEndNum());

		return resultMap;
	}
	
	//[한빛] 불량품 삭제
	public int deleteDefectiveProduct(List<String> delArr) {
		return defectiveProductMapper.deleteDefectiveProduct(delArr);
	}
}

