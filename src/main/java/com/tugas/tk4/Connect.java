package com.tugas.tk4;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Connect {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/TK4?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static java.sql.Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }    

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }

        return rs;
    }

    public void executeUpdate(String query) {
        try {
           stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }
    }
}
