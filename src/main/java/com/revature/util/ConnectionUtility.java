package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtility {

    private final static  String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=THE_PROJECT";
    private final static String user = "postgres";
    private final static String password = "password";

    public static Connection getConnection() {

        try {
            //Class.forName("org.postgresql.Driver"); // only add if you cant solve the No Suitable found exception
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}