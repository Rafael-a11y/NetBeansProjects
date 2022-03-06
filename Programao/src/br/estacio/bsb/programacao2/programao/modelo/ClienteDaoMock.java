package br.estacio.bsb.programacao2.programao.modelo;

import java.util.ArrayList;
import java.util.List;

/*
Um mock é uma classe que "finge" ser uma classe de verdade.

Ela serve para poupar tempo de implementação enquanto queremos experimentar 
algum conceito ou funcionalidades.
*/
public class ClienteDaoMock {
    
    private List<Cliente> clientesMock = new ArrayList<>();
 
    public List<Cliente> listarTodos() {
        return clientesMock;
    }

    public void excluir(int codigo) {
        // TODO
    }

    public void inserir(Cliente cliente) {
        clientesMock.add(cliente);
    }

    public Cliente buscarPorId(int id) {
        return new Cliente(2, "Maria", "22222");
    }

    public void alterar(Cliente cliente) {
        // TODO
    }

    public ClienteDaoMock() {
        clientesMock.add(new Cliente(1, "João", "111111"));
        clientesMock.add(new Cliente(2, "Maria", "22222"));
        clientesMock.add(new Cliente(3, "Zeca", "3333333"));
    }
   
}
