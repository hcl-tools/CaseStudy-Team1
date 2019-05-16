package com.team1.controller;

import com.team1.util.ApplicationHandler;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Account")
public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter output = response.getWriter();
        String accountType = request.getParameter("type");
        String accountName = request.getParameter("accountName");
        String sharedAccount = request.getParameter("sharetype");
        ApplicationHandler.dh.doConnect();
        ApplicationHandler.dh.doStatement("INSERT INTO Accounts (accountName, accountType) VALUES (" + accountName + ", " + accountType + ");");
        ApplicationHandler.dh.doStatement("INSERT INTO AccountsLinks (clientId, accountId) VALUES (" + clientId + ", "+ accountId + ");");
        if (sharedAccount.equals("joint")){
            ApplicationHandler.dh.doStatement("INSERT INTO AccountsLinks (accountSharerId, accountId) VALUES (" + accountSharerId + ", " + accountId + ");");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
