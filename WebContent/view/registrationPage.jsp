<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="viewServices.PrintServices" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <!-- <link rel="stylesheet" href="../css/style.css" />-->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <title>TechShop-register</title>
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
        <h2>Registretion Form</h2>
        <!-- ../RegistrationHandler -->
        <form action = "${pageContext.request.contextPath}/RegistrationHandler" method="post">
          <legend>Fill in your details</legend>
          <img
            src="${pageContext.request.contextPath}/photos/user.png"
            alt="user icon"
            width="200"
            height="200"
            id="userlogo"
          />
          <div class="inputfield-container">
            <label for="fname"><strong>First Name:</strong></label>
            <input
              class="inputfield"
              type="text"
              name="fname"
              required
            />
          </div>
          <div class="inputfield-container">
            <label for="lname"><strong>Enter Last Name:</strong></label>
            <input
              class="inputfield"
              type="text"
              name="lname"
              required
            />
          </div>
          <div class="inputfield-container">
            <label for="address"><strong>Address:</strong></label>
            <input
              class="inputfield"
              type="text"
              name="address"
              required
            />
          </div>
          <div class="inputfield-container">
            <label for="email"><strong>Email:</strong></label>
            <input
              class="inputfield"
              type="text"
              name="email"
              required
            />
          </div>
          <div class="inputfield-container">
            <label for="uname"><strong>Username:</strong></label>
            <input
              class="inputfield"
              type="text"
              name="uname"
              required
            />
          </div>
          <div class="inputfield-container">
            <label for="psw"><strong>Password:</strong></label>
            <input
              class="inputfield"
              type="password"
              name="psw"
              required
            />
          </div>
          <div class="inputfield-container">
            <label for="cpassword"><strong>Repeat Password:</strong></label>
            <input
              class="inputfield"
              type="password"
              name="cpsw"
              required
            />
          </div>
          <div class="frmbtn">
            <button type="submit"><strong>Register</strong></button>
          </div>
         <%
    	    if((request.getAttribute("result")!=null))
    		{
    	    	out.print(PrintServices.getResultp(request.getAttribute("result").toString()));
    		}
            
		  %>
        </form>
      </main>
      <footer class="item-e">
        <address>
          <p>Email: techShop@gmail.com</p>
          <p>Phone: 2310000000</p>
          <p>Adress: anAdreess</p>
        </address>
        <p>
          This web site developed by Christos Karathanasis,<br />
          for test reasons.
        </p>
      </footer>
  </body>
</html>
    