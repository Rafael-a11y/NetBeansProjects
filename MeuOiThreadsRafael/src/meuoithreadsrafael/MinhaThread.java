package meuoithreadsrafael;

public class MinhaThread extends Thread{
    
    MinhaThread(){}
    
    MinhaThread(Runnable run, String name){
        super(run, name);
    }
    private Thread quemEuQueroEsperar;
    
    @Override public void run(){
        try{
            String nomeThread = Thread.currentThread().getName();
        System.out.println("Olá da " + nomeThread);
        getQuemEuQueroEsperar().join();
        for (int i = 0; i < 5; i++) {
            System.out.println(nomeThread + ": iteração " + i);
            Thread.sleep(50);
            Thread.yield();
        }
        System.out.println("tchau da " + nomeThread);
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
    public void setandoEuMesmaComoAThreadQueEuQueroQueOMainEspere(){
        this.quemEuQueroEsperar = this;
    }
}


/*1. Faz com que a thread atual fique em estado de espera.
2. Fica em estado de Runnable e passa a execução do código para outra thread de prioridade igual ou superior
que está na fila pelo lock, se não houver continua a execução, é útil para quando uma thread depende de outra
como numa situação em que uma thread A precisa executar tral linha somente após a thread B passsar por ali.*/
