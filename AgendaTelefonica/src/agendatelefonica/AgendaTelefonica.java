
package agendatelefonica;

import dao.AgendaDAO;
import dto.Agenda;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iagui
 */
public class AgendaTelefonica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AgendaDAO agendaDAO = new AgendaDAO();
        Agenda agen = new Agenda("Iago miranda", "994143284");
        ArrayList<Agenda> agendas = new ArrayList<>();
        agen.setId(0);
        int opcao = 0;
        
        while (true){
        String menu = JOptionPane.showInputDialog(null, "**** Menu Principal *****\n"
                +"[ 1 ] Adicionar Contato\n"
                +"[ 2 ] Excluir Contato\n"
                +"[ 3 ] Listar Contatos\n"
                +"[ 4 ] Editar Contato\n"
                +"Opcao Desejada: ");
                opcao = Integer.parseInt(menu);
                
                switch(opcao){
                    case 1: 
                try {
                    agendaDAO.inserir(agen);
                } 
                
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());}
                break;
                
                case 2:
            
                try {
                    agendaDAO.remover(agen);
                } 
                catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage());}
                break;
                
                case 3:
                try {
                    agendaDAO.pesquisar();} 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
                
              }
        }
    }
}
