<%--
  Created by IntelliJ IDEA.
  User: brayden
  Date: 2019-05-16
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
</head>
<body style="text-align: center; color: white" background="https://i.imgur.com/6wNbgPO.jpg">
<img src="https://i.imgur.com/iYQj5cQ.png" >
<form action="/account">
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
    <select name="sharetype">
        <option value="single">Single</option>
        <option value="joint">Joint</option>
    </select>
    <p>Enter the client number of the person you would like to share the account with:</p>
    <input type="text" name="accountSharerId">
    <input type="submit"/>

</form>
</body>
</html>
