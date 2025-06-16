package com.tap.dao;

import com.tap.model.Restaurant;
import java.util.List;

public interface RestaurantDAO {

	void addRestaurant(Restaurant restaurant);

	void updateRestaurant(Restaurant restaurant);

	void deleteRestaurant(int restaurantId);

	List<Restaurant> getAllRestaurants();

	Restaurant getRestaurantById(int restaurantId);

}
