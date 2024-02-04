package org.example.dataBase.createDataBase;

import java.sql.*;

public class Test1 {
private static String BD_URL = "jdbc:postgresql://localhost:5433/Understanding_SQL";
private static String USER = "postgres";
private static String PASSWORD = "admin";

    public static void main(String[] args) {
     Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;
        try {
            con = DriverManager.getConnection(BD_URL,USER,PASSWORD);
            if(con == null){
                System.out.println("соединение с базой не установленно");
            }else {
                System.out.println("соединение с базой устоановленно");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM sjpeople";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getInt("snum")+"\t\t");
                System.out.print(rs.getString("sname")+"\t\t");
                System.out.print(rs.getString("city")+"\t\t");
                System.out.println(rs.getFloat("comm"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
