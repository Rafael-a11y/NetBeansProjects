
package sistemadeloja;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import sistemadeloja.test.ConnectionFactory;
import sistemadeloja.test.classes.Cliente;
/* @author MASTER */
public class SistemaDeLoja {
    public static void main(String[] args) {
        //Primeiro passo - conectar
        List<Cliente> test;
        ConnectionFactory conexaoFactory = new ConnectionFactory();
        test = ConnectionFactory.insereCliente();
        System.out.println("---------------------------------------");
        System.out.println(test);
    }
    
}
