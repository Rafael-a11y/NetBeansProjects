package meuoithreads;

import java.util.logging.Level;
import java.util.logging.Logger;

class MinhaThread extends Thread {
    
    @Override
    public void run() {
        String nomeThread = Thread.currentThread().getName();
        System.out.println("Olá da " + nomeThread);
        for (int i = 0; i < 5; i++) {
            System.out.println(nomeThread + ": iteração " + i);
            try {
                Thread.sleep(50);
                Thread.yield();
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("tchau da " + nomeThread);
    }
    
}
