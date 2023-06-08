package com.restaurant.app;

import java.util.List;
import java.util.Scanner;

import com.restaurant.dao.ProductDAO;
import com.restaurant.dao.RestaurantDAO;
import com.restaurant.dao.CartDAO;
import com.restaurant.daoimpl.CartDAOImpl;
import com.restaurant.daoimpl.ProductDAOImpl;
import com.restaurant.daoimpl.RestaurantDAOImpl;
import com.restaurant.model.Cart;
import com.restaurant.model.Product;
import com.restaurant.model.Restaurant;
/*
public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		RestaurantDAO obj = new RestaurantDAOImpl();
		
		List<Restaurant> listOfResto = obj.getAllRestaurants();
		System.out.println("List of restos ");
		for(Restaurant r: listOfResto) {
			System.out.println(r);
		}
		
		System.out.println("Choose restaurant = ");
		int restoId = sc.nextInt();
		
		ProductDAO prod = new ProductDAOImpl();
		
		List<Product> listOfProduct= prod.getAllProducts(restoId);
		System.out.println("List of Product ");
		for(Product r: listOfProduct) {
			System.out.println(r);
		}
		
		System.out.println("Choose item = ");
		int prodId = sc.nextInt();
		
		System.out.println("Kindly enter your name to create cart = ");
		String user = sc.next();
		
		System.out.println(user);
		System.out.println("Please enter quantity for itemId:"+prodId+" : "+ listOfProduct.get(prodId-1).getItemName());
		int quantity = sc.nextInt();
		
		CartDAO cart = new CartDAOImpl();
		cart.addCart(restoId, prodId, user,quantity);
		List<Cart> listOfCart= cart.getAllCarts(restoId,user);
		System.out.println("Purchase order ");
		for(Cart r: listOfCart) {
			System.out.println(r);
		}
	
	}

}
*/

public class Main {
	static Scanner sc = new Scanner(System.in);
	static RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
	static ProductDAO productDAO = new ProductDAOImpl();
	static CartDAO cartDAO = new CartDAOImpl();

	public static void main(String[] args) {
		

	
		int restoId = 0, prodId = 0 , choice = 0, quantity = 1;
		String user = "";
	    do {
	        System.out.println("------ Restaurant Ordering System ------");
	        System.out.println("1. List Restaurants");
	        
	        System.out.println("2. Add Item to Cart");
	        System.out.println("3. View Cart");
	        System.out.println("4. Exit");
	        System.out.print("Enter your choice: ");
	        choice = sc.nextInt();
	        sc.nextLine(); // Consume the newline character
	        
	        switch (choice) {
	            case 1:
	            	listRestaurants();
	        		restoId = chooseRestaurant();

	        		System.out.println("\n\t Food available in Restaurant ");
	        		listProducts(restoId);
	        		prodId = chooseProduct(restoId);
	        		user = getUserName();
	        		quantity = getQuantity(prodId, restoId);

	        		addCart(restoId, prodId, user, quantity);
	        		listCarts(restoId, user);
	                break;
	            case 2:
	            	listProducts(restoId);
	        		prodId = chooseProduct(restoId);
	        		quantity = getQuantity(prodId, restoId);

	        		addCart(restoId, prodId, user, quantity);
	                break;
	            case 4:
	            	listCarts(restoId, user);
	                break;
	            case 5:
	                System.out.println("Exiting the application. Goodbye!");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	        
	        System.out.println(); // Add a blank line for spacing
	    } while (choice != 4);
		System.out.println("Once order is ready.. We shall let you know...");
		System.out.println("Thank you...");
	}

	public static void listRestaurants() {
		List<Restaurant> listOfRestaurants = restaurantDAO.getAllRestaurants();
		System.out.println("Resto ID\tResto Name\t\tAddress");
		System.out.println("---------------------------------------------------------------");
		for (Restaurant r : listOfRestaurants) {
			String formattedOutput = String.format("%-8s\t%-16s\t%s", r.getRestoId(), r.getRestoName(), r.getAddress());
			System.out.println(formattedOutput);
		}
	}
	public static int maxRestoId() {
		int max = 0;
		List<Restaurant> listOfRestaurants = restaurantDAO.getAllRestaurants();
		for (Restaurant r : listOfRestaurants) {
			if(max<r.getRestoId()) {
				max = r.getRestoId();
			}
			
		}
		return max;
	}
	public static int chooseRestaurant() {
		System.out.print("\nChoose a restaurant: ");
		int restoId = sc.nextInt();
		if(restoId>0 || restoId<=maxRestoId()) {
			return restoId;
		}
		else {
			System.out.println("Invalid restaurant Id.. Kindly enter again..");
			return chooseRestaurant();
		}
	}

	public static void listProducts(int restoId) {
		List<Product> listOfProducts = productDAO.getAllProducts(restoId);
		int i = 1;
		System.out.println("Item ID\t\tItem\t\tDescription\t\t\t\tPrice(Rs.)");
		System.out.println("---------------------------------------------------------------------------------");
		for (Product p : listOfProducts) {
			String formattedOutput = String.format("%-7s\t\t%-6s\t%-24s\t%.2f", (i++), p.getItemName(),
					p.getDescription(), p.getPrice());
			System.out.println(formattedOutput);
		}
	}

	public static int chooseProduct(int restoId) {
		System.out.print("\nChoose an item: ");
		int itemId = sc.nextInt();
		if(itemId>0 || itemId<= maxItemId(restoId)) {
			return itemId;
		}
		else {
			System.out.println("Invalid item Id.. Kindly enter again..");
			return chooseProduct(restoId);
		}
	}
	public static int maxItemId(int restoId) {
		int max = 0;
		List<Product> listOfProducts = productDAO.getAllProducts(restoId);
		for (Product r : listOfProducts) {
			if(max<r.getItemId()) {
				max = r.getItemId();
			}
		}
		return max;
	}
	public static String getUserName() {
		System.out.print("Kindly enter your name to create a cart: ");
		String name = sc.next();
		if (isValidName(name)) {
			return name;
		} else {
			System.out.println("Invalid name. Please enter a valid name.");
			return getUserName();
		}
	}

	public static boolean isValidName(String name) {
		// Define the regular expression pattern for a valid name
		String pattern = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		return name.matches(pattern);
	}

	public static int getQuantity(int prodId, int restoId) {
		List<Product> listOfProducts = productDAO.getAllProducts(restoId);
		System.out.print("Please enter the quantity for item ID " + prodId + ": "
				+ listOfProducts.get(prodId - 1).getItemName() + ": ");
		int quant = sc.nextInt();
		if(quant>0 && quant<10) {
			return quant;
		}
		else {
			System.out.println("Sorry either quantity is negative or exceeds maximum quantity(10)..\n Kindly enter quantity again ..");
		
			return getQuantity(prodId,restoId);
		}
	}

	public static void addCart(int restoId, int prodId, String user, int quantity) {
		cartDAO.addCart(restoId, prodId, user, quantity);
	}

	public static void listCarts(int restoId, String user) {
		List<Cart> listOfCarts = cartDAO.getAllCarts(restoId, user);
//        System.out.println("Purchase order:");

		for (Cart c : listOfCarts) {
			System.out.println(c.getRestoId() + "\t" + c.getUserName() + "\t " + c.getTotalBill());
		}
	}
}