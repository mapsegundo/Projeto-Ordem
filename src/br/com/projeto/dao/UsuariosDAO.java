/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.modelos.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Shall
 */
public class UsuariosDAO {

    // 1 - Realizar a conexao com o banco
    private Connection conexao;

    public UsuariosDAO() throws SQLException {
        // Faz a conexao com o banco de dados
        this.conexao = (Connection) new ConnectionFactory().getConnection();
    }

    public void cadastrarUsuario(Usuarios usuario) throws SQLException {
        try {
            //Criar comando SQL
            String cmdSql = "insert into tbusuarios (usuario, cargo, senha, repitaSenha, nivelAcesso) values(?,?,?,?,?)";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getCargo());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getRepitaSenha());
            stmt.setString(5, usuario.getNivelAcesso());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    //Metodo alterar usuario
    public void alterarUsuario(Usuarios usuario) throws SQLException {

        try {
            //Criar comando SQL
            String cmdSql = "UPDATE tbusuarios set usuario = ?, senha =?, repitaSenha =?, nivelAcesso=? where idUsuario =?";

            //Estruturar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getRepitaSenha());
            stmt.setString(4, usuario.getNivelAcesso());
            stmt.setInt(5, usuario.getIdUsuario());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo excluir usuario
    public void excluirUsuario(Usuarios usuario) throws SQLException {

        try {
            //Criar comando SQL
            String cmdSql = "DELETE from tbusuarios where idUsuario =?";

            //Estruturar o comando SQL
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setInt(1, usuario.getIdUsuario());

            //Executa comando
            stmt.execute();

            //Fechar conexao
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
