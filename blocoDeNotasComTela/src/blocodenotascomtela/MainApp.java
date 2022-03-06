
package blocodenotascomtela;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane painelFundo;
    
    @Override
    public void start(Stage stage) throws Exception {
       this.primaryStage = stage;
       this.primaryStage.setTitle("Bloco de Notas");
       initPainelFundo();
    }
    
    public void initPainelFundo(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/FXMLDocument.fxml"));
            painelFundo = (BorderPane) loader.load();
            
            Scene scene = new Scene(painelFundo);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainApp.launch(args);
    }
    
}
