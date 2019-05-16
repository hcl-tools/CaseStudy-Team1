package com.team1.bean;

import com.team1.dao.AccountHandler;

public class Account {
    private int AccountID = 0;
    private String AccountName = "";
    private Double balance = 0.00;

    Account() {}
    public Account(int AccountID, String AccountName) {
        this.AccountID = AccountID;
        this.AccountName = AccountName;
    }

    public Double calcBalance() {
        this.balance = AccountHandler.getBalance(this.AccountID);
        return this.balance;
    }

    public int getAccountID() { return AccountID; }
    public String getAccountName() { return AccountName; }

    public void setAccountName(String accountName) { AccountName = accountName; }
    public void setAccountID(int accountID) { AccountID = accountID; }

}
