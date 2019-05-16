package com.team1.main;

import com.team1.dao.DatabaseHandler;

import java.util.HashMap;
import java.util.Map;

public class ApplicationHandler {

    public static DatabaseHandler dh = new DatabaseHandler();
    public Map<Object, Object> userData = new HashMap<>();
}
