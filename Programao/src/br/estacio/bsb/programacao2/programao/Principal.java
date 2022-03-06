package br.estacio.bsb.programacao2.programao;


import br.estacio.bsb.programacao2.programao.visao.InterfaceComando;
import br.estacio.bsb.programacao2.programao.visao.InterfaceSwingJanelao;
import br.estacio.bsb.programacao2.programao.visao.InterfaceSwingListagem;


public class Principal {

    public static void main(String[] args) {
        // meu programa em CLI - linha de comando
        InterfaceComando programaCli = new InterfaceComando();
        programaCli.executar();
        
        // meu programa em GUI com janelão
        InterfaceSwingJanelao programaSwJanelao = new InterfaceSwingJanelao();
        programaSwJanelao.executar();
        
        // meu programa em GUI com duas janelas
        InterfaceSwingListagem programaSwListagem = new InterfaceSwingListagem();
        programaSwListagem.executar();
    }
    
}
