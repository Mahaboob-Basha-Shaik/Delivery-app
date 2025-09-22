package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String url = "jdbc:mysql://mysql-2156c65f-maheboob2002basha-394c.f.aivencloud.com:19731/foodapp?ssl-mode=REQUIRED";
	private static final String un = "avnadmin";
	private static final String pwd = "AVNS_bbuHuB_1OXDH6ryfbAM";
	private static Connection Connection = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection = DriverManager.getConnection(url, un, pwd);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Connection;
	}
}

