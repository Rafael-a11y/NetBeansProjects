/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hortifruticombdeinterface.modelo;

/**
 *
 * @author MASTER
 */
public class Fruta {
    private Integer id = 0;
    private String descricao;
    private Integer quantidade;
    
    public Fruta(){}
    public Fruta(String nome, Integer quantidade){
        this.descricao = nome;
        this.quantidade = quantidade;
    }
    public Fruta(Integer id){
        this.id = id;
    }
    public Fruta(Integer id, String nome){
        this.id = id;
        this.descricao = nome;
    }
    public Fruta(Integer id, String nome, Integer quantidade){
        this.id = id;
        this.descricao = nome;
        this.quantidade = quantidade;
    }
     public Integer getId(){
        return this.id;
    }
    public String getDescricao() {
            return descricao;
    }
    public Integer getQuantidade() {
            return quantidade;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }
    public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
    }

@Override
    public String toString() {
        return "Fruta{" + "id = " + id + ", nome = " + descricao + ", quantidade = " + quantidade + '}';
    }
}
