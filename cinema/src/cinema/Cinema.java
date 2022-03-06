
package cinema;

import dao.GeneroDAO;
import dto.Genero;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class Cinema {

    
    public static void main(String[] args) throws Exception{
        GeneroDAO genDAO = new GeneroDAO();
        List<Genero> generos = new ArrayList<>();
        Genero gen = new Genero();
        int opcao = 0;
        String listaDeGeneros = "";
        String menu = "Digite uma das opções:\n"
                + "1 - Mostrar todos os gêneros;\n"
                + "2 - Alterar um gênero;\n"
                + "3 - Excluir um gênero;\n"
                + "4 - Inserir um gênero;\n"
                + "99 - Sair;";
       do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,menu ));
            switch(opcao){
                case 1 :
                    generos = genDAO.pesquisar();
                    for(Genero g : generos) listaDeGeneros += g;
                    JOptionPane.showMessageDialog(null, listaDeGeneros);
                    break;
                case 2 : 
                    
            }
        }while(opcao != 99);
    }
    
}
