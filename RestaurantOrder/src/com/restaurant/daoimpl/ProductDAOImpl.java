package com.restaurant.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.ProductDAO;
import com.restaurant.model.Product;
import com.restaurant.model.Restaurant;

public class ProductDAOImpl implements ProductDAO {
    private Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    // Constructor to establish database connection
    public ProductDAOImpl() {
        // Initialize the database connection
        // ...
    	  con = DBConnection.getConnection();
  		//System.out.println("Connected...");
  	    try {
  			st = con.createStatement();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			//e.printStackTrace();
  			System.out.println(e);
  		}
    }

    @Override
    public Product getProductById(int restoId, int itemId) {
        Product product = null;
        return product;
    }

    @Override
    public List<Product> getAllProducts(int restoId) {
        List<Product> productList = new ArrayList<>();
        
        try {
        	String sql = "SELECT item_id, item_name, description, price FROM products WHERE item_id IN (SELECT item_id FROM food_at_resto WHERE resto_id = ?)";
 		    
        	pst = con.prepareStatement(sql);
        	pst.setInt(1, restoId);
        	rs = pst.executeQuery();
 			//System.out.println("\n\t Food available in Restaurant ");
 		    while(rs.next()) {
 		    	int itemId = rs.getInt("item_id");
 		    	String itemName = rs.getString("item_name");
 		    	String description = rs.getString("description");
 		    	float price = rs.getFloat("price");
 		    	Product prod = new Product(itemId, itemName, description, price);
 		    	productList.add(prod);
 			}
 			System.out.println("-------------------------------------------------------------------------");
 		}
 		catch(SQLException e) {
 			System.out.println(e);
 		}
        
        return productList;
    }

    @Override
    public void addProduct(int restoId, Product product) {
    }

    @Override
    public void updateProduct(int restoId, Product product) {
    }

    @Override
    public void deleteProduct(int restoId, int itemId) {
    }

	
}
