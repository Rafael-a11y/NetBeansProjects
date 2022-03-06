/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import modelo.Agente;

/**
 *
 * @author MASTER
 */
public class InterfaceFinal extends InterfaceUsusario {
    
    public void executar(){
        Agente agente = new Agente();
        agente.exibirRelatorio();
    }
}
