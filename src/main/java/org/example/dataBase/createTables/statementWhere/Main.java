package org.example.dataBase.createTables.statementWhere;

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
            String sql = "SELECT onum,amt,odate,cnum FROM orders " +
                    "WHERE amt > 1000";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                int onum = rs.getInt("onum");
                float amt = rs.getFloat("amt");
                Date odate = rs.getDate("odate");
                int cnum = rs.getInt("cnum");
                System.out.println("onum = "+onum);
                System.out.println("amt = "+amt);
                System.out.println("odate = "+odate);
                System.out.println("cnum = "+cnum);
                System.out.println();
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
