package org.example.dataBase.createTables.insertIntoValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
    private static String DB_URL ="jdbc:postgresql://localhost:5433/driver";
    private static String USER ="postgres";
    private static String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        System.out.println("create database cnnnection");
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            stmt = conn.createStatement();
            String sql =" INSERT INTO employees " +
                    "values(3,'Semen','Semenov',3800)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO employees values(4,'Anton','Antonov',4300)";
            stmt.executeUpdate(sql);
            System.out.println("Done!!!!");



        } catch (SQLException e) {
            e.printStackTrace();
         }finally {
            if(stmt !=null){
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
