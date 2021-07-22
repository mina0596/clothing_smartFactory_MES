package ksmart39.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.SystemMapper;
import ksmart39.springboot.domain.HumanResources;

@Service
public class LoginService {
	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	private final SystemMapper systemMapper;
	public LoginService(SystemMapper systemMapper) {
		this.systemMapper = systemMapper;
	}
	
	//[민아]로그인정보 확인
	public Map<String,Object> loginEmployee(HumanResources loginInfo) {
		Map<String,Object> loginInfoMap = new HashMap<String,Object>();
		boolean loginCheck = false;
		
		
		HumanResources loginEmployeeInfo = systemMapper.getEmployeeInfoById(loginInfo.getEmployeeId());
		
		
		log.info("=============================================");
		log.info("service단에서 input 확인 loginEmployeeInfo : {}", loginEmployeeInfo);
		log.info("=============================================");
		
		if(loginEmployeeInfo != null && loginEmployeeInfo.getEmployeePw().equals(loginInfo.getEmployeePw()) && loginEmployeeInfo.getLevelNum().equals(loginInfo.getLevelNum()) && loginEmployeeInfo.getEmployeeId().equals(loginInfo.getEmployeeId())) {
			loginCheck = true;
			loginInfoMap.put("loginCheck", loginCheck);
			loginInfoMap.put("loginEmployeeInfo", loginEmployeeInfo);
			return loginInfoMap;
		}
		log.info("=============================================");
		log.info("service단에서 method출력값 확인 loginInfoMap : {}", loginInfoMap);
		log.info("=============================================");
		loginInfoMap.put("loginCheck", loginCheck);
		loginInfoMap.put("loginEmployeeInfo", loginEmployeeInfo);
		
		return loginInfoMap;
	}
}
