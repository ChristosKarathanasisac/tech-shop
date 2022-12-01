package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	     request.setAttribute("h2", "Computers Page");
	     request.setAttribute("products", products);
	     
	    /* if(products!=null) 
	     {
	    	 for(ProductBean p:products) 
		     {
		    	 System.out.println(p.getName());
		     }
	     }*/
	     dispatcher.forward(request, response);
	}

}
