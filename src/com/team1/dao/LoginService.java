package com.team1.dao;

import com.team1.util.ApplicationHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    public static boolean verifyClient(String username, String password){
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

    public static ResultSet getAllClients(){
        ApplicationHandler.dh.doConnect();
        return ApplicationHandler.dh.doStatement("SELECT * FROM Clients;");
    }

}
