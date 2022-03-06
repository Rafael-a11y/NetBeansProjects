/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.controler;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author MASTER
 */
public class Fluxo extends Thread{
    
    private ObservableList<Integer> obsMultis = FXCollections.observableArrayList();
    private ListView<Integer> list = new ListView<>();
    private Double num;
    
    public Fluxo(ListView<Integer> list,ObservableList<Integer> obs, double num, String name){
        super(name);
        this.list = list;
        this.obsMultis = obs;
        this.num = num;
    }
    @Override 
    public void run(){
        this.obsMultis.add(num.intValue());
        this.list.setItems(obsMultis);
    }
}
