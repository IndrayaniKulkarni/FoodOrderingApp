package com.restaurant.model;

public class Product {
	private int itemId;
	private String itemName;
	private String description;
	private float price;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int itemId, String itemName, String description, float price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
	}


	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", itemName=" + itemName + ", description=" + description + ", price="
				+ price + "]";
	}

	
}
