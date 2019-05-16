package com.team1.controller;

import com.team1.dao.AccountHandler;
import com.team1.dao.LoginService;

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
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(LoginService.verifyClient(username, password)){
            AccountHandler.getAccounts();
            rd.forward(request, response);
        }
        else{

        }
    }
}
