package excecaocustomizada.model;
public class Conta {
    private String cliente;
    private String cpf;
    private String numConta;
    private int saldo;
    private int limite;
    
    public Conta(String cliente, String cpf, String numConta, int saldo, int limite) {
        this.cliente = cliente;
        this.cpf = cpf;
        this.numConta = numConta;
        this.saldo = saldo;
        this.limite = limite;
    }
    
    public void sacar(int valorSaque) throws ContaExcecao{
        
        if(this.saldo >= valorSaque){
            this.saldo -= valorSaque;
        }
        else{
            throw new ContaExcecao(saldo, valorSaque);
        }
    }
    
    public void depositar(int valorDeposito) throws DepositoException{
        if((this.saldo += valorDeposito) <= this.limite){
            this.saldo += valorDeposito;
        }
        else{
            throw new DepositoException(limite, this.saldo + valorDeposito);
        }
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "cliente=" + cliente + ", cpf=" + cpf + ", numConta=" + numConta + ", saldo=" + saldo + ", limite=" + limite + '}';
    }
    
    
}
