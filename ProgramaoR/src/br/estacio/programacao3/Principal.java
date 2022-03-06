package br.estacio.programacao3;

import br.estacio.bsb.programacao3.visao.InterfaceComando;
import br.estacio.bsb.programacao3.visao.InterfaceSwingJanelao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MASTER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//          // meu programa em CLI - linha de comando
//        InterfaceComando programaCli = new InterfaceComando();
//        programaCli.executar();
        
//      meu programa em GUI com janelão
        InterfaceSwingJanelao programaSwJanelao = new InterfaceSwingJanelao();
        programaSwJanelao.executar();
//        
//        // meu programa em GUI com duas janelas
//        InterfaceSwingListagem programaSwListagem = new InterfaceSwingListagem();
//        programaSwListagem.executar();
    }
    
}
