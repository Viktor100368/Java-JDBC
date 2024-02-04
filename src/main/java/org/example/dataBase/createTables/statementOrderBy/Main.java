package org.example.dataBase.createTables.statementOrderBy;

import java.sql.*;

public class Main {
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
            String sql ="SELECT * FROM customers " +
                    "ORDER BY cnum DESC";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int cnum = rs.getInt("cnum");
                String cname = rs.getString("cname");
                String city = rs.getString("city");
                int rating = rs.getInt("rating");
                System.out.print("\tcnum = "+cnum);
                System.out.print("\tcname = "+cname);
                System.out.print("\t\tcity = "+city);
                System.out.print("\t\trating = "+rating);
                System.out.println();
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(stmt != null)
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
            System.out.println("done");
        }
    }
}
