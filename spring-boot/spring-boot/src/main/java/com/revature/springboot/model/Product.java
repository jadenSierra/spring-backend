package com.revature.springboot.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name="Product")
public @Data class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int price;
    private String description;
    private String image;
    private int rating;

    @ManyToOne
    @JoinColumn(name="cartId", nullable = false)
    private Cart cart;

    public Product(){       
    }

    public Product(int id){
        this.id = id;       
    }

	public Product(String productName, int price, String description, String image, int rating) {
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.image = image;
		this.rating = rating;
	}

}
