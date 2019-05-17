<%@ page import="com.team1.bean.Account" %>
<%@ page import="com.team1.util.ApplicationHandler" %>
<%@ page import="com.team1.bean.Transactions" %><%--
  Created by IntelliJ IDEA.
  User: brayden
  Date: 2019-05-17
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/Braydens.css">
    <link href="css/core.css" type="text/css" rel="stylesheet">
</head>
<body>
<img src="https://i.imgur.com/8x5O9zo.jpg">
<main>
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8 rounded content">
            <table style="width:100%">
                <tr>
                    <th>Transaction Number</th>
                    <th>To account</th>
                    <th>From account</th>
                    <th>Amount</th>
                </tr>
                <%
                    String myId = String.valueOf(ApplicationHandler.userData.get("id"));
                    for (Transactions transaction : ApplicationHandler.userTransactions.values()) {
                        out.print("<tr style=\"text-align: center\">");
                        out.print("<td>" + transaction.getTransID() + "</td>");
                        out.print("<td>" + (String.valueOf(transaction.getToAccountID()).equals(myId) ? "me" : transaction.getToAccountID()) + "</td>");
                        out.print("<td>" + (String.valueOf(transaction.getFromAccountID()).equals(myId) ? "me" : transaction.getFromAccountID())+ "</td>");
                        out.print("<td> $" + transaction.getAmount() + "</td>");
                        out.print("</tr>");
                    }
                %>
            </table>
            <div style="display: inline-block; width: 100%;">
                <a class="badBtn" href="home.jsp">Go Back</a>
                <a class="goodBtn" href="createAccounts.jsp">Create Account</a>
            </div>
        </div>
        <div class="col-2"></div>
    </div>
</main>
</body>
</html>
