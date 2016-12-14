/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.modelos.Usuarios;
import br.com.projeto.telas.FrmLogin;
import br.com.projeto.telas.FrmMenu;
import br.com.projeto.telas.FrmSplash;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
            String cmdSql = "UPDATE tbusuarios set usuario = ?, senha =?, repitaSenha =?, nivelAcesso=?, cargo=? where idUsuario =?";

            //Estruturar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getRepitaSenha());
            stmt.setString(4, usuario.getNivelAcesso());
            stmt.setString(5, usuario.getCargo());
            stmt.setInt(6, usuario.getIdUsuario());

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

    public List<Usuarios> listarTodosUsuarios() {
        List<Usuarios> listaUsuarios = null;
        try {
            //Criar vetor que vai armazenar os usuarios
            listaUsuarios = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbusuarios";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            ResultSet rs = stmt.executeQuery();

            //Percorrer os resultados no RS e colocados dentro da lista
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setRepitaSenha(rs.getString("repitaSenha"));
                usuario.setNivelAcesso(rs.getString("nivelAcesso"));

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: " + e);
        }
        return listaUsuarios;
    }

    public List<Usuarios> listarPorUsuario(String nomeUsuario) {
        List<Usuarios> listaUsuarios = null;
        try {
            //Criar vetor que vai armazenar os usuarios
            listaUsuarios = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbusuarios where usuario like ?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setString(1, "%" + nomeUsuario + "%");
            ResultSet rs = stmt.executeQuery();

            //Percorrer os resultados no RS e colocados dentro da lista
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setRepitaSenha(rs.getString("repitaSenha"));
                usuario.setNivelAcesso(rs.getString("nivelAcesso"));

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: " + e);
        }
        return listaUsuarios;
    }

    //metodo que faz o login
    public String efetuaLogin(String usuario, String senha) {
        String cargo = "";
        try {
            //Comando SQL
            String cmdSql = "SELECT * from tbusuarios where usuario=? and senha=?";
            //Organizar comando SQL
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            //Executa comando
            ResultSet rs = stmt.executeQuery();
            //Verificar se usuario foi encontrado
            if(rs.first()){
                //Descobrir cargo do funcionário e enviar para Splash
                cargo = rs.getString("nivelAcesso");
                } else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
            }
        } catch (Exception e) {

        }
        return cargo;
    }
    
    public void recuperarSenha(Usuarios usuario) throws SQLException {

        try {
            //Criar comando SQL
            String cmdSql = "UPDATE tbusuarios set senha =?, repitaSenha =? where usuario =?";

            //Estruturar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getRepitaSenha());
            stmt.setString(3, usuario.getUsuario());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
