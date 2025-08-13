package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// Test flow 
	// 1) create a product - POST localhost:8080/api/product?categoryId=1&tagId=1
	// 2) Get all product or get product by id = localhost:8080/api/product
	// 3) Get all categories, or get categories by id = localhost:8080/api/product
	@PostMapping
	public Product addProduct(
			@Valid @RequestBody Product product, @RequestParam Long categoryId, @RequestParam List<Long> tagId) {
		//Now to create a new product I have to specify the category ID - DTO
		//Temporarily use RequestParam
		//Best Practice user proper DTO
		return productService.createProduct(product, categoryId, tagId);
	}
	
	@GetMapping
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
		
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id){
		return productService.getProductById(id);
		
	}
		
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
}
