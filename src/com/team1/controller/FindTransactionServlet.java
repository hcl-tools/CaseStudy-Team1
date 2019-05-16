package com.team1.controller;

import com.team1.bean.Transactions;
import com.team1.util.ApplicationHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findTransactions")
public class FindTransactionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("findTransactions.jsp");
        Double amount = Double.valueOf(request.getParameter("amount"));
        request.setAttribute("amount", amount);
        request.setAttribute("searchForm", false);
        rd.forward(request, response);
    }
}
