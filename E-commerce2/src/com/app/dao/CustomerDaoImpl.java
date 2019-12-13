package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Customer CustomerLogin(String email, String password) {

		Customer c;

		try {
			c = sf.getCurrentSession()
					.createQuery("select c from Customer c where email=:em and password=:pwd", Customer.class)
					.setParameter("em", email).setParameter("pwd", password).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return c;
	}

	@Override
	public Customer CustomerSignUp(Customer c) {
		try {
			sf.getCurrentSession().save(c);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String CustomerUpdate(Customer c) {
		String status = "Updation failed!";
		try {
			sf.getCurrentSession().saveOrUpdate(c);
			status = "Updation successful!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
