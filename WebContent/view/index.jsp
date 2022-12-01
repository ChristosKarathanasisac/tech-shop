<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
          <li><a href="">Home</a></li>
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
          		if(session.getAttribute("first_name") !=null)
          		{
          			String pathLogout = request.getContextPath()+"/LogOutHandler";
          			out.print("<li style=\"float:right;padding-right: 1rem;\">"+"\r\n"+
      		            	"<button type=\"button\" style=\"font-size: 1.8rem;background-color: rgb(7, 7, 7);color: white;\">"+
      		            		"<a href=\""+pathLogout+"\">"+"Logout</a>"+"\r\n"+
              				"</button>"+"\r\n"+
            			"</li>");
          		
          		}
          		else
          		{
          			
          			String pathRegister = request.getContextPath()+"/view/registrationPage.jsp";
          			out.print("<li id=\"register\">"+"\r\n"+
      		            	"<button type=\"button\" id=\"openregister\">"+
      		            		"<a href=\""+pathRegister+"\">"+"Register</a>"+"\r\n"+
              				"</button>"+"\r\n"+
            			"</li>");
          			String pathLogin = request.getContextPath()+"/view/loginPage.jsp";
          			out.print("<li id=\"logIn\">"+"\r\n"+
          		            	"<button type=\"button\" id=\"openLogIn\">"+
          		            		"<a href=\""+pathLogin+"\">"+"Login</a>"+"\r\n"+
                  				"</button>"+"\r\n"+
                			"</li>");	}
          %>
        </ul>
      </nav>
      <main class="item-c">
        <h2>Why to choose us;</h2>
        <table>
          <tr>
            <td>
              <p>Free support!</p>
              <img
                src="${pageContext.request.contextPath}/photos/pic-support.png"
                alt="Support"
                width="200"
                height="150"
              />
            </td>
            <td>
              <p>Free delivery!</p>
              <img
                src="${pageContext.request.contextPath}/photos/pic-delivery.png"
                alt="Delivery"
                width="200"
                height="150"
              />
            </td>
            <td>
              <p>All payment methods!</p>
              <img
                src="${pageContext.request.contextPath}/photos/pic-payment-methods.png"
                alt="Payment Methods"
                width="200"
                height="150"
              />
            </td>
          </tr>
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
