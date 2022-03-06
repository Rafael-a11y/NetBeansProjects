/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.bsb.programacao3.visao.swing1;

import br.estacio.bsb.programacao3.controle.ClienteControle;
import br.estacio.bsb.programacao3.modelo.Cliente;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author MASTER
 */
public class ClienteFrame extends JFrame{
    
    private JLabel lbNome, lbTelefone, lbId, lbLocalizar;
    private JTextField txtNome, txtTelefone, txtId, txtLocalizar;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnNovo, btnLocalizar;
    private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;
    
    private List<Cliente> contatoList = new ClienteControle().listarTodos();
    private int registroAtual = 0;
    private Integer key;
    //A tela é o JFrame, mas sem um container, nada faz
    public ClienteFrame(){
        //Nome que aparece na parte superior da tela
        super("Contato dos Clientes");
        //Criando o componente container qque extende Component, que irá conter os demais componentes
        //gráficos
        Container tela = getContentPane();
        this.setLayout(null);
        
        lbNome = new JLabel("nome");
        lbTelefone = new JLabel("telefone");
        lbId = new JLabel("id");
        
        lbNome.setBounds(10, 10, 240, 15);
        lbTelefone.setBounds(10, 50, 240, 15);
        lbId.setBounds(10, 90, 240, 15);

        lbNome.setForeground(Color.BLACK);
        lbTelefone.setForeground(Color.BLACK);
        lbId.setForeground(Color.BLACK);
        
        lbNome.setFont(new Font("Courier New", Font.BOLD, 14));
        lbTelefone.setFont(new Font("Courier New", Font.BOLD, 14));
        lbId.setFont(new Font("Courier New", Font.BOLD, 14));
        
        tela.add(lbNome);
        tela.add(lbTelefone);
        tela.add(lbId);
        
        txtNome = new JTextField();
        txtTelefone = new JTextField();
        txtId = new JTextField();
        txtId.setEditable(false);
        
        txtNome.setBounds(10, 25, 265, 20);
        txtTelefone.setBounds(10, 65, 265, 20);
        txtId.setBounds(10, 105, 265, 20);
        
        tela.add(txtNome);
        tela.add(txtTelefone);
        tela.add(txtId);
        
        btnSalvar = new JButton("Salvar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Ecluir");
        btnNovo = new JButton("Novo");
        btnPrimeiro = new JButton("|<");
        btnAnterior = new JButton("<<");
        btnProximo = new JButton(">>");
        btnUltimo = new JButton(">|");
        
        btnSalvar.setBounds(280, 25, 80, 20);
        btnAlterar.setBounds(280, 65, 80, 20);
        btnExcluir.setBounds(280, 105, 80, 20);
        btnNovo.setBounds(110, 135, 75, 20);
        btnPrimeiro.setBounds(10, 135, 55, 20);
        btnAnterior.setBounds(60, 135, 55, 20);
        btnProximo.setBounds(185, 135, 55, 20);
        btnUltimo.setBounds(235, 135, 55, 20);
        
        tela.add(btnSalvar);
        tela.add(btnAlterar);
        tela.add(btnExcluir);
        tela.add(btnNovo);
        tela.add(btnPrimeiro);
        tela.add(btnAnterior);
        tela.add(btnProximo);
        tela.add(btnUltimo);
        
        lbLocalizar = new JLabel("Localizar por id");
        lbLocalizar.setBounds(10, 160, 220, 20);
        
        txtLocalizar = new JTextField();
        txtLocalizar.setBounds(10, 180, 220, 20);
        
        btnLocalizar = new JButton("Localizar");
        btnLocalizar.setBounds(230, 180, 55, 20);
        
        tela.add(lbLocalizar);
        tela.add(txtLocalizar);
        tela.add(btnLocalizar);
        
        this.setSize(400, 250);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        //O botão usa um método para adicionar um evento, este objeto precisa ser um ActionListener,
        //por sua vez o objeto ActionListener precisa implementar ActionListener e sobrescrever o
        //actionPeformed que recebe um Event e de parâmetro 
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickSalvar();
            }
        });
    }
    private void onClickSalvar() {
    	ClienteControle cc = new ClienteControle();
        try {
        	if (txtId.getText().isEmpty()) {
        		cc.inserir(txtNome.getText(), txtTelefone.getText());
        	} else {
        		cc.alterar(registroAtual, txtNome.getText(), txtTelefone.getText());
        	}
            JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
            clearFields();
            contatoList = new ClienteControle().listarTodos();
        } catch (Exception e) {//SQLException e
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel salvar contato!n" + 
				e.getLocalizedMessage()
			);
        }
    }
    private void clearFields(){
        txtNome.setText("");
        txtTelefone.setText("");
        txtId.setText("");
        txtLocalizar.setText("");
    }
    
}
