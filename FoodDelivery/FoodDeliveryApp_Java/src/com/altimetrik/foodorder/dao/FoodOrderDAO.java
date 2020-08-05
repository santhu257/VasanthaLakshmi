package com.altimetrik.foodorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.altimetrik.foodorder.connection.ConnectionManager;
import com.altimetrik.foodorder.entity.DishOrder;
import com.altimetrik.foodorder.entity.RestaurantInfo;

public class FoodOrderDAO {

	public static List<RestaurantInfo> getAllDetails() {
		List<RestaurantInfo> restaurantList = new ArrayList<>();
		String sql = "select image,name,ratings,price from restaurant where active = 1";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				String imageUrl = rs.getString("image");
				String name = rs.getString("name");
				double ratings = rs.getDouble("ratings");
				double price = rs.getDouble("price");
				RestaurantInfo fd = new RestaurantInfo(name, ratings, price, imageUrl);
				restaurantList.add(fd);
			}

		} catch (SQLException e) {
			System.out.println("SQLException occured while getting connection " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occured while getting connection " + e.getMessage());
		}
		return restaurantList;
	}
	
	public static List<Double> createOrder(List<DishOrder> dor) {
		List<Double> priceList = new ArrayList<Double>();
		for(DishOrder d : dor) {
			String sql = "insert into dishorder values('"+d.getRestaurantName()+",''"+d.getDishName()+",''"+d.getQuantity()+",''"+d.getPrice()+"')";
			try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
				int noOfRows = ps.executeUpdate();
				if(noOfRows > 1) {
					priceList.add(d.getPrice());
				}
				
			} catch (SQLException e) {
				System.out.println("SQLException occured while getting connection createOrder" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception occured while getting connection createOrder" + e.getMessage());
			}
		}
		return priceList;
	}
	
	public static List<Double> updateOrder(List<DishOrder> dor,String restaurantName) {
		List<Double> priceList = new ArrayList<Double>();
		for(DishOrder d : dor) {
			String sql = "update dishorder set dishname=''"+d.getDishName()+",quantity=''"
		+d.getQuantity()+",dishprice=''"+d.getPrice()+"'where name = '"+restaurantName+"')";
			try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
				int noOfRows = ps.executeUpdate();
				if(noOfRows > 1) {
					priceList.add(d.getPrice());
				}
				
			} catch (SQLException e) {
				System.out.println("SQLException occured while getting connection updateOrder" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception occured while getting connection updateOrder" + e.getMessage());
			}
		}
		return priceList;
	}
	
	
	public static List<Double> deleteOrder(List<DishOrder> dor,String restaurantName) {
		List<Double> priceList = new ArrayList<Double>();
		for(DishOrder d : dor) {
			String sql = "update dishorder set active = 2 where name = '"+restaurantName+"')";
			try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
				int noOfRows = ps.executeUpdate();
				if(noOfRows > 1) {
					priceList.add(d.getPrice());
				}
				
			} catch (SQLException e) {
				System.out.println("SQLException occured while getting connection in deleteOrder" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception occured while getting connection in deleteOrder" + e.getMessage());
			}
		}
		return priceList;
	}
	
	public static List<String> displayDestination(String origin) {
		List<String> availableDest = new ArrayList<String>();
		String sql = "select destination from address where origin="+origin;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while(rs.next()) {
				availableDest.add(rs.getString("destination"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException occured while getting connection in displayDestination" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occured while getting connection in displayDestination" + e.getMessage());
		}
		return availableDest;	
		
	}
	
	public static List<RestaurantInfo> searchByRestaurantName(String restaurantName) {
		List<RestaurantInfo> restaurantInfos = new ArrayList<RestaurantInfo>();
		String sql = "select image,name,ratings,price from restaurant where active = 1 and name = "+restaurantName;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while(rs.next()) {
				String imageUrl = rs.getString("image");
				String name = rs.getString("name");
				double ratings = rs.getDouble("ratings");
				double price = rs.getDouble("price");
				RestaurantInfo fd = new RestaurantInfo(name, ratings, price, imageUrl);
				restaurantInfos.add(fd);
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException occured while getting connection in deleteOrder" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occured while getting connection in deleteOrder" + e.getMessage());
		}
		return restaurantInfos;
	}
	
	public static List<RestaurantInfo> searchByPrice(double p) {
		List<RestaurantInfo> restaurantInfos = new ArrayList<RestaurantInfo>();
		String sql = "select image,name,ratings,price from restaurant where active = 1 and price = "+p;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while(rs.next()) {
				String imageUrl = rs.getString("image");
				String name = rs.getString("name");
				double ratings = rs.getDouble("ratings");
				double price = rs.getDouble("price");
				RestaurantInfo fd = new RestaurantInfo(name, ratings, price, imageUrl);
				restaurantInfos.add(fd);
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException occured while getting connection in searchByRatings" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occured while getting connection in searchByRatings" + e.getMessage());
		}
		return restaurantInfos;
	}
	
	public static List<RestaurantInfo> searchByRatings(double rating) {
		List<RestaurantInfo> restaurantInfos = new ArrayList<RestaurantInfo>();
		String sql = "select image,name,ratings,price from restaurant where active = 1 and ratings = "+rating;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while(rs.next()) {
				String imageUrl = rs.getString("image");
				String name = rs.getString("name");
				double ratings = rs.getDouble("ratings");
				double price = rs.getDouble("price");
				RestaurantInfo fd = new RestaurantInfo(name, ratings, price, imageUrl);
				restaurantInfos.add(fd);
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException occured while getting connection in searchByRatings" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occured while getting connection in searchByRatings" + e.getMessage());
		}
		return restaurantInfos;
	}
	
	public static List<DishOrder> bookingData() {
		List<DishOrder> dishOrder = new ArrayList<DishOrder>();
		String sql = "select restaurantname,dishname,quantity,price from order";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while(rs.next()) {
				String rName = rs.getString("restaurantname");
				String dName = rs.getString("dishname");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				DishOrder dor = new DishOrder(rName, dName, quantity, price);
				dishOrder.add(dor);
				
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException occured while getting connection in searchByRatings" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occured while getting connection in searchByRatings" + e.getMessage());
		}
		return dishOrder;
	}
	
	

}
