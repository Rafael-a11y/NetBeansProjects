
package excecaocustomizada.model;

public class ContaExcecao extends Exception{
    
    private int valorSaldo;
    private int valorSaque;

    public ContaExcecao(int valorSaldo, int valorSaque) {
        this.valorSaldo = valorSaldo;
        this.valorSaque = valorSaque;
    }

    public int getValorSaque() {
        return valorSaque;
    }

    public void setValorSaque(int valorSaque) {
        this.valorSaque = valorSaque;
    }

    public int getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(int valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    @Override
    public String toString() {
        return "O valor disponível é menor que o valor de saque -> " + valorSaldo + ", " + valorSaque + '.';
    }
    
}
