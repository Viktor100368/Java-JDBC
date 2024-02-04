package org.example.dataBase.createTables.statementLIke;

import org.example.dataBase.createTables.getValues.Worker;

import java.sql.*;
import java.util.ArrayList;

public class LIkeTest {
    private static String DB_URL = "jdbc:postgresql://localhost:5433/driver";
    private static String USER = "postgres";
    private static String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn= null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            System.out.println("create database connection");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            stmt = conn.createStatement();
            String sql ="SELECT * FROM employees WHERE surname like '%nov'";
            rs = stmt.executeQuery(sql);
            ArrayList<Worker> workerList = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int salary = rs.getInt("salary");
                workerList.add(new Worker(id,name,surname,salary));
            }
            for(Worker w:workerList){
                System.out.println(w);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
