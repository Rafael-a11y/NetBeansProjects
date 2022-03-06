/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import conexao.ConnectionFactory;
import dto.Agenda;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author iagui
 */
public class AgendaDAO {
    public void inserir(Agenda pAgen) throws Exception
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("INSERT INTO agenda (nome) VALUES (?)");
           stmt.setString(1, pAgen.getNome());
           stmt.executeUpdate();
           
           stmt = con.prepareStatement( "INSERT INTO agenda (telefone) VALUES (?)");
           stmt.setString(1, pAgen.getTelefone());
           stmt.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Contato: " + pAgen.getNome() +" - " + pAgen.getTelefone()
                   + " inserido com sucesso!");
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir contato: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
    
    public void remover (Agenda pAgen) throws Exception
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
           stmt = con.prepareStatement("DELETE FROM agenda WHERE (id = ?)");
           stmt.setInt(1, pAgen.getId());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Contato: " + pAgen.getNome() +" - " + pAgen.getTelefone()
                   + "excluído com sucesso!");
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir contato: " + ex.getMessage());
        }
        finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

       public void pesquisar() throws Exception
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String result = "";
        
        try {
           stmt = con.prepareStatement("SELECT id, nome, telefone FROM agenda");
           rs = stmt.executeQuery();
           
           while(rs.next())
           {
              result += "ID: " + rs.getInt("id")
                      + " - CONTATO: " + rs.getString("nome") + rs.getString("telefone") + "\n"+
                      "======= \n";
              
           }
           JOptionPane.showMessageDialog(null, result);
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir gênero: " + ex.getMessage());
        }
        finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    public void inserir(ArrayList<Agenda> agen) {
       
    }
}
