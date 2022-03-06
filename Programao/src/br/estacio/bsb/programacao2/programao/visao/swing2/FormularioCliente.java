package br.estacio.bsb.programacao2.programao.visao.swing2;


import br.estacio.bsb.programacao2.programao.controle.ClienteControle;
import br.estacio.bsb.programacao2.programao.modelo.Cliente;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/*
 O formulário do cliente é a GUI (janela) usada para editar ou criar um novo cliente.
*/
public class FormularioCliente extends JFrame {

    private static final long serialVersionUID = -4948126095067773611L;
    private Cliente cliente;
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbTelefone;
    private JTextField txNome;
    private JTextField txTelefone;

    public FormularioCliente(DefaultTableModel md, Cliente cliente) {
        super("Novo Cliente");
        if (cliente != null) {
            // entra em modo de edição
            this.setTitle("Editar Cliente");
            this.cliente = cliente;
        } else {
            // entra em modo de inserção
            this.cliente = new Cliente();
        }
        criaJanela();
    }

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("         Nome.:   ");
		lbTelefone = new JLabel("         Telefone.:   ");
		txNome = new JTextField(10);
		txTelefone = new JTextField();

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
		if (cliente.getId() != null) {
			painelFundo.add(new JLabel("         Código: " + cliente.getId()));
			painelFundo.add(new JLabel("                  "));
		}
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbTelefone);
		painelFundo.add(txTelefone);
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);
		
		if (cliente != null) {
			txNome.setText(cliente.getNome());
			txTelefone.setText(cliente.getTelefone());
		}

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);
		setLocationRelativeTo(null);
		btSalvar.addActionListener(new BtSalvarListener());
		btLimpar.addActionListener(new BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			cliente.setNome(txNome.getText());
			cliente.setTelefone(txTelefone.getText());

                        ClienteControle controle = new ClienteControle();
			if (cliente.getId() == null) {
				controle.inserir(cliente);
			} else {
				controle.alterar(cliente);
			}

			setVisible(false);
		}
	}

	private class BtLimparListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                txNome.setText("");
                txTelefone.setText("");
            }
	}
}
