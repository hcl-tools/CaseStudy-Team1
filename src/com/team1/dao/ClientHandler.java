package com.team1.dao;

import com.team1.util.ApplicationHandler;

import javax.xml.crypto.Data;

public class ClientHandler {

    public static boolean createAccount(String name, String username, String password){

        ApplicationHandler.dh.doConnect();
        if (name != null && username != null && password != null) {
            ApplicationHandler.dh.doStatement("INSERT INTO Clients (name, username, password) VALUES (\"" + name + "\", \"" + username + "\", \"" + password + "\");", "update");
            // We also need to create a Savings account for every new user.
            ApplicationHandler.dh.doStatement("INSERT INTO Accounts (accountName, accountType) VALUES(\"" + name +"'s Savings Account"  + "\", \"Savings\"); ", "update");
        }




        return true;

    }

}
