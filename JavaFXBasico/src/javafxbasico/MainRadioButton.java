package javafxbasico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* @author Rafael Souto da Silva*/
public class MainRadioButton extends Application{
    
     @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(this.getClass().getResource("FXMLRadioButton.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
