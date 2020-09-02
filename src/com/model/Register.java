package com.model;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.Customer;


@WebServlet("/Register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String result= null;
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String telephonenumber = request.getParameter("telephonenumber");
		
		Customer customer = new Customer(email, title, firstname, lastname,
				addressLine1, addressLine2, city, postcode, telephonenumber);
		
		RegisterDao rDao = new RegisterDao();
		
		try {
			result = rDao.insert(customer, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().print(result);
		
	}

}
