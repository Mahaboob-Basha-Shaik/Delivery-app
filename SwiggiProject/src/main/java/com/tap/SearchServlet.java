package com.tap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.MenuDAO;
import com.tap.dao.RestaurantDAO;
import com.tap.daoimpl.MenuDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAO menuDAO = new MenuDAOImpl();
	private RestaurantDAO restaurantDAO = new RestaurantDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String query = request.getParameter("query");
		if (query == null || query.trim().isEmpty()) {
			response.sendRedirect("first");
			return;
		}

		query = query.toLowerCase();

		List<Menu> matchingMenus = menuDAO.searchMenuItemsByName(query);
		if (matchingMenus == null)
			matchingMenus = new ArrayList<>();

		if (!matchingMenus.isEmpty()) {
			int restaurantId = matchingMenus.get(0).getRestaurantId();
			response.sendRedirect("menu?restaurantId=" + restaurantId);
			return;
		}

		List<Restaurant> matchingRestaurants = restaurantDAO.searchRestaurantsByName(query);
		if (matchingRestaurants == null)
			matchingRestaurants = new ArrayList<>();

		if (!matchingRestaurants.isEmpty()) {
			int restaurantId = matchingRestaurants.get(0).getRestaurantId();
			response.sendRedirect("menu?restaurantId=" + restaurantId);
			return;
		}

		// ❗ No match found: forward to not-found.jsp with a message
		request.setAttribute("searchError", "No matching menu items or restaurants found for: " + query);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
}
