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
    <img src="https://i.imgur.com/8x5O9zo.jpg">
  <div class="topSpacer">
    <h1>WELCOME TO HELL'S BANK</h1>
  </div>
  <div class="formContainer">

    <%

      int errorCode = 0;
      int createAccount = 0;
      int accountCreated = 0;

      if(request.getAttribute("errorCode") != null) {
        errorCode = (Integer) request.getAttribute("errorCode");
      }

      if(request.getAttribute("createAccount") != null) {
      createAccount = (Integer) request.getAttribute("createAccount");
    }

      if(request.getAttribute("accountCreated") != null) {
        accountCreated = (Integer) request.getAttribute("accountCreated");
      }

    %>

    <%
      if(createAccount == 0){
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
      <input type="submit" name="login" value="Log In">
    </form>
    <%
      }
    %>

    <%
      if(createAccount == 1){
    %>
    <form action="./login">
      <input type="hidden" name="page" value="lp">
      Client Name: <br>
      <input type="text" name="newName" value="">
      <br>
      Username: <br>
      <input type="text" name="newUsername" value="">
      <br>
      Password: <br>
      <input type="password" name="newPassword" value="">
      <br><br>
      <input type="submit" name="finaliseAccount" value="Confirm Information">
    </form>
    <%
      }
    %>

    <%
      if(errorCode == 1){
    %>
    <h2>Incorrect Username or Password, Please Try Again.</h2>
    <%
      }
    %>

    <%
      if(accountCreated == 1){
    %>
    <h2>Account Created</h2>
    <%
      }
    %>

  </div>

  </body>
</html>
