package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import beans.CustomerBean;
import dbhandlers.DButilities;
import viewServices.PrintServices;

@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  address = "/view/loginPage.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		String result="";
		CustomerBean customer = new CustomerBean();
		DButilities dao = new DButilities();
		
		customer = dao.getCustomerFromDB(request.getParameter("uname").toString().trim(), DigestUtils.sha256Hex(request.getParameter("psw").toString().trim()));
		
		if(customer == null) 
		{
			result = "Incorrect username or password.";
			request.setAttribute("result", result);
	        dispatcher.forward(request, response);
		}else 
		{
			createSession(request,customer);
			result = "Successful Login.";
			request.setAttribute("result", result);
	        dispatcher.forward(request, response);
		}
	}
	
	
	private void createSession(HttpServletRequest request,CustomerBean customer) 
	{
		HttpSession session = request.getSession();
		session.setAttribute("customer",customer);
	}

	
}
