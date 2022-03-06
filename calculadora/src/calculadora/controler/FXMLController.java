package calculadora.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    ObservableList<Integer> obsNums = FXCollections.observableArrayList();
    ObservableList<Integer> obsQuads = FXCollections.observableArrayList();
    ObservableList<Integer> obsCubs = FXCollections.observableArrayList();
    ObservableList<Integer> obsQuints = FXCollections.observableArrayList();
    
    Fluxo fluxoQuads;
    Fluxo fluxoCubs;
    Fluxo fluxoQuints;
    
    Integer numQuad = 0;
    Integer numCub = 0;
    Integer numQuint = 0;

     @FXML
    private ListView<Integer> listNums;

    @FXML
    private TextField textNums;

    @FXML
    private Button btnComecar;

    @FXML
    private ListView<Integer> listQuads;

    @FXML
    private ListView<Integer> listCubs;

    @FXML
    private ListView<Integer> listQuints;

    @FXML
    void comecar(ActionEvent event) {
        
        try{
            obsNums.add(Integer.parseInt(textNums.getText()));
            fluxoQuads = new Fluxo(listQuads, obsQuads, Math.pow(Double.valueOf(textNums.getText()).doubleValue(),2), "ThreadQuads");
            fluxoCubs = new Fluxo(listCubs, obsCubs, Math.pow(Double.valueOf(textNums.getText()).doubleValue(),3), "ThreadCubs");
            fluxoQuints = new Fluxo(listQuints, obsQuints, Math.pow(Double.valueOf(textNums.getText()).doubleValue(),5), "ThreadQuints");

            fluxoQuads.start();
            fluxoCubs.start();
            fluxoQuints.start();
            
            fluxoQuads.interrupt();
            fluxoCubs.interrupt();
            fluxoQuints.interrupt();
        }
        catch(IllegalStateException ex){
            ex.printStackTrace();
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
