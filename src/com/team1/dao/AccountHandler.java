package com.team1.dao;

import com.team1.bean.Account;
import com.team1.bean.Transactions;
import com.team1.bean.types.Checkings;
import com.team1.bean.types.Current;
import com.team1.bean.types.Savings;
import com.team1.util.ApplicationHandler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountHandler {

    public static List<Transactions> getTransactions() {
        List<Transactions> transactionList = new ArrayList<>();
        ApplicationHandler.dh.doConnect();
        try {
            ResultSet result = ApplicationHandler.dh.doStatement("SELECT * FROM Transactions WHERE toAccountId = " + ApplicationHandler.userData.get("id") + " OR fromAccountId = " + ApplicationHandler.userData.get("id") + ";");
            while (result.next()) {
                Double amount = result.getDouble("amount");
                int toId = result.getInt("toAccountId");
                int fromId = result.getInt("fromAccountId");
                int id = result.getInt("id");
                Transactions transaction = new Transactions(id, toId, fromId, amount);
                ApplicationHandler.userTransactions.put(id, transaction);
                transactionList.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApplicationHandler.dh.doClose();
        return transactionList;
    }

    public static Double getBalance(int id) {
        Double balance = 0.00;
        ApplicationHandler.dh.doConnect();
        try {
            ResultSet result = ApplicationHandler.dh.doStatement("CALL calculateBalance('" + id + "');");
            if (result.next()){
                balance = result.getDouble("Balance");
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
        return balance;
    }

    public static void getAccounts() {
        ApplicationHandler.dh.doConnect();
        try {
            ResultSet result = ApplicationHandler.dh.doStatement("SELECT * FROM Accounts WHERE id = " + ApplicationHandler.userData.get("id"));
            while (result.next()) {
                Account toLoad = null;
                String accountName = result.getString("accountName");
                int id = result.getInt("id");
                switch (result.getString("accountType")) {
                    case "Savings":
                        toLoad = new Savings(id, accountName);
                        break;
                    case "Checks":
                        toLoad = new Checkings(id, accountName);
                        break;
                    case "Current":
                    default:
                        toLoad = new Current(id, accountName);
                }
                ApplicationHandler.userAccounts.put(id, toLoad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApplicationHandler.dh.doClose();
    }
}
