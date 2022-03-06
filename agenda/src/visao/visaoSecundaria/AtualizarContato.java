
package visao.visaoSecundaria;

import agenda.controle.ContatoControle;
import dao.ContatoDAO;
import dto.Contato;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class AtualizarContato extends JFrame{
    
    private DefaultTableModel modelo;
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbId;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JTextField txId;
	private JTextField txNome;
	private JTextField txTelefone;
	private Contato contato;
	int linhaSelecionada;
	public AtualizarContato(DefaultTableModel md, int linha, int id) {
		super("Atualizar Contato");
		criaJanela();
		this.modelo = md;
		this.linhaSelecionada = linha;
		this.contato = new ContatoDAO().getContatoById(id);
		this.txId.setText(Integer.toString(contato.getId()));
		this.txNome.setText(contato.getNome());
		this.txTelefone.setText(contato.getTelefone());
	}
	
	public void criaJanela() {
		painelFundo = new JPanel(new GridLayout(4, 2, 2, 4));
		lbId = new JLabel("ID:");
		lbNome = new JLabel("NOME");
		lbTelefone = new JLabel("TELEFONE");
		txId = new JTextField();
		txId.setEditable(false);
		txNome = new JTextField();
		txTelefone = new JTextField();
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		painelFundo.add(lbId);
		painelFundo.add(txId);
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbTelefone);
		painelFundo.add(txTelefone);
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);
		
		btSalvar.addActionListener(new BtSalvarListener());
		btLimpar.addActionListener(new BtLimparListener());
		
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(painelFundo);
		this.setVisible(true);
	}
	
	private class BtSalvarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Contato contato = new Contato();
			contato.setId(Integer.parseInt(txId.getText()));
			contato.setNome(txNome.getText());
			contato.setTelefone(txTelefone.getText());
			new ContatoControle().atualizacao(contato);
			modelo.removeRow(linhaSelecionada);
			modelo.addRow(new Object[] {contato.getId(), contato.getNome(), contato.getTelefone()});
			setVisible(false);
		}
	}
	
	private class BtLimparListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txTelefone.setText("");
		}
	}
}
