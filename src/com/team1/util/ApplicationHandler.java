package com.team1.util;

import com.team1.dao.DatabaseHandler;

import java.util.HashMap;
import java.util.Map;

public class ApplicationHandler {

    public static DatabaseHandler dh = new DatabaseHandler();
    public static Map<Object, Object> userData = new HashMap<>();
}
