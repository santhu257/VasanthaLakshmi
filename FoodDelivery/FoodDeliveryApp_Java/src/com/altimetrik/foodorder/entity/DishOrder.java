package com.altimetrik.foodorder.entity;

public class DishOrder {

	private String restaurantName;
	private String dishName;
	private int quantity;
	private double price;
	
	public String getRestaurantName() {
		return restaurantName;
	}

	public String getDishName() {
		return dishName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return quantity * price;
	}

	public DishOrder(String restaurantName, String dishName, int quantity, double price) {
		super();
		this.restaurantName = restaurantName;
		this.dishName = dishName;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	
}
