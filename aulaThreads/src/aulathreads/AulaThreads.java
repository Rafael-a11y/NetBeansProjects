package aulathreads;


public class AulaThreads extends Thread {

    @Override
    public void run(){
        System.out.println("Executando uma thread!");
    }
          
   
    public static void main(String[] args) {
        AulaThreads t1 = new AulaThreads();
        ExemploRunnable er = new ExemploRunnable();
        t1.start();
        new Thread(er).start();
        ExMultiplasThreads eMT = new ExMultiplasThreads("Thread Rafael");
        ExMultiplasThreads eMT2 = new ExMultiplasThreads("Thread Israel");
        ExMultiplasThreads eMT3 = new ExMultiplasThreads("Thread Tirza");
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Saindo da Thread main!");
    }
    
}
