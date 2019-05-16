<%@ page import="com.team1.util.ApplicationHandler" %>
<%@ page import="com.team1.bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: brayden
  Date: 2019-05-16
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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

</body>
</html>
