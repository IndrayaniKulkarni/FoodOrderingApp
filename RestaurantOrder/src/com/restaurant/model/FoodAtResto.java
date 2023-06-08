package com.restaurant.model;

public class FoodAtResto {
	 private int id;
	    private boolean isAvailable;
	    private int itemId;
	    private int restoId;
		public FoodAtResto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public FoodAtResto(int id, boolean isAvailable, int itemId, int restoId) {
			super();
			this.id = id;
			this.isAvailable = isAvailable;
			this.itemId = itemId;
			this.restoId = restoId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public int getRestoId() {
			return restoId;
		}
		public void setRestoId(int restoId) {
			this.restoId = restoId;
		}
		@Override
		public String toString() {
			return "FoodAtResto [id=" + id + ", isAvailable=" + isAvailable + ", itemId=" + itemId + ", restoId="
					+ restoId + "]";
		}
	    
}
