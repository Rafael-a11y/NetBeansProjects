package meuoithreads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FundoInvestimento implements Runnable {
    
    private int saldo;
    
    public FundoInvestimento(int orcamentoDisponivel) {
        this.saldo = orcamentoDisponivel;
        System.out.println("Orçamento disponível para investimento: " + this.saldo + ")");
    }
    
    public synchronized void investir(int valorInvestimento) {
        try {
            String nomeThread = Thread.currentThread().getName();
            if (this.saldo >= valorInvestimento) {
                this.saldo -= valorInvestimento;
                //this.saldo = this.saldo - valorInvestimento;
                System.out.println("Investimento de " + valorInvestimento + 
                        " feito pela " + nomeThread + " (o novo saldo é " + this.saldo);
                Thread.sleep(20);
            } else {
                System.out.println("Não há saldo para a " + nomeThread + " investir (saldo restante " + this.saldo + ")");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FundoInvestimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        investir(3);
    }

    public int getSaldo() {
        return this.saldo;
    }
}
