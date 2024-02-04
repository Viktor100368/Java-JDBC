package org.example.dataBase.createTables.getValues;



import java.sql.*;

public class Main {
    static final String BD_URL = "jdbc:postgresql://localhost:5433/students";
    static final String USER = "postgres";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn= DriverManager.getConnection(BD_URL,USER,PASSWORD);
            stmt= conn.createStatement();
            System.out.println("read values");
            String sql = "SELECT * FROM student";
            rs= stmt.executeQuery(sql);
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
            System.out.println("values successfull reading");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                stmt.close();
                rs.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("done");

    }
}
