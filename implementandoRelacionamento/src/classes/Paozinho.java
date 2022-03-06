package classes;

public class Paozinho extends Produto{
    
    public Paozinho(float preco, float quantidade){
        super(preco, quantidade);
    }
    
     @Override
    public String toString(){
        return "Pão {preco = " + this.preco + ", quantidade = " + this.quantidade + "}";
    }
}
