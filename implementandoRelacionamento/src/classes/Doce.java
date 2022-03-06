package classes;

public class Doce extends Produto{
    
    public Doce(float preco, float quantidade){
        super(preco, quantidade);
    }
     @Override
    public String toString(){
        return "Doce {preco = " + this.preco + ", quantidade = " + this.quantidade + "}";
    }
}
