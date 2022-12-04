<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="beans.ProductBean" %>
<%@ page import="services.PrintServices" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <!--<link rel="stylesheet" href="./css/style.css" />-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <!-- WebContent/css -->
    <title>TechShop-home</title>
  </head>
  <body id="page">
      <header class="item-a">
        <img
          src="${pageContext.request.contextPath}/photos/TechShopLogo.png"
          alt="Tech Shop Logo"
          width="300"
          height="300"
          id="logo"
        />
        <h1>Technology for you</h1>
      </header>
      <nav class="item-b">
        <ul>
          <li><a href="${pageContext.request.contextPath}/view/index.jsp">Home</a></li>
          <li><a href="#news">News</a></li>
          <li><a href="#about">About</a></li>
          <li>
            <div class="dropdown">
              <p class="dropP">Products</p>
              <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/ComputersPageHandler">Computers</a>
                <a href="#">Tablets</a>
                <a href="#">Smartphones</a>
              </div>
            </div>
          </li>
          <%
          	session = request.getSession();
    		if(session.getAttribute("customer") !=null)
    		{
    			out.print(PrintServices.getLogOutbtn(request.getContextPath()+"/LogOutHandler"));
    			out.print(PrintServices.getShoppingCartbtn(request.getContextPath()+"/ShoppingCartHandler"));
    		}
    		else
    		{
    			out.print(PrintServices.getRegisterbtn(request.getContextPath()+"/view/registrationPage.jsp"));	
    			out.print(PrintServices.getLogInbtn(request.getContextPath()+"/view/loginPage.jsp"));	
    		}
          %>
        </ul>
      </nav>
      <main class="item-c">
      <%
      	 session = request.getSession();
     	 String h2 =""; 
      	 if(session.getAttribute("h2")!=null)
      	 {
      		
      		h2 = session.getAttribute("h2").toString();
      	 }else
      	 {
      		if(request.getAttribute("h2")!=null)
            {
           	 h2= request.getAttribute("h2").toString();
            }
      	 }
         
         out.print("<h2>"+h2+"</h2>");
         
      %>
        <table>
        <tr>
        <%
        
        	int count=1;
        	List<ProductBean> products=null;
        	if((request.getAttribute("products")==null) && (request.getSession()==null))
        	{
        		out.print("<h4 style=\"float:center;\">No Data to display.</h4>");
        	}else
        	{
        		if(request.getSession()!=null)
        		{
        			session = request.getSession();
        			products = (List)session.getAttribute("products");
        		}else
        		{
        			products = (List)request.getAttribute("products");
        		}
        		if(request.getAttribute("addToCartResult") != null)
	  			{
	  				out.print(PrintServices.getAddToCartResulth5(request.getAttribute("addToCartResult").toString()));
	  				request.removeAttribute("addToCartResult");
	  			}
        		out.print(PrintServices.getProductsTable(products, request));
        	}
        %>
        </table>
      </main>
      <footer class="item-e">
        <address>
          <p>Email: techShop@gmail.com</p>
          <p>Phone: 2310000000</p>
          <p>Adress: anAdreess</p>
        </address>
        <p>
          This web site created by Christos Karathanasis<br />
          for test reasons.
        </p>
      </footer>
  </body>
</html>
