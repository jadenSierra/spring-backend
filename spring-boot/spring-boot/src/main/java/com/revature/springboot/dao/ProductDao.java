package com.revature.springboot.dao;

import org.springframework.stereotype.Repository;

import com.revature.springboot.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    
}
