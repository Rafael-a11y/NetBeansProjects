/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinoexception;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MASTER
 */
public class TreinoException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
//       try{
//       
//            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Entre com o primeiro número: "));
//            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Entre com o segundo número: "));
//            JOptionPane.showMessageDialog(null, "A soma é: " + Math.addExact(num1, num2));}
//       catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Aconteceu um erro");
//       }
        String frase = "";
        String diretorio = "";
        FileWriter arquivo = null;
        PrintWriter escrita = null;
            frase = JOptionPane.showInputDialog("Digite uma frase: ");     
            try{
                arquivo = new FileWriter("C:\\Users\\MASTER\\Documents\\arquivo.txt", true);
                escrita = new PrintWriter(arquivo);
                
                escrita.println(frase);
                JOptionPane.showMessageDialog(null, "Frase escrita com sucesso. Acesse lá para ver");
            }
            catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "A pasta não foi encontrada");
            }
            catch(DirectoryNotEmptyException e){
                JOptionPane.showMessageDialog(null, "Verifique se o diretório está vazio");
            }
            finally{
               arquivo.close();
               escrita.close();
            }
        
    }
    
}
