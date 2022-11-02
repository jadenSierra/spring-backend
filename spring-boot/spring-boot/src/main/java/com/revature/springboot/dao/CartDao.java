package com.revature.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.springboot.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
    
}
