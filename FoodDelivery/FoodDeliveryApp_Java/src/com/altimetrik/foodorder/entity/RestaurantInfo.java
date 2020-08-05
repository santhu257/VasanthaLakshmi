package com.altimetrik.foodorder.entity;

public class RestaurantInfo {
	
	private String restaturantName;
	private double ratings;
	private double price;
	private String imageUrl;
	
	
	public RestaurantInfo(String restaturantName, double ratings, double price,String imageUrl) {
		super();
		this.restaturantName = restaturantName;
		this.ratings = ratings;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public String getRestaturantName() {
		return restaturantName;
	}

	public void setRestaturantName(String restaturantName) {
		this.restaturantName = restaturantName;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
