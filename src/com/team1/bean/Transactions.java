package com.team1.bean;

public class Transactions {
    private int transID;
    private int toAccountID;
    private int fromAccountID;
    private Double amount;

    public Transactions() {}
    public Transactions(int transID, int toAccountID, int fromAccountID, Double amount) {
        this.transID = transID;
        this.toAccountID = toAccountID;
        this.fromAccountID = fromAccountID;
        this.amount = amount;
    }

    //Getters
    public int getTransID() { return transID; }

    public int getToAccountID() { return toAccountID; }

    public Double getAmount() { return amount; }

    public int getFromAccountID() { return fromAccountID; }


    //Setters
    public void setToAccountID(int toAccountID) { this.toAccountID = toAccountID; }

    public void setTransID(int transID) { this.transID = transID; }

    public void setFromAccountID(int fromAccountID) { this.fromAccountID = fromAccountID; }

    public void setAmmount(Double ammount) { this.amount = ammount; }
}
