package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection connection;

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/jdbc_tutorial?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded");

            if(connection == null){
                connection = DriverManager.getConnection(CONNECTION_URL, USERNAME,PASSWORD);
                System.out.println("Connected");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return connection;
    }

}