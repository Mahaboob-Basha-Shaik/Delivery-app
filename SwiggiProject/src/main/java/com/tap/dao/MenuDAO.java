package com.tap.dao;

import java.util.List;
import com.tap.model.Menu;

public interface MenuDAO {

	void addMenu(Menu menu);

	Menu getMenu(int menuId);

	void updateMenu(Menu menu);

	void deleteMenu(int menuId);

	Menu getMenuById(int menuId);

	List<Menu> getAllMenuItems();

	List<Menu> getAllMenuByRestaurant(int restaurantId);

	List<Menu> searchMenuItemsByName(String query);
}
