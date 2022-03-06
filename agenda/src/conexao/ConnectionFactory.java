package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://a2nlmysql51plsk.secureserver.net:3306/cinema_estacio?serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static final String USER = "adm_estacio";
    private static final String PASS = "estacio@2021";
    
    public static Connection getConexao(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao conecctar ao banco :( -> " + e.getMessage());
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Classe Driver não encontrada");
        }
        return null;
    }
    
    public static void fecharConexao(Connection conn){
        try{
            if(conn != null) conn.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a \"conexão\".");
        }
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement stmt){
        try{
            fecharConexao(conn);
            if(stmt != null) stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar fechar o \"prepared statement\".");
        }
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs){
        try{
            fecharConexao(conn, stmt);
            if(rs != null) rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar fechar o \"result set\".");
        }
    }
    
    public static void fecharConexao(ResultSet rs){
        
        try{
            if(rs != null) rs.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
