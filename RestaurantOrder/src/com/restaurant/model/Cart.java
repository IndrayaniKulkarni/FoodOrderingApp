package com.restaurant.model;

public class Cart {
	private String cartId;
	private String userName;
	private float totalBill;
	private int restoId;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String cartId, String userName, float totalBill, int restoId) {
		super();
		this.cartId = cartId;
		this.userName = userName;
		this.totalBill = totalBill;
		this.restoId = restoId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

	public int getRestoId() {
		return restoId;
	}

	public void setRestoId(int restoId) {
		this.restoId = restoId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userName=" + userName + ", totalBill=" + totalBill + ", restoId=" + restoId
				+ "]";
	}

}
