package org.example.dataBase;

import org.postgresql.util.PSQLException;

import java.sql.*;


public class Main {
    public static void main(String[] args){
        Connection con= null;
        try {
             con =DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/Understanding_SQL",
                       "postgres","admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(con == null){
            System.out.println("подключение не установленно");
        }else{
            System.out.println("подключение установленно");
        }
        try {

            Statement stmt = con.createStatement();

            System.out.println("=========================");
             ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                System.out.println("customers -> " + rs.getString(2) + " : " + rs.getString(3) +
                        " : " + rs.getInt(4));
            }
            rs = stmt.executeQuery("SELECT * FROM salespeople");
            while (rs.next()) {
                System.out.println("salespeople -> " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getFloat(4));
            }
            rs = stmt.executeQuery("SELECT * FROM orders");
            while (rs.next()) {
                System.out.println("orders -> " + rs.getFloat(2) + " : " + rs.getDate(3) + " : " + rs.getInt(4));
            }
        stmt.close();
        rs.close();
        con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
