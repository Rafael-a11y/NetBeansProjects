package src.main.java.javafxpratico;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class OlaMundoJavaFX extends Application {//1

    public static void main(String[] args) {
        launch();//2
    }
/*Stage é como o JFrame,
    Label é como o JLabel,
    StackPane é como um JPanel setado com um Layout Manager StackLayout
    geChildren() retorna um ObservableList<Node> que adiciona o Label
    Scene recebe no construtor o StackPane, é como o janela.getContentPane().add(painelFundo);
    palco.show() é como o janela.setVisible();
    Scene também define o tamanho da janela, como o janela.setSize();*/
    @Override
    public void start(Stage palco) throws IOException {//3
        StackPane raiz = new StackPane();//4
        Label lbMensagem = new Label();//5
        
        lbMensagem.setText("Estou aprendendo JavaFX!");//6
        raiz.getChildren().add(lbMensagem);//7
        
        Scene cena = new Scene(raiz, 250, 100);//8
        palco.setTitle("Aprendendo JavaFX");//9
        palco.setScene(cena);//10
        palco.show();//11
    }
}


/*1. Perceba que a classe principal herda de javafx.application.Application. TODA classe principal de JavaFX 
    deve herdar de Application e implementar o método start;

2. No método main chamamos o método lunch para começar a nossa aplicação. Aqui não vai código JavaFX, o código 
    vai no método start (notem que no JavaFX 8 isso é mais necessário, abaixo mais detalhes);

3. A implementação do método start, herdado da classe Application. O atributo recebido é do tipo 
    javafx.stage.Stage. Sendo direto, podemos ver o Stage (palco) como o frame, a janela da nossa aplicação, 
    mas na verdade ele não pode ser representado sim se pensarmos nos diversos dispositivos que podem 
    rodar(em um futuro próximo) JavaFX: Celulares, televisores, "tablets", etc;

4. Nesse ponto nós criamos um elemento chamado "pai", pois permite adicionarmos outras coisas dentro dele. No 
    nosso caso, o javafx.scene.layout.StackPane permite adicionar vários elementos os quais tem seu layout de 
    pilha, ou seja, eles serão empilhados um sobre o outro. No futuro falaremos mais sobre isso, mas lembre-se 
    que tudo no JavaFX é um nó, ou seja, herda da classe Node;

5. Não há nada de mais aqui, simplesmente criamos um objeto do tipo javafx.scene.control.Label, que é um 
    controle de interface para mostrar texto. Ponto;

6. Aqui informamos o texto que o Label irá mostrar. Note que isso poderia ter sido feito pelo construtor, na 
    criação do Label;

7. Como o StackPane é um elemento pai, ele também tem elementos filhos. Nessa linha de código, recuperamos os 
    filhos dele(getChildren()) e adicionamos nosso Label(add(Node)), fazendo que o Label seja um filho dele;

8. É hora de aprender outro conceito do JavaFX. Nessa linha criamos uma javafx.scene.Scene(cena). Uma cena é o 
    contâiner principal de todos os elementos do JavaFX e na criação dela aproveitamos para informar a raiz 
    (como o nome diz, a raiz de todos os componentes), largura e altura da cena;

9. Agora vamos voltar a mexer com nosso palco. Nessa linha informamos o título dele, no nosso caso atual, o 
    título da janela que será mostrada;

10. O palco precisa de uma cena, simplesmente é isso que é feito nessa linha.
11. Simplesmente mostrando o palco! Se esse método não for chamado, nada irá acontecer quando executar esse código.*/