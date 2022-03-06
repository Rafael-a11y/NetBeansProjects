package hortifrutcombd;
import horhtifrutcombd.classes.FrutaDAO;
import hortifrutcombd.modelo.Fruta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/*@author MASTER
Para criar o BD no MySQL:

create database if not exists frutaria;
use frutaria;
CREATE TABLE fruta(
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 descricao VARCHAR(45) NOT NULL,
 quantidade INT NOT NULL,
 INDEX id (id ASC) VISIBLE);
show tables;
select* from fruta;*/
public class Aplicaco {
    private static Scanner entrada = new Scanner(System.in);
    private static List<Fruta> frutas1 = FrutaDAO.selecionarTodos();
	private static void listarFrutas() {
		frutas1.stream().forEach(System.out::println);
	}
	private static List<Fruta> getFrutas(){
		return frutas1;
	}
	private static Fruta criarFruta() {
		String descricao = "";
		int quantidade = 0;
		System.out.println("Entre com descrição (nome) da fruta: ");
		descricao = entrada.nextLine();
		System.out.println("Agora entre com a quantidade: ");
		quantidade = entrada.nextInt();
		return new Fruta(descricao, quantidade);
	}
	private static void addFruta() {
		Fruta frutap = criarFruta();
		if(frutas1.stream().anyMatch(e -> e.getDescricao().equals(frutap.getDescricao()))) {
			int count = frutap.getQuantidade();
			frutas1.stream().filter(e -> e.getDescricao().equals(frutap.getDescricao()))
                                .forEach(e -> {e.setQuantidade(e.getQuantidade() + count);
                                FrutaDAO.atualizarQuantidade(e);});
		}
		else {
                    FrutaDAO.salvar(frutap);
		}
	}
        private static void deletar(){
            Fruta fruta = new Fruta();
            System.out.println("Entre com id da fruta:");
            fruta.setId(entrada.nextInt());
            if(frutas1.stream().anyMatch(e -> e.getId() == fruta.getId())){
                FrutaDAO.deletar(fruta);
            }
        }
        private static void buscaPorNome(){
            System.out.println("Entre com o nome da fruta: ");
            String nome = entrada.nextLine();
            System.out.println(FrutaDAO.searchByName(nome));
            
        }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		boolean continueLoop = true;
		List<Fruta> frutas = new ArrayList<Fruta>();
		iteracao : do {
			try {
				System.out.print("\n1 - Para adicionar uma nova fruta junto de sua quantidade\n"
						+ "2 - Para somente listar as frutas\n3 - deletar umafruta\n4 - "
                                        + "Buscar por nome\n5 - Buscar por id\n6 - sair\nclique aqui: ");
				opcao = entrada.nextInt();
				switch(opcao) {
				case 1 : addFruta(); break;
				case 2 : { frutas1 = FrutaDAO.selecionarTodos();System.out.println();getFrutas().stream().forEach(System.out::println);}break;
                                case 3 : deletar();break;
                                case 4 : buscaPorNome();break;
				default : System.out.println("Saindo");entrada.close(); break iteracao;
				}
			}
			catch(Exception e) {
				System.out.println("\nAconteceu algo de errado\n");
                                e.printStackTrace();
			}
		}while(continueLoop);
    }   
}