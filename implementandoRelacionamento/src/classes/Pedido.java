package classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos = new ArrayList<>();
    
    public Pedido(){
        
    }
    
    public Pedido(List<Produto> produtos){
        this.produtos = produtos;
    }
    
    public List<Produto> getProdutos(){
        return this.produtos;
    }
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
}
