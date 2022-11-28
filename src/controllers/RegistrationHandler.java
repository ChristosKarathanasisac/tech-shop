package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.RegistartionBean;
import dbhandlers.DButilities;

@WebServlet("/RegistrationHandler")
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DButilities dao = new DButilities();
        
        RegistartionBean customer = RegistartionBean.createCustomer(request);
        if(dao.checkIfUsnameUsed(customer.getUsername())) 
		{
			//System.out.println("The user name is used");
			request.setAttribute("usernameIsUsed", true);
			String address;
			address = "view/registrationPage.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	        dispatcher.forward(request, response);
		}
        
        if(dao.insertCustomerToDB(RegistartionBean.createCustomer(request))) 
        {
        	System.out.println("Customer inserted successfully");
        }else 
        {
        	System.out.println("We had problem with registration");
        }
       
	}

}
