package com.team1.services;

import com.team1.dao.DatabaseHandler;
import com.team1.main.ApplicationHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    public boolean verifyClient(String username, String password){
        ApplicationHandler.dh.doConnect();
        ResultSet allUsers = getAllClients();

        try {
            while (allUsers.next()) {
                if(allUsers.getString("username").equalsIgnoreCase(username) && allUsers.getString("password").equals(password)){
                    ApplicationHandler.userData.put("id", allUsers.getInt("id"));
                    return true;
                }
            }
        }catch (SQLException SQLe){
            SQLe.printStackTrace();
        }
        return false;
    }

    public ResultSet getAllClients(){
        ApplicationHandler.dh.doConnect();
        ResultSet rs = ApplicationHandler.dh.doStatement("SELECT * FROM Clients;");
        return rs;
    }

}
