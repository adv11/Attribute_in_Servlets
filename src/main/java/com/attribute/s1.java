package com.attribute;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class s1 extends HttpServlet{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
		response.setContentType("text/html");
		try (PrintWriter outPrintWriter = response.getWriter()){
			outPrintWriter.println("<!DOCTYPE html");
			outPrintWriter.println("<html>");
			outPrintWriter.println("<head>");
			outPrintWriter.println("<title>Servlet S1</title>");
			outPrintWriter.println("</head>");
			outPrintWriter.println("<body>");
			
			// getting request parameters
			int number1 = Integer.parseInt(request.getParameter("n1"));
			int number2 = Integer.parseInt(request.getParameter("n2"));
			
			// sum variable
			int sum = Math.addExact(number1, number2);
			
			// adding this sum variable to attribute of the servlet
			request.setAttribute("sum", sum);	// (attribute name, attribute value)
			
			// forwarding this sum attribute to servlet s2
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("s2");
			requestDispatcher.forward(request, response);
			
			outPrintWriter.println("</body>");
			outPrintWriter.println("</html>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
}