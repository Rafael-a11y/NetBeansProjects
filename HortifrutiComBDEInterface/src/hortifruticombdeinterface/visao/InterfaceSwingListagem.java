/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hortifruticombdeinterface.visao;

import hortifruticombdeinterface.visao.swing2.ListaFrutasFrame;
import javax.swing.JFrame;

/**
 *
 * @author MASTER
 */
public class InterfaceSwingListagem extends InterfaceUsuario{
    
    @Override
    public void executar(){
        ListaFrutasFrame frame = new ListaFrutasFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
