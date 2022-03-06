package javafxbasico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class @author Rafael Souto da Silva
 */
public class FXMLRadioButtonController implements Initializable {

    @FXML
    private ToggleGroup grupo;
    
    //Não precisa do ActionEvent
    @FXML
    public void pegarSelecionado(){
        RadioButton radio = (RadioButton) grupo.getSelectedToggle();
        System.out.println(radio.getText());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
}
