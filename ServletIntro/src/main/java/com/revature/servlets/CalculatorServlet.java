package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet { // ctrl + shift + o to import everything
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("do get request handler method invoked successfully");
		PrintWriter pw = response.getWriter();
//		pw.write("<p> The calculator page is </p> <a href=\"Calculator.html\">here</a>"); // creating a link to html file
		
		RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("do post request handler method invoked successfully");
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		String operation = request.getParameter("operation");
		System.out.println(n1 + " " + operation + " "+ n2);
		
		String result = "<p> The answer is: ";
		Double first = Double.parseDouble(n1);
		Double second = Double.parseDouble(n2);
		
		switch(operation) {
		case "add":
			result += ""+(first+second) + "</p>"; // this will add them together then convert to a string
			break;
		case "subtract":
			result += ""+(first-second) + "</p>";
			break;
		case "multiply":
			result += ""+(first*second) + "</p>";
			break;
		case "divide":
			result += ""+(first/second) + "</p>";
			break;
		default:
			result += "invalid operation.";
		} // end switch
		
		PrintWriter pw = response.getWriter();
		pw.write("something before request dispatcher");
		//if we used include this would be included in our response
		
		request.setAttribute("answer", result); // result should be a string that says invalid operation or The answer is...
		RequestDispatcher rd = request.getRequestDispatcher("answer"); // must add to web xml
		rd.forward(request, response); // rd.include(request, response); is the same
		
		pw.write("something after request dispatcher");
		//if we used include this would be included in our response
		
		
		
		//now we use our PrintWriter to write out our results
//		PrintWriter pw = response.getWriter(); // use our response object
//		pw.write(result);
//		pw.write("<p> <a href=\"Calculator.html\">Calculate again</a> </p>");
	}

}
