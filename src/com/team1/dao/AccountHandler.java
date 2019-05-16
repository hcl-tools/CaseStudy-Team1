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

    public List<Transactions> getTransactions(String amount) {
        List<Transactions> transactions = new ArrayList<>();
        try {
            ApplicationHandler.dh.doConnect();
            ResultSet result = ApplicationHandler.dh.doStatement("");
            while(result.next()) {
                Transactions newTransaction = new Transactions();
                newTransaction.setAmmount(result.getDouble("amount"));
                newTransaction.setFromAccountID(result.getInt("fromAccountId"));
                newTransaction.setToAccountID(result.getInt("toAccountId"));
                newTransaction.setTransID(result.getInt("id"));
                transactions.add(newTransaction);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ApplicationHandler.dh.doClose();
        }
        return transactions;
    }

    public static List<Account> getAccounts() {
        // Works with the saved user.
        List<Account> accounts = new ArrayList<>();
        try {
            ApplicationHandler.dh.doConnect();
            ResultSet result = ApplicationHandler.dh.doStatement("SELECT accountID FROM AccountLinks WHERE clientID = " + ApplicationHandler.userData.get("id"));
            while (result.next()) {
                ResultSet accountResult = ApplicationHandler.dh.doStatement("SELECT * FROM Accounts WHERE id = " + result.getInt("id"));
                Account nextAccount = null;
                switch(accountResult.getString("accountType")) {
                    case "Savings":
                        nextAccount = new Savings(accountResult.getInt("id"), accountResult.getString("accountName"));
                        break;
                    case "Checks":
                        nextAccount = new Checkings(accountResult.getInt("id"), accountResult.getString("accountName"));
                        break;
                    case "Current":
                    default:
                        nextAccount = new Current(accountResult.getInt("id"), accountResult.getString("accountName"));
                }
                accounts.add(nextAccount);
                ApplicationHandler.userAccounts.put(nextAccount.getAccountID(), nextAccount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            ApplicationHandler.dh.doClose();
        }
        return accounts;
    }

    public Double getBalance(int id) {
        Double balance = 0.00;
        ApplicationHandler.dh.doConnect();
        try {
            ResultSet result = ApplicationHandler.dh.doStatement("SELECT * FROM Transactions WHERE fromAccountId = " + id + " OR toAccountId = " + id);
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
}
