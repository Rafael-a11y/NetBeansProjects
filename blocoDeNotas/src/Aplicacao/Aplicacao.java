
package Aplicacao;

import classes.BlocoDeNotas;
import classes.Nota;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Aplicacao {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        try{
            externo : while(true){
                opcao = JOptionPane.showInputDialog("1 - Para adicionar uma nova nota\n2 - Para alterar uma nota"
                + "\n3 - Para listar as notas\n4 - Para excluir uma nota\nn - sair\nEscolha uma das Opções: ");
                switch(opcao){
                    case "1" : add(); break;
                    case "2" : alterarSimplista (JOptionPane.showInputDialog("Mostre o índice")); break;
                    case "3" : BlocoDeNotas.getBloco().forEach(n -> System.out.println(n.toString()));System.out.println("____________"
                            + "___________________________________________________________________________________________"); break;
                    case "4" : excluir(JOptionPane.showInputDialog("Digite o índice")); break;
                    default : ;  break externo;
                }
            }
        }
        catch(Exception e){
            System.out.println("Ocorreu um erro: " + e);
        }
        
    }
    private static void add(){
        BlocoDeNotas.getBloco().add(new Nota());
    }
    private static void alterar(String indice){
        int ind = Integer.parseInt(indice);
        BlocoDeNotas.getBloco().get(ind).alter(JOptionPane.showInputDialog("Insira o novo texto"));
    }
    private static void alterarSimplista(String indice){
        int ind = Integer.parseInt(indice);
        BlocoDeNotas.getBloco().get(ind).alter(JOptionPane.showInputDialog("Digite a nova anotação"));
    }
    private static void excluir(String indice){
        int ind = Integer.parseInt(indice);
        Nota nota = BlocoDeNotas.getBloco().remove(ind);
        BlocoDeNotas.getBloco().forEach(e -> {if (e.getContador() > nota.getContador()){
            e.setContador(e.getContador() - 1);
        }});
    }
    public final static void clearConsole(){

        try{
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");

            }else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){
        //  Tratar Exceptions
        }
    }
}
