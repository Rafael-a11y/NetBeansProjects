package src.main.java.javafxpratico;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
public class TocandoVideo extends Application{

    private String VIDEO_URL = "http://www.mediacollege.com/video-gallery/testclips/20051210-w50s.flv";
    public static void main(String[] args) {
        TocandoVideo.launch();
    }
    @Override
    public void start(Stage palco) throws Exception{
        Media media = new Media(VIDEO_URL);//1
        MediaPlayer mediaPlayer = new MediaPlayer(media);//2
        MediaView mediaView = new MediaView(mediaPlayer);//3
        
        StackPane raiz = new StackPane();
        raiz.getChildren().add(mediaView);//4
        Scene cena = new Scene(raiz, 600, 400);
        palco.setTitle("Tocando vídeo em JavaFX!");
        palco.setScene(cena);
        palco.show();
        mediaPlayer.play();//5
        
        
    }
}


/*1. Nessa linha estamos carregando o nosso vídeo. No construtor é recebido a URL do vídeo que pode ser ou um 
    arquivo local ou um link para um vídeo publicado em algum servidor;

2. Após informar a mídia, nós temos que criar um player ("tocador") que será responsável por interagir com a 
    midia em sí e assim poder tocar, parar, pausar (entre outras ações) o referido vídeo;

3. Nós já temos o vídeo e já sabemos como controlar ele, no entanto, temos que adicionar ele a nossa aplicação 
    JavaFX para que o vídeo seja mostrado.

4. O MediaView é uma classe que herda de Node, ou seja, podemos adicionar ele a qualquer Node que herda de 
    Parent (não se preocupe, futuramente teremos posts específicos sobre essas classes). Nessa linha nós 
    adicionamos o vídeo ao pai;

5. Por fim tocamos o vídeo através do método play(). Há também outros métodos para controle do vídeo, sendo 
    possível criar um player dinâmico...*/
