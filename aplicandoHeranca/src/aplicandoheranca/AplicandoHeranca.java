/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicandoheranca;

import javax.swing.JOptionPane;

/**
 *
 * @author MASTER
 */
public class AplicandoHeranca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Pessoa pessoa = new Pessoa(JOptionPane.showInputDialog("Entre com o nome: "));
//        JOptionPane.showMessageDialog(null, "Nome da pessoa: " + pessoa.getNome());
        
        Pessoa pessoaFisica = new PessoaFisica(JOptionPane.showInputDialog("Entre com o CPF: "),
                JOptionPane.showInputDialog("Entre com o RG: "),
                JOptionPane.showInputDialog("Entre com o NOME: "),
                JOptionPane.showInputDialog("Entre com o CIDADE: "));
        
//        Pessoa pessoaJuridica = new PessoaJuridica(JOptionPane.showInputDialog("Entre com o CNPJ: "),
//                JOptionPane.showInputDialog("Entre com o IE: "),
//                JOptionPane.showInputDialog("Entre com o NOME: "),
//                JOptionPane.showInputDialog("Entre com o CIDADE: "));
              JOptionPane.showMessageDialog(null,  pessoaFisica.gerarRelatorio());
}
}

//JOptionPane.showMessageDialog(null, "RG da pessoa física: " + pessoaFisica.getRg());
//        JOptionPane.showMessageDialog(null, "NOME da pessoa física: " + pessoaFisica.getNome());
//        JOptionPane.showMessageDialog(null, "CIDADE da pessoa física: " + pessoaFisica.getCidade());