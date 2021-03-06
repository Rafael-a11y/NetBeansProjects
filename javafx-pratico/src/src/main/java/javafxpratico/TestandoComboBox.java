package src.main.java.javafxpratico;

import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TestandoComboBox extends Application{

    String cores[] = {"Blue", "Black", "Red", "White", "Green", "Yellow", "Gray", "Pink", "Salmon"};
    @Override
    public void start(Stage palco) throws InvocationTargetException{
        StackPane raiz = new StackPane();
        
        HBox opcoes = new HBox(10);
        opcoes.setAlignment(Pos.CENTER);
        
        final Rectangle retangulo = new Rectangle(300, 100);
        final Rectangle fundo = new Rectangle(450, 250);
        
        ComboBox<String> cbCorCena = new ComboBox<>(); //1
        ComboBox<String> cbCorRetangulo = new ComboBox();
        
        cbCorCena.getItems().addAll(cores); //2
        cbCorRetangulo.getItems().addAll(cores);
        
        opcoes.getChildren().addAll(cbCorCena, cbCorRetangulo);
        
        raiz.getChildren().addAll(fundo, retangulo, opcoes);
        
        final Scene cena = new Scene(raiz, 450, 250);
        palco.setTitle("Uso de ComboBox");
        palco.setScene(cena);
        palco.show();
        //3
        cbCorCena.getSelectionModel().selectedItemProperty().addListener((valorObservado, valorAntigo, valorNovo)
            -> {
                    //4
                    fundo.setFill(Color.valueOf(valorNovo));});
        
        cbCorRetangulo.getSelectionModel().selectedItemProperty().addListener((valorObservado, valorAntigo, valorNovo)
            -> {
                    retangulo.setFill(Color.valueOf(valorNovo));});
        
        cbCorCena.getSelectionModel().select(0); //5
        cbCorRetangulo.getSelectionModel().select(1);
    }
    
    public static void main(String[] args) {
        try{
            launch();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }   
}


/*1. Come??amos instanciando uma ComboBox. Perceba que ela faz uso de gen??ricos, onde informamos que tipo de 
dado ser??o os itens contidos nela, no nossa caso, String;

2. Nessa linha adicionamos os itens. Isso ?? feito de forma semelhante com a qual adicionamos itens a um 
componente pai como o Group, VBox, HBox, entre outros. Nesse caso estamos adicionando uma lista de Strings,
pois esse ?? o tipo aceitado por essa combobox;

3. Para observar quando o usu??rio escolhe algum valor no Combobox, adicionamos um ouvinte ao valor observ??vel 
da propriedade do item selecionado. Isso pode parecer bastante estranho, mas em breve voc?? vai se acostumar. 
JavaFX traz uma API com atributos diferentes, onde n??s podemos observar as modifica????es feitas nesses 
atributos e tomar alguma a????o. Novamente isso ?? feito atrav??s de Listeners, no nosso caso usamos um 
listener de mudan??a, o ChangeListener. Note que o uso dele ?? bastante semelhante ao uso dos listeners de 
bot??es. Em resumo, n??s estamos observando o valor selecionado do combox atrav??s de um listener, quando ele 
muda, n??s trocamos a cor de fundo da cena e usamos a sintaxe das express??es lambda para simplificar;

4. A classe Color do JavaFX ?? bastante interessante e cont??m muito mais do que um aglomerado de constantes 
para definir cores. ?? poss??vel tamb??m converter o valor de texto de uma cor para um objeto Color. ?? isso o 
que fazermos aqui;

5. Por fim n??s usamos o m??todo select do modelo de sele????o para escolher uma cor. Esse m??todo equivale a a????o 
de um usu??rio ao escolher uma cor na combobox usando a sua aplica????o, ou seja, isso tamb??m vai disparar o 
ouvinte de mudan??a que falamos na explica????o 3.*/
