package src.main.java.javafxpratico;
import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

public class ControlesSimples extends Application{    
    public static void main(String[] args) {
        ControlesSimples.launch();
    }
    
    @Override
    public void start(Stage palco){
        VBox raiz = new VBox(); //1
        raiz.setAlignment(Pos.BASELINE_CENTER); //2
//        raiz.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        
        Label rotuloDemo = new Label("Sou um rótulo de texto!"); //3
        rotuloDemo.setTooltip(new Tooltip("Este é Um Rótulo Para Mostrar Textos De Forma Simples")); //4
        
        TextField campoTexto = new TextField("Digite algo."); //5
        campoTexto.setTooltip(new Tooltip("Campo de texto para entrada de uma só linha"));
        
        TextArea areaTexto = new TextArea("Digite algo com várias linhas"); //6
        areaTexto.setTooltip(new Tooltip("Campo de texto para entrada de múltiplas linhas"));
        
        Separator separadorHorizontal = new Separator(); //7
        Separator separadorVertical = new Separator(Orientation.VERTICAL); //8
        Slider deslizante = new Slider(); //9
        deslizante.setShowTickLabels(true); //10
        deslizante.setShowTickMarks(true); //11
        deslizante.setTooltip(new Tooltip("O controle deslizante tem um valor de acordo com a sua posição"));
        
        raiz.getChildren().addAll(rotuloDemo, campoTexto, areaTexto, separadorVertical, separadorHorizontal, deslizante);
        Scene cena = new Scene(raiz, 300, 400);
        palco.setTitle("Controles Básicos I");
        palco.setScene(cena);
        palco.show();
    }
}


/*1. Nessa linha introduzimos um novo componente pai, ou seja, um componente que podemos colocar outros dentro 
    dele. Nesse caso a VBox, que irá organizar os componentes verticalmente. O construtor informa o espaçamento 
    entre os componentes, no nosso caso 10;

2. Você também pode determinar qual o posicionamento dos componentes dentro da VBox. Você usa o enum Pos para 
    informar qual posicionamento quer. Nessa linha, informamos o posicionamento CENTER, logo todos os 
    componentes serão posicionados no centro da nossa VBox;

3. Esse é nosso primeiro controle de interface apresentado um Label, ou o rótulo. Esse componente nada mais é 
    do que um texto estático, semelhante ao Text, mas herda de Control, o que significa que ele é um controle 
    de interface, no entanto, o usuário não muda o texto do Label diretamente. Como você já deve ter deduzido, 
    o Label é um Node, assim como todos os controles e assim como e qualquer componente dentro da Cena do 
    JavaFX. Pense quão poderoso esse detalhe arquitetural é!

4. Os controles tem algumas características em comum e uma delas é a possibilidade de informar um Tooltip, que 
    nada mais é um texto demostrativo informado quando mantemos o mouse sobre o componente;

5. Nessa linha criamos um campo de texto, o TextField. Esse campo, ao contrário do Label, permite a modificação
    do usuário diretamente. Futuramente você pode recuperar esse texto através do método getText();

6. Semelhante ao campo de texto, temos o uma área de texto. Não há muita diferença entre essas duas classes, 
    na verdade a maior diferença é que o TextArea permite a entrada de várias linhas e também contém 
    propriedades para trabalhar com essa característica. Detalhe que a TextArea e o TextField herdam de 
    TextInputControl;

7. Nessa linha mostramos um separador horizontal. Ele é sem graça assim mesmo, só serve para separar as coisas.
   No entanto, lembre-se que ele é um... Node e também um controle;

8. Aqui também criamos um separador, mas esse fica na vertical conforme informado pelo Enum Orientation;

9. O controle deslizando, ou Slider, permite você escolher um valor numérico dentro de uma faixa determinada. 
   De acordo com a posição do controle, você terá um valor numérico que pode ser recuperado depois através do 
   método getValue();

10. Se você quiser que o controle deslizante mostre marcas para indicação relativa de qual valor o Slider tem 
    no momento, você deve chamar o método setShowTickLabels que vai configurar se devem aparecer essas marcas, 
    ou não (true, false);

11. Na linha anterior, mostramos como colocar marcas, nessa linha chamamos o método setShowTickMarks e 
    informamos que queremos ver números que indicam o valor do controle deslizante.*/