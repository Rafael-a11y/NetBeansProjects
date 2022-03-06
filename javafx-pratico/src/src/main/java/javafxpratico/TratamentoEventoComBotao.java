package src.main.java.javafxpratico;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;

//Se quisermos que esta classe trate o evento, ela deve herdar de EventHandler<>

public class TratamentoEventoComBotao extends Application implements EventHandler<ActionEvent>{

    public static void main(String[] args) {
        TratamentoEventoComBotao.launch();
    }

    @Override
    public void start(Stage palco) throws Exception {
        VBox raiz = new VBox(20);
        raiz.setAlignment(Pos.CENTER);
        raiz.setTranslateY(30);
        
        Button botao1 = new Button("Clica em mim! (Tratador Externo)");
        Button botao2 = new Button("Clica em mim! (Classe anônima)");
        Button botao3 = new Button("Clica em mim! (Própria Classe)");
        Button botao4 = new Button("Clica em mim! (expressão Lambda com Function)");
        
        //Usamos a classe TratadorEvento para cuidar dos eventos.
        botao1.setOnAction(new TratadorEvento());
         botao1.setTooltip(new Tooltip("Botão gera evento que é tratado por uma classe atributo estática"));
        //Criando uma instância de classe anônima para tratar eventos.
        botao2.setOnAction(new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent evento){
                System.out.println("Evento tratado por uma classe anônima");
            }
        });
        botao2.setTooltip(new Tooltip("Botão que gera um evento que é tratado por um objeto de classe anônima"));
        //O botao3 usa essa própria classe para tratar seus eventos.
        botao3.setOnAction(this);
        botao3.setTooltip(new Tooltip("Botão que gera um evento que é tratado pela própria classe."));
        //O botao4 usa uma lambda para tratar seus eventos.
        botao4.setOnAction((e) -> {System.out.println("Evento tratado por uma lambda");});
        botao4.setTooltip(new Tooltip("Botão que gera um evento que é tratado por uma lambda"));
        raiz.getChildren().addAll(botao1, botao2, botao3, botao4);
        
        Scene cena = new Scene(raiz, 400, 300);
        palco.setTitle("Tratamento de eventos");
        palco.setScene(cena);
        palco.show();
    }
    /* Como a própria classe TratamentoEventoComBotao implementa 
    *  a interface EventHandler, ela mesma pode responder a eventos do botão.*/
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Evento tratado na própria classe.");
    }
    /*Uma classe para tratar os eventos poderia ser uma classe externa.*/
     public static class TratadorEvento implements EventHandler<ActionEvent> { // 1
         @Override
         public void handle(ActionEvent evento) { // 2
          System.out.println("Evento tratado por uma classe externa");
         }
    }
    
    
}
