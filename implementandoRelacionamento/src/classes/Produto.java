package classes;

public class Produto {
    protected float preco;
    protected float quantidade;
    
    public  Produto(){
    }
    public Produto(float preco, float quantidade){
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public float getPreco(){
        return preco;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }
    public float getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(float quantidade){
        this.quantidade = quantidade;
    }
    @Override
    public String toString(){
        return "Produto {preco = " + this.preco + ", quantidade = " + this.quantidade + "}";
    }
}
