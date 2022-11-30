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
  <body>
    <section id="page">
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
                <a href="#">Computers</a>
                <a href="#">Tablets</a>
                <a href="#">Smartphones</a>
              </div>
            </div>
          </li>
          <li id="register">
            <button type="button" id="openregister">
              <a href="${pageContext.request.contextPath}/view/registrationPage.jsp">Register</a>
            </button>
          </li>
          <li id="logIn">
            <button type="button" id="openLogIn">
              <a href="${pageContext.request.contextPath}/view/loginPage.jsp">Login</a>
            </button>
          </li>
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
    </section>
  </body>
</html>
