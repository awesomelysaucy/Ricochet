package com.terriblehackx.ricochet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		boolean error = false;
		String errorStream = new String();
		StringBuilder stringBuilder = new StringBuilder();
		
		if(username.matches("^.*[^a-zA-Z0-9]. *$")) {
			errorStream = ("<p>alphanumeric usernames only fool</p>");
			error = true;
		}

		if(username.equals("")) {
			errorStream += "<p>username pls</p>";
			error = true;
		}
		
		if(password.equals("")) {
			errorStream += "<p>password pls</p>";
			error = true;
		}
		
		if(username.equals("william") && password.equals("jack") && !error) {
			response.sendRedirect("messaging.jsp");
		}
		
		else if(error) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println(errorStream);
			rd.include(request, response);
		}
		
		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<p>u rong m8</p>");
			rd.include(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

}
