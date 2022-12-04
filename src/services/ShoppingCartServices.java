package services;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.CustomerBean;
import beans.ProductBean;
import dbhandlers.DButilities;

public class ShoppingCartServices {
	public void addToCart(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean)session.getAttribute("customer");
		customer.addProductToShoppingCart(request.getParameter("id"));
		session.setAttribute("customer", customer);
		customer = (CustomerBean)session.getAttribute("customer");
		String addToCartResult = "The product added to cart successfully!";
		request.setAttribute("addToCartResult", addToCartResult);
	}
	public void goToCart(HttpServletRequest request) 
	{
		DButilities dao = new DButilities();
		HttpSession  session = request.getSession();
    	CustomerBean customer = (CustomerBean)session.getAttribute("customer");
    	Set<String> productIDs = customer.getShoppingCart().keySet();
    	List<ProductBean> products = dao.getProductsFromDB(productIDs);
    	session.setAttribute("h2", "Shopping Cart");
    	session.setAttribute("CartProducts", products);
	}

	public void removeFromCart(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean)session.getAttribute("customer");
		customer.removeQuantityFromProduct(request.getParameter("id"));
		session.setAttribute("customer", customer);
		customer = (CustomerBean)session.getAttribute("customer");
		String addToCartResult = "The product removed from cart successfully!";
		request.setAttribute("addToCartResult", addToCartResult);
	}
	public void removeAllQFromCart(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean)session.getAttribute("customer");
		customer.removeProductFromShoppingCart(request.getParameter("id"));
		session.setAttribute("customer", customer);
		customer = (CustomerBean)session.getAttribute("customer");
		String addToCartResult = "The product removed from cart successfully!";
		request.setAttribute("addToCartResult", addToCartResult);
	}

}
