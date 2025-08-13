package com.example.ecommerce.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Product;

// My Repository will get all the function from JpaRepository
// The first argument  inside <> will be your Entity name
// The second argument inside <> will be the ID Entity
// The theory term is Generic ( can refer to book as well)
public interface ProductRepository extends JpaRepository<Product, Long> {
	
//	List<Product> findByIdandName (Long id, String name);
}
