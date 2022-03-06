
package visao;
import agenda.controle.ContatoControle;
import dto.Contato;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import visao.visaoSecundaria.AtualizarContato;
import visao.visaoSecundaria.ExcluirContato;
import visao.visaoSecundaria.InserirContato;

public class JanelaPrincipal extends JFrame{
    
    private JButton btnInserir;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JPanel painelBotoes;
    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel();
    
    public JanelaPrincipal(){
        super("Tabela de Contatos");
        initJTable();
        initGUI();
    }
    
    private void initJTable(){
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("NOME");
        modelo.addColumn("TELEFONE");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
        pesquisar(modelo);
        
    }

    private void initGUI(){
        btnInserir = new JButton("Inserir");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(barraRolagem, BorderLayout.CENTER);
        painelBotoes.add(btnInserir);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelFundo.add(painelBotoes, BorderLayout.SOUTH);
        
        this.getContentPane().add(painelFundo);
        //ou this.setSize(new Dimension(500, 320));
        this.setSize(500,320);
        this.setDefaultCloseOperation(JanelaPrincipal.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true); 
        
        btnInserir.addActionListener(new BtnInserirListener());
        btnEditar.addActionListener(new BtnEditarListener());
        btnExcluir.addActionListener(new btnExcluirListener());
    }
    
    public static void pesquisar(DefaultTableModel modelo){
        modelo.setNumRows(0);
        for(Contato c : new ContatoControle().getContatos()){
            modelo.addRow(new Object[]{c.getId(), c.getNome(),
                c.getTelefone()});
        }
    }
    private class BtnInserirListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InserirContato ic = new InserirContato(modelo);
        }
    }
    
    private class BtnEditarListener implements ActionListener{
        @Override 
        public void actionPerformed(ActionEvent e){
            int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if(linhaSelecionada >= 0) {
				Contato contato = new Contato();
				contato.setId((int) tabela.getValueAt(linhaSelecionada, 0));
                                    AtualizarContato atContato = new AtualizarContato(modelo, linhaSelecionada, contato.getId());
			}
			else {
				JOptionPane.showMessageDialog(null, "É nescessário selecionar uma linha");
			}
        }
    }
    
    private class btnExcluirListener implements ActionListener{
        @Override 
        public void actionPerformed(ActionEvent e){
            int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if(linhaSelecionada >= 0) {
				int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
				new ExcluirContato(modelo, linhaSelecionada, idContato);
			}
			else {
				JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha");
			}
        }
    }
}
