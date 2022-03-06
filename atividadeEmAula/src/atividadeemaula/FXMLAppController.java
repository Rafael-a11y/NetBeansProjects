/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeemaula;

import atividadeemaula.model.Person;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MASTER
 */
public class FXMLAppController implements Initializable {

    private String capture = "";
    
    private ObservableList<String> obsWords = FXCollections.observableArrayList();
    
    @FXML
    private Button botao;

    @FXML
    private Label label;

    @FXML
    private TextField campo;

    @FXML
    private ListView<String> listView;
    
    @FXML
    private Button botaoDeletarPrimeiro;

    @FXML
    void deletarPrimeiro(ActionEvent event) {
        if(obsWords.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mensagem");
            alert.setHeaderText("Atenção");
            alert.setContentText("Você deve selecionar uma linha.");
            alert.show();
            
            return;
        }
        else if(listView.getSelectionModel().getSelectedIndex() < 0){
            obsWords.remove(0);
        }
        else{
            obsWords.remove(listView.getSelectionModel().getSelectedIndex());
        }
       
    }
    
    @FXML
    void inserir(ActionEvent event) {
        label.setText("Olá " + campo.getText());
        
        capture = campo.getText();
        obsWords.add(capture);
        listView.setItems(obsWords);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
