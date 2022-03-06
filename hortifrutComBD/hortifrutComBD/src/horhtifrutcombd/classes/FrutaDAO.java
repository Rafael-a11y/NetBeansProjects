package horhtifrutcombd.classes;

import hortifrutcombd.modelo.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author MASTER*/
public class FrutaDAO {
    public static void salvar(Fruta fruta){
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
    public static void atualizarQuantidade(Fruta fruta){
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
    public static List<Fruta> selecionarTodos(){
        String sql = "SELECT* FROM fruta;";
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
    public static void deletar(Fruta fruta){
        if(fruta.getId() < 1 || fruta == null){
            System.out.println("Não foi possível excluir a fruta");
            return;
        }
        String sql = "delete from frutaria.tb_fruta where nome = ?;";
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                ps.setString(1, fruta.getDescricao());
                ps.executeUpdate();
                System.out.println("Fruta excluída com sucesso");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static Fruta searchByName(String nome){
        Fruta fruta = new Fruta();
        String sql = "select id, descricao, quantidade from frutaria.fruta where descricao like ?";
        try(Connection conn = ConnectionFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
            ps.setString(1, "'%" + nome + "%'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               fruta.setId(rs.getInt("id"));
               fruta.setDescricao(rs.getString("descricao"));
               fruta.setQuantidade(rs.getInt("quantidade"));
        }
            ConnectionFactory.closeConexao(conn, ps, rs);
            return fruta;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Fruta searchById(int id ){
        String sql = "select id, descricao, quantidade from frutaria.fruta where id = ?;";
        Fruta fruta = null;
        try(Connection conn = ConnectionFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fruta = new Fruta(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
            ConnectionFactory.closeConexao(conn, ps, rs);
            return fruta;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}