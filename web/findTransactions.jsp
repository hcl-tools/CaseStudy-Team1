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
    <link rel="stylesheet" href="css/Braydens.css">
    <link href="css/core.css" type="text/css" rel="stylesheet">
</head>
<body>
    <img src="https://i.imgur.com/8x5O9zo.jpg" href="home.jsp">
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
                <form action="findTransactions" method="post">
                    <h1>What was the amount of the transaction?</h1>
                    <input type="number" name="amount" min="1" placeholder="Amount to look for" style="border-radius: 10px; padding: 10px; width: 80%; border: black 1px solid;"/>
                    <br />
                    <input type="submit" style="margin-top: 10px; width: 80%; background-color: rgba(0,212,255,1); font-size: 0.9em; font-weight: bold; padding: 20px; border-radius: 10px; border: none;" />
                </form>
                <%
                    }

                    if (!searchForm) {
                %>
                <table style="width:100%">
                    <tr>
                        <th>ID</th>
                        <th>To Account</th>
                        <th>From Account</th>
                        <th>Amount</th>
                    </tr>
                    <%
                        List<Transactions> found = new ArrayList<>();
                        for (Transactions trans : ApplicationHandler.userTransactions.values()) {
                            if (trans.getAmount().equals((Double) request.getAttribute("amount"))) {
                                found.add(trans);
                            }
                        }

                        for (Transactions trans : found) {
                            out.print("<tr style=\"text-align: center\">");
                            out.print("<td>" + trans.getTransID() + "</td>");
                            out.print("<td>" + trans.getToAccountID() + "</td>");
                            out.print("<td>" + trans.getFromAccountID() + "</td>");
                            out.print("<td> $" + trans.getAmount() + "</td>");
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
