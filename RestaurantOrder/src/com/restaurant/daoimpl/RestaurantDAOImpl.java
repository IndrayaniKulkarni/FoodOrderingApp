package com.restaurant.daoimpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.RestaurantDAO;
import com.restaurant.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {
    private Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pst;
    // Constructor to establish database connection
    public RestaurantDAOImpl() {
        // Initialize the database connection
        // ...
        con = DBConnection.getConnection();
//		System.out.println("Connected...");
	    try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
    }

    @Override
    public Restaurant getRestaurantById(int restoId) {
        Restaurant restaurant = null;
        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = new ArrayList<>();
       try {
			
			rs = st.executeQuery("SELECT * FROM restaurant");
		    System.out.println("\t Restaurants available in area");
		    while(rs.next()) {
				int id = rs.getInt("resto_id"); 
				String name = rs.getString("resto_name");
				String address = rs.getString("address");
				Restaurant resto = new Restaurant(id, name, address);
                restaurantList.add(resto);
			}
			System.out.println("-------------------------------------------------------------------");
		}
		catch(SQLException e) {
			System.out.println(e);
		}
        return restaurantList;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
    
	   
	  try {  
         // Create and execute SQL query to insert a new restaurant
            // ...
	    pst = con.prepareStatement("INSERT INTO restaurant VALUES (?,?,?)");
	    pst.setInt(1, restaurant.getRestoId());
	    pst.setString(2,  restaurant.getRestoName());
	    pst.setString(3, restaurant.getRestoName());
	    
	    int noOfRowsInserted = pst.executeUpdate();
	    if(noOfRowsInserted>0) {
	    	System.out.println("Restaurant added successfully ..");
	    }
	    else {
	    	System.out.println("Error..");
	    }
	  }
	  catch(SQLException e) {
		  System.out.println(e);
	  }
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
    }

    @Override
    public void deleteRestaurant(int restoId) {
    }

	
}
