package com.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = ConnectionProvider.getConnection();
        System.out.println(connection);
    }
}
