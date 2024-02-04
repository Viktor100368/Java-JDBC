package org.example.dataBase.createTables.insertIntoValues;

import javax.print.DocFlavor;
import java.sql.*;

public class Test {
    private static String url = "jdbc:postgresql://localhost:5433/Understanding_SQL";
    private static String user ="postgres";
    private static String password = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        ResultSet res = null;
        Statement stmt=null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            String sql = "SELECT  * FROM customers";
            res=stmt.executeQuery(sql);
            while(res.next()) {
                int cnum = res.getInt("cnum");
                String cname = res.getString("cname");
                String city = res.getString("city");
                int rarting = res.getInt("rating");
                int snum = res.getInt("snum");
                System.out.print("\ncnum =\t"+cnum);
                System.out.print("\ncname =\t"+cname);
                System.out.print("\ncity =\t"+city);
                System.out.print("\nrating =\t"+rarting);
                System.out.print("\nsnum =\t"+snum);
                System.out.println();
            }
            res.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("done!");

    }
}
