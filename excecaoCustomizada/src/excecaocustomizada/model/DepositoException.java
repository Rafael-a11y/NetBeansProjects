package excecaocustomizada.model;


public class DepositoException extends Exception{
    
    private int valorLimite;
    private int soma;

    public DepositoException(int valorLimite, int soma) {
        this.valorLimite = valorLimite;
        this.soma = soma;
    }

    public int getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(int valorLimite) {
        this.valorLimite = valorLimite;
    }

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }
    
    

    @Override
    public String toString() {
        return "DepositoException: O valor de saldo mais depósito supera o limite disponível " + valorLimite + ", " + this.soma;
    }
    
    
}
