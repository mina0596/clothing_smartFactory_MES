package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.RawMaterialsInventory;
import ksmart39.springboot.domain.SupplierRequest;

@Mapper
public interface RawMaterialsInventoryStatusMapper {
	
	
	//[한빛] 출고 등록
	public int addExwarehousing(RawMaterialsInventory rawMaterialsInventory);
	
	//[한빛] 모달 목록 뿌려주기
	public List<SupplierRequest> getSupplierRequest(String approval);
	
	//[한빛] 출고현황 리스트
	public List<Map<String,Object>> getExwarehousing();
	
	//[한빛] 리스트 삭제
	public int deleteExHousing(List<String> delArr);
	
	//================================================================
	
	//[민아]자재 입출고 현황 리스트
	public List<RawMaterialsInventory> getMaterialsTransactionList();
	
	//[민아]자재 입고 수정화면
	public RawMaterialsInventory getTransInfoByCode(String transactionCode);
	
	//[민아]자재 입고 수정 처리
	public int modifyMaterialIn(Map<String,Object> paramMap);
	
	//[민아]자재 현재고 리스트
	public Map<String,Object> getInventoryStatusByMCode(String materialCode);

}
