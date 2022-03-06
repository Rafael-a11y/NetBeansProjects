/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.bsb.programacao3.visao;

import br.estacio.bsb.programacao3.visao.swing1.ClienteFrame;
import javax.swing.JFrame;

/**
 *
 * @author MASTER
 */
public class InterfaceSwingJanelao extends InterfaceUsuario{
    
     @Override
    public void executar() {
         ClienteFrame frame = new ClienteFrame();
         //DEFININDO QUE AO FECHAR A JANELA, O PROGRAMA ENCERRA NA MESMA HORA
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //DEFININDO VISIBILIDADE
        frame.setVisible(true);
    }
}
