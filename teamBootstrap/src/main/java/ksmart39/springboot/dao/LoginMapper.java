package ksmart39.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.HumanResources;

@Mapper
public interface LoginMapper {
	//[민아]로그인했을때 회원정보
	public HumanResources getEmployeeInfoById(String employeeId);
}
