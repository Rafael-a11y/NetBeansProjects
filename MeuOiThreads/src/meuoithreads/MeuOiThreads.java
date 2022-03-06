package meuoithreads;

public class MeuOiThreads {

    public static void main1(String[] args) {
        final int PRIORIDADE_BAIXA = 2;
        System.out.println("olá da main");
        
        // 1) extender (herdar) da classe Thread
        MinhaThread minhaThread = new MinhaThread();
        minhaThread.setPriority(PRIORIDADE_BAIXA);
        minhaThread.start();
        
        // 2) implementar da interface Runnable
        MinhaRunnable minhaRunnable = new MinhaRunnable();
        Thread thread = new Thread(minhaRunnable);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        
        System.out.println("tchau da main");
    }
    
    public static void main2(String[] args) throws InterruptedException {
        System.out.println("inicio do main");
        MinhaRunnable minha = new MinhaRunnable();
        minha.quemEuQueroEsperar = Thread.currentThread();
        Thread linhaExec1 = new Thread(minha, "Linha1");
        Thread linhaExec2 = new Thread(new MinhaRunnable(), "\tLinha2");
        linhaExec1.start();
        linhaExec2.start();
        linhaExec2.join();
        System.out.println("término do main");
    }
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws InterruptedException {
        FundoInvestimento fundoInvestimento2021 = new FundoInvestimento(16);
        
        //Thread t = new Thread(fundoInvestimento2021, "Equipe 1");
        //t.start();
        
        Thread[] threads = new Thread[16];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(fundoInvestimento2021, "Equipe " + i);
            //threads[i].setName(null);
            threads[i].start();
        }
        
        
        
        
        
        
        
        
        
        //t.join();
        //System.out.println("Orçamento remanescente " + fundoInvestimento2021.getSaldo());
    }
    
}
