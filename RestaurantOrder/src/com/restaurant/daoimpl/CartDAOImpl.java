package com.restaurant.daoimpl;

import java.util.UUID;

import com.restaurant.dao.CartDAO;
import com.restaurant.model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
	private Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst, pst1, pst2, pst3;

	// Constructor to establish database connection
	public CartDAOImpl() {
		// Initialize the database connection
		// ...
		con = DBConnection.getConnection();
		// System.out.println("Connected...");
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e);
		}
	}

	@Override
	public Cart getCartById(String cartId) {
		Cart cart = null;
		return cart;
	}

	@Override
	public List<Cart> getAllCarts(int restoId, String user) {
		List<Cart> cartList = new ArrayList<>();

		try {
			String sql = "SELECT cart_id, user_name, tot_bill, resto_id FROM cart WHERE user_name = ? AND resto_id = ?";

			pst = con.prepareStatement(sql);

			pst.setString(1, user);
			pst.setInt(2, restoId);
//        	System.out.println(restoId+" "+user);
//        	System.out.println(sql);
			rs = pst.executeQuery();

			// System.out.println(rs.toString());
//			System.out.println("\t Bill ");
			System.out.println("\n\t Purchase order:");
			while (rs.next()) {
				String cartId = rs.getString("cart_id");
				String userName = rs.getString("user_name");
				float totalBill = rs.getFloat("tot_bill");
				// int restoId = rs.getInt("resto_id");
				Cart cart = new Cart(cartId, userName, totalBill, restoId);
				cartList.add(cart);
			}
			System.out.println("-------------------------------------------------------------------------");

		} catch (SQLException e) {
			System.out.println(e);
		}

		return cartList;
	}

	@Override
	public void addCart(int restoId, int prodId, String user) {
//		UUID uuid = UUID.randomUUID();
//		// System.out.println(restoId+" "+prodId+" "+user);
//		// System.out.println(uuid);
//		try {
//			// Create and execute SQL query to insert a new cart
//			// ...
//			String sql1 = "INSERT INTO cart (cart_id, user_name, tot_bill, resto_id) VALUES (?, ?, ?, ?)";
//			pst1 = con.prepareStatement(sql1);
//			pst1.setString(1, uuid.toString());
//			pst1.setString(2, user);
//			pst1.setFloat(3, 0.0f);
//			pst1.setInt(4, restoId);
//			int rowsInserted = pst1.executeUpdate();
//
//			System.out.println("New entry = " + rowsInserted);
//			// get price
//			String sqlProduct = "SELECT item_id, price FROM products WHERE item_id = ?";
//			pst = con.prepareStatement(sqlProduct);
//			pst.setInt(1, prodId);
//			rs = pst.executeQuery();
//
//			String sql2 = "INSERT INTO items_in_cart (cart_id, item_id, quantity, price, tot_cost) VALUES (?, ?, ?, ?, ?) ";
//			pst = con.prepareStatement(sql2);
//			pst.setString(1, uuid.toString());
//			pst.setInt(2, prodId);
//			pst.setInt(3, 1);
//
//			if (rs.next()) {
//				pst.setFloat(4, rs.getFloat("price")); // price
//				pst.setFloat(5, rs.getFloat("price"));
//			}
//			int rowsInsertedInCart = pst.executeUpdate();
//			System.out.println("New entry = " + rowsInsertedInCart);
//			 CartDAOImpl c = new CartDAOImpl();
//			 c.finalBilling(uuid.toString());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		CartDAOImpl c = new CartDAOImpl();
		c.addCart(restoId, prodId, user, 1);
	}

	@Override
	public void addCart(int restoId, int prodId, String user, int quant) {
		UUID uuid = UUID.randomUUID();
		// System.out.println(uuid);
		try {
			// Create and execute SQL query to insert a new cart
			// ...
			String sql1 = "INSERT INTO cart (cart_id, user_name, tot_bill, resto_id) VALUES (?, ?, ?, ?)";
			pst = con.prepareStatement(sql1);
			pst.setString(1, uuid.toString());
			pst.setString(2, user);
			pst.setFloat(3, 0.0f);
			pst.setInt(4, restoId);
			int rows = pst.executeUpdate();
			// get price
			String sqlProduct = "SELECT price FROM products WHERE item_id = ?";
			pst1 = con.prepareStatement(sqlProduct);
			pst1.setInt(1, prodId);
			rs = pst1.executeQuery();
//			System.out.println(rs.next());
//			while(rs.next()) {
//				System.out.println(rs.getFloat("price"));
//			}
			
			if (rs.next()) {
				String sql2 = "INSERT INTO items_in_cart (cart_id, item_id, quantity, price, tot_cost) VALUES (?, ?, ?, ?, ?) ";
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, uuid.toString());
				pst2.setInt(2, prodId);
				pst2.setInt(3, quant);

				pst2.setFloat(4, rs.getFloat("price")); // price
				pst2.setFloat(5, (quant * rs.getFloat("price")));
				int rowsInItemCart = pst2.executeUpdate();
			}
			//System.out.println(rowsInItemCart);
            CartDAOImpl c = new CartDAOImpl();
            c.finalBilling(uuid.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCart(Cart cart) {
	}

	@Override
	public void deleteCart(String cartId) {
	}

	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub

	}

	public  void finalBilling(String uuid) {
		
		try {
			
			String sql = "UPDATE cart set tot_bill = (SELECT SUM(tot_cost) FROM items_in_cart GROUP BY cart_id HAVING cart_id = ? ) WHERE cart_id = ? ";
             pst = con.prepareStatement(sql);
            pst.setString(1, uuid);
            pst.setString(2, uuid);
            int rows = pst.executeUpdate();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
