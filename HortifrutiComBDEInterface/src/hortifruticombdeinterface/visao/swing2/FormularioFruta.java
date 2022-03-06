/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hortifruticombdeinterface.visao.swing2;

import hortifruticombdeinterface.controle.FrutaControle;
import hortifruticombdeinterface.modelo.Fruta;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MASTER
 * Usada para editar ou criar uma nova fruta
 */
public class FormularioFruta extends JFrame{
    //Componentes painéis, botões, rótulos, campos de texto para digitação, e uma fruta
    //Esta é a GUI para criar ou editar uma fruta.
    private Fruta fruta;
    private JPanel painelFundo;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JLabel lbDescricao;
    private JLabel lbQuantidade;
    private JTextField txtDescricao;
    private JTextField txtQuantidade;

    //Ainda não sei onde entra este tabel model
    public FormularioFruta(DefaultTableModel md, Fruta fruta){
        super("NOVA FRUTA");
        if(fruta != null){
            //entra em modo de edição
            this.setTitle("EDITAR FRUTA");
            this.fruta = fruta;
        }
        else{
            //entra em modo de inserção
            this.fruta = new Fruta();
        }
        criarJanela();
    }
    
    public void criarJanela(){
        btnSalvar = new JButton("SALVAR");
        btnLimpar = new JButton("LIMPAR");
        lbDescricao = new JLabel("       NOME :  ");
        lbQuantidade = new JLabel("     QUANTIDADE :    ");
        
        //Dar uma olhada neste parâmetro. Creio que seja a largura do campo.
        txtDescricao = new JTextField(10);
        txtQuantidade = new JTextField();
        
        painelFundo = new JPanel();
        
        //4 linhas, 2 colunas, intervalo horintal 2, intervalo vertical 4 (espaço entre as colunas e linhas hehe)
        painelFundo.setLayout(new GridLayout(3, 2, 2, 4));
        if(fruta.getId() != null){
            painelFundo.add(new JLabel("        CÓDIGO: " + fruta.getId()));
            painelFundo.add(new JLabel("            "));
        }
        painelFundo.add(lbDescricao);
        painelFundo.add(txtDescricao);
        painelFundo.add(lbQuantidade);
        painelFundo.add(txtQuantidade);
        painelFundo.add(btnSalvar);
        painelFundo.add(btnLimpar);
        
        if(fruta != null){
            txtDescricao.setText(fruta.getDescricao());
            txtQuantidade.setText(Integer.toString(fruta.getQuantidade()));
        }
        //Retornaa o painel de conteúdos e adiciona o JPanel painel que criamos.
        this.getContentPane().add(painelFundo);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(300, 150); 
        this.setVisible(true);
        //definir localização relativa a Component
        this.setLocationRelativeTo(null);
        //definindo os subjects
        btnSalvar.addActionListener(new BtSalvarListener());
        btnLimpar.addActionListener(new BtLimparListener());
        
    }
    
    //Implementa Ação Ouvinte. Os listeners adicionads ao botões devem ser um ActionListener e implemntar o método actionPerformed(ActionEvent e);
    private class BtSalvarListener implements ActionListener{
        //Ação executada, e se eu alterar este parâmetro? E se eu removê-lo?
        public void actionPerformed(ActionEvent e){
            //seta os atributos da fruta capturando os valores inseridos nos campos de digitação
            fruta.setDescricao(txtDescricao.getText());
            fruta.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            
            FrutaControle controle = new FrutaControle();
            if(fruta.getId() == null){
                controle.salvar(fruta);
            }
            else{
                controle.atualizarQuantidade(fruta);
            }
            //Quem está aqui?
            setVisible(false);
        }
    }
    
    private class BtLimparListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            txtDescricao.setText("");
            txtQuantidade.setText("");
        }
    }
}
