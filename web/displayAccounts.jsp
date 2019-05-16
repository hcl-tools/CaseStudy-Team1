<%@ page import="com.team1.bean.Transactions" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.team1.util.ApplicationHandler" %>
<%@ page import="com.team1.bean.Account" %><%--
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
    <link rel="stylesheet" href="css/Braydens.css">
</head>
<body>
<main>
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8 rounded content">
            <table style="width:100%">
                <tr>
                    <th>Account Number</th>
                    <th>Account Name</th>
                    <th>Amount Available</th>
                </tr>
                <%
                    for (Account account : ApplicationHandler.userAccounts.values()) {
                        out.print("<tr style=\"text-align: center\">");
                        out.print("<td>" + account.getAccountID() + "</td>");
                        out.print("<td>" + account.getAccountName() + "</td>");
                        out.print("<td> $" + account.calcBalance() + "</td>");
                        out.print("</tr>");
                    }
                %>
            </table>
        </div>
        <div class="col-2"></div>
    </div>
</main>
</body>
</html>