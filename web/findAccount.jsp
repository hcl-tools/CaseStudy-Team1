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
                <%
                    boolean searchForm = true;

                    if (request.getAttribute("searchForm") != null) {
                        searchForm = (Boolean) request.getAttribute("searchForm");
                    }

                    if (searchForm) {
                %>
                <form action="findAccount" method="post">
                    <h1>What was the name of the account?</h1>
                    <input type="text" name="name" min="1" placeholder="Account to look for" style="border-radius: 10px; padding: 10px; width: 80%; border: black 1px solid;"/>
                    <br />
                    <input type="submit" style="margin-top: 10px; width: 80%; background-color: rgba(0,212,255,1); font-size: 0.9em; font-weight: bold; padding: 20px; border-radius: 10px; border: none;" />
                </form>
                <%
                    }

                    if (!searchForm) {
                %>
                <table style="width:100%">
                    <tr>
                        <th>Account Number</th>
                        <th>Account Name</th>
                        <th>Amount Available</th>
                    </tr>
                    <%
                        List<Account> found = new ArrayList<>();
                        for (Account account : ApplicationHandler.userAccounts.values()) {
                            if (account.getAccountName().equalsIgnoreCase((String) request.getAttribute("name"))) {
                                found.add(account);
                            }
                        }

                        for (Account account : found) {
                            out.print("<tr style=\"text-align: center\">");
                            out.print("<td>" + account.getAccountID() + "</td>");
                            out.print("<td>" + account.getAccountName() + "</td>");
                            out.print("<td> $" + account.calcBalance() + "</td>");
                            out.print("</tr>");
                        }
                    %>
                </table>
                <%
                    }
                %>
            </div>
            <div class="col-2"></div>
        </div>
    </main>
</body>
</html>
