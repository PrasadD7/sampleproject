package com.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Product;
import com.app.service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService service;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
			return new ResponseEntity<ArrayList<Product>>(service.listProducts(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product p){
		try {
			return new ResponseEntity<Product>(service.addProduct(p), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid Request", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product p){
		try {
			return new ResponseEntity<String>("Updation successful!",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Updation failed!",HttpStatus.BAD_REQUEST);
		}
	}
}
