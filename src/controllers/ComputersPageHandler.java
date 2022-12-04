package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductBean;
import dbhandlers.DButilities;

/**
 * Servlet implementation class ComputersPageHandler
 */
@WebServlet("/ComputersPageHandler")
public class ComputersPageHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String  address = "/view/productsPage.jsp";
	     RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	     ArrayList<ProductBean> products = new ArrayList<ProductBean>();
	     DButilities dao = new DButilities();
	     
	     products = dao.getProductsFromDB("computer");
	     if(request.getSession()!=null) 
	     {
	    	 HttpSession session = request.getSession();
	    	 session.setAttribute("h2", "Computers Page");
	    	 session.setAttribute("products", products);
	     }else 
	     {
	    	 request.setAttribute("h2", "Computers Page");
		     request.setAttribute("products", products);
	     }
	    
	     dispatcher.forward(request, response);
	}

}
