/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hortifruticombdeinterface.visao.swing2;

import hortifruticombdeinterface.controle.FrutaControle;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import hortifruticombdeinterface.modelo.Fruta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author MASTER
 * 
 * Esta é a GUI usada para listar as frutas.
 * Neste formato de implementação, vamos usar classes aninhadas para desenvolver o escutadores de eventos (subjects), como o btnAtaulizarListener.
 */
public class ListaFrutasFrame extends JFrame{
    
    private JPanel painelFundo;
    private JPanel painelBotoes;
    //Objeto Tabela
    private JTable tabela;
    //Modelo de tabela padrão
    private DefaultTableModel modeloJTable = new DefaultTableModel();
    private JScrollPane barraRolagem;
    private JButton btInserir;
//    private JButton btExcluir;
    private JButton btEditar;
    private JButton btAtualizar;
    
    public ListaFrutasFrame(){
        super("Lista de Frutas");
        criaJTable();
        criaJanela();
    }
    
    private void criaJanela(){
        btInserir = new JButton("Inserir");
//        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        btAtualizar = new JButton("Atualizar");
        
        painelBotoes = new JPanel();
        //Usa de parâmetro o objeto JTable, creio que serve para criar uma barra de rolagem na tabela dependendo de seu tamanho.
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        //Testar esta parte aqui
        painelFundo.setLayout(new BorderLayout());
       //Creio que serve para especificar onde a barra de rolagem se encontgrará na tela.
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserir);
//        painelBotoes.add(btExcluir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btAtualizar);
        ///Creio que esteja especificando onde o painel de botões se econtrará na tela
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);
        //Depois voltar aqui para testar, creio qque este método serve para adicionar o painel de fundo dentro da janela principal
        this.getContentPane().add(painelFundo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 320);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //Adicionando os objects subjects que irão implementar a interface ActionListener e posteriormente implementar o método actionPerformed(ActionEvent e);
        btInserir.addActionListener(new btInserirListener());
//        btExcluir.addActionListener(new btExcluirListener());
        btEditar.addActionListener(new btEditarListener());
        btAtualizar.addActionListener(new btAtualizarListener());
    }
    //Método responsável por criar a tabela JTablel
    private void criaJTable(){
        //Posso criar uma JTable sem fornecr uma JTableModel
//        tabela = new JTable();
          tabela = new JTable(modeloJTable);
          modeloJTable.addColumn("Id");
          modeloJTable.addColumn("Nome");
          modeloJTable.addColumn("Quantidade");
          tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
          tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
          tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
          pesquisar(modeloJTable);
    }
    private void pesquisar(DefaultTableModel modeloJTable){
        modeloJTable.setNumRows(0);
        FrutaControle controle = new FrutaControle();
        for(Fruta fruta : controle.selecionarTodos()){
            modeloJTable.addRow(new Object [] {fruta.getId(), fruta.getDescricao(), fruta.getQuantidade()});
            
        }
    }
    private class btInserirListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            FormularioFruta iFruta = new FormularioFruta(modeloJTable, null);
            iFruta.setVisible(true);
            pesquisar(modeloJTable);
        }
    }
    private class btEditarListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if(linhaSelecionada >= 0){
                int idFruta = (int) tabela.getValueAt(linhaSelecionada, 0);
                String nomeFruta = (String) tabela.getValueAt(linhaSelecionada, 1);
                int quantidadeFruta = (int) tabela.getValueAt(linhaSelecionada, 2);
                Fruta fruta = new Fruta(idFruta, nomeFruta, quantidadeFruta);
                FormularioFruta ff = new FormularioFruta(modeloJTable, fruta);
                ff.setVisible(true);
                pesquisar(modeloJTable);
            }
            else{
                JOptionPane.showMessageDialog(null, "É nescessário selecionar uma linha");
            }
        }
    }
    
    private class btExcluirListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int linhaSelecionada = -1;
            //Pega o número da linha selecionada que começa em 0, por isso inicialmente a linha começa com o valor -1, pois por padrão, uma variável int
            //não inicializada recebe 0, e a inndexação das linhas começa em 0, assim como os arrays e collections
            linhaSelecionada = tabela.getSelectedRow();
            if(linhaSelecionada >= 0){
                //Captura os valores da linha, o primeiro parâmetro numérico é a linha selecionada e o segundo parâmetro numérico é o índice da coluna.
                int idFruta = (int) tabela.getValueAt(linhaSelecionada, 0);
                FrutaControle controle = new FrutaControle();
                //Exclui o objeto do banco de dados após capturar o id. 
                controle.excluir(idFruta);
                //exclui a linha após o objeto ser removido
                modeloJTable.removeRow(linhaSelecionada);   
            }
            else{
                JOptionPane.showMessageDialog(null, "É nescessário selecionar uma linha");
            }
        }
    }
    
    private class btAtualizarListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            pesquisar(modeloJTable);
        }
    }
}
