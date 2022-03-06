package br.estacio.bsb.programacao2.programao.visao;


import br.estacio.bsb.programacao2.programao.visao.swing1.ClienteFrame;

import javax.swing.JFrame;


public class InterfaceSwingJanelao extends InterfaceUsuario {

    @Override
    public void executar() {
        ClienteFrame frame = new ClienteFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
