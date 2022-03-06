/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulathreads;

/**
 *
 * @author MASTER
 */
public class ExMultiplasThreads implements Runnable{
    
    String name;
    Thread thread;
    
    public ExMultiplasThreads(String name){
        this.name = name;
        this.thread = new Thread(this, this.name);
        System.out.println("Thread criada: " + this.name);
        this.thread.start();
    }
    
    @Override
    public void run(){
        try{
            for(int i = 0; i< 5; i++){
                System.out.println("NOME: " + this.name + " iteração " + i);
                Thread.sleep(5000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Thread interrompida: " + e.getMessage());
        }
    }
    
}
