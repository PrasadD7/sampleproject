package com.app.service;

import com.app.pojos.Customer;

public interface ICustomerService {

	public Customer CustomerLogin(String email,String password);
	public Customer CustomerSignup(Customer c);
	public String CustomerUpdate(Customer c);
	
}
