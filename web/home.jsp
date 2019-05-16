<%--
  Created by IntelliJ IDEA.
  User: brayden
  Date: 2019-05-16
  Time: 08:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hell's Bank</title>
  <link rel="stylesheet" type="text/css" href="css/homeStyle.css">
</head>
<body>

  <div class="navbar">
    <ul>
      <li><a href="displayTransactions.jsp">Display Transactions</a></li>
      <li><a href="displayAccount.jsp">Display Account</a></li>
      <li><a href="findAccount.jsp">Find Account</a></li>
      <li><a href="findTransactions.jsp">Find Transactions</a></li>
      <li><a href="createAccounts.jsp">Create Account</a></li>
      <li><a href="createTransactions.jsp">Create Transaction</a></li>
      <li><a href="${pageContext.request.contextPath}/login?page=lout">Logout</a></li>
    </ul>
  </div>

</body>
</html>

