/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinoexception;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author MASTER
 */
public class Aplication {
    public static void main(String[] args) {
       try{
            Produto[] produtos = new Produto[5];
            for(int i = 0; i < produtos.length + 1; i++){
            produtos[i] = new Produto("Arroz", "muito bom", 10.00F);
            }
            for(int i = 0; i < produtos.length + 1; i++){
                System.out.println(produtos.toString());
            }
        }
       catch(ArrayIndexOutOfBoundsException e){
           JOptionPane.showMessageDialog(null, e.toString(), "Errinho hehe", 1);
       }
    }
}
