package ksmart39.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksmart39.springboot.domain.HumanResources;

@Repository
public class LoginDAOImpl implements LoginDAO{
	@Autowired
	private SqlSession session;
	@Override
	public LoginDAO login(HumanResources employeeInfo) {
		return session.selectOne("employee.login", employeeInfo);
	}
}
