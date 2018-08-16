package com.amit.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amit.model.CustomerData;
import com.amit.model.CustomerTransactionMessages;
import com.amit.model.CustomerTransactions;

@Repository
@Transactional
public class FileUpdateDAO {
	
	@Autowired
	HibernateTemplate hTemp;

	public void addCustomerData(CustomerData custData) {
		hTemp.save(custData);
	}
	public void addCustomerTransactionMessages(CustomerTransactionMessages TxMsg) {
		hTemp.save(TxMsg);
	}
	public void addCustomerTransactions(CustomerTransactions custTx) {
		hTemp.save(custTx);
	}
	
	
}
