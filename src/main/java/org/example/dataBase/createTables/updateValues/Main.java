package org.example.dataBase.createTables.updateValues;

import java.sql.*;

public class Main {
    static final String BD_URL = "jdbc:postgresql://localhost:5433/students";
    static final String USER = "postgres";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;



        try {
            conn = DriverManager.getConnection(BD_URL,USER,PASSWORD);
            stmt = conn.createStatement();


//            String sql = "UPDATE student SET surname = 'Pisulkin' WHERE name ='Ivan'";
//            stmt.executeUpdate(sql);

        String sql = " UPDATE student " +
                "SET surname = 'Boltushkin'" +
                " WHERE id = 1";
            stmt.executeUpdate(sql);

            System.out.println("values update successfull");
            sql = "SELECT * FROM student" ;
            rs= stmt.executeQuery(sql);
            while(rs.next()){
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
            System.out.println("values reading");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!= null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(stmt!=null)
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
