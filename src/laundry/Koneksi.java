/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alfinadewi
 */
public class Koneksi {
    
    Connection conn;
    Statement stat;
    
    private Connection koneksi;
    
    public static void main(String[] args) {
        Connection conn = new Koneksi().Connect();
    }
    
    public Connection Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Koneksi Driver Berhasil");
        } catch (ClassNotFoundException e) {
            System.out.println("Koneksi Driver Gagal"+e);
        }
        
        String url = "jdbc:mysql://localhost:3306/laundry";
        try {
            koneksi = DriverManager.getConnection(url, "root","");
            System.out.println("Koneksi Database Berhasil");
        } catch (SQLException e) {
            System.out.println("Koneksi Database Gagal");
        }
        
        return koneksi; 
    }
}
