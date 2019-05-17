package com.team1.dao;

import com.team1.util.ApplicationHandler;

import javax.xml.crypto.Data;
import java.sql.ResultSet;

public class ClientHandler {

    public static boolean createAccount(String name, String username, String password){

        ApplicationHandler.dh.doConnect();
        if (name != null && username != null && password != null) {
            ApplicationHandler.dh.doStatement("CALL createClient(\"" + name + "\", \"" + username + "\", \"" + password + "\");");
        }

        return true;

    }

}
