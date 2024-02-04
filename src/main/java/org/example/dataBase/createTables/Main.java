package org.example.dataBase.createTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static final String BD_URL = "jdbc:postgresql://localhost:5433/students";
    static final String USER = "postgres";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            String sql = "CREATE TABLE student" +
                    "(id integer ," +
                    "name varchar(100) not null," +
                    "surname varchar(100) not null," +
                    "course integer, " +
                    "sex char(1)," +
                    "avgGradle real," +
                    " PRIMARY KEY(id))";
            stmt.executeUpdate(sql);
            System.out.println("table created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("goodby");
    }
}
