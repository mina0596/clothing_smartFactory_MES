package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.domain.QualityInspectionResult;


@Mapper
public interface DefectiveProductMapper {
	
	
	//[한빛] 불량품 추가
	public int addDefectiveProduct(DefectiveProduct defectiveProduct);
	//[한빛] 불량품 모달 뿌려주기
	public List<QualityInspectionResult> getFinalResult(String fail); 
	//[한빛] 불량품 목록
	public List<Map<String,DefectiveProduct>> getDefectiveProduct(Map<String, Object> paramMap);
	//[한빛] 테이블 행 개수
	public int defectiveProductCount();
	//[한빛] 불량품 수정
	public int modifyDefectiveProduct(DefectiveProduct defectiveProduct);
	//[한빛] 불량품 수정 뿌려주기
	public DefectiveProduct getProductByCode(String defectiveProductCode);
	//[한빛] 리스트 삭제
	public int deleteDefectiveProduct(List<String> delArr);
}
