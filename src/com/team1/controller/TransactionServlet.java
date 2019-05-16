package com.team1.controller;

import com.team1.bean.Transactions;
import com.team1.util.ApplicationHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet ("/createTransaction")
public class TransactionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter output = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("/html/Transactions.html");
        rd.forward(request, response);
        int fromAccountID = Integer.valueOf(request.getParameter("fromAccountID"));
        int toAccountID = Integer.valueOf(request.getParameter("toAccountID"));
        Double amount = Double.valueOf(request.getParameter("amount"));
        ApplicationHandler.dh.doConnect();
        if (ApplicationHandler.userAccounts.containsKey(fromAccountID)) {
            ApplicationHandler.dh.doStatement(" INSERT INTO Transactions (toAccountID, fromAccountID, amount) VALUES (" + toAccountID + ", " + fromAccountID + ", " + amount +");");
//            ResultSet results = ApplicationHandler.dh.doStatement("SELECT * FROM Transactions WHERE toAccountID = "+toAccountID+" AND fromAccountID = " + fromAccountID + " AND amount = "+amount+";");
            ResultSet results = ApplicationHandler.dh.doStatement("SELECT LAST_INSERT_ID();");
            try {
                ApplicationHandler.userTransactions.put(results.getInt("id"), new Transactions(results.getInt("id"), toAccountID, fromAccountID, amount));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
