/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shall Classe responsavel pela conexao com o banco de dados
 */
public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        try {
            //Responsavel pela conexao
            return DriverManager.getConnection("jdbc:mysql://localhost/bdordem", "usuario", "123");
        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
