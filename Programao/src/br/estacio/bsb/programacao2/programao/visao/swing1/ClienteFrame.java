package br.estacio.bsb.programacao2.programao.visao.swing1;


import br.estacio.bsb.programacao2.programao.controle.ClienteControle;
import br.estacio.bsb.programacao2.programao.modelo.Cliente;
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


/*
Essa é a GUI (janela) usada para toda a manipulação dos clientes (CRUD completo). 

Nesse formato de implementação, usamos objetos anônimos para desenvolver os 
escutadores de eventos. Por exemplo "new ActionListener".
*/
public class ClienteFrame extends JFrame {

    private static final long serialVersionUID = -5424920495451047991L;
    private JLabel lbNome, lbTelefone, lbId;
    private JTextField txtNome, txtTelefone, txtId, txtLocalizar;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnNovo, btnLocalizar;
    private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;

    private List<Cliente> contatoList = new ClienteControle().listarTodos();
    private int registroAtual = 0;
    private Integer key;

    public ClienteFrame() {
        super("Contato dos Clientes");
        Container tela = getContentPane();
        setLayout(null);
        lbNome = new JLabel("Nome");
        lbTelefone = new JLabel("Telefone");
        lbId = new JLabel("Código");

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
        btnExcluir = new JButton("Excluir");
        btnNovo = new JButton("Novo");
        btnPrimeiro = new JButton("|<");
        btnAnterior = new JButton("<<");
        btnProximo = new JButton(">>");
        btnUltimo = new JButton(">|");

        btnSalvar.setBounds(280, 25, 80, 20);
        btnAlterar.setBounds(280, 65, 80, 20);
        btnExcluir.setBounds(280, 105, 80, 20);

        tela.add(btnSalvar);
        btnAlterar.setEnabled(false);
        tela.add(btnAlterar);
        tela.add(btnExcluir);

        btnPrimeiro.setBounds(10, 135, 55, 20);
        btnAnterior.setBounds(60, 135, 55, 20);
        btnNovo.setBounds(110, 135, 75, 20);
        btnProximo.setBounds(185, 135, 55, 20);
        btnUltimo.setBounds(235, 135, 55, 20);

        tela.add(btnPrimeiro);
        tela.add(btnAnterior);
        tela.add(btnNovo);
        tela.add(btnProximo);
        tela.add(btnUltimo);

        JLabel lbLocalizar = new JLabel("Localizar por código");
        lbLocalizar.setBounds(10, 160, 220, 20);

        txtLocalizar = new JTextField();
        txtLocalizar.setBounds(10, 180, 220, 20);

        btnLocalizar = new JButton("Localizar");
        btnLocalizar.setBounds(230, 180, 55, 20);

        tela.add(lbLocalizar);
        tela.add(txtLocalizar);
        tela.add(btnLocalizar);

        setSize(400, 250);
        setVisible(true);
        setLocationRelativeTo(null);

        btnSalvar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickSalvar();
                }
            }
        );

        btnAlterar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickAlterar();
                }
            }
        );

        btnExcluir.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickExcluir();
                }
            }
        );

        btnNovo.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearFields();
                    registroAtual = 0;
                }
            }
        );

        btnLocalizar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickLocalizar();
                }
            }
        );

        btnPrimeiro.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickPrimeiro();
                }
            }
        );
        
        btnAnterior.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickAnterior();
                }
            }
        );

        btnProximo.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickProximo();
                }
            }
        );

        btnUltimo.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClickUltimo();
                }
            }
        );
    }

    private void onClickUltimo() {
        registroAtual = contatoList.size() - 1;
        getValores(registroAtual);
    }

    private void onClickProximo() {
        if (registroAtual != contatoList.size() - 1) {
            getValores(++registroAtual);
        }
    }

    private void onClickAnterior() {
        if (registroAtual != 0) {
            getValores(--registroAtual);
        }
    }

    private void onClickPrimeiro() {
        registroAtual = 0;
        getValores(registroAtual);
    }

    private void getValores(int index) {
        if (index <= contatoList.size() - 1) {
            Cliente contatoAtual = contatoList.get(index);
            txtNome.setText(contatoAtual.getNome());
            txtTelefone.setText(contatoAtual.getTelefone());
            txtId.setText(String.valueOf(contatoAtual.getId()));
        }
    }

    private void onClickAlterar() {
    	ClienteControle cc = new ClienteControle();
        int id = 0;
        if (key == null) {
            id = contatoList.get(registroAtual).getId();
        } else {
            id = key;
            key = null;
        }
		
        try {
            cc.alterar(id, txtNome.getText(), txtTelefone.getText());
            JOptionPane.showMessageDialog(this, "Contato alterado com sucesso!");
            clearFields();
            contatoList = new ClienteControle().listarTodos();
        } catch (Exception e) {//SQLException e
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar contato!n" + e.getLocalizedMessage());
        }
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

    private void onClickExcluir() {
    	ClienteControle cc = new ClienteControle();
        int id = contatoList.get(registroAtual).getId();
        try {
            cc.excluir(id);
            JOptionPane.showMessageDialog(this, "Contato excluido com sucesso!");
            clearFields();
            contatoList = new ClienteControle().listarTodos();
        } catch (Exception e) { //SQLException e
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel excluir o contato!n" + 
				e.getLocalizedMessage()
			);
        }
    }

    private void onClickLocalizar() {
    	ClienteControle cc = new ClienteControle();
        try {
            Cliente c = cc.buscarClientePorId(Integer.valueOf(txtLocalizar.getText()));
            txtNome.setText(c.getNome());
            txtTelefone.setText(c.getTelefone());
            txtId.setText(String.valueOf(c.getId()));
			key = c.getId();
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, 
				"Contato não localizdo ou não existe!n" + 
				e.getLocalizedMessage()
			);
        } catch (Exception e) {//SQLException e
            JOptionPane.showMessageDialog(this, 
				"Ocorreu um erro, tente novamente!n" + 
				e.getLocalizedMessage()
			);
        }
    }

    private void clearFields() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtId.setText("");
        txtLocalizar.setText("");
    }

}
