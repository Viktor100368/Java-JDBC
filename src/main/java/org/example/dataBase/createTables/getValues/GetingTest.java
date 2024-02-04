package org.example.dataBase.createTables.getValues;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetingTest {
    private static String DB_URL = "jdbc:postgresql://localhost:5433/driver";
    private static String USER = "postgres";
    private static String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection conn= null;
        Statement stmt = null;
        ResultSet rs = null;

            try {
                conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
                System.out.println("created database conneciton");
                stmt = conn.createStatement();
                String sql="select * from employees";
                rs = stmt.executeQuery(sql);
                List<Worker> workerList = new ArrayList<>();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    int salary = rs.getInt("salary");
//                    System.out.print("id = "+id+"\n"
//                            +"name = "+ name+"\n"
//                            +"surname = "+surname+"\n"
//                            +"salary = "+salary+"\n"
//                    );
                    workerList.add(new Worker(id,name,surname,salary));
                }
                for(Worker w:workerList){
                    System.out.println(w);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

    }
}
