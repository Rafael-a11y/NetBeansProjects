package br.estacio.bsb.programacao2.programao.visao;

import br.estacio.bsb.programacao2.programao.visao.swing2.ListaClientesFrame;
import javax.swing.JFrame;

public class InterfaceSwingListagem extends InterfaceUsuario {

    @Override
    public void executar() {
        ListaClientesFrame frame = new ListaClientesFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
