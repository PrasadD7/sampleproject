package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/{email}/{pwd}")
	public ResponseEntity<?> processLoginForm(@PathVariable String email, @PathVariable String pwd) {
		System.out.println("in process login");
		Customer c = service.CustomerLogin(email, pwd);
		if (c != null) {
			return new ResponseEntity<Customer>(c, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invalid Credentials", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> processSignUpForm(@RequestBody Customer c) {
		try {
			return new ResponseEntity<Customer>(service.CustomerSignup(c), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid Request", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	public ResponseEntity<?> processUpdate(@RequestBody Customer c) {
		try {
			return new ResponseEntity<String>(service.CustomerUpdate(c), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(service.CustomerUpdate(c), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
