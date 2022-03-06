package visao.visaoSecundaria;

import agenda.controle.ContatoControle;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ExcluirContato extends JFrame{
    
    private JPanel painelFundo;
	private JPanel painelBotoes;
	private JLabel indexOfRow;
	private JButton sim;
	private JButton nao;
	private int id;
	private DefaultTableModel md;
	private int linha;
	
	public ExcluirContato(DefaultTableModel modelo, int linhaSelecionada, int idContato) {
		super("Exclusao");
		this.id = idContato;
		this.md = modelo;
		this.linha = linhaSelecionada;
		criaJanela();
	}
	
	private void criaJanela() {
		painelFundo = new JPanel(new GridLayout(2, 2, 20, 20));
		indexOfRow = new JLabel
				("Certeza que deseja excluir este registro? "
						+ "(número da linha = " + Integer.toString(this.linha) + ").");
		painelFundo.add(this.indexOfRow);
		painelBotoes = new JPanel();
		sim = new JButton("Sim");
		sim.addActionListener(new BtSimListener());
		nao = new JButton("não");
		nao.addActionListener(new BtNaoListener());
		painelBotoes.add(nao);
		painelBotoes.add(sim);
		painelFundo.add(painelBotoes);
		
		this.getContentPane().add(BorderLayout.CENTER, painelFundo);
		this.setSize(300, 150);
		setLocation(300, 150);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private class BtSimListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ContatoControle().deletar(id);
			md.removeRow(linha);
			setVisible(false);
		}
	}
	
	private class BtNaoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
