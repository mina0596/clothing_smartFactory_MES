package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.RawMaterialsInventory;

@Mapper
public interface RawMaterialsInventoryStatusMapper {
	
	
	//[민아]자재 입출고 현황
	public List<RawMaterialsInventory> getMaterialsTransactionList();
}
