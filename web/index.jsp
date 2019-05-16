<%--
  Created by IntelliJ IDEA.
  User: brayden
  Date: 2019-05-16
  Time: 08:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hell's Bank Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>

  <div class="topSpacer">
    <h1>WELCOME TO HELL'S BANK</h1>
  </div>
  <div class="formContainer">

    <%

      int errorCode = 0;

      if(request.getAttribute("errorCode") != null) {
        errorCode = (Integer) request.getAttribute("errorCode");
      }
    %>

    <form action="./login">
      <input type="hidden" name="page" value="lp">
      Username: <br>
      <input type="text" name="username" value="">
      <br>
      Password: <br>
      <input type="password" name="password" value="">
      <br><br>
      <input type="submit" name="createAccount" value="Create Account">
      <input type="submit" value="Log In">

    </form>


    <%
      if(errorCode == 1){
    %>
    <h2>Incorrect Username or Password, Please Try Again.</h2>
    <%
      }
    %>
  </div>

  </body>
</html>
