package src.main.java.javafxpratico;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class TratadorEvento implements EventHandler<ActionEvent> { //1

    @Override
    public void handle(ActionEvent evento){ //2
        System.out.println("Evento tratado por uma classe externa!");
    }
    
}


/*1. Conforme já falamos, a classe destinada a tratar eventos deve implementar a Interface EventHandler. Nesse 
     caso também fica claro o uso de Genéricos, onde devemos informar um tipo de classe que herda de Event, no caso informamos o ActionEvent, pois é o que o botão requer;

2. Esse é o método que será chamado quando clicarmos no botão.O parâmetro evento será enviado pelo gerador do 
   evento, no caso o botão, e deles poderíamos saber tudo de quem gerou o evento.*/
