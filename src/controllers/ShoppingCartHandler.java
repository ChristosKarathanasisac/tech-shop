package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerBean;
import beans.ProductBean;
import dbhandlers.DButilities;
import services.ShoppingCartServices;
import viewServices.PrintServices;

@WebServlet("/ShoppingCartHandler")
public class ShoppingCartHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String  address = "/view/productsPage.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        String addToCartResult = "";
        ShoppingCartServices services = new ShoppingCartServices();
		if(session.getAttribute("customer") ==null) 
		{
			addToCartResult = "You should Login in order to buy a product!";
			request.setAttribute("addToCartResult", addToCartResult);
			dispatcher.forward(request, response);
			return;
		}
		if((request.getParameter("action").equals("buyfromCart")) && (request.getParameter("id")!=null)) 
		{
			services.addToCart(request);
			address = "/view/shoppingCart.jsp";
			dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			
		}
		
		if((request.getParameter("action").equals("buy")) && (request.getParameter("id")!=null))
		{
			address = "/view/productsPage.jsp";
	        dispatcher = request.getRequestDispatcher(address);
	        services.addToCart(request);
			dispatcher.forward(request, response);
		}
		if((request.getParameter("action").equals("removeOneProduct")) && (request.getParameter("id")!=null)) 
		{
			services.removeFromCart(request);
			address = "/view/shoppingCart.jsp";
			dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
		if((request.getParameter("action").equals("removeAllQ")) && (request.getParameter("id")!=null)) 
		{
			services.removeAllQFromCart(request);
			address = "/view/shoppingCart.jsp";
			dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
		
		if((request.getParameter("action").equals("goToCart")))
		{
			services.goToCart(request);
			address = "/view/shoppingCart.jsp";
			dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}
	
}
