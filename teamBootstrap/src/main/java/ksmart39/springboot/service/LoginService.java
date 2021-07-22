package ksmart39.springboot.service;

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
	
	//회원정보 조회
	public HumanResources loginEmployee(HumanResources loginInfo) {
		boolean loginCheck = false;
		HumanResources loginEmployeeInfo = systemMapper.getEmployeeInfoById(loginInfo.getEmployeeId());
		if(loginEmployeeInfo.getEmployeePw().equals(loginInfo.getEmployeePw()) && loginEmployeeInfo.getLevelNum().equals(loginInfo.getLevelNum())) {
			loginCheck = true;
			return loginEmployeeInfo;
		}
		return null;
	}
}
