package agenda.controle;
import dao.ContatoDAO;
import dto.Contato;
import java.util.List;

public class ContatoControle {
    private ContatoDAO dao = new ContatoDAO();
    
    public ContatoControle(){
        
    }
    public ContatoDAO getContatoDAO(){
        return this.dao;
    }
    public void setContatoDAO(ContatoDAO dao){
        this.dao = dao;
    }
    public void insercao(Contato pCont){
        dao.insercao(pCont);
    }
    
    public void atualizacao(Contato PCont){
        dao.atualizacao(PCont);
    }
    public void deletar(int id){
        dao.deletar(id);
    }
    
    public List<Contato> getContatos(){
        return dao.getContatos();
    }
    
    public Contato getContatoById(int id){
        return dao.getContatoById(id);
    }
}
