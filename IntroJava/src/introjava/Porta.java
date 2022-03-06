/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introjava;

/**
 *
 * @author MASTER
 */
public class Porta {
    private float cumprimento;
    private float largura;
    private float altura;
    
    public Porta(float cumprimento, float largura, float altura){
        this.cumprimento = cumprimento;
        this.largura = largura;
        this.altura = altura;
    }
    public String toString(){
        return "Porta { cumprimento = " + cumprimento + ", largura = " + largura + ", altura = " + altura + "}";
    }
    public float getCumprimento(){
        return cumprimento;
    }
    public void setCumprimento(float novoCumprimento){
        this.cumprimento = novoCumprimento;
    }
    public float getLargura(){
        return largura;
    }
    public void setLargura(float novaLargura){
        this.largura = novaLargura;
    }
    public float getAltura(){
        return altura;
    }
    public void setAltura(float novaAltura){
        this.altura = novaAltura;
    }
    
}
