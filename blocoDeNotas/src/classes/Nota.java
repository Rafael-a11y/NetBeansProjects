
package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Nota implements Comparable<Nota>{
    private String texto;
    private final String data;
    private int contador;
    
    public Nota(){
        this.texto = this.entrada();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("'Recanto ds Emas -> ' dd MMMM YYYY");
        this.data = sdf.format(calendar.getTime());
        this.contador = BlocoDeNotas.getBloco().size();
        
    }
    private String entrada(){
        String texto = "";
        texto = JOptionPane.showInputDialog("Entre com o texto aqui");
        return texto;
    }
    public void alter(String texto){
        this.texto = texto;
    }
    
    @Override
    public String toString(){
        return this.contador + " - " + "Nota -> " + this.data + "\n" + this.texto + "\n\n";
    }
    public int getContador(){
        return this.contador;
    }
    @Override 
    public int compareTo(Nota outraNota){
        Integer cont = Integer.valueOf(this.contador);
        return cont.compareTo(outraNota.contador);
    }
    public void setContador(int contador){
        this.contador = contador;
    }
}
