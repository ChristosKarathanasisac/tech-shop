package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerBean;
import dbhandlers.DButilities;
import viewServices.PrintServices;

@WebServlet("/RegistrationHandler")
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  address = "/view/registrationPage.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        String result = "";
        
        if(!request.getParameter("psw").toString().trim().equals(request.getParameter("cpsw").toString().trim())) 
        {
        	result = "Passwords are not equal.";
        	request.setAttribute("result", result);
        	dispatcher.forward(request, response);
        	return;
        }
        CustomerBean customer = CustomerBean.createCustomer(request);
        DButilities dao = new DButilities();
        if(dao.checkIfUsnameUsed(customer.getUsername())) 
		{
        	result = "The username already used.";
			request.setAttribute("result", result);
	        dispatcher.forward(request, response);
		}
        
        if(dao.insertCustomerToDB(CustomerBean.createCustomer(request))) 
        {
        	result = "Successful registration.";
        	request.setAttribute("userInserted", true);
        	createSession(request,customer); 
        }else 
        {
        	result = "Problem with registration. Try Again.";
        	request.setAttribute("userInserted", false);
        }
        request.setAttribute("result", result);
        dispatcher.forward(request, response);
       
	}
	private void createSession(HttpServletRequest request,CustomerBean customer) 
	{
		HttpSession session = request.getSession();
		session.setAttribute("customer",customer);
	}

}
