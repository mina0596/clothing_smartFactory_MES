package ksmart39.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.DefectiveProductMapper;
import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.domain.QualityInspectionResult;

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
	public List<DefectiveProduct> getDefectiveProduct(){
		List<DefectiveProduct> defectiveProduct = defectiveProductMapper.getDefectiveProduct();
		return defectiveProduct;
	}
	
	//[한빛] 불량품 삭제
	public int deleteDefectiveProduct(List<String> delArr) {
		return defectiveProductMapper.deleteDefectiveProduct(delArr);
	}
}

