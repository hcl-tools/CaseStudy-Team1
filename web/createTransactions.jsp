<%--
  Created by IntelliJ IDEA.
  User: brayden
  Date: 2019-05-16
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Transaction</title>
    <link rel="stylesheet" type="text/css" href="css/Transactions.css">
</head>
<body style="text-align: center" background="images/BEANS.jpg">
<div class="box" id="box">
    <form action="createTransaction">
        <h1>New Transaction</h1>

        <p>Enter Account ID to withdraw from</p>
        <input type="number" name="fromAccountID">

        <p>Enter Account ID to transfer to</p>
        <input type="number" name="toAccountID" min="1">

        <p>Enter amount to transfer</p>
        <input type="number" name="amount">

        <br><br>
        <input type="submit" name="submit">
    </form>
</div>
</body>
</html>
