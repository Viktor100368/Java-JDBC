package org.example.dataBase.createTables.getValues;

import java.sql.*;
import java.util.ArrayList;

public class TestSQL {
        static final String DB_URL = "jdbc:postgresql://localhost:5433/Northwind";
        static final String USER = "postgres";
        static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        ArrayList<Customers> customersList = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT company_name,contact_name,address FROM customers "+
                    "LIMIT 10";
            rs= stmt.executeQuery(sql);
            while(rs.next()){
                String companyName = rs.getString("company_name");
                String contactName = rs.getString("contact_name");
                String address = rs.getString("address");
               customersList.add(new Customers(companyName,contactName,address));

            }
            rs.close();
            for(Customers c: customersList){
                System.out.println(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(stmt!=null)
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
        System.out.println("done");
    }
}
