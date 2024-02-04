package org.example.dataBase.createDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
   static final String DB_URL ="jdbc:postgresql://localhost:5433/";
  static final String USER = "postgres";
  static final String PASSWORD ="admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            System.out.println("create database connection");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("creating database");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE Students";
            stmt.executeUpdate(sql);
            System.out.println("create database successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null)
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("goodby");
    }
}
