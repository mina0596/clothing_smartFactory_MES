package ksmart39.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.HumanResourcesMapper;
import ksmart39.springboot.domain.HumanResources;

@Service
public class HumanResourcesService {
	@Autowired
	private HumanResourcesMapper humanResourcesMapper;
	
	//회원전체조회(levelName포함)
	public List<HumanResources> getHumanResources(){
		List<HumanResources> humanResources = humanResourcesMapper.getHumanResources();
		return humanResources;
	}
}