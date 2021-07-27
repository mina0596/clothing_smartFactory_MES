package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ksmart39.springboot.dao.RawMaterialInwarehousingMapper;
import ksmart39.springboot.domain.RawMaterialsInventory;

@Service
public class RawMaterialInwarehousingService {
	
	@Autowired
	private RawMaterialInwarehousingMapper rawMaterialInwarehousingMapper;
	
	public List<RawMaterialsInventory> getRawMaterialInwarehousingList(String str){
		return rawMaterialInwarehousingMapper.getRawMaterialInwarehousingList();
	}
}
