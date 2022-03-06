package src.main.java.javafxpratico;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class TocandoAudio extends Application{
    private String AUDIO_URL = "http://sampleswap.org/mp3/artist/5101/Peppy--The-Firing-Squad_YMXB-160.mp3";
    
    public static void main(String[] args) {
        launch();    
    }
    
    @Override
    public void start(Stage palco) throws Exception{
        AudioClip clip = new AudioClip(AUDIO_URL);//1
        clip.play();//2
        StackPane raiz = new StackPane();
        raiz.getChildren().add(new Text("Tocando música"));//3
        Scene cena = new Scene(raiz, 600, 100);
        palco.setTitle("Tocando Áudio em JavaFX!");
        palco.setScene(cena);
        palco.show();
    }
}


/*1. Aqui carregamos o clipe de áudio e informamos a URL do audio a ser tocado;

2. O áudio irá começar a tocar nessa linha. Semelhante ao vídeo, temos vários outros métodos que poderíamos 
    utilizar;

3. Não é relacionado ao áudio, mas essa linha adiciona um simples texto informativo, pois não temos nada visual 
    quanto tocamos áudio.

A aplicação pode demorar um pouquinho para rodar, pois o áudio está na internet. Você pode incrementar essa 
    aplicação quando aprender sobre botões e outros controles de interface que falaremos em breve.*/