/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.modelos.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Shall
 */
public class ClientesDAO {

    private Connection conexao;

    public ClientesDAO() throws SQLException {
        this.conexao = (Connection) new ConnectionFactory().getConnection();
    }

    public java.sql.Date dataHoje() {
        java.sql.Date date = null;
        try {
            date = new java.sql.Date(new Date().getTime());
        } catch (Exception e) {
            System.out.println("Erro ao converter a data: " + e);
        }
        return date;
    }

    public void cadastrarCliente(Clientes cliente) throws SQLException {
        try {
            //Criar comando SQL
            String cmdSql = "insert into tbclientes (nome, cpf, telefone, endereco, bairro, cidade, estado, dataCadastro) values(?,?,?,?,?,?,?,?)";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getEstado());
            stmt.setDate(8, dataHoje());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void alterarCliente(Clientes cliente) throws SQLException {

        try {
            //Criar comando SQL
            String cmdSql = "UPDATE tbclientes set nome=?, cpf=?, telefone=?, endereco=?, bairro=?, cidade=?, estado=? where idCliente =?";

            //Estruturar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getEstado());
            stmt.setInt(8, cliente.getIdCliente());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirCliente(Clientes cliente) throws SQLException {

        try {
            //Criar comando SQL
            String cmdSql = "DELETE from tbclientes where idCliente =?";

            //Estruturar o comando SQL
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setInt(1, cliente.getIdCliente());

            //Executa comando
            stmt.execute();

            //Fechar conexao
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Clientes> listarTodosClientes() {
        List<Clientes> listaClientes = null;
        try {
            //Criar vetor que vai armazenar os usuarios
            listaClientes = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbclientes";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            ResultSet rs = stmt.executeQuery();
            
            //Percorrer os resultados no RS e colocados dentro da lista
            while(rs.next()){
                Clientes cliente = new Clientes();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setDataCadastro(rs.getDate("dataCadastro"));
                
                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: "+e);
        }
        return listaClientes;
    }
}
