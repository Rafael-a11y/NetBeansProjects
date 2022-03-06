package meuoithreadsrafael;

public class MinhaRunnable implements Runnable{
    private Thread quemEuQueroEsperar;
    @Override public void run(){
        try{
        String nomeThread = Thread.currentThread().getName();
        System.out.println("\tOlá da Runnable " + nomeThread);
        for (int i = 0; i < 5; i++) {
            System.out.println("\t" + nomeThread + ": iteração " + i);
            Thread.sleep(50);
            Thread.yield();
        }
            System.out.println("\tTchau da " + nomeThread);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public Thread getQuemEuQueroEsperar(){
        return this.quemEuQueroEsperar;
    }
    public void setQuemEuQueroEsperar(Thread thread){
        this.quemEuQueroEsperar = thread;
    }
}
