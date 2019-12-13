package com.app.dao;

import com.app.pojos.Customer;

public interface ICustomerDao {

	public Customer CustomerLogin(String email,String password);
	public Customer CustomerSignUp(Customer c);
	public String CustomerUpdate(Customer c);
}
