package org.example.dataBase.createTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
    private final static String DB_URL="jdbc:postgresql://localhost:5433/driver";
    private final static String USER = "postgres";
    private final static String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn= null;
        Statement stmt = null;
        try {
            System.out.println("create database connection");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            stmt = conn.createStatement();

            String sql ="create table employees" +
                    "(id serial primary key," +
                    "name varchar(15)," +
                    "surname varchar(25)," +
                    "salary int)";
            stmt.executeUpdate(sql);
            System.out.println("table created successful");


        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
