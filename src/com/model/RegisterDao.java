package com.model;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.data.Customer;

public class RegisterDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/aeroparkerdb";
	private String dbUname = "root";
	private String dbPassword = "12345";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	public String insert(Customer customer, String email) throws SQLException {

		String result = null;

		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			Statement stmt = con.createStatement();

			ResultSet RS = stmt.executeQuery("SELECT COUNT(*) AS total FROM customer where email ='" + email + "'");
			while (RS.next()) {
				if (RS.getInt("total") > 0) {
					result = "Email address already existed";
				} else {
					result = "Registration completed successfully";
					String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";

					PreparedStatement ps;

					ps = con.prepareStatement(sql);
					ps.setString(1, customer.getEmail());
					ps.setString(2, customer.getTitle());
					ps.setString(3, customer.getFirstName());
					ps.setString(4, customer.getLastName());
					ps.setString(5, customer.getAddressLine1());
					ps.setString(6, customer.getAddressLine2());
					ps.setString(7, customer.getCity());
					ps.setString(8, customer.getPostcode());
					ps.setString(9, customer.getTelephoneNumber());
					ps.executeUpdate();
					con.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}

}
