package visao.visaoSecundaria;

import agenda.controle.ContatoControle;
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
import visao.JanelaPrincipal;

public class InserirContato extends JFrame{

    private DefaultTableModel modelo;
	private JPanel painelCampos;
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JTextField txNome;
	private JTextField txTelefone;
	
	public InserirContato(DefaultTableModel md) {
		super("Contatos");
		criaJanela();
		this.modelo = md;
	}
	
	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("NOME:");
		lbTelefone = new JLabel("TELEFONE:");
		txNome = new JTextField();
		txTelefone = new JTextField();
		
		painelCampos = new JPanel();
		painelCampos.setLayout(new GridLayout(3,2,2,4));
		painelFundo = new JPanel();
		painelCampos.add(lbNome);
		painelCampos.add(txNome);
		painelCampos.add(lbTelefone);
		painelCampos.add(txTelefone);
		painelCampos.add(btLimpar);
		painelCampos.add(btSalvar);
		painelFundo.add(painelCampos);

		this.getContentPane().add(painelFundo);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 150);
		this.pack();
		this.setVisible(true);
		btSalvar.addActionListener(new BtSalvarListener());
		btLimpar.addActionListener(new BtLimparListener());
	}
	
	private class BtSalvarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
                        Contato c = new Contato();
			c.setNome(txNome.getText());
			c.setTelefone(txTelefone.getText());
			new ContatoControle().insercao(c);
			JanelaPrincipal.pesquisar(modelo);
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
