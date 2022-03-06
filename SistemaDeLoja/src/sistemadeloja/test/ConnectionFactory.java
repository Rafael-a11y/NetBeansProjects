/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeloja.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemadeloja.test.classes.Cliente;
/**
 *
 * @author MASTER
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USER = "root";
    private static final String PASSWORD = "PQ@n@17";
    //Retorna uma conexão a partir da classe DriverManager, usando de parâmetro o link fornecido pela
    //Documentação, o usuário, e a senha. A partir do momento em que o connection é retornado, a conexão
    //é criada e bem sucedida.
    public static Connection getConexaoProf(){
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem sucedida pae!");
            return connection;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static Connection getConexao(){
        try {
            
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabvbelecida  " + conn);
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();  ;
        }
        return null;
    }
    
    public static void closeConexao(Connection conn){
        try{
            if (conn != null) {
                conn.close();
                System.out.println("Conexão fechada");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void closeConexao(Connection conn, PreparedStatement stmt){
        if (stmt != null) try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConexao(conn);
    }
    
     public static void closeConexao(Connection conn, PreparedStatement stmt, ResultSet rs){
        if (rs != null) try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConexao(conn, stmt);
    }
     
     public static List<Cliente> consultaCliente(){
         Connection conn = getConexaoProf();
         //satement significa afirmação,é usado para realizar consultas no banco de dados e o construtor é
         //acessado a partir do objeto Connection, lembrando que empre é preciso criar a conexãao antes de
         // fazer qualquer operação no banco.
         Statement st;
         ResultSet rs;
        try{
             st = conn.createStatement();
             //executar a consulta retorna um conjunto de resulktados, ou seja, várias linhas, é preciso atribuir
             //este conjunto a um ResultSet, caso contrário, os valores vão direto ppara a lixeira.
             rs = st.executeQuery("select * from cliente");
             //Após conseguir as linhas no ResultSet, é preciso iterar sobre as linhas, por isso usamos next()
             //que verifica se há uma próxima linha, usamos as apropriadas variáveis para receber os valores
             //de cada coluna e imprimimos na tela. Agora, para inserir os valores em objetos, vamos criar
             //uma lista de Clientes e retornar esta lista, lembrando que você nãao precisa necessáriamente
             //criar a lsitaa, mas como são várias tuplas, e considerando que você quer armazenar todos eles
             //em objetos, vamos criaar a lista clientes;
             List<Cliente> clientes = new ArrayList<>();
             while(rs.next()){
                 Integer id = rs.getInt("id");
                 String nome = rs.getString("nome");
                 String cpf = rs.getString("cpf");
                 /*Usamos para valores decimal, o BigDecimal do Java, e posteriormente convertemos para
                   Double, porém é preciso fazer uma verificação antes, pois caso o campo esteja nulo, 
                   irá lançar um NullPointerException.
                   BigDecimal campoEmBigDec = rs.getBigDecimal("quantidade");
                   Double quantidade = null;
                   if(campoEmBigDec != null) quantidade = campoEmBigDec.doubleValue();*/
                 Cliente cliente = new Cliente(id, nome, cpf);
                 clientes.add(cliente);
                 System.out.println("\tId\tnome\tcpf");
                 System.out.println("\t" + id + "\t" + nome + "\t\t" + cpf);
             }
             return clientes;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            //Após as devidas alterações fechamos a conexão, de preferênciaa dentro de um finally
            closeConexao(conn);
                 
        }
        return null;
     }
     
     public static List<Cliente> insereCliente(){
         Connection conn = getConexaoProf();
         PreparedStatement ps;
         ResultSet rs;
         List<Cliente> clientes = new ArrayList<>();
        try {
            ps = conn.prepareStatement("insert into loja.cliente(nome, cpf) values(?,?)");
            ps.setString(1, "Luciene Souto");
            ps.setString(2, "06763614234");
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            closeConexao(conn);
        }
        return null;
     }
}