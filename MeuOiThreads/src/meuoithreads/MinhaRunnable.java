package meuoithreads;

import java.util.logging.Level;
import java.util.logging.Logger;


class MinhaRunnable implements Runnable {
    public Thread quemEuQueroEsperar;

    @Override
    public void run() {
        String nomeThread = Thread.currentThread().getName();
        System.out.println("olá da runnable " + nomeThread);
        for (int i = 0; i < 5; i++) {
            System.out.println(nomeThread + " " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("tchau da runnable " + nomeThread);
        System.out.println("vou esperar a main");
        if (quemEuQueroEsperar != null) {
            try {
                quemEuQueroEsperar.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
