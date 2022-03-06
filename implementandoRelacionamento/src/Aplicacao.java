
import classes.Doce;
import classes.Frio;
import classes.Paozinho;
import classes.Pedido;
import java.awt.HeadlessException;
import java.util.Scanner;
import javax.swing.JOptionPane;




 
public class Aplicacao {

    
    public static void main(String[] args) {
        String objeto;
        boolean loop = true;
        int opcao;
        Scanner entrada = new Scanner(System.in);
        Frio frio = new Frio(10.0F, 1.0F);
        Paozinho paozinho = new Paozinho(2, 10);
        Doce doce = new Doce(15F, 2F);
        Pedido pedido = new Pedido();
        pedido.getProdutos().add(frio);
        pedido.getProdutos().add(paozinho);
        pedido.getProdutos().add(doce);
        try{
            while(loop){
                opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Lista a coleção\n2 - Insere"
                        + " um novo produto\n3 - sair"));
                switch(opcao){
                    case 1 : pedido.getProdutos().stream().forEach( p -> JOptionPane.showMessageDialog(null, p));break;
                    case 2 : {objeto = JOptionPane.showInputDialog("1 - Paozinho\n2 - Doce\n3 - Frio\nClique aqui: ");
                        switch(objeto){
                            case "1" : pedido.getProdutos().add(new Paozinho(Float.parseFloat(JOptionPane.showInputDialog("Entre com o preço: ")), Float.parseFloat(JOptionPane.showInputDialog("Entre com a quantidade: "))));break;
                            case "2" : pedido.getProdutos().add(new Doce(Float.parseFloat(JOptionPane.showInputDialog("Entre com o preço: ")), Float.parseFloat(JOptionPane.showInputDialog("Entre com a quantidade: "))));break;
                            case "3" : pedido.getProdutos().add(new Frio(Float.parseFloat(JOptionPane.showInputDialog("Entre com o preço: ")), Float.parseFloat(JOptionPane.showInputDialog("Entre com a quantidade: "))));break;
                            default : JOptionPane.showMessageDialog(null, "Tipo Incompatível");
                        }
                        break;
                    }
                    case 3 : loop = false;
                }
            }
        }
        catch(HeadlessException | NumberFormatException e ){
            System.out.println(e + "Ocorreu um erro do tipo ");
        }   
    }
}
