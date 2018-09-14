package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginResultServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		PrintWriter pw = response.getWriter(); // use our response object
		String answer = (String) request.getAttribute("loginResult");
		System.out.println("the answer" + answer);
		pw.write(answer);
		
		if (answer == "<p>That username + password combination is: correct!!</p>") {
			
			pw.write("<p><a href=\"LoginSuccess.html\"></a></p>");
		}
		
		else {
			pw.write("<p><a href=\"Login.html\">Try again</a></p>");
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
