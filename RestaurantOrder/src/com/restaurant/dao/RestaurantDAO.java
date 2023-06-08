package com.restaurant.dao;

import java.util.List;

import com.restaurant.model.Restaurant;

public interface RestaurantDAO {
    Restaurant getRestaurantById(int restoId);
    List<Restaurant> getAllRestaurants();
    void addRestaurant(Restaurant restaurant);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(int restoId);
}
