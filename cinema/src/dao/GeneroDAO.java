/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Genero;
import conexao.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MASTER
 */
public class GeneroDAO {

    public void inserir(Genero pGen) throws Exception{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("insert into generos(nome) values(?)");
            stmt.setString(1, pGen.getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Gênero: " + pGen.getNome() + " inserido com sucesso!");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir gênero " + ex.getMessage());
        }
        finally{
            ConnectionFactory.fecharConexao(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
    
    public void deletar(Genero pGen) throws Exception{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("delete from generos where (idgeneros = ?)");
            stmt.setInt(1, pGen.getIdGenero());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Gênero: " + pGen.getNome() + " excluído com sucesso!");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir gênero " + ex.getMessage());
        }
        finally{
            ConnectionFactory.fecharConexao(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
    
    public List<Genero> pesquisar() throws Exception{
        List<Genero> generos = new ArrayList<>();
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String result = "";
        try{
            stmt = con.prepareStatement("select idgeneros, nome from generos");
            rs = stmt.executeQuery();
            while(rs.next()){
                generos.add(new Genero(rs.getInt("idgeneros"), rs.getString("nome")));
            }
            return generos;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir gênero " + ex.getMessage());
        }
        finally{
            ConnectionFactory.fecharConexao(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);
        }
        return null;
    }
    
    public void alterar(Genero genero) throws Exception{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("update generos set nome = ? where id = ?");
            stmt.setString(1, genero.getNome());
            stmt.setInt(2, genero.getIdGenero());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro alteraddo com sucesso!");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar gênero " + ex.getMessage());
        }
        finally{
            ConnectionFactory.fecharConexao(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
}
