package meuoithreadsrafael;

public class FundoInvestimento implements Runnable{

    public int saldo;
    
    public FundoInvestimento(int orcamentoDisponivel){
        this.saldo = orcamentoDisponivel;
        System.out.println("Orçamento disponível para investimento: " + this.saldo + ")");
    }
    
    public synchronized void investir(int valorInvestimento){
        try{
            String nomeThread = Thread.currentThread().getName();
        if(this.saldo >= valorInvestimento){
            this.saldo -= valorInvestimento;
            System.out.println("Investimento de " + valorInvestimento + " feito pela equipe " + nomeThread + 
                    " (o novo saldo é " + this.saldo);
            Thread.sleep(20);
        }
        else{
            System.out.println("Não há saldo para a " + nomeThread + " investir (saldo restante " + this.saldo + ')');
        }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
    @Override
    public void run() {
        investir(3);
    }

    public int getSaldo(){
        return this.saldo;
    }
}
