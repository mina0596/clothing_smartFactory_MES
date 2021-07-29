package ksmart39.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.RawMaterialsInventory;

@Mapper
public interface RawMaterialsInwarehousingMapper {
	
	//원부자재 입고리스트
	public List<RawMaterialsInventory> getRawMaterialInwarehousingList();
}
