package com.team1.dao;

import com.team1.bean.Account;
import com.team1.bean.Transactions;
import com.team1.bean.types.Checkings;
import com.team1.bean.types.Current;
import com.team1.bean.types.Savings;
import com.team1.util.ApplicationHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountHandler {

    public List<Transactions> getTransactions(String amount) {
        try {
            ApplicationHandler.dh.doConnect();
            ResultSet result = ApplicationHandler.dh.doStatement("");
            List<Account> accounts = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ApplicationHandler.dh.doClose();
        }
        return null;
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
}
