package com.demo.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/test")
	public String testMsg() {
		return "Hello!!! I am there.";
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return service.listAll();
	}
	
	@PostMapping("/saveProduct")
	public void addProduct(@RequestBody Product product) {
		service.save(product);		
	}
	
	@GetMapping("/getProductById")
	public Product getProductById(@RequestParam(value = "id") Integer id) {
		return service.get(id);
	}
	
	@DeleteMapping("/deleteProductById")
	public String deleteProductById(@RequestParam(value="id") Integer id) {
		service.delete(id);
		return "Product with "+id+" is successfully deleted from DB";
	}
	

}
