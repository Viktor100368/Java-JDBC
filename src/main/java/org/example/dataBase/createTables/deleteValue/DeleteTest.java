package org.example.dataBase.createTables.deleteValue;

import org.example.dataBase.createTables.getValues.Worker;

import java.sql.*;
import java.util.ArrayList;

public class DeleteTest {
    private static String DB_URL= "jdbc:postgresql://localhost:5433/driver";
    private static String USER = "postgres";
    private static String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("begining");
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            stmt = conn.createStatement();
            String sql = "DELETE FROM employees WHERE surname  = 'Petrov'";
            stmt.executeUpdate(sql);
            sql = "select * from employees";
            rs = stmt.executeQuery(sql);
            ArrayList<Worker> list = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int salary = rs.getInt("salary");
                list.add(new Worker(id,name,surname,salary));
            }
            for(Worker w :list){
                System.out.println(w);
            }
                rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {

                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
