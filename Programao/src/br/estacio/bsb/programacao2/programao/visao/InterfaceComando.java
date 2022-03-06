package br.estacio.bsb.programacao2.programao.visao;


import br.estacio.bsb.programacao2.programao.controle.ClienteControle;
import br.estacio.bsb.programacao2.programao.modelo.Cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InterfaceComando extends InterfaceUsuario {

    @Override
    public void executar() {
        ClienteControle controle = new ClienteControle();
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int opcao = 0;
        do {
            controle.listarTodos().forEach((cliente) -> {
                System.out.println(cliente.getId() + " :: " + cliente.getNome() + " :: " + cliente.getTelefone());
            });
            System.out.println("1-Incluir 2-Excluir 0-Sair");
            try {
                opcao = new Integer(teclado.readLine());
                if (opcao == 1) {
                    Cliente cliente = new Cliente();
                    System.out.println("Nome:");
                    cliente.setNome(teclado.readLine());
                    System.out.println("Telefone:");
                    cliente.setTelefone(teclado.readLine());
                    controle.inserir(cliente);
                }
                if (opcao == 2) {
                    System.out.println("Id do cliente que deverá excluído:");
                    controle.excluir(new Integer(teclado.readLine()));
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        } while (opcao != 0);
    }
  
}
