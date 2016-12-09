/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.modelos.Servicos;
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
public class ServicosDAO {
    
    // 1 - Realizar a conexao com o banco
    private Connection conexao;
    
    public ServicosDAO() throws SQLException{
        // Faz a conexao com o banco de dados
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
    
    public void cadastrarServicos(Servicos servico) throws SQLException {
        try {
            //Criar comando SQL
            String cmdSql = "insert into tbservicos (nomeServico, descricao, observacao, valor, dataCadastro) values(?,?,?,?,?)";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setString(1, servico.getNomeServico());
            stmt.setString(2, servico.getDescricao());
            stmt.setString(3, servico.getObservacao());
            stmt.setDouble(4, servico.getValor());
            stmt.setDate(5, dataHoje());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    public void alterarServico(Servicos servico) throws SQLException {

        try {
            //Criar comando SQL
            String cmdSql = "UPDATE tbservicos set nomeServico=?, descricao=?, observacao=?, valor=? where idServico =?";

            //Estruturar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setString(1, servico.getNomeServico());
            stmt.setString(2, servico.getDescricao());
            stmt.setString(3, servico.getObservacao());
            stmt.setDouble(4, servico.getValor());
            stmt.setInt(5, servico.getIdServico());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirServico(Servicos servico) throws SQLException {

        try {
            //Criar comando SQL
            String cmdSql = "DELETE from tbservicos where idServico =?";

            //Estruturar o comando SQL
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            stmt.setInt(1, servico.getIdServico());

            //Executa comando
            stmt.execute();

            //Fechar conexao
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public List<Servicos> listarTodosServicos() {
        List<Servicos> listaServicos = null;
        try {
            //Criar vetor que vai armazenar os usuarios
            listaServicos = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbservicos";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            ResultSet rs = stmt.executeQuery();
            
            //Percorrer os resultados no RS e colocados dentro da lista
            Servicos servico;
            while(rs.next()){
                servico = new Servicos();
                servico.setIdServico(rs.getInt("idServico"));
                servico.setNomeServico(rs.getString("nomeServico"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setObservacao(rs.getString("observacao"));
                servico.setValor(rs.getDouble("valor"));
                servico.setDataCadastro(rs.getDate("dataCadastro"));
                
                listaServicos.add(servico);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: "+e);
        }
        return listaServicos;
    }
    
    public List<Servicos> listarPorIdServico(String id) {
        List<Servicos> listaServicos = null;
        try {
            //Criar vetor que vai armazenar os usuarios
            listaServicos = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbservicos where idServico=?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            
            //Percorrer os resultados no RS e colocados dentro da lista
            Servicos servico;
            while(rs.next()){
                servico = new Servicos();
                servico.setIdServico(rs.getInt("idServico"));
                servico.setNomeServico(rs.getString("nomeServico"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setObservacao(rs.getString("observacao"));
                servico.setValor(rs.getDouble("valor"));
                servico.setDataCadastro(rs.getDate("dataCadastro"));
                
                listaServicos.add(servico);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: "+e);
        }
        return listaServicos;
    }
    
}
