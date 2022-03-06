/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbasico;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafxbasico.model.Categoria;

/**
 * FXML Controller class
 *
 * @author MASTER
 */
public class FXMLComboBoxController implements Initializable {

    @FXML
    private ComboBox<Categoria> cbCategorias;
    
    private List<Categoria> categorias = new ArrayList<>();
    
    private ObservableList<Categoria> obsCategorias;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCategorias();
    }

    private void carregarCategorias(){
       
        Categoria categoria1 = new Categoria(1, "Bebidas");
        Categoria categoria2 = new Categoria(2, "Comidas");
        categorias.add(categoria1);
        categorias.add(categoria2);
        
        obsCategorias = FXCollections.observableArrayList(categorias);
        cbCategorias.setItems(obsCategorias);
    }
    
}
