/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.ordem;

import br.com.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Shall
 */
public class ProjetoOrdem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // testando conexao com banco de dados
        JOptionPane.showMessageDialog(null, "Testando a conexão");
        try {
            Connection con = new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso");
            System.out.println("Conexão: "+con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e);
        }
    }

}
