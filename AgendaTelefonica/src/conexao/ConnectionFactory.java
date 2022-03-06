/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author iagui
 */
public class ConnectionFactory {
    
    //DRIVER - qual tecnologia de SGBD vai ser utilizada
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //URL - onde está o SGBD (web, localhost)
    private static final String URL = "jdbc:mysql://a2nlmysql51plsk.secureserver.net:3306/cinema_estacio";
    //USER - usuario do BD
    private static final String USER = "adm_estacio";
    //PASS - senha do BD
    private static final String PASS = "estacio@2021";
    
    public  static Connection getConnection() throws SQLException, Exception
    {
        try
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (ClassNotFoundException ex)
        {
            throw new Exception("Ocorreu um erro ao conectar um BD"+ ex.getMessage());
        }
    }
    
     public static void fecharConexao(Connection con) throws Exception
        {
            try
            {
                if(con !=null)
                {
                    con.close();
                }
            }
            catch (SQLException ex)
            {
                throw new Exception("Ocorreu um erro ao fechar a conexão do BD"+ ex.getMessage());
            }
         }
     
      public static void fecharConexao(Connection con, PreparedStatement stmt) throws Exception
        {
            try
            {
                fecharConexao(con);
                
                if(stmt !=null)
                {
                    stmt.close();
                }
            }
            
            catch (SQLException ex)
            {
                throw new Exception("Ocorreu um erro ao fechar a conexão do BD"+ ex.getMessage());
            }
         }
      
       public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) throws Exception
        {
            try
            {
                fecharConexao(con);
                
                if(stmt !=null)
                {
                    stmt.close();
                }
            }
            
            catch (SQLException ex)
            {
                throw new Exception("Ocorreu um erro ao fechar a conexão do BD"+ ex.getMessage());
            }
         }
}
