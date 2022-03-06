
package aplicandosobrescrita.classes;

import aplicandosobrescrita.classes.Empregado;
import aplicandosobrescrita.classes.Chefe;
import java.util.Scanner;

public class AplicandoSobrescrita {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        Empregado empregado = new Empregado(1000);
        Chefe chefe = new Chefe();
        PorComissao porComissao = new PorComissao(0.50f, 10000);
        PorItem porItem = new PorItem(200.0f, 50);
        PorHora porHora = new PorHora(20.0f, 44);
        
        System.out.print("\t\t\t\tAplicar método de pagamento, escolha uma opção"
                + "\n\n1 - Empregado\n\n2 - Chefe\n\n3 - PorComissao\n\n4 - PorItem\n\n5 - PorHora"
                + "\n\n6 - Sair\n\nClique aqui: ");
        opcao = entrada.nextInt();
        switch(opcao){
            case 1 : System.out.println("Salário do empregado: " + empregado.receber()); break;
            case 2 : System.out.println("Salário do chefe: " + chefe.receber()); break;
            case 3 : System.out.println("Salário PorComissao: " + porComissao.receber()); break;
            case 4 : System.out.println("Salário por item: " + porItem.receber()); break;
            case 5 : System.out.println("Salário por hora: " + porHora.receber()); break;
            default : opcao = 6;
        }
        System.out.println("Fim");
        
        
    }
    
}
