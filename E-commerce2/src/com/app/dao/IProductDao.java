package com.app.dao;

import java.util.List;

import com.app.pojos.Product;

public interface IProductDao {

	public List<Product> listProducts();
	
	public Product addProduct(Product p);
	
	public String updateProduct(Product p);

}
