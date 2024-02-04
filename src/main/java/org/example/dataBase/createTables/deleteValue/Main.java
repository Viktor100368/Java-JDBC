package org.example.dataBase.createTables.deleteValue;

import java.sql.*;

public class Main {
    static final String BD_URL = "jdbc:postgresql://localhost:5433/students";
    static final String USER = "postgres";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(BD_URL,USER,PASSWORD);
            stmt = conn.createStatement();
            String sql = "DELETE FROM student " +
                    "WHERE id = 1";
            stmt.executeUpdate(sql);
            System.out.println("deleting successfull");
            sql = "SELECT * FROM student";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int course = rs.getInt("course");
                String sex = rs.getString("sex");
                float avggradle = rs.getFloat("avggradle");
                System.out.println("id = "+id);
                System.out.println("name = "+name);
                System.out.println("surname = "+surname);
                System.out.println("course = "+ course);
                System.out.println("sex = "+sex);
                System.out.println("avgGradle = "+avggradle);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(rs!=null)
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(stmt!=null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            if(conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}
