package br.estacio.bsb.programacao2.programao.visao.swing2;


import br.estacio.bsb.programacao2.programao.controle.ClienteControle;
import br.estacio.bsb.programacao2.programao.modelo.Cliente;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/*
Essa é a GUI (janela) usada para listar clientes. 

Obs.: estamos usando um componente chamado JTable

Nesse formato de implementação, usamos classes aninhadas para desenvolver os 
escutadores de eventos. Por exemplo o BtAtualizarListener.
*/
public class ListaClientesFrame extends JFrame {

	private static final long serialVersionUID = -3337868718384632126L;
	
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
        private DefaultTableModel modeloJTable = new DefaultTableModel();
	private JScrollPane barraRolagem;
	private JButton btInserir;
	private JButton btExcluir;
	private JButton btEditar;
	private JButton btAtualizar;

	public ListaClientesFrame() {
            super("Lista de Contatos");
            criaJTable();
            criaJanela();
	}

	public void criaJanela() {
            btInserir = new JButton("Inserir");
            btExcluir = new JButton("Excluir");
            btEditar = new JButton("Editar");
            btAtualizar = new JButton("Atualizar");
            painelBotoes = new JPanel();
            barraRolagem = new JScrollPane(tabela);
            painelFundo = new JPanel();
            painelFundo.setLayout(new BorderLayout());
            painelFundo.add(BorderLayout.CENTER, barraRolagem);
            painelBotoes.add(btInserir);
            painelBotoes.add(btEditar);
            painelBotoes.add(btExcluir);
            painelBotoes.add(btAtualizar);
            painelFundo.add(BorderLayout.SOUTH, painelBotoes);

            getContentPane().add(painelFundo);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(500, 320);
            setVisible(true);
            setLocationRelativeTo(null);
            btInserir.addActionListener(new BtInserirListener());
            btEditar.addActionListener(new BtEditarListener());
            btExcluir.addActionListener(new BtExcluirListener());
            btAtualizar.addActionListener(new BtAtualizarListener());
	}

	private void criaJTable() {
            tabela = new JTable(modeloJTable);
            modeloJTable.addColumn("Id");
            modeloJTable.addColumn("Nome");
            modeloJTable.addColumn("Telefone");
            tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
            pesquisar(modeloJTable);
	}

	public static void pesquisar(DefaultTableModel modeloJTable) {
            modeloJTable.setNumRows(0);
            ClienteControle controle = new ClienteControle();

            for (Cliente cliente : controle.listarTodos()) {
                modeloJTable.addRow(new Object[]{cliente.getId(), cliente.getNome(),
                cliente.getTelefone()});
            }
	}

	private class BtInserirListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                FormularioCliente ic = new FormularioCliente(modeloJTable, null);
                ic.setVisible(true);
                pesquisar(modeloJTable);			
            }
	}

	private class BtEditarListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
                    String nomeContato = (String) tabela.getValueAt(linhaSelecionada, 1);
                    String telefoneContato = (String) tabela.getValueAt(linhaSelecionada, 2);
                    Cliente cliente = new Cliente(idContato, nomeContato, telefoneContato);
                    FormularioCliente ic = new FormularioCliente(modeloJTable, cliente);
                    ic.setVisible(true);
                    pesquisar(modeloJTable);			
                } else {
                    JOptionPane.showMessageDialog(null,
                    "É necesário selecionar uma linha.");
                }
            }
	}

	private class BtExcluirListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int idContato = (int)
                    tabela.getValueAt(linhaSelecionada, 0);
                    ClienteControle controle = new ClienteControle();
                    controle.excluir(idContato);
                    modeloJTable.removeRow(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(null,
                    "É necesário selecionar uma linha.");
                }
            }
	}

	private class BtAtualizarListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                pesquisar(modeloJTable);
            }
	}
}
