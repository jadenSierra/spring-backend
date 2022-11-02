package com.revature.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springboot.model.Product;
import com.revature.springboot.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method= RequestMethod.GET, value = "/")
    public List<Product> GetProducts(){
        return productService.GetProducts();
    }

    @GetMapping(value = "/{productId}")
    public Product GetProductsById(@PathVariable("productId") int productId){
        return productService.GetProductById(productId);
    }

    @PostMapping(value="/add")
    public Product AddProduct(@RequestBody Product newproduct){
        return productService.AddProduct(newproduct);
    }

    @PutMapping(value = "/update")
        public Product UpdateProduct(@RequestBody Product updateProduct){
            return productService.UpdateProduct(updateProduct);
        }
    

    @RequestMapping(method = RequestMethod.DELETE, value="/delete/{productId}")
    public void DeleteProduct(@PathVariable("productId") int productId){
        productService.DeleteProduct(productId);
    }
}