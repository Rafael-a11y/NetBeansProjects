/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introjava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MASTER
 */
public class TrabalhandoComArray{
    public static void main(String[] args){
        
        double nota0 = 10.0;
        double nota1 = 8.0;
        double nota2 = 8.0;
        double nota3 = 8.0;
        double nota4 = 8.0;
        double mediaTotal = 0;
        double[] arrayDeNotas = {nota0, nota1, nota2, nota3, nota4};
        for(double elemento : arrayDeNotas){
            mediaTotal += elemento;
        }
        System.out.println("médias total: " + mediaTotal / arrayDeNotas.length);
        List<Double> lista = new ArrayList<>();
        lista.stream().count
    }
}
