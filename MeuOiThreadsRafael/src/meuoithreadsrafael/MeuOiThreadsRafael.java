package meuoithreadsrafael;

public class MeuOiThreadsRafael extends Thread{
    @Override public void run(){
        System.out.println("oi da main");
    }
    public static void main1(String[] args) {
        FundoInvestimento fundoInvestimento2021 = new FundoInvestimento(16);
        Thread[] threads = new Thread[16];
        
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(fundoInvestimento2021, "Equipe " + i);
            threads[i].start();
            
        }
    }
    
    public static void main2(String[] args) {
        final int PRIORIDADE_BAIXA = 2;
        System.out.println("Olá do main ()");
        //1. Estender (herdar) de Thread
        MinhaThread minhaThread = new MinhaThread();
        minhaThread.setName("Rafael");
        minhaThread.setPriority(PRIORIDADE_BAIXA);
        minhaThread.start();
        //2. Implementar da Interface Runnnable
        MinhaRunnable minhaRunnable = new MinhaRunnable();
        Thread thread = new Thread(minhaRunnable, "Israel");
        thread.setPriority(MeuOiThreadsRafael.MAX_PRIORITY);
        thread.start();
         System.out.println("Tchau do main()");
        
    }
    
    public static void main(String[] args) throws InterruptedException{
//        System.out.println("Início da main()");
//        MinhaRunnable minha1 = new MinhaRunnable();
//        minha1.setQuemEuQueroEsperar(Thread.currentThread());
//        System.out.println(minha1.getQuemEuQueroEsperar().getName());
//        //Aqui o main fica esperando o próprio main terminar.
//        minha1.getQuemEuQueroEsperar().join();
//        MinhaThread linhaExecucao1 = new MinhaThread(minha1, "Linha de Execução 1");
//        MinhaRunnable minha2 = new MinhaRunnable();
//        minha2.setQuemEuQueroEsperar(linhaExecucao1);
//        minha2.getQuemEuQueroEsperar().join();
//        MinhaThread linhaExecucao2 = new MinhaThread(minha2, "\tLinha de Execução 2");
//        linhaExecucao2.setandoEuMesmaComoAThreadQueEuQueroQueOMainEspere();
//        linhaExecucao2.getQuemEuQueroEsperar().join();
//        linhaExecucao1.start();
//        linhaExecucao2.start();
//        Thread.currentThread().join();
//      System.out.println("Término da main");
        System.out.println("OI DA MAIN");  
        MinhaThread thread1 = new MinhaThread(new MinhaRunnable(), "Rafael");
        Thread thread = new Thread();
        thread1.setQuemEuQueroEsperar(thread);
//        MinhaThread thread2 = new MinhaThread(new MinhaRunnable(), "Israel");
//        thread1.setQuemEuQueroEsperar(Thread.currentThread());
//        thread1.getQuemEuQueroEsperar().join();
        thread1.start();
        thread.start();
        //Funciona somente depois de startar a thread.
//        thread1.setandoEuMesmaComoAThreadQueEuQueroQueOMainEspere();
        System.out.println("TCHAU DA MAIN");
    }
}















