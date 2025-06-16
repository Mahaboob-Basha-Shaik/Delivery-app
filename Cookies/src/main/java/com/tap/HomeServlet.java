package com.tap;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callingServlet1")

public class HomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String Password = req.getParameter("Password");

		Cookie C2 = new Cookie("Username", name);
		Cookie C1 = new Cookie("password", Password);

		resp.addCookie(C1);
		resp.addCookie(C2);

		System.out.println("Cookies Added Sucessfully");

	}

}
