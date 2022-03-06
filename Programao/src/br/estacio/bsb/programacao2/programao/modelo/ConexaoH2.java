package br.estacio.bsb.programacao2.programao.modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoH2 {
    
    // TODO implementar a recuperação dos parâmetros do banco de um arquivo de propriedades

    private static final String URL_H2 = "jdbc:h2:./programaoDB";

    private static final String DRIVER_CLASS = "org.h2.Driver";

    private static final String USER = "AulaPratica";

    private static final String PASS = "AulaPratica";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL_H2, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
