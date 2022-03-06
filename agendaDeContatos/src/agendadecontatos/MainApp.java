package agendadecontatos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane; 
import javafx.stage.Stage;

/* @author Rafael Souto da Silva
 */
public class MainApp extends Application {
    //É tipo o Container do swing
    private Stage primaryStage;
    //layout BorderPane, é uma mistura de JPanel com BorderLayout. Diferente do swing, creio que não é preciso
    //setar um JPanel com um gerenciador de layout.
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        //O título é setado no Stage, e não na janela em sí
        this.primaryStage.setTitle("AddressApp");
        
        this.initRootLayout();
        
        this.showPersonOverview();
    }
    //Inicializa o layout base
    private void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load(); 
            //Mostra a scene (cena) contendo o root layout. A Scene é como a JPanel que é adicionaada ao Stage
            //que é como o Container da Janela.
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    } 

    /**
     * @param args the command line arguments
     */
    //Mostra o person overview dentro do rootLayout
    
    public void showPersonOverview(){
       try{
            //Carrega o PersonOverview.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            //Define o personOverview dentro do rootLayout
            rootLayout.setCenter(personOverview);
       }
       catch(IOException e){
           e.printStackTrace();
       }
    }
    public Stage getPrimaryStage(){
        return this.primaryStage;
    }
    public static void main(String[] args) {
        //chama start() que é sobrescrito nesta classe para dar início ao show.
        launch(args);
    }
    
}
