
package javafxbasico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLButtonController implements Initializable {
    
    @FXML
    private Label labelOlaMundo;
    
    @FXML
    private TextField txtNome;
    
    @FXML
    private void acaoDoBotao(ActionEvent event) {
        System.out.println("Você clicou!");
        labelOlaMundo.setText("Olá mundo: " + txtNome.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
