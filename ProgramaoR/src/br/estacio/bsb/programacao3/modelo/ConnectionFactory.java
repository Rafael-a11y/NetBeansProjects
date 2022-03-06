/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.bsb.programacao3.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASTER
 */
public class ConnectionFactory {
    
    private static final String url = "jdbc:mysql://localhost:3306/programao_DB";
    
    private static final String user = "root";
    
    private static final String password = "PQ@n@17";
    
    public static Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
