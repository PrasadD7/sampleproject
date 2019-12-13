package com.app.service;

import java.util.ArrayList;

import com.app.pojos.Product;

public interface IProductService {
	public ArrayList<Product> listProducts();

	public Product addProduct(Product p);
	
	public String updateProduct(Product p);
}
