package src.main.java.javafxpratico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RadioCheckToggle extends Application{
    
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage palco){
        VBox raiz = new VBox(10);
        raiz.setTranslateY(20);
        raiz.setTranslateX(10);
//        raiz.setAlignment(Pos.CENTER);
        
        Label lbTitulo = new Label("Pesquisa sobre Programação");
        lbTitulo.setUnderline(true); //1
        
        final TextField txtNome = new TextField();
        HBox hbNome = new HBox(10); //2
        hbNome.getChildren().addAll(new Label("Nome"), txtNome);

        HBox hbSO = new HBox(20);
        ToggleButton tbLinux = new ToggleButton("Linux"); //3
        tbLinux.setSelected(true);
        ToggleButton tbWindows = new ToggleButton("Windows");
        ToggleButton tbMac = new ToggleButton("Mac");
        final ToggleGroup tgSO = new ToggleGroup(); //4
        tgSO.getToggles().addAll(tbLinux, tbWindows, tbMac); //5
        hbSO.getChildren().addAll(new Label("Sistema Operacional utilizado"),
                tbLinux, tbWindows, tbMac);
        
        final ToggleGroup tgLinguagem = new ToggleGroup();
        HBox hbLinguagens = new HBox(20);
        RadioButton rbJava = new RadioButton("Java"); //6
        rbJava.setSelected(true);
        RadioButton rbC = new RadioButton("C");
        RadioButton rbPython = new RadioButton("Python");
        tgLinguagem.getToggles().addAll(rbJava, rbC, rbPython);
        hbLinguagens.getChildren().addAll(new Label("Linguagem de Programação Predileta: "),
                rbJava, rbC, rbPython);
        
        final CheckBox chkFrequencia = new CheckBox("Programa todo dia? "); //7
        final CheckBox chkGosto = new CheckBox("Gosta de Programação? ");
        chkGosto.setAllowIndeterminate(true); //8
        chkGosto.setIndeterminate(true);
        
        Button btnSubmeter = new Button("Submeter Pesquisa: ");
        btnSubmeter.setOnAction(e -> {
            System.out.println("\t\tResultado da pesquisa para \"" + txtNome.getText() + "\"\n");
            System.out.println("\t\t \"testando\"");
        
            //Podemos não ter só um SO selecionado
            ToggleButton tbSO = (ToggleButton) tgSO.getSelectedToggle(); //9
            System.out.println("Sistema Operacional Predileto: ");
            System.out.println(tbSO == null ? "Não selecionado." : tbSO.getText());
            
            //Deve ter uma linguagem selecionada.
            RadioButton rbLinguagem = (RadioButton) tgLinguagem.getSelectedToggle();
            System.out.println(rbLinguagem == null ? "Não selecionado" : "Linguagem de programação: " + rbLinguagem.getText());
            if(rbC.isSelected()) System.out.println("C também foi selecionado : " + rbC.getText());
            //10
            System.out.println((chkFrequencia.isSelected() == true ? "P" : "Não p") + "rograma todo dia.");
            
            System.out.println("Gosta de programação: ");
            if(chkGosto.isSelected()){
                System.out.println("Sim");
            }
            //11
            else if(chkGosto.isIndeterminate()){
                System.out.println("Não respondido");
            }
            else{
                System.out.println("Não");
            }
            System.out.println("\n\n");
        });
        raiz.getChildren().addAll(lbTitulo, hbNome, hbSO, hbLinguagens, chkFrequencia, chkGosto, btnSubmeter);
        
        Scene cena = new Scene(raiz, 500, 250);
        palco.setTitle("Pesquisa sobre Programação");
        palco.setScene(cena);
        palco.show();
     }
}

/*1. Já começamos mostrando uma propriedade do Label. Se você chamar esse método e enviar true, ele será 
    sublinhado;

2. Esse componente é novo, mas o primo dele, VBox, funciona de forma muito semelhante. As propriedades são 
    exatamente as mesmas, a diferença é que a HBox os componentes são organizados horizontalmente;

3. Nessa linha estamos criando o tão falado botão alternado ToggleButton. Vamos usar três. Daqui a pouco 
    teremos que adicionar ele a um grupo junto com outros botões alternados, assim somente um poderá ser 
    escolhido nesse grupo, mas há a possibilidade de não escolher nenhum. Perceba que estamos informando no
    construtor o texto que ele irá mostrar;

4. O grupo que falamos no passo anterior é representado pela classe ToggleGroup. Ele agrupo objetos do tipo 
    Toggle, que é a classe pai do ToggleButton e do RadioButton;

5. Nessa linha simplesmente adicionamos os botões já declarados para o grupo, dizendo que eles não podem ser
    selecionados simultaneamente;

6. Semelhante ao ToggleBox, temos o RadioButton. A maior diferença está na aparência e que um grupo de 
    RadioButton não permite um botão não selecionado;

7. Aqui usamos uma caixa de checagem, CheckBox. A String enviada no construtor também é o texto associado à 
    ela;

8. Dizemos que essas caixas de checagem têm três estados. Nessa linha habilitamos o terceiro estado, o estado 
    indeterminado (quântico?);

9. Dentro do listener do botão usando Lambda, estamos lendo as propriedades dos controles de interface 
    apresentados. Essa linha especificamente retorna o Toggle selecionado. Como sabemos que esse grupo contém 
    toggles do tipo ToggleButton, já fazemos um cast para esse tipo. Se nada estiver selecionado, null é 
    retornado;

10. O isSelected retorna um valor booleano para informar se essa caixa está selecionada;

11. Por fim(ufa), usamos o método isIndeterminate para sabermos se o estado dessa CheckBox é indeterminado.*/
