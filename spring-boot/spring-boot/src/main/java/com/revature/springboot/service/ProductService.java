package com.revature.springboot.service;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.revature.springboot.dao.CartDao;
import com.revature.springboot.dao.ProductDao;
import com.revature.springboot.model.Cart;
import com.revature.springboot.model.Product;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartDao cartDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Product AddProduct(Product newProduct){


        Optional<Cart> foundCart = cartDao.findById(newProduct.getCart().getCartId());
        Cart cart;

        if(foundCart.isEmpty()) {
             cart = cartDao.save(new Cart());
        } else {
           cart = foundCart.get();
        }

        newProduct.getCart().setCartId(cart.getCartId());

        return productDao.save(newProduct);
    }

    public List<Product> GetProducts(){
        return productDao.findAll();
    }

    public Product GetProductById(int id){
        Optional<Product> foundProduct = productDao.findById(id);

        if(foundProduct.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Was Not Found");
        } else {
            return foundProduct.get();
        }
    }

    public Product UpdateProduct(Product updateProduct){
        //checking if product exsis
    GetProductById(updateProduct.getId());

        return productDao.save(updateProduct); //save will add or update
    }

    public void DeleteProduct(int id){

        Product found = GetProductById(id);

        productDao.delete(found);
    }

}
