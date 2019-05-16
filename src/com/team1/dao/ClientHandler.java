package com.team1.dao;

import com.team1.util.ApplicationHandler;

import javax.xml.crypto.Data;

public class ClientHandler {

    public static boolean createAccount(String name, String username, String password){

        ApplicationHandler.dh.doConnect();
        ApplicationHandler.dh.doStatement("INSERT INTO Clients (name, username, password) VALUES (\"" + name + "\", \"" + username + "\", \"" + password + "\");", "update");
        return true;

    }

}
