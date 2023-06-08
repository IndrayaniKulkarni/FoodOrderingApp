package com.restaurant.dao;
import java.util.List;

import com.restaurant.model.Cart;

public interface CartDAO {
    Cart getCartById(String cartId);
    List<Cart> getAllCarts(int restoId, String user);
    void addCart(Cart cart);
    void addCart(int restoId, int prodId, String user);
    void addCart(int restoId, int prodId, String user, int quant);
    void updateCart(Cart cart);
    void deleteCart(String cartId);
    void finalBilling(String cartId);
}