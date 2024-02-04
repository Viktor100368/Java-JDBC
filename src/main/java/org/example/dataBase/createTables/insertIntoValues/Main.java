package org.example.dataBase.createTables.insertIntoValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static final String BD_URL ="jdbc:postgresql://localhost:5433/students";
    static final String USER ="postgres";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn= DriverManager.getConnection(BD_URL,USER,PASSWORD);
            stmt = conn.createStatement();
            String sql = "INSERT INTO student" +
                    " VALUES (1,'Ivan','Pukin',2,'m',8.4)";
            stmt.executeUpdate(sql);
            sql= "INSERT INTO student (id,name,surname,course,sex,avggradle)" +
                    "VAlUES (2,'Bonh','Jovi',3,'m',7.8)";
            stmt.executeUpdate(sql);
            System.out.println("values insert successfully");
        } catch (SQLException e) {
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
                e.printStackTrace();
            }
        }
        System.out.println("done");
    }
}
