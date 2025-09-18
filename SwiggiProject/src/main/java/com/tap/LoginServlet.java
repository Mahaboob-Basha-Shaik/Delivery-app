package com.tap;

import java.io.IOException;
import com.tap.dao.UserDAO;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserDAO userDAO = new UserDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usernameOrEmail = request.getParameter("usernameOrEmail");
		String password = request.getParameter("password");

		User user = userDAO.login(usernameOrEmail, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// ✅ Redirect to profile.jsp
			response.sendRedirect("first");
		} else {
			// ❌ FIXED: Forward back to login.jsp on failure
			request.setAttribute("error", "Invalid username/email or password.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
