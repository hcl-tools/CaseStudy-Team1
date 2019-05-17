<%--
  Created by IntelliJ IDEA.
  User: Emma
  Date: 2019-05-16
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/Account.css" type="text/css" rel="stylesheet">
    <link href="css/core.css" type="text/css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Create Account</title>
</head>
<body>
<img src="https://i.imgur.com/8x5O9zo.jpg" >
<form action="account">
    <h1>Create a New Account</h1>
    <p>What kind of account would you like to create?</p>
    <select name="type">
        <option value="Savings">Savings</option>
        <option value="Cheque">Cheque</option>
        <option value="Credit">Credit</option>
    </select>
    <p>What would you like to name your account?</p>
    <input type="text" name="accountName">
    <p>Would you like to create a single or joint account? </p>
    <select name="sharetype" id="shareType" onchange="checkUpdate()">
        <option value="single">Single</option>
        <option value="joint">Joint</option>
    </select>
    <br />
    <div id="otherPerson" class="hide">
        <p>Enter the client number of the person you would like to share the account with:</p>
        <input type="text" name="accountSharerId">
    </div>
    <break/>
    <input type="submit" class="button"/>

</form>
<script src="js/code.js"></script>
</body>
</html>
