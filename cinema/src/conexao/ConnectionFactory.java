package conexao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://a2nlmysql51plsk.secureserver.net:3306/cinema_estacio";
    private static final String USER = "adm_estacio";
    private static final String PASS = "estacio@2021";
    
    public static Connection getConexao() throws SQLException, Exception{
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
           throw new Exception("Ocorreu um erro ao conectar ao BD: " + ex.getMessage());
        }
    }
    
    
    public static void fecharConexao(Connection con) throws Exception{
        try{
            if(con != null){
            con.close();
            }
        }
        catch(SQLException ex){
            throw new Exception("Erro ao fechar a conexão do BD: " + ex.getMessage());
        }
    }
    
    public static void fecharConexao(Connection con, PreparedStatement stmt) throws Exception{
        try{
            fecharConexao(con);
            if(stmt != null){
            stmt.close();
            }
        }
        catch(SQLException ex){
            throw new Exception("Erro ao fechar a conexão do BD: " + ex.getMessage());
        }
    }
    
    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) throws Exception{
        try{
            fecharConexao(con, stmt);
            if(rs != null){
            rs.close();
            }
        }
        catch(SQLException ex){
            throw new Exception("Erro ao fechar a conexão do BD: " + ex.getMessage());
        }
    }
}
