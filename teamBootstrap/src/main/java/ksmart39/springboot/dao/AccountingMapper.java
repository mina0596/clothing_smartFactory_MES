package ksmart39.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.AccountingCategory;

@Mapper
public interface AccountingMapper {
	public List<AccountingCategory> getAccountingSubjectList();
}
