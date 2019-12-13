package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao dao;
	
	@Override
	public ArrayList<Product> listProducts() {
		return (ArrayList<Product>) dao.listProducts();
	}

	@Override
	public Product addProduct(Product p) {
		return dao.addProduct(p);
	}

	@Override
	public String updateProduct(Product p) {
		return dao.updateProduct(p);
	}

	
	
}
