package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;

/**
 * 
 * @author nozuk
 * This is an in-class exercise about servlets 09/04/2018
 * Create a new application which includes servlets and is packaged as a war
 * Create a servlet which performing a get request to will take you to a simple login page with an input field for username and password
 * Define doPost method which processes the post request sent when the login form is submitted
 * Check username and password (these can be hardcoded values) and have a user be brought to a page indicating that the username and/or password was incorrect if they are not correct, otherwise they should be brought to a successful login page

 */

public class UsersServlet extends HttpServlet {
	
	List<Users> allUsers = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		System.out.println("do get request handler method invoked successfully");

		//first create a list of users with usernames + passwords
		
		allUsers.add(new Users("Hallewood", "123456"));
		allUsers.add(new Users("Freida", "bigbigbig"));
		allUsers.add(new Users("missTake", "thisismypassword"));
		allUsers.add(new Users("crease", "hArRuY99"));

		//using jackson bind dependency we can now use ObjectMapper
		ObjectMapper om = new ObjectMapper();
		String userString = om.writeValueAsString(allUsers);
		userString = "{\"users\":" + userString+"}";

		//now we print write out our user string
		PrintWriter pw = response.getWriter();
		pw.write(userString); // to show this nicely, use the extension JSON viewer

		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("do post request handler method invoked successfully");
		String un = request.getParameter("username"); // get the input
		String pw = request.getParameter("password"); // get the input
		System.out.println("username:  " + un + "; password:  "+ pw);
		
		PrintWriter prwr = response.getWriter(); // use our response object
		
		prwr.write("the username entered is: " + un);
		prwr.write("the password entered is: " + pw);
		
		String result = "<p>That username + password combination is: ";
		
		//trying to read in from stored JSON info
//		Users u = new Users();
//		String storedUsername = u.getUsername();
//		String storedPassword = u.getPassword();
		
//		//using jackson bind dependency we can now use ObjectMapper
//		ObjectMapper om = new ObjectMapper();
//		String userString = om.writeValueAsString(allUsers);
//		
//		prwr.write("the username stored is: " + Arrays.toString(userString.split(":")));
//		//prwr.write("the password stored is: " + userString);

		if (un == "hardCodedUsername" || pw == "hardCodedPassword") {
			result += "correct!!</p>";
		}
		
		else {
			result += "incorrect!!";
		}
		
		request.setAttribute("loginResult", result); // result should be a string that says invalid operation or The answer is...
		RequestDispatcher rd = request.getRequestDispatcher("loginResult"); // must add to web xml
		rd.forward(request, response);
		
//		prwr.write(result);
//		prwr.write("<p> <a href=\"Login.html\">Try again</a> </p>");
	}
}
