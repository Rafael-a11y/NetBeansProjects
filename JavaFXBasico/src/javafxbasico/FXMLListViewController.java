package javafxbasico;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafxbasico.model.Categoria;

public class FXMLListViewController implements Initializable {

    @FXML
    private ListView<Categoria> lvCategorias;
    
    private List<Categoria> categorias = new ArrayList<>();
    
    private ObservableList<Categoria> obsCategorias;
    @Override
    public void initialize(URL url, ResourceBundle rb) {carregarCategorias();}

private void carregarCategorias(){
    Categoria c1 = new Categoria(1, "Comidas");
    Categoria c2 = new Categoria(2, "Bebidas");
    categorias.add(c1);
    categorias.add(c2);
    obsCategorias = FXCollections.observableArrayList(categorias);
    lvCategorias.setItems(obsCategorias);
}    
    
}
