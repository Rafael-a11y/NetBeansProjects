package br.estacio.bsb.programacao2.programao.visao;

/*
Camada de Visão (o "V" do MVC)

Essa classe abstrata é resposável por definir uma forma genérica e padronizada 
de implementar as interfaces.

Neste programa, fizemos 3 implementações diferentes de interfaces:
- uma CLI
- uma GUI em janela única
- uma GUI em duas janelas (listagem e edição)
*/
public abstract class InterfaceUsuario {

    public abstract void executar();
	
}
