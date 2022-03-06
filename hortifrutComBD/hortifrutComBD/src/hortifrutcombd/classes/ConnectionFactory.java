package hortifrutcombd.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
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
    public static void closeConexao(Connection conn, Statement stmt){
        closeConexao(conn);
        try{
            if(stmt != null) stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeConexao(Connection conn, Statement stmt, ResultSet rs){
         closeConexao(conn, stmt);
         try{
             if(rs != null) rs.close();
         }
         catch(SQLException e){
             e.printStackTrace();
         }
    }
}
