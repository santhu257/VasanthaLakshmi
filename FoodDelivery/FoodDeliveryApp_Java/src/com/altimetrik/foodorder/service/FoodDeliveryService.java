package com.altimetrik.foodorder.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.altimetrik.foodorder.dao.FoodOrderDAO;
import com.altimetrik.foodorder.entity.DishOrder;
import com.altimetrik.foodorder.entity.RestaurantInfo;


@Path("/order")
public class FoodDeliveryService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDetails() {
		Gson gson = new Gson();
		List<RestaurantInfo> info = FoodOrderDAO.getAllDetails();
		return gson.toJson(info);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createOrder(JsonObject json) {
		Gson gson = new Gson();
		List<DishOrder> dor = gson.fromJson(json,DishOrder.class);
		List<RestaurantInfo> info = FoodOrderDAO.createOrder(dor);
		return gson.toJson(info);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateOrder(JsonObject json,String name) {
		Gson gson = new Gson();
		List<DishOrder> dor = gson.fromJson(json,DishOrder.class);
		List<Double> info = FoodOrderDAO.updateOrder(dor,name);
		return gson.toJson(info);
	}
	
	@POST
	@Produces(MediaType.PLAIN_TEXT_STRING)
	@Consumes(MediaType.APPLICATION_JSON)
	public String displayDest(String name) {
		Gson gson = new Gson();
		List<String> info = FoodOrderDAO.displayDestination(name);
		return gson.toJson(info);
	}
	
	@POST
	@Produces(MediaType.PLAIN_TEXT_STRING)
	@Consumes(MediaType.APPLICATION_JSON)
	public String searchByName(String name) {
		Gson gson = new Gson();
		List<RestaurantInfo> info = FoodOrderDAO.searchByRestaurantName(name);
		return gson.toJson(info);
	}
	
	@POST
	@Produces(MediaType.PLAIN_TEXT_STRING)
	@Consumes(MediaType.APPLICATION_JSON)
	public String searchByPrice(String p) {
		Gson gson = new Gson();
		List<RestaurantInfo> info = FoodOrderDAO.searchByPrice(Double.valueOf(p));
		return gson.toJson(info);
	}
	
	@POST
	@Produces(MediaType.PLAIN_TEXT_STRING)
	@Consumes(MediaType.APPLICATION_JSON)
	public String searchByRatings(String r) {
		Gson gson = new Gson();
		List<RestaurantInfo> info = FoodOrderDAO.searchByPrice(Double.valueOf(r));
		return gson.toJson(info);
	}
	
	@GET
	@Produces(MediaType.PLAIN_TEXT_STRING)
	public String searchByPrice() {
		Gson gson = new Gson();
		List<DishOrder> info = FoodOrderDAO.bookingData();
		return gson.toJson(info);
	}
	
	
}
