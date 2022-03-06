/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hortifruticombdeinterface.controle;

import hortifruticombdeinterface.modelo.Fruta;
import hortifruticombdeinterface.modelo.FrutaDAO;
import java.util.List;

/**
 *
 * @author MASTER
 */
//Faz a ponte entre visao e modelo
public class FrutaControle {
    private FrutaDAO dao;
    public FrutaControle(){
        this.dao = new FrutaDAO();
    }
    public List<Fruta> selecionarTodos(){
        return this.dao.selecionarTodos();
    }
    public void salvar(Fruta fruta){
        dao.salvar(fruta);
    }
    public void salvar(Integer codigo, String descricao, Integer quantidade){
        Fruta fruta = new Fruta();
        fruta.setId(codigo);
        fruta.setDescricao(descricao);
        fruta.setQuantidade(quantidade);
        this.salvar(fruta);
    }
    public void atualizarQuantidade(Fruta fruta){
        dao.atualizarQuantidade(fruta);
    }
    
    public void excluir(Integer codigo){
        dao.excluir(codigo);
    }
}
