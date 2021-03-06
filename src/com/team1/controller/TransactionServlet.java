package com.team1.controller;

import com.team1.bean.Transactions;
import com.team1.util.ApplicationHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet ("/createTransaction")
public class TransactionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
        int fromAccountID = Integer.valueOf(request.getParameter("fromAccountID"));
        int toAccountID = Integer.valueOf(request.getParameter("toAccountID"));
        Double amount = Double.valueOf(request.getParameter("amount"));
        ApplicationHandler.dh.doConnect();
        if (ApplicationHandler.userAccounts.containsKey(fromAccountID)) {
            ApplicationHandler.dh.doStatement(" INSERT INTO Transactions (toAccountID, fromAccountID, amount) VALUES (\"" + toAccountID + "\", \"" + fromAccountID + "\", \"" + amount +"\");", "update");
//            ResultSet results = ApplicationHandler.dh.doStatement("SELECT * FROM Transactions WHERE toAccountID = "+toAccountID+" AND fromAccountID = " + fromAccountID + " AND amount = "+amount+";");
            ResultSet results = (ResultSet) ApplicationHandler.dh.doStatement("SELECT MAX(id) AS 'id' FROM Transactions;");
            try {
                ApplicationHandler.userTransactions.put(results.getInt("id"), new Transactions(results.getInt("id"), toAccountID, fromAccountID, amount));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rd.forward(request, response);
    }
}
