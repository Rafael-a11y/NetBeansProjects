
package dao;

import conexao.ConnectionFactory;
import dto.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
public class ContatoDAO {

    public void pesquisar(){
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement stmt = conn.prepareStatement("select* from agenda;");
                ResultSet rs = stmt.executeQuery()){
            String resultado = "";
            while(rs.next()){
                resultado += "Id: " + rs.getInt("id") + " - Nome: " + rs.getString("nome") + " - Telefone: " + 
                        rs.getString("telefone") + " \n====================\n";
            }
            JOptionPane.showMessageDialog(null, resultado);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar pesquisar: " + e.getMessage());
        }
    }
    public void insercao(Contato pCont){
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement stmt = conn.prepareStatement("insert into agenda(nome, telefone) values(?, ?);")){
            stmt.setString(1, pCont.getNome());
            stmt.setString(2, pCont.getTelefone());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserção efetuada com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer inserção: " + e.getMessage());
        }
    }
    
    public void atualizacao(Contato PCont){
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement stmt = conn.prepareStatement("update agenda set nome = ?, telefone = ? where id = ?;")){
            stmt.setString(1, PCont.getNome());
            stmt.setString(2, PCont.getTelefone());
            stmt.setInt(3, PCont.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar atualização: " + e.getMessage());
        }
    }
    
    public void deletar(int id){
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement stmt = conn.prepareStatement("delete from agenda where id = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleção efetuada com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar a exclusão: " + e.getMessage());
        }
    }
    public List<Contato> getContatos(){
        List<Contato> contatos = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement ps = conn.prepareStatement("select* from agenda;");
                ResultSet rs = ps.executeQuery()){
            while(rs.next()) contatos.add(new Contato(rs.getInt("id"),
                    rs.getString("nome"), rs.getString("telefone")));
            return contatos;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar"
                    + " os contatos do Banco");
        }
        return null;
    }
    
    public Contato getContatoById(int id) {
        Contato contato = new Contato();
        ResultSet rs = null;
        try(Connection conn = ConnectionFactory.getConexao();
                PreparedStatement pstm = conn.prepareStatement("select* from agenda where"
                        + " id = ?");){
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
            }
            return contato;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Contato" + e.getMessage());
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.fecharConexao(rs);
        }
        return null;
	}
}
