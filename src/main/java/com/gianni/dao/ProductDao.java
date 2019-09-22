package com.gianni.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianni.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
