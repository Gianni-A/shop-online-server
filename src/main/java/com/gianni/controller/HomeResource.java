package com.gianni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianni.dao.ProductDao;
import com.gianni.model.Product;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class HomeResource {
	
	@Autowired
	ProductDao data;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return data.findAll();
	}
	
	@GetMapping("/products/{pId}")
	public Optional<Product> getProductById(@PathVariable("pId") int id) {
		return data.findById(id);
	}
	
	@PostMapping("/products")
	public Product addOrUpdateProduct(@RequestBody Product pro) {
		return data.save(pro);
	}
	
	
	@DeleteMapping("/products/{pId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pId") int pId) {
		Product p = data.getOne(pId);
		data.delete(p);
		//return "User deleted";
		return new ResponseEntity<String>("user deleted", HttpStatus.OK);
	}

}
