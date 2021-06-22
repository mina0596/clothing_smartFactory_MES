package ksmart39.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.AccountingMapper;
import ksmart39.springboot.domain.AccountingCategory;

@Service
public class AccountingService {
	
	@Autowired
	private AccountingMapper accountingMapper;
	
	public List<AccountingCategory> getAccountingSubjectList(){		
		return accountingMapper.getAccountingSubjectList();
		
	}
}