package org.example.dataBase.createTables.statementLIke;

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
            stmt  = conn.createStatement();
            String sql = "SELECT cnum,cname,city FROM customers "+
                    "WHERE cname like '%men%'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int cnum = rs.getInt("cnum");
                String cname =rs.getString("cname");
                String city = rs.getString("city");
                System.out.println("cnum = "+cnum);
                System.out.println("cname = "+cname);
                System.out.println("city = "+city);
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
