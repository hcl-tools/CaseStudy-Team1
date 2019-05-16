package com.team1.bean;

public class Transactions {
    private int transID;
    private int toAccountID;
    private int fromAccountID;
    private float ammount;

    //Getters
    public int getTransID() { return transID; }

    public int getToAccountID() { return toAccountID; }

    public float getAmmount() { return ammount; }

    public int getFromAccountID() { return fromAccountID; }


    //Setters
    public void setToAccountID(int toAccountID) { this.toAccountID = toAccountID; }

    public void setTransID(int transID) { this.transID = transID; }

    public void setFromAccountID(int fromAccountID) { this.fromAccountID = fromAccountID; }

    public void setAmmount(float ammount) { this.ammount = ammount; }
}
