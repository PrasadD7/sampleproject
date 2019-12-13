package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;
@Repository
public class ProductDaoImpl implements IProductDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Product> listProducts() {
		return sf.getCurrentSession().createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product addProduct(Product p) {
		try {
			sf.getCurrentSession().save(p);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateProduct(Product p) {
		String status="Updation failed!";
		try {
			sf.getCurrentSession().saveOrUpdate(p);
			status = "Updation successful!";
			return status;
		} catch (Exception e) {
			return status;
		}
		
	}

}
