package br.estacio.bsb.programacao2.programao.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
Camada de Modelo (o "M" do MVC)

Nesta camada são definidas e tratadas as regras de negócio e os objetos que 
compõem o sistema.

Neste exemplo, dividimos a camada de modelo em duas:
- entidade: classe para definir a "cara" do dado que manipulamos;
- DAO: esta classe que faz as operações de persistêcia com o banco de dados.

Obs.: DAO = Data Access Object - Objeto de Acesso aos Dados
*/
public class ClienteDao {

    private Connection getConnection() throws SQLException {
        Connection con = ConexaoH2.getConnection();
        assegurarExistenciaTabela(con);
        return con;
    }

    // método para garantir que a tabela "cliente" existe.
    private void assegurarExistenciaTabela(Connection con) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cliente (id identity primary key, nome varchar(20), telefone varchar(20));";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
    }

    private void closeConnection(Connection c1) {
        try {
            if (c1 != null) {
                c1.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        Connection c1 = null;
        try {
            c1 = getConnection();
            Statement st = c1.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE order by upper(nome)");
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection(c1);
        }
        return clientes;
    }

    public void excluir(int codigo) {
        Connection c1 = null;
        try {
            c1 = getConnection();
            PreparedStatement st = c1.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");
            st.setInt(1, codigo);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection(c1);
        }
    }

    public void inserir(Cliente cliente) {
        Connection c1 = null;
        try {
            c1 = getConnection();
            PreparedStatement st = c1.prepareStatement("INSERT INTO CLIENTE (nome, telefone) VALUES(?,?)");
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getTelefone());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection(c1);
        }
    }

    public Cliente buscarPorId(int id) {
        Cliente cliente = null;
        Connection c1 = null;
        try {
            c1 = getConnection();
            Statement st = c1.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE where id = " + id);
            while(rs.next()) {
                cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection(c1);
        }
        return cliente;
    }

    public void alterar(Cliente cliente) {
        Connection c1 = null;
        try {
            c1 = getConnection();
            PreparedStatement st = c1.prepareStatement("UPDATE cliente SET nome=?, telefone=? WHERE id = ?");
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getTelefone());
            st.setInt(3, cliente.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection(c1);
        }
    }

}
