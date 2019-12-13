package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Override
	public Customer CustomerLogin(String email, String password) {

		return dao.CustomerLogin(email, password);
	}

	@Override
	public Customer CustomerSignup(Customer c) {
		return dao.CustomerSignUp(c);
	}

	@Override
	public String CustomerUpdate(Customer c) {
		return dao.CustomerUpdate(c);
	}

}
