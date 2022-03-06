
import exercícosaula05.classes.Empregado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*@author MASTER*/
public class EmpregadoTest {
    public static void main(String[] args) {
        List<Empregado> empregados = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcao, mat = 0;
        boolean iterator = false;
        String nome = "";
        System.out.print("\t\tBem vindo\n\n1 - Cadastrar novo empregado\n2 - Listar\n3 - Pesquisar por nome"
                + "\n4 - Pesquisar por matrícula\n5 - Sair");
        opcao = entrada.nextInt();
        iteracao : do{
        switch(opcao){
            case 1 : empregados.add(cadastrarEmpregado()); iterator = true; break;
            case 2 : empregados.stream().forEach(System.out::println);iterator = true; break;
            case 3 : {
                System.out.print("Entre com o nome: ");
                mat = entrada.nextInt();
                pesquisarEmpregado(nome, empregados);
                iterator = true;
                break;
            }
            case 4: {
                System.out.print("Entre com a matrícula: ");
                nome = entrada.next();
                pesquisarEmpregado(mat, empregados);
                iterator = true;
                break;
            }
            default : break iteracao;
        }
    }while(iterator);
        entrada.close();
    }
    private static Empregado cadastrarEmpregado(){
        Empregado emp;
        Scanner entrada1 = new Scanner(System.in);
        String nome = "";
        System.out.print("Entre com o nome: ");
        nome = entrada1.nextLine();
        entrada1.close();
        return emp = new Empregado(nome); 
    }
    private static void pesquisarEmpregado(String nome, List<Empregado> empregados){
        empregados.stream().filter(e -> e.getNome().equals(nome)).forEach(System.out::println);
    }
    private static void pesquisarEmpregado(int matricula, List<Empregado> empregados){
        empregados.stream().filter(e -> e.getMatricula() == matricula).forEach(System.out::println);
    }
}
