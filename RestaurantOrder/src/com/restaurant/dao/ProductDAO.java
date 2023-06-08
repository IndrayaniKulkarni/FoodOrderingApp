package com.restaurant.dao;

import java.util.List;

import com.restaurant.model.Product;

public interface ProductDAO {
    Product getProductById(int restoId, int itemId);
    List<Product> getAllProducts(int restoId);
    void addProduct(int restoId, Product product);
    void updateProduct(int restoId, Product product);
    void deleteProduct(int restoId, int itemId);
}
