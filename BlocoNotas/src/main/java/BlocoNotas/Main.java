package BlocoNotas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

public static void main(String[] args, String novaNota) {
      
    
            
 List<Nota> notas = new ArrayList<Nota>();
    
 for (int i = 0; i < 10; i++){
        
 }
 
 String textoNovo = JOptionPane.showInputDialog("Escreva a nota:");
 notas.get(0).setTexto(novaNota);
 notas.get(0).setTipo(novaNota);
 
  notas.add(new Nota(novaNota));
 
 }
}
