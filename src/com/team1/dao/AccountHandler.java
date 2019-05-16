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
//        List<Transactions> transactions = new ArrayList<>();
//        try {
//            ApplicationHandler.dh.doConnect();
//            ResultSet result = ApplicationHandler.dh.doStatement("");
//            while(result.next()) {
//                Transactions newTransaction = new Transactions();
//                newTransaction.setAmmount(result.getDouble("amount"));
//                newTransaction.setFromAccountID(result.getInt("fromAccountId"));
//                newTransaction.setToAccountID(result.getInt("toAccountId"));
//                newTransaction.setTransID(result.getInt("id"));
//                transactions.add(newTransaction);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public static Double getBalance(int id) {
        Double balance = 0.00;
        ApplicationHandler.dh.doConnect();
        try {
            ResultSet result = (ResultSet) ApplicationHandler.dh.doStatement("SELECT * FROM Transactions WHERE fromAccountId = " + id + " OR toAccountId = " + id);
            while(result.next()) {
                if (result.getString("fromAccountId").equals(id)) {
                    // We are sending out money.
                    balance -= result.getDouble("amount");
                } else if (result.getString("toAccountId").equals(id)) {
                    balance += result.getDouble("amount");
                }
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
