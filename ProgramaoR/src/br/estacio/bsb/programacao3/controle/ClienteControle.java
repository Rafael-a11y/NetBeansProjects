/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.bsb.programacao3.controle;

import br.estacio.bsb.programacao3.modelo.Cliente;
import br.estacio.bsb.programacao3.modelo.ClienteDAO;
import java.util.List;

/**
 *
 * @author MASTER
 */
public class ClienteControle {
    
     private ClienteDAO dao;
    
    public ClienteControle() {
        this.dao = new ClienteDAO();
    }

    public List<Cliente> listarTodos() {
        return dao.listarTodos();
    }

    public void inserir(Cliente cliente) {
        dao.inserir(cliente);
    }

    public void inserir(String nome, String telefone) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        this.inserir(cliente);
    }

    public void alterar(int codigo, String nome, String telefone) {
        Cliente cliente = new Cliente();
        cliente.setId(codigo);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        this.alterar(cliente);
    }

    public void alterar(Cliente cliente) {
        dao.alterar(cliente);
    }

    public void excluir(Integer codigo) {
        dao.excluir(codigo);
    }

    public Cliente buscarClientePorId(Integer codigo) {
        return dao.buscarPorId(codigo);
    }
}
