package org.example.dataBase.createTables;

import java.sql.*;

public class ReadTableSalespeople {
    static final String BD_URL = "jdbc:postgresql://localhost:5433/Understanding_SQL";
    static final String USER = "postgres";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(BD_URL,USER,PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT  snum,sname,city FROM salespeople "+
                    "ORDER BY snum";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int snum = rs.getInt("snum");
                String sname =rs.getString("sname");
                String city = rs.getString("city");
                System.out.print("\tsnum = "+snum);
                System.out.print("\tsname = "+sname);
                System.out.print("\tcity = "+city);
                System.out.println();
            }
            rs.close();
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
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("done");
        }

    }
}
