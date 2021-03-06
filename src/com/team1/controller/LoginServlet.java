package com.team1.controller;

import com.team1.dao.AccountHandler;
import com.team1.dao.ClientHandler;
import com.team1.dao.LoginService;
import com.team1.util.ApplicationHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        RequestDispatcher rdhome = request.getRequestDispatcher("/home.jsp");
        RequestDispatcher rdindex = request.getRequestDispatcher("/index.jsp");

        String page = request.getParameter("page");

        if(page.equals("lp")) {

            if (request.getParameter("login") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                if (LoginService.verifyClient(username, password)) {
                    AccountHandler.getAccounts();
                    AccountHandler.getTransactions();
                    rdhome.forward(request, response);
                } else {
                    request.setAttribute("errorCode", 1);
                    rdindex.forward(request, response);
                }
            }

            if(request.getParameter("createAccount") != null){
                request.setAttribute("createAccount", 1);
                rdindex.forward(request, response);
            }

            if(request.getParameter("finaliseAccount") != null){
                String newName = request.getParameter("newName");
                String newUsername = request.getParameter("newUsername");
                String newPassword = request.getParameter("newPassword");

                if(ClientHandler.createAccount(newName, newUsername, newPassword)){
                    request.setAttribute("accountCreated", 1);
                    rdindex.forward(request, response);
                }

            }

        }

        if(page.equals("lout")){
            ApplicationHandler.logout();
            rdindex.forward(request, response);
        }
    }

}
