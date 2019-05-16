package com.team1.controller;

import com.team1.bean.Transactions;
import com.team1.util.ApplicationHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/account")
public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/html/Account.html");
        rd.forward(request, response);
        String accountType = request.getParameter("type");
        String accountName = request.getParameter("accountName");
        String sharedAccount = request.getParameter("sharetype");
        String accountSharerId = request.getParameter("accountSharerId");
        ApplicationHandler.dh.doConnect();

        try {
            ApplicationHandler.dh.doStatement("INSERT INTO Accounts (accountName, accountType) VALUES (" + accountName + ", " + accountType + ");");
            ResultSet result = ApplicationHandler.dh.doStatement("SELECT LAST_INSERT_ID();");
            ApplicationHandler.dh.doStatement("INSERT INTO AccountsLinks (clientId, accountId) VALUES (" + ApplicationHandler.userData.get("id") + ", "+ result.getInt("id") + ");");

            if (sharedAccount.equals("joint")){
                ApplicationHandler.dh.doStatement("INSERT INTO AccountsLinks (accountSharerId, accountId) VALUES (" + accountSharerId + ", " + result.getInt("id") + ");");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
