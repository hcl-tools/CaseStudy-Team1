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
                    <th>Account Number</th>
                    <th>Account Name</th>
                    <th>Amount Available</th>
                    <th>Actions</th>
                </tr>
                <%
                    for (Account account : ApplicationHandler.userAccounts.values()) {
                        out.print("<tr style=\"text-align: center\">");
                        out.print("<td>" + account.getAccountID() + "</td>");
                        out.print("<td>" + account.getAccountName() + "</td>");
                        out.print("<td> $" + account.calcBalance() + "</td>");
                        out.print(
                                "<td><div style=\"display: inline-block; width: 100%;\"><a class='goodBtn'>Transfer</a><a class='badBtn'>History</a></div></td>"

                        );
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
