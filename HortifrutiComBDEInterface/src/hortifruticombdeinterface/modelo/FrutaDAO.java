/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hortifruticombdeinterface.modelo;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
/**
 *
 * @author MASTER
 */
public class FrutaDAO {
    public void salvar(Fruta fruta){
        String sql = "INSERT INTO frutaria.fruta(descricao, quantidade) VALUES(?, ?)";
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                ps.setString(1, fruta.getDescricao());
                ps.setInt(2, fruta.getQuantidade());
                ps.executeUpdate();
                System.out.println("Fruta salva com sucesso");
        }
        catch(SQLException e){
            e.printStackTrace();     
        }
    }
    
    public void excluir(int codigo){
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement ps = conn.prepareStatement("delete from frutaria.fruta where id = ?")){
            ps.setInt(1, codigo);
            ps.executeUpdate();
            }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void atualizarQuantidade(Fruta fruta){
        String sql = "UPDATE fruta SET quantidade = ? WHERE descricao = ?";
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            ps.setInt(1, fruta.getQuantidade());
            ps.setString(2, fruta.getDescricao());
            ps.executeUpdate();
            System.out.println("Quantidade da Fruta atualizada com sucesso");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Fruta> selecionarTodos(){
        String sql = "SELECT* FROM fruta";
        List<Fruta> frutas = new ArrayList<>();
       
        
        try( Connection conn = ConnectionFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                frutas.add(new Fruta(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            return frutas;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
