
package src.main.java.javafxpratico;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PraticaVBox extends Application{
    
    public static void main(String[] args) {
        Application.launch();
     }
    @Override
    public void start(Stage palco) throws Exception{
        VBox caixaVertical = new VBox(); //1
        caixaVertical.setSpacing(5); //2
        caixaVertical.setAlignment(Pos.CENTER); //3
        
        //4
        caixaVertical.setTranslateX(10);
        caixaVertical.setTranslateY(20);
        
        //5
        Rectangle retanguloAzul = new Rectangle(40, 20, Color.BLUE);
        Rectangle retanguloVerde = new Rectangle(40, 20);
        Rectangle retanguloVermelho = new Rectangle(40, 20, Color.RED);
        
        retanguloVerde.setFill(Color.GREEN);
        
        //6
        caixaVertical.getChildren().addAll(retanguloAzul, retanguloVerde, retanguloVermelho);
        Scene cena = new Scene(caixaVertical, 230, 250);
        cena.addEventHandler(EventType.ROOT, new Handler());
        palco.setScene(cena);
        palco.show();
        palco.setTitle("Testando VBox");
    }
    private class Handler implements EventHandler<Event>{

        @Override
        public void handle(Event e) {
            System.out.println("Evento tratado port uma classe estática");
        }
    }
}


/*1. Criando nossa VBox. Não estamos enviando nada no construtor, mas é possível informar o espaçamento entre 
os componentes diretamente no construtor;

2. Informamos o espaçamento. Esse atributo é do tipo Double e ele informa qual distância os componentes devem 
entre eles;

3. Aqui determinamos que os componentes fiquem centralizados no nosso VBox. Podemos também escolher colocar eles
para esquerda, direta, entre outros. Veja o enum Pos.

4. Nessa linha mudamos a posição X e Y do nosso VBox. O interessante é que os componentes filhos terão que 
obedecer a posição do pai, para isso eles também são deslocados automaticamente;

5. Criamos nossos componentes que estarão no VBox. Criamos retângulos e lembrando que eles herdam de Node. Isso 
é um requisito para nosso gerenciador.

6. Agora adicionamos todos de uma vez. A ordem de adicão é a ordem que eles serão mostrados na aplicação.*/
