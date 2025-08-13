package com.example.ecommerce.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	
	// Create product
	public Product createProduct(Product product, Long categoryId, List<Long> tagId) {
		// When create a new product, will get the category, and set it to the product 
		product.setCategory(categoryService.getCategoryById(categoryId));
		// When create a new product, will get the tag, and set it to the product
		product.setTags(Set.copyOf(tagService.getByTagId(tagId)));
		return productRepository.save(product);
	}
	
	// Read all product from Product file
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	//Read by Product.ID from Product file
	public Product getProductById(long id) {
		return productRepository.findById(id)
			.orElseThrow(()-> new RuntimeException("Product not found"));
	}
	
	//Update data in Product file
	public Product updateProduct(Long id, Product updatedProduct) {
		Product existing = getProductById(id);
		existing.setName(updatedProduct.getName());
		existing.setPrice(updatedProduct.getPrice());
		existing.setQuantity(updatedProduct.getQuantity());
		return productRepository.save(existing);
	}
	
	// Delete
	public void deleteProduct (long id) {
		if(!productRepository.existsById(id)) {
			throw new RuntimeException("Product not found");
		}
		productRepository.deleteById(id);
	}

}
