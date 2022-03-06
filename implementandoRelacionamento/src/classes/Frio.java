package classes;

public class Frio extends Produto{
    
    public Frio(float preco, float quantidade){
        super(preco, quantidade);
    }
    
     @Override
    public String toString(){
        return "Frio {preco = " + this.preco + ", quantidade = " + this.quantidade + "}";
    }
}
