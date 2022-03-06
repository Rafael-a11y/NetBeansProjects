package br.estacio.bsb.programacao2.programao.controle;


import br.estacio.bsb.programacao2.programao.modelo.Cliente;
import br.estacio.bsb.programacao2.programao.modelo.ClienteDao;
import java.util.List;


/*
Camada de Controle (o "C" do MVC)

Essa classe é resposável por fazer a ponte entre a visão e o modelo.
*/
public class ClienteControle {
    
    private ClienteDao dao;
    
    public ClienteControle() {
        this.dao = new ClienteDao();
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
