package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.HumanResources;

@Mapper
public interface HumanResourcesMapper {
	
	//회원전체조회(levelName포함)
	public List<HumanResources> getHumanResources();
}
