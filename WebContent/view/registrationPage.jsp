<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="../css/style.css" />
    <title>TechShop-register</title>
  </head>
  <body>
    <article id="page">
      <header class="item-a">
        <img
          src="../photos/TechShopLogo.png"
          alt="Tech Shop Logo"
          width="300"
          height="300"
          id="logo"
        />
        <h1>Technology for you</h1>
      </header>
      <nav class="item-b">
        <ul>
          <li><a href="../">Home</a></li>
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
              <a href="">Register</a>
            </button>
          </li>
          <li id="logIn">
            <button type="button" id="openLogIn">
              <a href="loginPage.jsp">Login</a>
            </button>
          </li>
        </ul>
      </nav>
      <main class="item-c">
        <h2>Registretion Form</h2>
        <form action="post">
          <legend>Fill in your details</legend>
          <img
            src="../photos/user.png"
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
              name="uname"
              required
            />
          </div>
          <div class="inputfield-container">
            <label for="lname"><strong>Enter Last Name:</strong></label>
            <input
              class="inputfield"
              type="text"
              name="psw"
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
          <div class="frmbtn">
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
            <label for="cpassword"><strong>Confirm Password:</strong></label>
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
    </article>
  </body>
</html>
    