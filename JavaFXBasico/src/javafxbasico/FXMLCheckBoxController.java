
package javafxbasico;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class FXMLCheckBoxController {
    
    @FXML
    private CheckBox cbJava;
    
    @FXML
    private CheckBox cbPHP;
    
    //Equivale ao actionPerformed do swing
    @FXML
    public void pegarValores(){
        System.out.println(cbJava.selectedProperty().getValue());
        System.out.println(cbPHP.selectedProperty().getValue());
    }
}
