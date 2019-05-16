<%@ page import="com.team1.bean.Transactions" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.team1.util.ApplicationHandler" %><%--
  Created by IntelliJ IDEA.
  User: brayden
  Date: 2019-05-16
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/findTransactions" method="post">
    <h3>What was the amount of the transaction?</h3>
    <input type="number" name="amount" min="1" />
    <input type="submit" />
</form>
<%
    Double amount = Double.valueOf(request.getParameter("amount"));
    List<Transactions> found = new ArrayList<>();
    for (Transactions transaction : ApplicationHandler.userTransactions.values()) {
        if (transaction.getAmount().equals(amount)) {
            found.add(transaction);
        }
    }
    for (Transactions f : found) {
        out.print(f);
    }
%>
</body>
</html>