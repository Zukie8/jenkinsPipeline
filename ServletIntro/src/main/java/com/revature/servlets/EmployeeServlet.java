package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.models.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeServlet extends HttpServlet { // we want this to display us some employees; we need a new dependency for this...
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//first create a list of employees
		List<Employee> allEmployees = new ArrayList<>();
		allEmployees.add(new Employee(34,"Sally Jones", "sjones@gmail.com"));
		allEmployees.add(new Employee(56,"Kermit McNealy", "kmcneal@gmail.com"));
		allEmployees.add(new Employee(31,"Kylo Ren", "theforce@gmail.com"));
		allEmployees.add(new Employee(44,"Big Jiln", "bigJ@gmail.com"));
		
		//using jackson bind dependency we can now use ObjectMapper
		ObjectMapper om = new ObjectMapper();
		String employeeString = om.writeValueAsString(allEmployees);
		employeeString = "{\"employees\":" + employeeString+"}";
		
		//now we print write out our employee string
		PrintWriter pw = response.getWriter();
		pw.write(employeeString); // to show this nicely, use the extension JSON viewer
	}

}
