package com.team1.bean;

public class Account {
    private int AccountID = 0;
    private String AccountName = "";
    private String AccountType = "";

    public int getAccountID() { return AccountID; }
    public String getAccountName() { return AccountName; }
    public String getAccountType() { return AccountType; }

    public void setAccountName(String accountName) { AccountName = accountName; }
    public void setAccountID(int accountID) { AccountID = accountID; }
    public void setAccountType(String accountType) { AccountType = accountType; }

}
