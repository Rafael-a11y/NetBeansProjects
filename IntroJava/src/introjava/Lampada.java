package introjava;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MASTER
 */
public class Lampada {
    
    private int voltagem;
    private int potencia;
    private String cor;
    private int luminosidade;
    
    //Criando os métodos
    public void acender(){
        System.out.println("Lâmpada Acesa");
    }
    
    public void apagar(){
        System.out.println("Lâmpada desligada");
    }
    
    public void aquecer(){
        System.out.println("Lâmpada está aquecendo");
    }
    
    public void iluminar(){
        System.out.println("Lâmpada está iluminado");
    }
}
