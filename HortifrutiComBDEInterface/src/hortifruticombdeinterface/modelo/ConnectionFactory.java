/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hortifruticombdeinterface.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MASTER
 */
public class ConnectionFactory {
     private static final String URL = "jdbc:mysql://localhost:3306/frutaria?serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static final String USER = "root";
    private static final String PASSWORD = "PQ@n@17";
    
    public static Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("");
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void closeConexao(Connection conn){
       try{
            if(conn != null) conn.close();
       }
       catch(SQLException e){
           e.printStackTrace();
       }
    }
    public static void closeConexao(Connection conn, PreparedStatement stmt){
        closeConexao(conn);
        try{
            if(stmt != null) stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeConexao(Connection conn, PreparedStatement stmt, ResultSet rs){
         closeConexao(conn, stmt);
         try{
             if(rs != null) rs.close();
         }
         catch(SQLException e){
             e.printStackTrace();
         }
    }
}
