package org.example.dataBase.createTables.statementWhere;

import org.example.dataBase.createTables.getValues.Worker;

import java.sql.*;
import java.util.ArrayList;

public class WhereTest {
    private static String DB_URL = "jdbc:postgresql://localhost:5433/driver";
    private static String USER = "postgres";
    private static String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        System.out.println("create database connection");
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            stmt =conn.createStatement();
            String sql = "SELECT * FROM employees WHERE salary > 3500";
            rs= stmt.executeQuery(sql);
            ArrayList<Worker> listWorker = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int salary = rs.getInt("salary");
                listWorker.add(new Worker(id,name,surname,salary));
            }
            for(Worker w: listWorker){
                System.out.println(w);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
