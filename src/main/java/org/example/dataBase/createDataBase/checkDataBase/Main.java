package org.example.dataBase.createDataBase.checkDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static final String BD_URL = "jdbc:postgresql://localhost:5433/students";
    static final String USER = "postgres";
    static final String PASSWORD ="admin";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(BD_URL,USER,PASSWORD);
            System.out.println("connecton with database successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn !=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println("goodby");
    }
}
